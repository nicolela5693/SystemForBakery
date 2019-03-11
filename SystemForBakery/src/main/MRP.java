package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MRP {

	// Gross Demand - Estimated Inventory = Net Demand
	// Calculate which date of planned order received amounts
	// Calculate which date of planned order delivery amounts
	// Input MPS, BOM, Inventory Amount
	
	public MasterSchedule mSchedule;
	public InventoryRecord ivtRecord;
	public ArrayList<OrderData> oList;
	public ArrayList<Inventory> ivtList;
	
	public int order_amounts = 0; // number per unit
	public int dough_amounts; // number per unit
	public int flour_amounts; // gram per unit
	public int floss_amounts; // gram per unit
	
	public int bread_need = 0; 
	public int dough_need; 
	public int flour_need; 
	public int floss_need;
	
	public int breadivt = 0;
	public int doughivt;
	public int flourivt;
	public int flossivt;
	
	public ArrayList<OrderData> MPSList = new ArrayList<OrderData>();
	public ArrayList<MRPDataList> MRPBreadList = new ArrayList<MRPDataList>();
	public ArrayList<MRPDataList> MRPDoughList = new ArrayList<MRPDataList>();
	public ArrayList<MRPDataList> MRPFlourList = new ArrayList<MRPDataList>();
	public ArrayList<MRPDataList> MRPFlossList = new ArrayList<MRPDataList>();
	
	public ArrayList<BOM> calculateBreadList = new ArrayList<BOM>();
	public ArrayList<BOM> calculateDoughList = new ArrayList<BOM>();
	public ArrayList<BOM> calculateFlourList = new ArrayList<BOM>();
	public ArrayList<BOM> calculateFlossList = new ArrayList<BOM>();
	
	public MRP(MasterSchedule mSchedule, InventoryRecord ivtRecord) {
		this.mSchedule = mSchedule;
		this.ivtRecord = ivtRecord;
		this.oList = mSchedule.output();
		this.ivtList = ivtRecord.output();
	}
	
	//DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
	
	
	public int calculateBreadADemand(OrderData anOrder) {
		breadivt = returnInventory(101, anOrder.delivery_date);
		bread_need = anOrder.MPS - breadivt;
		return bread_need;
	}
	public int calculateBreadBDemand(OrderData anOrder) {
		breadivt = returnInventory(102, anOrder.delivery_date);
		bread_need = anOrder.MPS - breadivt;
		return bread_need;
	}
	public int calculateBreadCDemand(OrderData anOrder) {
		breadivt = returnInventory(103, anOrder.delivery_date);
		bread_need = anOrder.MPS - breadivt;
		return bread_need;
	}
	
	public void calculateGrossDemand(OrderData anOrder) {
		
		if (anOrder.p_id == 10) {
			order_amounts = calculateBreadADemand(anOrder);
			dough_amounts = 1 * order_amounts;  
			flour_amounts = dough_amounts*5; 
			floss_amounts = 3 * order_amounts;  
		}
		else if (anOrder.p_id == 20) {
			order_amounts = calculateBreadBDemand(anOrder);
			dough_amounts = 1 * order_amounts;  
			flour_amounts = dough_amounts*4; 
			floss_amounts = 2 * order_amounts;
		}
		else if (anOrder.p_id == 30) {
			order_amounts = calculateBreadCDemand(anOrder);
			dough_amounts = 1 * order_amounts;  
			flour_amounts = dough_amounts*3; 
			floss_amounts = 5 * order_amounts;  
		}
	
	}

	public void calculateNetDemand(OrderData anOrder) {
	
		doughivt = returnOtherInventory(110, anOrder.delivery_date);
		flourivt = returnOtherInventory(200, anOrder.delivery_date);
		flossivt = returnOtherInventory(111, anOrder.delivery_date);

//		doughivt = 0;
//		flourivt = 0;
//		flossivt = 0;
	
		calculateGrossDemand(anOrder);
		dough_need = dough_amounts - doughivt;
		flour_need = flour_amounts - flourivt;
		floss_need = floss_amounts - flossivt;
	
	}
	
	public int returnInventory(int id, String Date) {
		int ivtAmt = 0;

		for(OrderData o: oList) {
			if(Date.equals(o.delivery_date)) {
				ivtAmt = o.est_inventory;
				break;
			}
		}
		return ivtAmt;
	}
	
	public int returnOtherInventory(int id, String Date) {
		int ivtAmt = 0;
		for (Inventory i : ivtList) {
			if(Date.equals(i.inventory_date) && id == i.inventory_id) {
				ivtAmt = i.inventory_amt;
			}
		}
		return ivtAmt;
	}
	
	
	
	public void calculateMRP() {
		for(OrderData anOrder: oList) {
			if(anOrder.MPS != 0) {
				MPSList.add(anOrder);
			}
		}
	}
	
	
	public void calculateBreadALeadTime() {
		calculateMRP();
		for(OrderData o: MPSList) {
			calculateNetDemand(o);
			MRPBreadList.add(new MRPDataList(101, o.delivery_date, o.MPS, breadivt, bread_need, bread_need));
			MRPDoughList.add(new MRPDataList(110, finishDateBefore(o.delivery_date, 1), dough_amounts, doughivt, dough_need, dough_need));
			MRPFlourList.add(new MRPDataList(200, finishDateBefore(o.delivery_date, 3), flour_amounts, flourivt, flour_need, flour_need));
			MRPFlossList.add(new MRPDataList(111, finishDateBefore(o.delivery_date, 1), floss_amounts, flossivt, floss_need, floss_need));
		}
		
		
	}
	

	
	public String finishDateBefore(String origDate, int amount) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		Calendar calendar = Calendar.getInstance();
		try{
			calendar.setTime(sdf.parse(origDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
	    calendar.add(Calendar.DAY_OF_MONTH, -amount);
	    String newDate = sdf.format(calendar.getTime());  
		return newDate;
	}
	
	
	public void calculatePlanDeliverDate(ArrayList<MRPDataList> MRPArray) {

		for(MRPDataList m: MRPArray) {
			if(m.inventory_id == 101) {
				calculateBreadList.add(new BOM(101, finishDateBefore(m.Date, 1),m.planOrderReceived));
			}
			else if(m.inventory_id == 110) {
				calculateDoughList.add(new BOM(110, finishDateBefore(m.Date, 2),m.planOrderReceived));
			}
			else if(m.inventory_id == 111) {
				calculateFlossList.add(new BOM(111, finishDateBefore(m.Date, 3),m.planOrderReceived));
			}
		}
	}
	
	public void calculateFlourDeliverDate(ArrayList<MRPDataList> MRPArray) {
		for(MRPDataList m : MRPArray) {
			calculateFlourList.add(new BOM(200, finishDateBefore(m.Date, 2),m.planOrderReceived));
		}
	}
	
	public ArrayList<MRPDataList> sortByDate() {
        Collections.sort(MRPBreadList, new Comparator<MRPDataList>() {
        	public int compare(MRPDataList i1, MRPDataList i2) {
        		DateFormat format = new SimpleDateFormat("yyyy-MM-DD");

        		Date date1 = null;
        		Date date2 = null;
        		try {
        			date1=format.parse(i1.getMRPDate());
        			date2=format.parse(i2.getMRPDate());

        		} catch (ParseException e) {
        			e.printStackTrace();
        		}

        		return date1.compareTo(date2);
        	}
      });

      return MRPBreadList;
   }
	
	public ArrayList<BOM> sortBOMByDate() {
        Collections.sort(calculateDoughList, new Comparator<BOM>() {
        	public int compare(BOM i1, BOM i2) {
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

      return calculateDoughList;
   }
	
	public void addFinalMRPList() {
		calculatePlanDeliverDate(MRPBreadList);
		calculatePlanDeliverDate(MRPDoughList);
		calculateFlourDeliverDate(MRPFlourList);
		calculatePlanDeliverDate(MRPFlossList);
	}
	
	public void intergrateList() {
		calculateBreadALeadTime();
		addFinalMRPList();
		
	}
	
	
	
	
}
