
package main;

import java.util.ArrayList;
import java.util.Date;


public class MasterSchedule {
	
	//Input : initial_inventory, forecast_order, commited_order
	//Output : estimated_inventory, master_schedule, uncommited_order
		
	// A term is a week.
	// first we forecast for eight weeks
		
	public int ini_inventory; //from InventoryRecord
	public int fore_order;    //from prediction system
	public int MPS_amount = 22;           //from ordering model	
	
	public int est_inventory = 0;
	
	public ArrayList<OrderData> orderList;
	
//	public int cOrderSum = 0;
//	public int num = 0;
//	public int changeTimes = 0;
	
	public MasterSchedule(int ini_inventory, ArrayList<OrderData> orderList)
	{
		this.ini_inventory = ini_inventory;
		//this.fore_order = fore_order;
		this.fore_order = new ForecastOrder(orderList).forecast();
		this.orderList = orderList;
		this.est_inventory = ini_inventory;
	}
	

	
	public int setSchedule(OrderData anOrder) {
		
		int orderAmount = anOrder.order_amounts;
		
		if (fore_order >= orderAmount) 
		{
			if (est_inventory >= fore_order) 
			{
				est_inventory -= fore_order;
				anOrder.est_inventory = est_inventory;
			}
			else
			{
				est_inventory += MPS_amount;
				est_inventory -= fore_order;
				//MPS_dateList.add(anOrder.delivery_date);
				anOrder.MPS = MPS_amount;
				anOrder.est_inventory = est_inventory;
			}
		}
		else if (fore_order < orderAmount)
		{
			if (est_inventory >= orderAmount)
			{
				est_inventory -= orderAmount;
				anOrder.est_inventory = est_inventory;
			}
			else 
			{
				est_inventory += MPS_amount;
				est_inventory -= orderAmount;
				//MPS_dateList.add(anOrder.delivery_date);
				anOrder.MPS = MPS_amount;
				anOrder.est_inventory = est_inventory;
			}		
		}
		

		return est_inventory;
	
	}
	
	
	public void calculateATP()
	{
		int cOrderSum = 0;
		int num = 0;
		int changeTimes = 0;
		for(int i=0; i<orderList.size(); i++) 
		{
			
			
			if(i==0) {
				cOrderSum += orderList.get(i).order_amounts;
				num++;
			}else if(i>0) {
				if(orderList.get(i).MPS != 0) {
					changeTimes++;
					if (changeTimes==1) {
						orderList.get(0).ATP = ini_inventory + orderList.get(0).MPS - cOrderSum;
						cOrderSum = 0;
						cOrderSum += orderList.get(i).order_amounts;
						num=0;
						num++;
					}else {
						orderList.get(i-num).ATP = MPS_amount - cOrderSum;
						cOrderSum = 0;
						cOrderSum += orderList.get(i).order_amounts;
						num=0;
						num++;
					}
					
				}else if(orderList.get(i).MPS == 0) {
					cOrderSum += orderList.get(i).order_amounts;
					num++;
				}
			}
			
			if(i==orderList.size()-1) {
				if(orderList.get(i).MPS != 0) {
					orderList.get(i).ATP = orderList.get(i).MPS - orderList.get(i).order_amounts;
				}else if(orderList.get(i).MPS == 0){
					orderList.get(i-num+1).ATP = MPS_amount - cOrderSum;
				}
			}
			
			
			
			
		}
		 
	}
	
	
	//sort by date
	
	public ArrayList<OrderData> output() 
	{
		//Output --> Date, predictOrder, customerOrder, estimatedOrder, MPS, ATP
		//Sorted by Date
		for(OrderData o : orderList) {
			setSchedule(o);
		}
		calculateATP();
		return orderList;
	}
	


}
	
	
	
	

