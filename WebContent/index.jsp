<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://localhost:8080/CustomTag/" prefix="customTag" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tag tEST</title>
</head>
<body>
	<h1>custom tag example</h1>
	<% String str = "such a nice day"; %>
	<% out.println("our test case string is : "+str);  %>
	
	reverse value is : <customTag:str operation="reverse"><%= str %></customTag:str><br/>
	length is : <customTag:str operation="length"><%= str %></customTag:str><br/>
	upper case is : <customTag:str operation="uppercase"><%= str %></customTag:str><br/>
	substring from 5 to 8 is : <customTag:str operation="substring" lower="0" upper="4"><%= str %></customTag:str>
</body>
</html>