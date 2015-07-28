<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FBI</title>
</head>
<body>
<h2>Connexion ultra sécurisée...</h2>
<s:form action="pwd" method="post">
	<s:textfield name ="login" label = "Login" />
	<s:password name ="password" label = "Mot de passe" />
	<s:submit />
</s:form>
</body>
</html>