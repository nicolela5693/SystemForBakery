package main;
import java.awt.List;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//member_register
public class customerassign 
{

	public static ArrayList <customer> sortrecency (ArrayList <customer> original) 
	{
		ArrayList<customer> result = null;
        int n = original.size();
        ArrayList<customer> temp = new ArrayList<customer>();
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(original.get(j-1).recency > original.get(j).recency){
                                //swap the elements!
                        		temp.add(original.get(j-1));
                        		original.set(j-1,original.get(j));
                        		original.set(j,temp.get(0));
                                temp.remove(0);
                        }
                       
                }
		}
		return original;
	} 
	public static ArrayList <customer> sortfrequency (ArrayList <customer> original) 
	{
		ArrayList<customer> result = null;
        int n = original.size();
        ArrayList<customer> temp = new ArrayList<customer>();
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(original.get(j-1).frequency < original.get(j).frequency){
                                //swap the elements!
                        		temp.add(original.get(j-1));
                        		original.set(j-1,original.get(j));
                        		original.set(j,temp.get(0));
                                temp.remove(0);
                        }
                       
                }
		}
		return original;
	} 
	public ArrayList <customer> sortmonetary (ArrayList <customer> original) 
	{
		ArrayList<customer> result = null;
        int n = original.size();
        ArrayList<customer> temp = new ArrayList<customer>();
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(original.get(j-1).monetary < original.get(j).monetary){
                                //swap the elements!
                        		temp.add(original.get(j-1));
                        		original.set(j-1,original.get(j));
                        		original.set(j,temp.get(0));
                                temp.remove(0);
                        }
                       
                }
		}
		return original;
	} 
  }
