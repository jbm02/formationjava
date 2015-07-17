<%@page import="java.util.List"%>
<%@page import="com.loncoto.WebArticles.beans.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
		</tr>
		<% 
			List<Article> clients = (List<Article>)request.getAttribute("articles");
			for (Article a : clients){
		%>
		<tr>
			<td><%= a.getLibelle() %></td>
			<td><%= a.getPrix() %></td>
			<td><%= a.getPoids() %></td>
			<td>
			     <form action="ArticleServlet" method="post">
					<input type="hidden" name="id" value='<%= a.getId() %>' />
					<input type="hidden" name="action" value="editer" />
					<input type="submit" value="Edition" />
				</form>
			</td>
			<td>
				<form action="ArticleServlet" method="post">
					<input type="hidden" name="id" value='<%= a.getId() %>' />
					<input type="hidden" name="action" value="supprimer" />
					<input type="submit" value="Suppression" />
				</form>
			</td>
		</tr>
		<%}%>
		<tr>
			<td>
			<form action="ArticleServlet" method="post">
				<input type="hidden" name="action" value="creer" />
				<input type="submit" value="Nouvel Article" />
			</form>
			</td>
			<%--
			<td COLSPAN=2>
			 <form action="ArticleServlet" method="post">
				<input type="hidden" name="action" value="trier" />
				<input type="submit" value="Trier" />
				<input type="radio" name="choix" value="prix" checked> Prix
				<input type="radio" name="choix" value="poids"> Poids
			</form>
			</td>
			--%>
		</tr>	
	</table>
</body>
</html>