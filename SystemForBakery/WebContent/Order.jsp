<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import=" main.* "%>
<% String tel=request.getParameter("tel"); %>
<% String Aamount=request.getParameter("amount_of_bread_A_ordered"); %>
<% String Bamount=request.getParameter("amount_of_bread_B_ordered"); %>
<% String Camount=request.getParameter("amount_of_bread_C_ordered"); %>
<% String totalprice=request.getParameter("total_price"); %>
<% String order_profit=request.getParameter("profit_of_order"); %>
<% String customerorderdate=request.getParameter("customer_order_date"); %>
<% String due_date=request.getParameter("order_due_date"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>OrderPage</title>

<style>

body {
  background-color: lightblue;
  font-family:monospace;
}

h1 {
  color: #4CAF50;
  text-align: center;
  font-size: 35px;
}

p {
  color: #4CAF50;
  text-align: center;
  font-size: 18px;
  font-weight:bold;
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

<h1>Order Page</h1>
<br>

<script>
function count_total_price(){
var x = document.getElementById("amount_of_bread_A_ordered").value;
var y = document.getElementById("amount_of_bread_B_ordered").value;
var z = document.getElementById("amount_of_bread_C_ordered").value;
var total_price = (Number(x) * 20) + (Number(y) * 50) + (Number(z) * 80);
var profit_of_order = (Number(x) * 10) + (Number(y) * 25) + (Number(z) * 40);
document.getElementById("see_total_price").innerHTML = '$' + total_price;
}
</script>

<p>Do you want to check customer's data? </p>
<form action = "Customer.jsp" class="forminput">
<input type="submit" value="Check Customer Data" class="button"><br>
</form>

<br>

<form action="finishorder.jsp" class="forminput">
   Telephone <input type="number" name="tel"><br><br>
   
   bread A $20 each × <input type="number" id="amount_of_bread_A_ordered" name="amount_of_bread_A_ordered" ><br><br>
   
   bread B $50 each × <input type="number" id="amount_of_bread_B_ordered" name="amount_of_bread_B_ordered"><br><br>
   
   bread C $80 each × <input type="number" id="amount_of_bread_C_ordered" name="amount_of_bread_C_ordered"><br><br>
   
  <input type="button" value="see total price" onClick="count_total_price()" class="button">
  <p id = "see_total_price" name="see_total_price" ></p><br><br>

  Please insert total price as confirmation. <br>$<input type="number" id="total_price_confirm" name="total_price"><br><br>
  Today's date?  <br><input type="text" name="customer_order_date"  placeholder="xxxx-xx-xx"><br><br>
  When do you want your bread? <br><input type="text" name="order_due_date"  placeholder="xxxx-xx-xx"><br>
  <br>
  <input type="submit" value="Order" class="button">
</form>

<br>
   <p>Don't have an account?</p>
   <p>Sign up for FREE now!</p><br>
   
<form action = "Register.jsp" class="forminput">
<input type="submit" value="Register" class="button"><br>
</form>


</body>
</html>