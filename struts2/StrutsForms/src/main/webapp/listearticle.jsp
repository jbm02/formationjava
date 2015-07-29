<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
	<h2>Liste des articles</h2>
	<table border="1">
		<tr>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
	    </tr>
	    <s:iterator value="articles">
	    	<tr>
	    		<td><s:property value="libelle"/></td>
	    		<td><s:property value="prix"/></td>
	    		<td><s:property value="poids"/></td>
	    	</tr>
	    </s:iterator>
	</table>
	<br/>
		<table border="1">
		<tr>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
	    </tr>
	    <s:iterator value="articles" var="art">
	    	<tr>
	    		<td><s:property value="#art.libelle"/></td>
	    		<td><s:property value="#art.prix"/></td>
	    		<td><s:property value="#art.poids" /></td>
	    	</tr>
	    </s:iterator>
	</table>
	<s:form>
		<s:select list="articles" name="articleID" listKey="id" listValue="libelle"></s:select>
	</s:form>
</body>
</html>