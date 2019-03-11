<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="main.DBController" %>
<%@ page import="main.OrderData" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.OrderList" %>
<%@ page import="main.MasterSchedule" %>
<%@ page import="main.BOM" %>
<%@ page import="main.Inventory" %>
<%@ page import="main.InventoryRecord" %>
<%@ page import="main.MRP" %>
<%@ page import="main.MRPDataList" %>
<%@ page import="main.ForecastOrder" %>




<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreadAMasterSchedule</title>

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

p {
  color: white;
  font-size: 18px;
  font-weight:bold;
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
	
	<h1>BreadAMasterSchedule</h1>
	<br>
	<%
	DBController dbc = new DBController();
	ArrayList<OrderData> orderList = dbc.getAOrderData();
	OrderList oList = new OrderList(orderList);
	
	ArrayList<Inventory> ivtList = dbc.getInventoryData();
	InventoryRecord ivtRecord = new InventoryRecord(ivtList);

	ForecastOrder fo = new ForecastOrder(orderList);
	//int initialIvt = dbc.getInitialInventory();
	int initialIvt = ivtRecord.getInitialBreadInventory(ivtRecord.output());
	out.println("<p>Forecast Order = " + fo.forecast() + " </p>");
	out.println("<p>Initial Bread Inventory = " + initialIvt +" </p>");
	%>
	
	<br>
	<br>
	
	<table id="inventorylist">
	<tr>
	<th>
	P_ID
	</th>
	<th>
	DeliveryDate
	</th>
	<th>
	OrderAmount
	</th>
	<th>
	EstimatedInventory
	</th>
	<th>
	MPS
	</th>
	<th>
	ATP
	</th>
	</tr>
	<% 
	
		MasterSchedule mSchedule = new MasterSchedule(initialIvt, orderList);
		
		
		MRP anMRP = new MRP(mSchedule, ivtRecord);
		anMRP.intergrateList();

		
		for(int i=0; i<orderList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+orderList.get(i).p_id+"</td>");
			out.println("<td align=\"center\">"+orderList.get(i).delivery_date+"</td>");
			out.println("<td align=\"center\">"+orderList.get(i).order_amounts+"</td>");
			out.println("<td align=\"center\">"+orderList.get(i).est_inventory+"</td>");
			out.println("<td align=\"center\">"+orderList.get(i).MPS+"</td>");
			out.println("<td align=\"center\">"+orderList.get(i).ATP+"</td>");
			out.println("</tr>");
		}
	%>
	</table>
	
	<br>
	<br>
	<br>
	

	<form action = "Manage.jsp" method="POST"  class="button" style="vertical-align:middle">
		<span><input type="submit" value="Back To Manager Page" class="button" name="send"></span><br>
	</form>
	<br><br>	
	
	
	
</body>
</html>