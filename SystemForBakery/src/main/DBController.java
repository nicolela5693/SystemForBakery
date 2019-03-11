package main;
import java.sql.*;
import java.util.ArrayList;


public class DBController {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBController() {
		try {
			// Class 的靜態 forName() 方法實現動態加載類別
			Class.forName("com.mysql.jdbc.Driver");
			// 3306|MySQL開放此端口
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bread?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "FU23310521");
			st = con.createStatement();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	public ArrayList<OrderData> getOrderData() {
		ArrayList<OrderData> result=new ArrayList<OrderData>();
		try {
			String query = "select * from `order`";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				OrderData anOrder = new OrderData(rs.getInt("p_id"), rs.getString("delivery_date"), rs.getInt("order_amounts"),0, 0, 0 );
				result.add(anOrder);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public ArrayList<Inventory> getInventoryData() {
		ArrayList<Inventory> result=new ArrayList<Inventory>();
		try {
			String query = "select * from `inventory` ORDER BY `Date` ASC LIMIT 1000";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				Inventory anInventory = new Inventory(rs.getInt("inventory_id"), rs.getString("Date"), rs.getInt("purchase_amount"),rs.getInt("used_amount"),rs.getInt("inventory_amount"));
				result.add(anInventory);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public ArrayList<OrderData> getAOrderData() {
		ArrayList<OrderData> result=new ArrayList<OrderData>();
		try {
			String query = "SELECT * FROM `bread`.`order` ORDER BY `Deliver_Date`";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				OrderData anOrder = new OrderData(10, rs.getString("Deliver_Date"), rs.getInt("A_amount"),0, 0, 0 );
				result.add(anOrder);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public ArrayList<OrderData> getBOrderData() {
		ArrayList<OrderData> result=new ArrayList<OrderData>();
		try {
			String query = "select * from `orderdata`";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				OrderData anOrder = new OrderData(20, rs.getString("Deliver_Date"), rs.getInt("B_amount"),0, 0, 0 );
				result.add(anOrder);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public ArrayList<OrderData> getCOrderData() {
		ArrayList<OrderData> result=new ArrayList<OrderData>();
		try {
			String query = "select * from `orderdata`";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				OrderData anOrder = new OrderData(30, rs.getString("Deliver_Date"), rs.getInt("C_amount"),0, 0, 0 );
				result.add(anOrder);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public int getInitialInventory() {
		int result = 0;
		try {
			String query = "SELECT * FROM `bread`.`inventory` WHERE `inventory_id` IN ('101')\r\n" + 
					" ORDER BY `Date` ASC LIMIT 1000;";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				int initialIvt = rs.getInt("inventory_amount");
				result = initialIvt; 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public int getInitialDoughInventory() {
		int result = 0;
		try {
			String query = "SELECT * FROM `bread`.`inventory` WHERE `inventory_id` IN ('110')\r\n" + 
					" ORDER BY `Date` ASC LIMIT 1000;";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				int initialIvt = rs.getInt("inventory_amount");
				result = initialIvt; 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public int getInitialFlourInventory() {
		int result = 0;
		try {
			String query = "SELECT * FROM `bread`.`inventory` WHERE `inventory_id` IN ('200')\r\n" + 
					" ORDER BY `Date` ASC LIMIT 1000;";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				int initialIvt = rs.getInt("inventory_amount");
				result = initialIvt; 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public int getInitialIngredientInventory() {
		int result = 0;
		try {
			String query = "SELECT * FROM `bread`.`inventory` WHERE `inventory_id` IN ('111')\r\n" + 
					" ORDER BY `Date` ASC LIMIT 1000;";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				int initialIvt = rs.getInt("inventory_amount");
				result = initialIvt; 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public void sendIvtData(Integer id, String date, Integer purcahseAmount, Integer usedAmount, Integer ivtAmount) 
	{
		
		try {
			String query = "INSERT INTO `bread`.`inventory` (`inventory_id`, `Date`, `purchase_amount`, `used_amount`, `inventory_amount`) VALUES "
							+ "('" + id + "','" + date + "','" + purcahseAmount + "','" + usedAmount + "','" + ivtAmount  + "')";
			st.executeUpdate(query);
			System.out.println("Records for Database");
	    } 
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}
	
	
	
	public int getDoughInventory(String Date) {
		int result = 0;
		try {
			String query = "SELECT * FROM `bread`.`inventory` WHERE `Date` IN ('" + Date + "')\r AND " + "`inventory_id` IN ('110')\r\n" +
					" ORDER BY `Date` ASC LIMIT 1000;";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				int initialIvt = rs.getInt("inventory_amount");
				result = initialIvt; 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	

}
