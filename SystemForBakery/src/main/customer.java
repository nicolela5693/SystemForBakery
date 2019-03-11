package main;
import java.text.ParseException;
import java.util.ArrayList;

public class customer 
{
	public String c_id;
	public String c_name;
	public double recency; 
	public double frequency;
	public double monetary;
	public String    rgrp;
	public String    fgrp;
	public String    mgrp;
	public String    rfmgrp;
	
	public String buy_date; //format:2008-1-1 
	public String lastbuy_date;//format:2008-1-1 
	public String firstbuy_date;
	public int buytimes;
	public double beforetotalmoney;
	public double thistimetotalmoney;
	public ArrayList<order> orderhistory=new ArrayList <order>(); //from database
	
	public String promoting;
	public double  response_rate;
	public int promote_times;
	public int response_times;
	
	public String gender;
	public String tel;
	
	public customer() throws ParseException
	{
		buytimes=0;
		beforetotalmoney=0;
		promoting="0";
	}	
                                                     
	
}
