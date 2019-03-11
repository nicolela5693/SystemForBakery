package main;

public class order 
{
	public String order_id;
	public String c_id;

	public double profit;
	public double total_price;
	public String order_date; //format:2008-1-1 
	
	public order(String ic_id, double itotal_price,String iorder_date)
	{
		c_id=ic_id;
		total_price=itotal_price;
	    order_date=iorder_date;
	    profit = itotal_price/2;
	}
	

}
