package main;
import java.util.ArrayList;

public class rfmrank 
{
    public static void combineRFMnum(ArrayList <customer> original)
    {
    	for(int i=0;i<=original.size()-1;i++)
    	{
    		original.get(i).rfmgrp=original.get(i).rgrp+original.get(i).fgrp+original.get(i).mgrp;
    	}
    }

}
