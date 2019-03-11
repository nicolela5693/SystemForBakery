package main;

public class Inventory {

	
	public int inventory_id;
	public String inventory_date;
	public int purchase_amt;
	public int used_amt;
	public int inventory_amt;

	
	public int breadAmt;
	public int doughAmt;
	public int flourAmt;
	public int flossAmt;
	
	public Inventory(int inventory_id, String inventory_date, int purchase_amt, int used_amt, 	int inventory_amt) {
		this.inventory_id = inventory_id;
		this.inventory_date = inventory_date;
		this.purchase_amt = purchase_amt;
		this.used_amt = used_amt;
		this.inventory_amt = inventory_amt;
	}
	
	public String getIvtDate() {
		return inventory_date;
	}
	
	@Override
	public String toString() {
		return "[" + "ID: " + inventory_id + "," + "Date: " + inventory_date + "," + "PurchaseAmount: " + purchase_amt + "," + "UsedAmount: " + used_amt + "," + "InventoryAmount: " + inventory_amt + "]" + "\n";
	}
	
}
