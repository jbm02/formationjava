<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition article</title>
</head>
<body>
	<jsp:useBean id="article" type="com.loncoto.WebArticles.beans.Article" scope="request"/>
	<form action="ArticleServlet" method="post">
		<input type="hidden" name="id" value= '<jsp:getProperty name="article" property="id"/>'/>
		<input type="hidden" name="action" value="sauver">
		<input type="text" name="libelle" value= '<jsp:getProperty name="article" property="libelle"/>'/><br/>
		<input type="text" name="prix" value= '<jsp:getProperty name="article" property="prix"/>'/><br/>
		<input type="text" name="poids" value= '<jsp:getProperty name="article" property="poids"/>'/><br/>
		<input type="submit" value="sauver" />
	</form>
</body>
</html>