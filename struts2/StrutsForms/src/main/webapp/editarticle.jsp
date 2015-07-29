<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition article</title>
</head>
<body>
	<h2>Edition article</h2>
	<s:form action="enregistrer" method="post">
		<s:hidden name="id"/>
		<s:textfield name="libelle" label="Nom de l'article"/>
		<s:textfield name="prix" label="Prix de l'article"/>
		<s:textfield name="poids" label="Poids de l'article"/>
		<s:submit value="Enregistrer"/>
	</s:form>
</body>
</html>