package main;
 

public class OrderData {

	public String delivery_date;
	public int order_amounts;
	public int p_id;
	
	public int est_inventory;
	public int MPS;
	public int ATP;
	
	public OrderData(int p_id, String delivery_date, int order_amounts, int est_inventory, int MPS, int ATP) {
		this.p_id = p_id;
		this.delivery_date = delivery_date;
		this.order_amounts = order_amounts;
		this.est_inventory = 0;
		this.MPS = 0;
		this.ATP = 0;
	}
	

	public String getDate() {
		return delivery_date;
	}
	
	public int getID(){
		return p_id;
	}
	
	
	
	@Override
	public String toString() {
		return "[" + "ID: " + p_id + "," + "DeliveryDate: " + delivery_date + "," + "OrderAmount: " + order_amounts + "," + "EstimatedInventory: " + est_inventory + "," + "MPS: " + MPS + "," + "ATP: " + ATP + "]" + "\n";
	}
}
