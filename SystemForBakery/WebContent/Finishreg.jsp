<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import="main.*" %>
<% String name=request.getParameter("customer_name"); %>
<% String phonenumber=request.getParameter("customer_phone_no"); %>
<% String sex=request.getParameter("customer_sex"); %>
<% String date=request.getParameter("date"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Register Success</title>
<style>
body {
  background-color: lightblue;
  font-family:monospace;
  text-align: center;
}

h1 {
  color: #4CAF50;
  text-align: center;
  font-size: 35px;
}
</style>

</head>
<body>

<br><br><br><br><br><br><br><br><br><br>
<h1>Finish registration!!</h1>
<br>
<%
	DBcontrol dbc=new DBcontrol();
	dbc.sendData(name,sex,phonenumber,date);
	
%>

</body>
</html>