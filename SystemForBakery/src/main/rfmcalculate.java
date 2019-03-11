package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rfmcalculate 

{	
	public static double recencycal(String buying_date, String lastbuying_date) throws ParseException
	{
			double recency;
	        String dateStr1 = lastbuying_date; //2008-1-1 1:21:28
	        String dateStr2 = buying_date;//2010-1-2 1:21:28
	        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1 = format1.parse(dateStr1);
            Date date2 = format2.parse(dateStr2);
	        recency = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return recency;
	}
	
	public static double monthfrequencycal(double buyingtimes, String buying_date, String firstbuying_date) throws ParseException
	{
		buyingtimes=buyingtimes+1;
		double daydistance;
		double monthdistance;
		double monthfrequency;
		daydistance = recencycal(buying_date,firstbuying_date);
		monthdistance=daydistance/30;
		monthfrequency=Math.round((buyingtimes/monthdistance*100.0))/100.0;//round to 2decimal
		return monthfrequency;	
	}
	
	public static double monthmonetarycal(double before_totalmoney,double thistime_totalmoney, String buying_date, String firstbuying_date) throws ParseException
	{
		double now_totalmoney=before_totalmoney+thistime_totalmoney;
		double monthmonetary;
		double daydistance;
		double monthdistance;
		daydistance = recencycal(buying_date,firstbuying_date);
		monthdistance=(double)daydistance/30;
		monthmonetary=Math.round((now_totalmoney/monthdistance*100.0))/100.0;//round to 2decimal
		return monthmonetary;		
	}

	
	
}