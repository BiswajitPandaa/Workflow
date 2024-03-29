package com.sbilife.smartannuityplus6;

import com.sbilife.common.CommonForAllProd;

public class AnnuityBusinessLogic {
	
	
	AnnuityBean bean = new AnnuityBean();
	AnnuityDB db = new AnnuityDB();
	AnnuityProperties prop = new AnnuityProperties();
	CommonForAllProd comm = new CommonForAllProd();
	public AnnuityBusinessLogic(AnnuityBean bean) {
		this.bean=bean;	
	}
	
	final int maxagejointImmediate=100;
	final int minagejointImmediate =0;
	final int maxageSingleDeferred=75;
	final int minageSingleDeferred =45;
	
	public int getNumberAsPerOptionType() {
		int val = 0;
		String OptionType= bean.getOptionType();
		if (OptionType.equals("Life Annuity")) {
			val = 1;
		} else if (OptionType.equals("Life Annuity with Return of Purchase Price")) {
			val = 2;
		} else if (OptionType.equals("Life Annuity with Return of Balance Purchase Price")) {
			val = 3;
		} else if (OptionType.equals("Life Annuity with Annual Simple Increase of 3%")) {
			val = 4;
		} else if (OptionType.equals("Life Annuity with Annual Simple Increase of 5%")) {
			val = 5;
		} else if (OptionType.equals("Life Annuity with certain period of 10 years")) {
			val = 6;
		} else if (OptionType.equals("Life Annuity with certain period of 20 years")) {
			val = 7;
		} else if (OptionType.equals("Life Annuity with Annual Compound Increase of 3%")) {
			val = 8;
		} else if (OptionType.equals("Life Annuity with Annual Compound Increase of 5%")) {
			val = 9;
		}
		
		return val;
	}
	
	
	public double getVestingAMount_X()
	{
		double res = bean.getAnnuAmt();
		return res;
		
	}
	
	public double getServiceTax_Y() {
		
		double res =0;
		if(prop.AI9==5)
		{
			return 0;
			
		}
		
		else
		{
			 res = getVestingAMount_X() -( getVestingAMount_X() /(1+0.018));
		}
		 
		
		return comm.roundDown(res,4);
		
	}
	
	public double getAmountAfterServiceTax_Z()
	{
		double res = getVestingAMount_X() - getServiceTax_Y();
		
		return res;
	}
	//  Required for AnnuityAMount
	
	public double getSingleLifeImmediate()
	{  double output=0;
	  String plantype= bean.getPlantype();
	  String lifeType= bean.getLifeType();
	  int optionType = getNumberAsPerOptionType();
	  
	  double arr[]=null;
	  
	  if(plantype.equalsIgnoreCase("IMMEDIATE ANNUITY") && lifeType.equalsIgnoreCase("Single Life"))
	  {
		  arr= db.getSingleLifeImmediate(optionType);
	  }
	  
	 for(int i=0;i<=100;i++)
	 {
		 if(bean.getAge() ==i)
		 {
			 output = arr[i];
		 }
	 }
	 return output;
	  
		
	}
	
	
	public double getSingleLifeDeferred()
	{  double output=0;
	  String plantype= bean.getPlantype();
	  String lifeType= bean.getLifeType();
	  double arr[]=null;
	  if(plantype.equalsIgnoreCase("DEFERRED ANNUITY") && lifeType.equalsIgnoreCase("Joint Life"))
	  {
		  arr= db.getSingleLifeDeferred();
	  }
	   
	  int row =( minageSingleDeferred-1)  - bean.getAge();
		 int col =10;
		 int min = row*col ; 
		
		 output = arr[min+col];
		 System.out.println(output);
	
	 return output;
	}
	
	
	public double getJointLifeImmediate()
	{ 
		 String output =null;
		 int row = bean.getAge();
		 int col =bean.getsAnuAge();
		 int min = row*(maxagejointImmediate-minagejointImmediate) +row;
		 
		 String res = db.getJointLifeImmediate();
		 
		 String arr[] = comm.split(res,",");
		 
		 output = arr[min+col];
		 return Double.parseDouble(output);
	}
	
	
	    
	
	
	
	
	
	
	
	
//	public double getAnnuityRate_L() {
//		if(prop.AI9==5)
//		{
//			
//		}
//	}
//	

}
