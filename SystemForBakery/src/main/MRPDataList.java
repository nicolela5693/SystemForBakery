package main;

public class MRPDataList {

	public int inventory_id;
	public String Date;
	public int grossDemand;
	public int est_inventory;
	public int netDemand;
	public int planOrderReceived;
	//int planOrderDelivered;
	
	public MRPDataList(int inventory_id, String Date, int grossDemand, int est_inventory, int netDemand, int planOrderReceived) {
		this.inventory_id = inventory_id;
		this.Date = Date;
		this.grossDemand = grossDemand;
		this.est_inventory = est_inventory;
		this.netDemand = netDemand;
		this.planOrderReceived = planOrderReceived;
		//this.planOrderDelivered = planOrderDelivered;
	}
	
	public String getMRPDate() {
		return Date;
	}
	
	@Override
	public String toString() {
		return "[" + "InventoryID: " + inventory_id +  "," + "Date: " + Date + "," + "GrossDemand: " + grossDemand + "," + "EstimatedInventory: " + est_inventory + "," + "NetDemand: " + netDemand + "," + "PlanOrderReceived: " + planOrderReceived + "]" + "\n";
	}
	
}
