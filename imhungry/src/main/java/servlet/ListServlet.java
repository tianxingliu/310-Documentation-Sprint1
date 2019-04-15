package servlet;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import database_manager.GroceryDataManager;
import database_manager.RecipeDataManager;
import database_manager.RestaurantDataManager;
import database_manager.HistoryDataManager;
import info.Info;
import info.Message;
import info.RecipeInfo;
import info.RestaurantInfo;
import info.GroceryInfo;
import info.History;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ListServlet", urlPatterns = "/Lists")
public class ListServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    //GET method used to fetch contents of a list
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String listName = request.getParameter("list"); //See what list was requested
        PrintWriter respWriter = response.getWriter();
        Gson gson = new Gson();
        if(!listName.equals("Favorites") && !listName.equals("To Explore") && !listName.equals("Do Not Show") && !listName.equals("Grocery") && !listName.equals("Quick Access")) //Check if list is valid
        {
            respWriter.println(gson.toJson(new Message("Invalid List!")));
            respWriter.close();
            return;
        }
        if(listName.equals("Quick Access")) {
    			HistoryDataManager historyDB = new HistoryDataManager();
    			//load quickAccessList from database
    			ArrayList<History> quickAccessList = new ArrayList<History>();
    			quickAccessList = historyDB.loadHistory();
    			session.setAttribute("Quick Access", quickAccessList);
    			List<History> historyList = (List<History>)session.getAttribute(listName);
	        	List<String> list = new ArrayList<String>();
	        	for(int i = 0;i < historyList.size();i++){
	        		list.add(historyList.get(i).query);
	        	}
	        	respWriter.println(gson.toJson(new Message(listName,list))); //convert to JSON before sending it to the response
	            respWriter.close();
	            return;
        }
	    	List<Info> list = (List<Info>)session.getAttribute(listName); //Cast stored list to correct type and
	        respWriter.println(gson.toJson(new Message(listName,list))); //convert to JSON before sending it to the response
	        respWriter.close();
	        
	    }

    //POST method used to add and remove items from a list
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())); //Java 8 magic to collect all lines from a BufferedReadder, in this case the request.
        Gson gson = new Gson();
        PrintWriter respWriter = response.getWriter();
        try
        {
            Message reqMessage = gson.fromJson(reqBody, Message.class); //Parse outer Message object from JSON
            Message reqListAndItem = gson.fromJson((String)reqMessage.body, Message.class); //Parse inner Message object from json
            
           
            String listName = reqListAndItem.header; //Get name of list to modify from the inner Message
            if(!listName.equals("Favorites") && !listName.equals("To Explore") && !listName.equals("Do Not Show") && !listName.equals("Grocery") && !listName.equals("Quick Access")) //Check validity
                throw new Exception("Invalid list name.");
            
            
            if(listName.equals("Quick Access")) {
            	//TODO: Add code for other cases, only addItem for now
//		        	System.out.print("Testing: ");
//		        	System.out.println((String)reqListAndItem.body);
		        	ArrayList<History> list = (ArrayList<History>)session.getAttribute("Quick Access");
		        	String s = (String)reqListAndItem.body;
		        	History h = new History(s,0,0);
		        	HistoryDataManager historyDB = new HistoryDataManager();
		        	historyDB.addToList(h);
		        	respWriter.println(gson.toJson(new Message("quick access "+listName)));
		        	return;
            }
            
            String infoJson = (String)reqListAndItem.body; //Get Info object of item to add/remove as a JSON string

            //Interact with the raw JSON to determine the type of the object via unique fields
            JsonObject info = new JsonParser().parse(infoJson).getAsJsonObject();
            Type infoType;
            if(info.has("prepTime")) infoType = RecipeInfo.class;
            else if(info.has("placeID")) infoType = RestaurantInfo.class;
            else throw new Exception("Unknown item type.");
            
            
            	Info item = gson.fromJson(infoJson, infoType); //Parse Info object from JSON
                List<Info> list = (List<Info>)session.getAttribute(listName); //Get the requested list from session
                //Switch on requested action
                RestaurantDataManager restaurantDB = new RestaurantDataManager();
            	RecipeDataManager recipeDB = new RecipeDataManager();
            	System.out.println(reqMessage.header);
                switch(reqMessage.header)
                {
                    case "addItem":
//                        
                        if(listName.equals("Grocery")) { //case for add to Grocery List
                        	GroceryDataManager groceryDB = new GroceryDataManager();
                        	RecipeInfo newItem = gson.fromJson(infoJson, infoType);
                        	ArrayList<String> ingredients = newItem.ingredients; 
                        	for(int i = 0; i < ingredients.size(); i++) {
                        		GroceryInfo newGrocery = new GroceryInfo(ingredients.get(i));
                        		boolean alreadyAdded = false;
                        		for(int j=0;j < list.size();j++) {
                        			GroceryInfo g = (GroceryInfo) list.get(j);
                        			if(g.item.equals(ingredients.get(i))) {
                        				alreadyAdded = true;
                        				break;
                        			}
                        		}
                        		if(!alreadyAdded) {
                        			list.add(newGrocery);
                        			groceryDB.addToList(newGrocery);
                        		}
                        	}

                        }
                        else {
                        	if(!list.contains(item)) {
                        		list.add(item);
                        		int listToAdd = 1;
                        		if(listName.equals("Favorites")) listToAdd = 1;
                        		else if(listName.equals("Do Not Show")) listToAdd = 2;
                        		else if(listName.equals("To Explore")) listToAdd = 3;
                        		if(infoType == RecipeInfo.class)
                        			recipeDB.addToList((RecipeInfo)item, listToAdd);
                        		else if(infoType == RestaurantInfo.class)
                        			restaurantDB.addToList((RestaurantInfo)item, listToAdd);
                        	}
                        }
                        respWriter.println(gson.toJson(new Message("Added to list "+ list)));
                        break;
                        
                    case "removeItem":
                        list.remove(item);
                        int listToRemove = 1;
                		if(listName.equals("Favorites")) listToRemove = 1;
                		else if(listName.equals("Do Not Show")) listToRemove = 2;
                		else if(listName.equals("To Explore")) listToRemove = 3;
                		if(infoType == RecipeInfo.class) {
                			RecipeInfo itemRecipeInfo = (RecipeInfo)item;
                			recipeDB.removeFromList(itemRecipeInfo.recipeID, listToRemove);
                		}
                		else if(infoType == RestaurantInfo.class) {
                			RestaurantInfo itemRestaurantInfo = (RestaurantInfo)item;
                			restaurantDB.removeFromList(itemRestaurantInfo.placeID, listToRemove);
                		}
                        respWriter.println(gson.toJson(new Message("Removed from list "+listName)));
                        break;
                    case "resetLists":
                        session.invalidate(); //Note: This is for debuggin only; the page will break if this is called and a new search is not immediately made
                        break;
                       
                    default:
                        throw new Exception("Invalid action.");
                }


        } catch(Exception e) { //Handle exceptions
            e.printStackTrace();
            respWriter.println(gson.toJson(new Message("Invalid Response!\n"+e.getMessage())));
            respWriter.close();
        }
        respWriter.close();
    }

	private History History(String body) {
		// TODO Auto-generated method stub
		return null;
	}
}
