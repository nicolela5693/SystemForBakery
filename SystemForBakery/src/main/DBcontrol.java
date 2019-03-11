package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBcontrol {
	private Connection con;

	private Statement st;
	private ResultSet rs;
	private ResultSet rs2;
	private ResultSet rs3;
	private ResultSet rs4;
	private ResultSet rs5;
	public DBcontrol() {
		{
			try {
				// Class 的靜態 forName() 方法實現動態加載類別
				Class.forName("com.mysql.jdbc.Driver");
				// 3306|MySQL開放此端口
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bread?serverTimezone=UTC  ", "root","FU23310521"
						+ "");
				st = con.createStatement();
				
			} catch (Exception ex) {
				System.out.println("Error: " + ex);
			}
		}
	}
	public void close() throws SQLException
	{
		con.close();
		st.close();
		rs.close();
		
		
	}



	public ArrayList<customer> getcustomerData() {
		ArrayList<customer> result = new ArrayList<customer>();
		try {
			String query = "SELECT * FROM customer";
			rs = st.executeQuery(query);
			while (rs.next()) {
				customer cus = new customer();
				cus.c_id = rs.getString("C_Id");
				cus.c_name = rs.getString("C_Name");
				cus.recency = rs.getDouble("Recency");
				cus.frequency = rs.getDouble("Frequency");
				cus.monetary = rs.getDouble("Monetary");
				cus.rgrp = rs.getString("Rgrp");
				cus.fgrp = rs.getString("Fgrp");
				cus.mgrp = rs.getString("Mgrp");
				cus.rfmgrp = rs.getString("Rfmgrp");
				cus.buy_date = rs.getString("Buy_Date");
				cus.lastbuy_date = rs.getString("Lastbuy_Date");
				cus.firstbuy_date = rs.getString("Firstbuy_Date");
				cus.buytimes = rs.getInt("Buytimes");
				cus.beforetotalmoney = rs.getDouble("Beforetotalmoney");
				cus.thistimetotalmoney = rs.getDouble("Thistimetotalmoney");
				cus.response_rate = rs.getDouble("Response_Rate");
				cus.promote_times = rs.getInt("Promoting_Times");
				cus.response_times = rs.getInt("Response_Times");
				cus.promoting = rs.getString("Promoting");
				cus.gender = rs.getString("Gender");
				cus.tel = rs.getString("TEL");
				result.add(cus);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return result;
		

	}

	// public ArrayList<customer> getorderData()
	{
		// ArrayList<customer> result=new ArrayList<customer>();
		// try {
		// String query = "SELECT * FROM order";
		// rs = st.executeQuery(query);
		// while (rs.next()) {
		// order ord=new order(rs.getString("Customer_Id"),;
		// ord.c_id = );
		// ord.order_date = rs.getString("Date");
		// ord.total_price = rs.getDouble("Recency");
		// cus.frequency = rs.getDouble("Frequency");
		// cus.monetary = rs.getDouble("Monetary");
		// cus.buy_date = rs.getString("Buy_Date");
		// cus.lastbuy_date=rs.getString("Lastbuy_Date");
		// cus.firstbuy_date=rs.getString("Firstbuy_Date");
		// result.add(cus);
		// }
		// } catch (Exception ex) {
		// System.out.println(ex);
		// }
		// return result;

	}

	public void sendData(String name, String sex, String phonenumber,String regdate) {
		try {
			String query = "INSERT INTO customer (`C_Name`,`Buy_Date`,`Lastbuy_Date`,`Firstbuy_Date`,`Gender`, `TEL`) VALUES" + 
		"('" + name + "'," +"'"+"0000-00-00"+ "',"+"'"+"0000-00-00"+ "','"+regdate+ "','" + sex+ "','" + phonenumber + "')";
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void operateCustomer(String icid, int ibuytimes, String ibuy_date, double ithistimemoney,String ilastbuy_date,double beforemoney) {
		try {
			String query = "UPDATE customer SET Buytimes=" + ibuytimes + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query);
			String query2 = "UPDATE customer SET Lastbuy_Date=" + "'" + ilastbuy_date + "'" + " WHERE C_Id =" + "'" + icid
					+ "'";
			st.executeUpdate(query2);
			String query3 = "UPDATE customer SET Buy_Date=" + "'" + ibuy_date + "'" + " WHERE C_Id =" + "'" + icid
					+ "'";
			st.executeUpdate(query3);
			String query4 = "UPDATE customer SET Beforetotalmoney=" + beforemoney + " WHERE C_Id =" + "'" + icid
					+ "'";
			st.executeUpdate(query4);
			String query5 = "UPDATE customer SET Thistimetotalmoney=" + ithistimemoney + " WHERE C_Id =" + "'" + icid
					+ "'";
			st.executeUpdate(query5);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public void rfmcal(String icid, double irecency, double ifrequency, double imonetary) {

		try {
			String query = "UPDATE customer SET Recency=" + irecency + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query);
			String query2 = "UPDATE customer SET Frequency=" + "'" + ifrequency + "'" + " WHERE C_Id =" + "'" + icid
					+ "'";
			st.executeUpdate(query2);
			String query3 = "UPDATE customer SET Monetary=" + imonetary + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query3);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public void rgroup(String icid, String irgrp) {

		try {
			String query = "UPDATE customer SET Rgrp=" + irgrp + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public void fgroup(String icid, String ifgrp) {

		try {
			String query = "UPDATE customer SET Fgrp=" + ifgrp + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	public void mgroup(String icid, String imgrp) {

		try {
			String query = "UPDATE customer SET Mgrp=" + imgrp + " WHERE C_Id =" + "'" + icid + "'";
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	public ArrayList<customer> selectRgrp(String igrp, String igrpnum) {
		ArrayList<customer> result = new ArrayList<customer>();
		try {
			String query = "SELECT * FROM customer WHERE " + igrp + "=" + "'" + igrpnum + "'";
			rs2 = st.executeQuery(query);
			while (rs2.next()) {
				customer cus = new customer();
				cus.c_id = rs2.getString("C_Id");
				cus.c_name = rs2.getString("C_Name");
				cus.recency = rs2.getDouble("Recency");
				cus.frequency = rs2.getDouble("Frequency");
				cus.monetary = rs2.getDouble("Monetary");
				cus.buy_date = rs2.getString("Buy_Date");
				cus.lastbuy_date = rs2.getString("Lastbuy_Date");
				cus.firstbuy_date = rs2.getString("Firstbuy_Date");
				cus.buytimes = rs2.getInt("Buytimes");
				cus.beforetotalmoney = rs2.getDouble("Beforetotalmoney");
				cus.thistimetotalmoney = rs2.getDouble("Thistimetotalmoney");
				cus.response_rate = rs2.getDouble("Response_Rate");
				cus.promote_times = rs2.getInt("Promoting_Times");
				cus.response_times = rs2.getInt("Response_Times");
				cus.promoting = rs2.getString("Promoting");
				cus.gender = rs2.getString("Gender");
				cus.tel = rs2.getString("TEL");
				result.add(cus);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	public ArrayList<customer> selectRFgrp11(String iRgrp, String iRgrpnum,String iFgrp,String iFgrpnum) {
		ArrayList<customer> result = new ArrayList<customer>();
		try {
			String query = "SELECT * FROM customer WHERE " + iRgrp + "=" + "'" + iRgrpnum + "'"
			+" AND "+ iFgrp + "=" + "'" + iFgrpnum+"'";
			rs3 = st.executeQuery(query);
			while (rs3.next()) {
				customer cus = new customer();
				cus.c_id = rs3.getString("C_Id");
				cus.c_name = rs3.getString("C_Name");
				cus.recency = rs3.getDouble("Recency");
				cus.frequency = rs3.getDouble("Frequency");
				cus.monetary = rs3.getDouble("Monetary");
				cus.buy_date = rs3.getString("Buy_Date");
				cus.lastbuy_date = rs3.getString("Lastbuy_Date");
				cus.firstbuy_date = rs3.getString("Firstbuy_Date");
				cus.buytimes = rs3.getInt("Buytimes");
				cus.beforetotalmoney = rs3.getDouble("Beforetotalmoney");
				cus.thistimetotalmoney = rs3.getDouble("Thistimetotalmoney");
				cus.response_rate = rs3.getDouble("Response_Rate");
				cus.promote_times = rs3.getInt("Promoting_Times");
				cus.response_times = rs3.getInt("Response_Times");
				cus.promoting = rs3.getString("Promoting");
				cus.gender = rs3.getString("Gender");
				cus.tel = rs3.getString("TEL");
				result.add(cus);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	public ArrayList<customer> selectRFgrp12(String iRgrp, String iRgrpnum,String iFgrp,String iFgrpnum) {
		ArrayList<customer> result = new ArrayList<customer>();
		try {
			String query = "SELECT * FROM customer WHERE " + iRgrp + "=" + "'" + iRgrpnum + "'"
			+" AND "+ iFgrp + "=" + "'" + iFgrpnum+"'";
			rs4 = st.executeQuery(query);
			while (rs4.next()) {
				customer cus = new customer();
				cus.c_id = rs4.getString("C_Id");
				cus.c_name = rs4.getString("C_Name");
				cus.recency = rs4.getDouble("Recency");
				cus.frequency = rs4.getDouble("Frequency");
				cus.monetary = rs4.getDouble("Monetary");
				cus.buy_date = rs4.getString("Buy_Date");
				cus.lastbuy_date = rs4.getString("Lastbuy_Date");
				cus.firstbuy_date = rs4.getString("Firstbuy_Date");
				cus.buytimes = rs4.getInt("Buytimes");
				cus.beforetotalmoney = rs4.getDouble("Beforetotalmoney");
				cus.thistimetotalmoney = rs4.getDouble("Thistimetotalmoney");
				cus.response_rate = rs4.getDouble("Response_Rate");
				cus.promote_times = rs4.getInt("Promoting_Times");
				cus.response_times = rs4.getInt("Response_Times");
				cus.promoting = rs4.getString("Promoting");
				cus.gender = rs4.getString("Gender");
				cus.tel = rs4.getString("TEL");
				result.add(cus);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	public void combinegroup(ArrayList<customer> rfmnum) 
	{
		for(int i=0;i<rfmnum.size();i++)
		{
		try {
			String query = "UPDATE customer SET Rfmgrp=" + "'"+(rfmnum.get(i).rgrp+rfmnum.get(i).fgrp+rfmnum.get(i).mgrp) + "'"+
					" WHERE C_Id='"+rfmnum.get(i).c_id+"'";
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		}

	}
	public String selectrfm(String icid)
	{
		String grp="";
		try {
			String query = "SELECT Rfmgrp FROM customer WHERE C_id=" + "'"+ icid + "'" ;
			rs4 = st.executeQuery(query);
			while (rs4.next()) {
			   grp=rs4.getString("Rfmgrp");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return grp;
	}
	
	
}
