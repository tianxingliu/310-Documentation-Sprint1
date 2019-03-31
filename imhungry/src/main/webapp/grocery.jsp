<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Grocery</title>
		<link rel="stylesheet" type="text/css" href="css/listPage.css" />
	</head>
	<body>
		<form action="resultPage.jsp">
			<input type="hidden" id="queryStringInput" name="search" value="" />
			<input type="hidden" id="numberResultsInput" name="number" value="cache" />
			<input type="submit" id = "back_result" value="Back to Result" />
		</form>
	
		<form action="searchPage.jsp">
			<input type="submit" id = "back_search" value="Back to Search" />
		</form>
	    
		<div id = "header"></div>
		<div id = "container">
			<script>
				console.log(sessionStorage);
			</script>
		</div>

		<script src="js/dropdown.js"></script>
		<script src="js/ListClient.js"></script>
		<script src="js/parseQueryString.js"></script>
		
		
		
	</body>
</html>