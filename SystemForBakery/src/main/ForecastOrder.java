package main;

import java.util.ArrayList;

public class ForecastOrder {

	ArrayList<OrderData> orderList;
	
	public ForecastOrder(ArrayList<OrderData> orderList) {
		this.orderList = orderList;
	}
	
	public int forecast() {
		int sum=0;
		for(int i=orderList.size()-1; i>orderList.size()-6;i--) {
			sum += orderList.get(i).order_amounts;
		}
		sum = Math.round(sum/5);
		return sum;
	}
	
}
