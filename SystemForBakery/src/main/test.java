package main;

public class test {

	public static void main(String[] args)
	{
		String name="Happy";
		String sex="male";
		String phonenumber="091234";
		
		String query = "INSERT INTO order (Customer_Id, A_amount, B_amount, C_amount, Totalmoney, Profit, Deliver_Date) VALUES"
				+ "(" + 31 + "," + 1 + "," + 2 + "," + 3 + "," + 360 + "," + 180 + ",'" + "2018-02-08" + "')";;
	
		// TODO Auto-generated method stub
		System.out.println(query);

	}

}
