<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition article</title>
</head>
<body>
	<h2>Edition article</h2>
    <s:form action="save" method="post">
		<s:hidden name="postId"/>
		<s:textfield name="postTitre" size="60" label="Titre" />
		<s:textarea name="postCorps" cols="150" rows="15" label="Corps" />
		<s:submit value="Sauver"/>
	</s:form>
	Date: <s:property value="postDate"/>
</body>
</html>