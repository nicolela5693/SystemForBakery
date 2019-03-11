<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="main.DBController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.Inventory" %>
<%@ page import="main.InventoryRecord" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.*, java.text.* "%>


<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Inventory List</title>

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


#inventorylist {
  margin-left:auto; 
  margin-right:auto;
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#inventorylist td, #inventorylist th {
  border: 1px solid #ddd;
  padding: 8px;
}

#inventorylist tr:nth-child(even){background-color: #f2f2f2;}

#inventorylist tr:hover {background-color: #ddd;}

#inventorylist th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

.button{
  background-color: #4CAF50;
  border: none;
  border-radius: 8px;
  color: white;
  padding: 6px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 22px;
  margin: 4px 2px;
  cursor: pointer;
  transition: all 0.5s;
  
  }
  
.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 10px;
  right: 0px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 15px;
}

.button:hover span:after {
  opacity: 1;
  right: 25px;
  
}

</style>

</head>

<body>

<%
	
	String ID = request.getParameter("id");

	String date = request.getParameter("date");

	String Purchase = request.getParameter("purchase");

	String Shipment = request.getParameter("shipment");
	int id = 0;
	int purchase = 0;
	int shipment = 0;
	try{
		id = Integer.parseInt(ID);
		purchase = Integer.parseInt(Purchase);
		shipment = Integer.parseInt(Shipment);
	} catch (NumberFormatException e) {
		
	}
	
	DBController dbc = new DBController();
	
	int ivtAmount = 0;
//	if (id == 101){
//		ivtAmount = dbc.getInitialInventory() + purchase - shipment;
//	}
//	else if (id == 110){
//		ivtAmount = dbc.getInitialDoughInventory() + purchase - shipment;
//	}
//	else if (id == 200){
//		ivtAmount = dbc.getInitialFlourInventory() + purchase - shipment;
//	}
//	else if (id == 111){
//		ivtAmount = dbc.getInitialIngredientInventory() + purchase - shipment;
//	}
	
		
	dbc.sendIvtData(id, date, purchase, shipment, ivtAmount); 
	
	
	
	

%>

<h1>InventoryList</h1>
<br>
<br>
<h4 style="color: #4CAF50;">ID : Bread --> 101  Dough --> 110 Flour --> 200 Ingredients--> 111</h4><br>
<table id="inventorylist">
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	</th>
	<th>
	PurchasedAmount
	</th>
	<th>
	UsedAmount
	</th>
	<th>
	InventoryAmount
	</th>
	</tr>
	
	<% 
		try{
			//DBController dbc = new DBController();
			ArrayList<Inventory> ivtList = dbc.getInventoryData();
			InventoryRecord ivtRecord = new InventoryRecord(ivtList);
			//ivtRecord.sortByDate();
			ivtRecord.output();
			
			
			for(int i=0; i<ivtList.size(); i++)
			{
				out.println("<tr>");
				out.println("<td align=\"center\">"+ivtList.get(i).inventory_id+"</td>");
				out.println("<td align=\"center\">"+ivtList.get(i).inventory_date+"</td>");
				out.println("<td align=\"center\">"+ivtList.get(i).purchase_amt+"</td>");
				out.println("<td align=\"center\">"+ivtList.get(i).used_amt+"</td>");
				out.println("<td align=\"center\">"+ivtList.get(i).inventory_amt+"</td>");
				out.println("</tr>");
			}
	        String rqname = request.getParameter("ID");

		}catch(IOException e){
			
		}
		
	%>
	
	</table>
	
	<br><br>
	<form action = "Manage.jsp" method="POST"  class="button" style="vertical-align:middle">
		<span><input type="submit" value="Back To Manager Page" class="button" name="send"></span><br>
	</form>
	<br><br>

</body>
</html>