<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des posts</title>
</head>
<body>
	<h2>Liste des posts</h2>
	<table border="1">
		<tr>
			<th>Date</th>
			<th>Titre</th>
			<th>Corps</th>
			<th>Actions</th>
		</tr>
	<s:iterator value="posts">		
		<tr>
		    <td><s:property value="dateCreation"/></td>
			<td><s:property value="titre"/></td>
			<td><s:property value="corps"/></td>
			<td><s:a href="edit/%{id}">Edition</s:a></td>
		</tr>
    </s:iterator>	
	</table>
	<br/>
</body>
</html>