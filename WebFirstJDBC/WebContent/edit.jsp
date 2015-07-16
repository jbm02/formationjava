<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition client</title>
</head>
<body>
	<h2>Edition client</h2>
	<jsp:useBean id="client" type="com.loncoto.webfirstjdbc.beans.Client" scope="request"/>
	<form action="ClientServlet" method="post">
		<input type="hidden" name="id" value= '<jsp:getProperty name="client" property="id"/>'/>
		<input type="hidden" name="action" value="sauver">
		<input type="text" name="nom" value= '<jsp:getProperty name="client" property="nom"/>'/><br/>
		<input type="text" name="email" value= '<jsp:getProperty name="client" property="email"/>'/><br/>
		<input type="text" name="solde" value= '<jsp:getProperty name="client" property="solde"/>'/><br/>
		<input type="submit" value="sauver" />
	</form>
</body>
</html>