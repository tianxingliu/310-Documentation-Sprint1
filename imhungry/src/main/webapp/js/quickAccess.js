var list = getList("Quick Access").body;
    document.getElementById("quickAccess1").innerHTML += "| Quick Access List |";
    document.getElementById("quickAccess1").innerHTML += "<br/>";
//    for(var i = 0;i < 6;i++){
//    	if (i === 6) {
//    	    break;
//    	}
//    	if (i == 0)
//    	{
//    		document.getElementById("quickAccess2").innerHTML += "tomato";
//    	}
//    	if (i == 1)
//		{
//    		document.getElementById("quickAccess3").innerHTML += "orange";
//		}
//    	if (i == 2)
//		{
//    		document.getElementById("quickAccess4").innerHTML += "noodle";
//		}
//    	if (i == 3)
//		{
//    		document.getElementById("quickAccess5").innerHTML += "dumpling";
//		}
//    	if (i == 4)
//		{
//    		document.getElementById("quickAccess6").innerHTML += "cookie";
//		}
//    	if (i == 5)
//		{
//    		document.getElementById("quickAccess7").innerHTML += "cookie";
//		}
//    }
    
    for(var i = 0;i < list.length;i++){
    	if (i === 6) {
    	    break;
    	}
    	var noun = list[i];
    	noun = noun.substring(1, noun.length-1);
    	var nounToSearch = noun;
    	console.log(nounToSearch);
    	if (i == 0)
    	{
    		document.getElementById("quickAccess2").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
    	}
    	if (i == 1)
		{
    		document.getElementById("quickAccess3").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
		}
    	if (i == 2)
		{
    		document.getElementById("quickAccess4").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
		}
    	if (i == 3)
		{
    		document.getElementById("quickAccess5").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
		}
    	if (i == 4)
		{
    		document.getElementById("quickAccess6").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
		}
    	if (i == 5)
		{
    		document.getElementById("quickAccess7").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    		document.getElementById("quickAccess2").innerHTML += "<br/>";
		}
    }