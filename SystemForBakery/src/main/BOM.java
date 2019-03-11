package main;

public class BOM {

	public int inventory_id;
	public String Date;
	public int planOrderDelivered;
	
	public BOM(int inventory_id, String Date, int planOrderDelivered) {
		this.inventory_id = inventory_id;
		this.Date = Date;
		this.planOrderDelivered = planOrderDelivered;
	}
	
	public String getIvtDate() {
		return Date;
	}
	
	@Override
	public String toString() {
		return "[" + "InventoryID: " + inventory_id +  "," + "Date: " + Date + "," + "PlanOrderDelivered: " + planOrderDelivered + "]" + "\n";
	}
	
	
	
}
