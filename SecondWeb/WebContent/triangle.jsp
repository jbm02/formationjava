<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/<%= request.getAttribute("style")%>" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Triangle</title>
</head>
<body>
	<h2 id="titrePage">Triangle de taille <%= request.getAttribute("dimension") %></h2>
	<table>
	<% for (int ligne = 0; ligne < (int)request.getAttribute("dimension"); ligne++){ %>
	<tr>
	   		<% for(int colonne = 0; colonne < (int)request.getAttribute("dimension") - ligne; colonne++) { 
	   			if (colonne == 0 || ligne == 0 || colonne == (int)request.getAttribute("dimension") - ligne - 1) {%>
	   			<td class="bord"><% out.print("*"); %></td>
	   			<%}
	   			else { %> 
	   				<td class="centre"><% out.print("°"); %></td>		
				<%
	   			}
	   			}%>
	</tr>			
	<%}%>
	</table>
	
	<a href="index.html">retour au formulaire</a>
</body>
</html>
