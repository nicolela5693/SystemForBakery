package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;



public class InventoryRecord {
	
	OrderList aList;
	ArrayList<Inventory> inventoryList;
	
	public int breadivt;
	public int doughivt;
	public int flourivt;
	public int flossivt;
	
	public InventoryRecord(OrderList aList) 
	{
		this.aList = aList;
	}
	
	public InventoryRecord(ArrayList<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}
	
	public void averageNeed() 
	{
		aList.averageOrderSum();
	}
	
	public int updateRecord(Inventory ivt) {
		if(ivt.inventory_id == 101) {
			ivt.inventory_amt = breadivt + ivt.purchase_amt - ivt.used_amt;
			breadivt = ivt.inventory_amt;
		}else if (ivt.inventory_id == 110) {
			ivt.inventory_amt = doughivt + ivt.purchase_amt - ivt.used_amt;
			doughivt = ivt.inventory_amt;
		}else if (ivt.inventory_id == 200) {
			ivt.inventory_amt = flourivt + ivt.purchase_amt - ivt.used_amt;
			flourivt = ivt.inventory_amt;
		}else if (ivt.inventory_id == 111) {
			ivt.inventory_amt = flossivt + ivt.purchase_amt - ivt.used_amt;
			flossivt = ivt.inventory_amt;
		}
		return ivt.inventory_amt;	
	}
	

	
	public ArrayList<Inventory> sortByDate() {
        Collections.sort(inventoryList, new Comparator<Inventory>() {
        	public int compare(Inventory i1, Inventory i2) {
        		DateFormat format = new SimpleDateFormat("yyyy-MM-DD");

        		Date date1 = null;
        		Date date2 = null;
        		try {
        			date1=format.parse(i1.getIvtDate());
        			date2=format.parse(i2.getIvtDate());

        		} catch (ParseException e) {
        			e.printStackTrace();
        		}

        		return date1.compareTo(date2);
        	}
      });

      return inventoryList;
   }
	
	public ArrayList<Inventory> output(){
		for(Inventory i: inventoryList) {
			updateRecord(i);
		}
		return inventoryList;
	}
	
	public int getInitialBreadInventory(ArrayList<Inventory> ivtList) {
		int num = 0;
		for(Inventory i: inventoryList) {
			if (i.inventory_id == 101) {
				num = i.inventory_amt;
			}
		}
		return num;
	}
	
	
	

	
}
