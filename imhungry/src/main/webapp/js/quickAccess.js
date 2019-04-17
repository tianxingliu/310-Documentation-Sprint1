var list = getList("Quick Access").body;
    document.getElementById("quickAccess1").innerHTML += "| Quick Access List |";
    document.getElementById("quickAccess1").innerHTML += "<br/>";
    for(var i = 0;i < list.length;i++){
    	if (i === 6) {
    	    break;
    	}
    	var noun = list[i];
    	noun = noun.substring(1, noun.length-1);
    	var prefix = "■ - ";
    	var nounToSearch = noun;
    	noun = prefix.concat(noun);
    	console.log(nounToSearch);
    	document.getElementById("quickAccess2").innerHTML += "<a href = 'http://localhost:9090/resultPage.jsp?search=" + nounToSearch + "&number=5&radius=2000&submit.x=0&submit.y=0'>" + noun;
    	document.getElementById("quickAccess2").innerHTML += "<br/>";
    }