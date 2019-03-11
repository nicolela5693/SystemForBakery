package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class OrderList {
	
	public ArrayList<OrderData> oList;
	
	public int order_sum;
	public double avg_orderSum;

	public OrderList(ArrayList<OrderData> oList) {
		this.oList = oList;
	}
	
	public void add(OrderData o) {
		oList.add(o);
	}
	
	public int orderSum() {
		for(int i=0; i<oList.size(); i++) {
			order_sum += oList.get(i).order_amounts;
		}
		
		return order_sum;
	}
	
	public double averageOrderSum() {
		avg_orderSum = orderSum()/oList.size();
		return avg_orderSum; 
	}
	
	public ArrayList<OrderData> sortByDate() {
        Collections.sort(oList, new Comparator<OrderData>() {
        	public int compare(OrderData o1, OrderData o2) {
        		DateFormat format = new SimpleDateFormat("yyyy-MM-DD");

        		Date date1 = null;
        		Date date2 = null;
        		try {
        			date1=format.parse(o1.getDate());
        			date2=format.parse(o2.getDate());

        		} catch (ParseException e) {
        			e.printStackTrace();
        		}

        		return date1.compareTo(date2);
        	}
      });

      return oList;
   }
	
	
}
