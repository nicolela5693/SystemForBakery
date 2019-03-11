<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import=" main.* "%>
<% String name=request.getParameter("customer_name"); %>
<% String phonenumber=request.getParameter("customer_phone_no"); %>
<% String sex=request.getParameter("customer_sex"); %>
<% String date=request.getParameter("date"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>RegisterPage</title>

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

.forminput{
  color: white;
  text-align: center;
  font-size: 18px;
  font-weight:bold;
}

.button {
  display: inline-block;
  padding: 8px 25px;
  font-size: 20px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 7px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>

</head>
<body>

<h1>Register</h1>
<br>
<br>

<form action="Finishreg.jsp" class="forminput">
   Name <input type="text" name="customer_name"><br><br>
   Sex <input type="radio" name="customer_sex"  value="male">Male <input type="radio" name="customer_sex"  value="female">Female<br><br>
   Phone-number <input type="number" name="customer_phone_no"><br><br>
   Date <input type="text" name="date"  placeholder="xxxx-xx-xx">
   <br>
   <br>
   <br>
   <br>
  <input type="submit" value="註冊" class="button">
  </form>
  


</body>
</html>