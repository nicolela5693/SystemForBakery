<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import="main.*" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>InventoryPage</title>

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

	<h1>Inventory</h1>
	<br>
	<br>
	<h2 style="color: #4CAF50;font-size: 22px;">Please Input Your Inventory</h2>
	<form name="InventoryInput" action="Inventory.jsp" method="POST" class="forminput">
			Inventory ID       : <select name="id">
			<option value="101">Bread</option>
			<option value="110">Dough</option>
			<option value="200">Flour</option>
			<option value="111">Ingredients</option>
			</select>
			<br><br>
			Inventory Date     : <input type="text" name="date" size="30" placeholder="xxxx-xx-xx"/><br><br>
            Inventory Purchase : <input type="text" name="purchase" size="30" /><br><br>
            Inventory Shipment : <input type="text" name="shipment" size="30" /><br><br>
            <input type="submit" value="Submit" name="send" class="button"/>
    </form>
    
    <br>
    
    <form action = "Manage.jsp" method="POST"  class="forminput" style="vertical-align:middle">
		<input type="submit" value="Back To Manager Page" class="button" name="send"><br>
	</form>
	<br><br>

</body>
</html>