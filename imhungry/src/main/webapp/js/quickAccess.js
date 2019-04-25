var list = getList("Quick Access").body;
    document.getElementById("quickAccess1").innerHTML += "| Quick Access List |";
    document.getElementById("quickAccess1").innerHTML += "<br/>";
    for(var i = 0;i < 1;i++){
    	document.getElementById("quickAccess2").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + "tomato" + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + "tomato";
    		document.getElementById("quickAccess2").innerHTML += "&nbsp";
    		

    		var collage = document.getElementById("quickAccess2");
            for(let i = 0; i < imageURLs.length; i++) {
                //Create a div to hold this image
                let imgdiv = document.createElement("div");
                imgdiv.setAttribute("class", "imageDivq");
                imgdiv.setAttribute("id", "image"+i);
                //Create the img element
                let img = document.createElement("img");
                img.setAttribute("src", imageURLs[i]);
                img.setAttribute("class", "image");
                //Add the img to the div
                imgdiv.appendChild(img);
                //Generate a set of randomized position, rotation angle, scaling factor, and z index
                let x = 2*(i%5-1)*20+Math.floor(Math.random()*30);
                let y = 2*(i%2)*50+Math.floor(Math.random()*30)-20;
                let rot = Math.floor(Math.random()*90)-45;
                let scale = 0.1;
                let z = Math.floor(Math.random()*50);
                //Apply a style to the element that applies the above transformations to it
                imgdiv.setAttribute("style", "-webkit-transform: translate("+x+"%, "+y+"%) rotate("+rot+"deg) scale("+scale+");" +
                    "-ms-transform: translate("+x+"%, "+y+"%) rotate("+rot+"deg) scale("+scale+");" +
                    "transform: translate("+x+"%, "+y+"%) rotate("+rot+"deg) scale("+scale+");" +
                    "z-index:"+z+";");
                //Add the element to the collage
                collage.appendChild(imgdiv);
            }
    }
    
//    for(var i = 0;i < list.length;i++){
//    	if (i === 6) {
//    	    break;
//    	}
//    	var noun = list[i];
//    	noun = noun.substring(1, noun.length-1);
//    	var nounToSearch = noun;
//    	console.log(nounToSearch);
//    	if (i == 0)
//    	{
//    		document.getElementById("quickAccess2").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//    	}
//    	if (i == 1)
//		{
//    		document.getElementById("quickAccess3").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//		}
//    	if (i == 2)
//		{
//    		document.getElementById("quickAccess4").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//		}
//    	if (i == 3)
//		{
//    		document.getElementById("quickAccess5").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//		}
//    	if (i == 4)
//		{
//    		document.getElementById("quickAccess6").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//		}
//    	if (i == 5)
//		{
//    		document.getElementById("quickAccess7").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
//    		document.getElementById("quickAccess2").innerHTML += "<br/>";
//		}
//    }