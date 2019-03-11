<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import=" marketing.* "%>
<% String name=request.getParameter("customer_name"); %>
<% String phonenumber=request.getParameter("customer_phone_no"); %>
<% String sex=request.getParameter("customer_sex"); %>
<% String date=request.getParameter("date"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style>
.button{
  font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
  }
</style>

</head>
<body>

<form action="http://localhost:8080/new_bakery/Finishreg.jsp" >
   Name<br>
  <input type="text" name="customer_name"><br>
   Sex<br>
  <input type="radio" name="customer_sex"  value="male">Male
  <br>
  <input type="radio" name="customer_sex"  value="female">Female<br>
   Phone-number<br>
  <input type="number" name="customer_phone_no"><br>
   Date<br>
  <input type="text" name="date"  placeholder="xxxx-xx-xx"><br>
  <input type="submit" value="µù¥U">
  </form>
  


</body>
</html>