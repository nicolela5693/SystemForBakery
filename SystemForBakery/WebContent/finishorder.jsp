<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.text.* "%>
<%@ page import="main.*" %>
<%
	String tel = request.getParameter("tel");

	String Aamount = request.getParameter("amount_of_bread_A_ordered");

	String Bamount = request.getParameter("amount_of_bread_B_ordered");

	String Camount = request.getParameter("amount_of_bread_C_ordered");

	String totalprice = request.getParameter("total_price");

	String order_profit = request.getParameter("profit_of_order");

	String customerorderdate = request.getParameter("customer_order_date");
%>
<%
	String due_date = request.getParameter("order_due_date");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<style>
.body {
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
  color: #4CAF50;
  text-align: center;
  font-size: 18px;
  font-weight:bold;
}

</style>

</head>
<body>
	<br><br><br><br>
	<h1>Finish</h1>
	<%
	String message = "";
    
	Order_DBcontrol dbc = new Order_DBcontrol();
	String C_id=dbc.findid(tel);
	dbc.sendorderData(C_id, customerorderdate, Aamount, Bamount, Camount, totalprice, due_date);
	double Totalprice = Double.parseDouble(totalprice);
	ArrayList<customer> tempcus = dbc.getcustomerData();
	
	
	order temporder = new order(C_id, Totalprice, customerorderdate);
	String order_cid = "";
	for (int i = 0; i < tempcus.size(); i++) {
		if (temporder.c_id.equals(tempcus.get(i).c_id)) {
			order_cid = tempcus.get(i).c_id;
			tempcus.get(i).lastbuy_date = tempcus.get(i).buy_date;
			tempcus.get(i).buy_date = temporder.order_date;
			tempcus.get(i).beforetotalmoney += tempcus.get(i).thistimetotalmoney;
			tempcus.get(i).thistimetotalmoney = temporder.total_price;
			dbc.operateCustomer(order_cid, tempcus.get(i).buytimes + 1, tempcus.get(i).buy_date,
					tempcus.get(i).thistimetotalmoney, tempcus.get(i).lastbuy_date,
					tempcus.get(i).beforetotalmoney);

		}
	}
	tempcus = dbc.getcustomerData(); //Recatch all customer new data
	for (int i = 0; i < tempcus.size(); i++)//Calculate RFM value
	{
		String temp_cid = tempcus.get(i).c_id;
		tempcus.get(i).recency = rfmcalculate.recencycal(tempcus.get(i).buy_date, tempcus.get(i).lastbuy_date);
		tempcus.get(i).frequency = rfmcalculate.monthfrequencycal(tempcus.get(i).buytimes,
				tempcus.get(i).buy_date, tempcus.get(i).firstbuy_date);
		tempcus.get(i).monetary = rfmcalculate.monthmonetarycal(tempcus.get(i).beforetotalmoney,
				tempcus.get(i).thistimetotalmoney, tempcus.get(i).buy_date, tempcus.get(i).firstbuy_date);
		dbc.rfmcal(temp_cid, tempcus.get(i).recency, tempcus.get(i).frequency, tempcus.get(i).monetary);
	}

	///GiveR	    
	tempcus = dbc.getcustomerData();//Recatch all customer new data
	tempcus = customerassign.sortrecency(tempcus);//Sort according R
	for (int i = 0; i < tempcus.size() / 2; i++)//Give rgrp=1
	{
		String temp_cid = tempcus.get(i).c_id;
		dbc.rgroup(temp_cid, "1");
	}
	for (int i = tempcus.size() / 2; i < tempcus.size(); i++)//Give rgrp=2
	{
		String temp_cid = tempcus.get(i).c_id;
		dbc.rgroup(temp_cid, "2");
	}
	///GiveF	   
	tempcus = dbc.getcustomerData();//Recatch all customer new data
	ArrayList<customer> r1cus = new ArrayList<customer>();
	ArrayList<customer> r2cus = new ArrayList<customer>();
	r1cus = dbc.selectRgrp("Rgrp", "1");
	r2cus = dbc.selectRgrp("Rgrp", "2");
	r1cus = customerassign.sortfrequency(r1cus);//Sort according F
	for (int i = 0; i < r1cus.size() / 2; i++)//Give fgrp=1
	{
		String temp_cid = r1cus.get(i).c_id;
		dbc.fgroup(temp_cid, "1");
	}
	for (int i = r1cus.size() / 2; i < r1cus.size(); i++)//Give fgrp=2
	{
		String temp_cid = r1cus.get(i).c_id;
		dbc.fgroup(temp_cid, "2");
	}
	r2cus = customerassign.sortfrequency(r2cus);//Sort according F
	for (int i = 0; i < r2cus.size() / 2; i++)//Give fgrp=1
	{
		String temp_cid = r2cus.get(i).c_id;
		dbc.fgroup(temp_cid, "1");
	}
	for (int i = r1cus.size() / 2; i < r1cus.size(); i++)//Give fgrp=2
	{
		String temp_cid = r2cus.get(i).c_id;
		dbc.fgroup(temp_cid, "2");
	}
	///GiveM	   
	tempcus = dbc.getcustomerData();//Recatch all customer new data
	ArrayList<customer> rf11cus = new ArrayList<customer>();
	ArrayList<customer> rf12cus = new ArrayList<customer>();
	ArrayList<customer> rf21cus = new ArrayList<customer>();
	ArrayList<customer> rf22cus = new ArrayList<customer>();
	rf11cus = dbc.selectRFgrp11("Rgrp", "1", "Fgrp", "1");
	rf12cus = dbc.selectRFgrp12("Rgrp", "1", "Fgrp", "2");
	rf21cus = dbc.selectRFgrp12("Rgrp", "2", "Fgrp", "1");
	rf22cus = dbc.selectRFgrp12("Rgrp", "2", "Fgrp", "2");

	rf11cus = customerassign.sortfrequency(rf11cus);
	rf12cus = customerassign.sortfrequency(rf12cus);
	rf21cus = customerassign.sortfrequency(rf21cus);
	rf22cus = customerassign.sortfrequency(rf22cus); //Sort according M
	//rf11
	for (int i = 0; i < rf11cus.size() / 2; i++)//Give mgrp=1
	{
		String temp_cid = rf11cus.get(i).c_id;
		dbc.mgroup(temp_cid, "1");
	}
	for (int i = rf11cus.size() / 2; i < rf11cus.size(); i++)//Give mgrp=2
	{
		String temp_cid = rf11cus.get(i).c_id;
		dbc.mgroup(temp_cid, "2");
	}
	//rf12	    
	for (int i = 0; i < rf12cus.size() / 2; i++)//Give mgrp=1
	{
		String temp_cid = rf12cus.get(i).c_id;
		dbc.mgroup(temp_cid, "1");
	}
	for (int i = rf12cus.size() / 2; i < rf12cus.size(); i++)//Give mgrp=2
	{
		String temp_cid = rf12cus.get(i).c_id;
		dbc.mgroup(temp_cid, "2");
	}
	//rf21	    
	for (int i = 0; i < rf21cus.size() / 2; i++)//Give mgrp=1
	{
		String temp_cid = rf21cus.get(i).c_id;
		dbc.mgroup(temp_cid, "1");
	}
	for (int i = rf21cus.size() / 2; i < rf21cus.size(); i++)//Give mgrp=2
	{
		String temp_cid = rf21cus.get(i).c_id;
		dbc.mgroup(temp_cid, "2");
	}
	//rf22
	for (int i = 0; i < rf22cus.size() / 2; i++)//Give mgrp=1
	{
		String temp_cid = rf22cus.get(i).c_id;
		dbc.mgroup(temp_cid, "1");
	}
	for (int i = rf22cus.size() / 2; i < rf22cus.size(); i++)//Give mgrp=2
	{
		String temp_cid = rf22cus.get(i).c_id;
		dbc.mgroup(temp_cid, "2");
	}

	tempcus = dbc.getcustomerData();
	rfmrank.combineRFMnum(tempcus);
	dbc.combinegroup(tempcus);
	//String message="";

	if (dbc.selectrfm(order_cid).equals("111")) {
		message = "Promote";
	} else {
		message = "Bye";
	}
%>
	<br><br>
	<p><%=message%></p>



</body>
</html>