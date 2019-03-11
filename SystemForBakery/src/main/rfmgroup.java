package main;
import java.util.ArrayList;

public class rfmgroup 
{
	String group_id;
	double avg_response_rate;
	double BEI;
	double costper;
	ArrayList<customer> groupmember=new ArrayList<customer>();
	
	public rfmgroup(String i_group_id)
	{
		group_id=i_group_id;
	}
	public void rfhgrpmember(ArrayList<customer> i_grp_customerlist)
	{
		groupmember.clear();
		for(int i=0;i<=i_grp_customerlist.size()-1;i++)
		{
			groupmember.add(i_grp_customerlist.get(i));
		}
	}
	
	public void groupcheck(ArrayList<customer> i_grp_customerlist)
	{
		if(group_id.equals(i_grp_customerlist.get(0).rfmgrp))
		{
			System.out.println("Group Setting Right");
		}
		else
		{
			System.out.println("Group Setting Wrong");
		}
	}
	public void avg_response_rate_cal()
	{
		double total_response_rate=0;
		for(int i=0;i<=groupmember.size()-1;i++)
		{	
			total_response_rate = total_response_rate+groupmember.get(i).response_rate;			
		}
		avg_response_rate=total_response_rate/groupmember.size();
		//avg_response_rate=0.8;
	}

}
