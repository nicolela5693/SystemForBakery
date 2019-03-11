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
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>MRP</title>
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

caption {
  color: #4CAF50;
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


<h1>MRP</h1>
	
	<br>
	
	<table id="inventorylist">
	<caption>Bread (Lead Time = 1)</caption>
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	</th>
	<th>
	GrossDemand
	</th>
	<th>
	EstimatedInventory
	</th>
	<th>
	NetDemand
	</th>
	<th>
	PlanOrderReceived
	</th>
	</tr>
	
	<% 
	DBController dbc = new DBController();
	ArrayList<OrderData> orderList = dbc.getAOrderData();
	OrderList oList = new OrderList(orderList);
	int initialIvt = dbc.getInitialInventory();
	MasterSchedule mSchedule = new MasterSchedule(initialIvt, orderList);
	
	ArrayList<Inventory> ivtList = dbc.getInventoryData();
	for(Inventory i: ivtList){
		if(i.inventory_id == 101){
			
		}
	}
	InventoryRecord ivtRecord = new InventoryRecord(ivtList);
	MRP anMRP = new MRP(mSchedule, ivtRecord);
	anMRP.intergrateList();
		
		for(int i=0; i<anMRP.MRPBreadList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).grossDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).est_inventory+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).netDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPBreadList.get(i).planOrderReceived+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br>
	
	<table id="inventorylist">
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	<th>
	PlanOrderDelivered
	</th>
	</tr>
	
	<% 
				
		for(int i=0; i<anMRP.calculateBreadList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.calculateBreadList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateBreadList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateBreadList.get(i).planOrderDelivered+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br><br><br><br>
	
	<table id="inventorylist">
	<caption>Dough (Lead Time = 2)</caption>
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	</th>
	<th>
	GrossDemand
	</th>
	<th>
	EstimatedInventory
	</th>
	<th>
	NetDemand
	</th>
	<th>
	PlanOrderReceived
	</th>
	</tr>
	
	<% 
		
		
		for(int i=0; i<anMRP.MRPDoughList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).grossDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).est_inventory+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).netDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPDoughList.get(i).planOrderReceived+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br>
	
	<table id="inventorylist">
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	<th>
	PlanOrderDelivered
	</th>
	</tr>
	
	<% 
				
		for(int i=0; i<anMRP.calculateDoughList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.calculateDoughList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateDoughList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateDoughList.get(i).planOrderDelivered+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br><br><br><br>
	
	<table id="inventorylist">
	<caption>Flour (Lead Time = 2)</caption>
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	</th>
	<th>
	GrossDemand
	</th>
	<th>
	EstimatedInventory
	</th>
	<th>
	NetDemand
	</th>
	<th>
	PlanOrderReceived
	</th>
	</tr>
	
	<% 
		
		
		for(int i=0; i<anMRP.MRPFlourList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).grossDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).est_inventory+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).netDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlourList.get(i).planOrderReceived+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br>
	
	<table id="inventorylist">
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	<th>
	PlanOrderDelivered
	</th>
	</tr>
	
	<% 
				
		for(int i=0; i<anMRP.calculateFlourList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.calculateFlourList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateFlourList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateFlourList.get(i).planOrderDelivered+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br><br><br><br>
	
	<table id="inventorylist">
	<caption>Ingredients (Lead Time = 3)</caption>
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	</th>
	<th>
	GrossDemand
	</th>
	<th>
	EstimatedInventory
	</th>
	<th>
	NetDemand
	</th>
	<th>
	PlanOrderReceived
	</th>
	</tr>
	
	<% 
		
		
		for(int i=0; i<anMRP.MRPFlossList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).grossDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).est_inventory+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).netDemand+"</td>");
			out.println("<td align=\"center\">"+anMRP.MRPFlossList.get(i).planOrderReceived+"</td>");
			out.println("</tr>");
		}
	%>
	
	</table>
	
	<br>
	
	<table id="inventorylist">
	<tr>
	<th>
	Inventory_ID
	</th>
	<th>
	Date
	<th>
	PlanOrderDelivered
	</th>
	</tr>
	
	<% 
				
		for(int i=0; i<anMRP.calculateFlossList.size(); i++)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+anMRP.calculateFlossList.get(i).inventory_id+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateFlossList.get(i).Date+"</td>");
			out.println("<td align=\"center\">"+anMRP.calculateFlossList.get(i).planOrderDelivered+"</td>");
			out.println("</tr>");
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