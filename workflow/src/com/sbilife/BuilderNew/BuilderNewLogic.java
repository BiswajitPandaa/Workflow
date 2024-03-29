
package com.sbilife.BuilderNew;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.sbilife.builder.BuilderBean;
import com.sbilife.common.CommonForAllProd;

public class BuilderNewLogic {
 CommonForAllProd comm = new CommonForAllProd();
 BuilderNewBean bean = new BuilderNewBean();
 
 BuilderNewDb db = new BuilderNewDb();
 BuilderNewProperties prop = new BuilderNewProperties();
 
 public BuilderNewLogic(BuilderNewBean bean) {
		this.bean = bean;
 }
 
 public int age(double year)
 {
	 return (bean.age +(int)year) -1;
 }
 
 
 
 
 public double month(int row)
 {
	 return row;
	
 }
  
 public double year(int row) {
	 
	 double yearr = month(row)/12;
	 return comm.roundUP(yearr,0);
}
 public double premiumPayingTerm()
 {   double ppt = 0;
 
 
	 if(bean.getPlanType().equalsIgnoreCase("regular"))
	 {
		 ppt = bean.getPolicyTerm();
	 }
	 else if (bean.getPlanType().equalsIgnoreCase("single"))
		 ppt= 1;
	 else
	 {  if(bean.getPolicyTerm()==7 || bean.getPolicyTerm()==10|| bean.getPolicyTerm() == 12)
		   ppt = bean.getPolicyTerm();
	 else
		 System.out.println("wrong input in Premium Paying Term it will be either 7,10 or 12");
	    
	 }
	 return ppt;
 }
   public double getpremiumMode()
   {    double mod= 0;
     if( bean.getPremiumPaymentMode().equalsIgnoreCase("yearly"))
    	 mod= 1;
     
     return mod;
    	 
   }
   // premium
   public double getAnnualPremium(double month, double year) {
		double val1 = month - 1;
		double val2 = 12 / getpremiumMode();
		double mod = val1 % val2;
		double premium = 0;

		if (year > 0 && year <= bean.policyTerm && mod == 0) {
			premium = bean.getBasePremium();
		} else {
			premium=0;
		}
		return comm.roundUP(premium, 2);
	}

   //allocation charge
   
   public double premallocationchargeInputPG(boolean bancaDiss, double year) {
		double allocCharge = 0;
		double ot = 0;
		if (bean.getPlanType().equalsIgnoreCase("Regular")) {
			if (year == 1) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 3) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 5) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 7) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}

		} else if (bean.getPlanType().equalsIgnoreCase("Single")) {
			if (year == 1) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.02 * 1;
				}
			} else {
				return 0;
			}

		} else if (bean.getPlanType().equalsIgnoreCase("LPPT")) {
			if (year == 1) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2 || year == 3) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4 || year == 5) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6 || year == 7) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (bean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (bean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}
		}
		return ot;
	}
   //  allocation result
   public double getPremiumAllocCharge(double month, double year, boolean bancaDiss) {
		double  allo= getAnnualPremium(month, year) * premallocationchargeInputPG(bancaDiss, year);
		String res=  comm.getRoundOffLevel2New(String.valueOf(allo));
		return Double.parseDouble(res);
		
	}
   
   
   public double getTaxOnAllocation_K(double month, double year, boolean bancaDiss) {
		if (prop.admistration_charge == true) {
			double Taxall =  prop.ServiceTax * getPremiumAllocCharge(month, year, bancaDiss);
			String res = comm.getRound(String.valueOf(Taxall));
			return Double.parseDouble(res);
		} else   
			return 0;
		
	}
   
   //=======================================amnt for investment
   public double getAmtAvailForInvestment(double month, double year, boolean bancaDiss) {
		if (year == 0) {
			return 0;
		} else {
			double invest = getAnnualPremium(month, year)
					- getPremiumAllocCharge(month, year, bancaDiss) - (getTaxOnAllocation_K(month, year, bancaDiss));
			
			double res = comm.roundUP(invest, 2);
			return res;
		}
   }
   //====================================dn't use
    public double getDonotuse()
    {
    	return 0;
    }
    
    //============================== for policyAdministrationCharge
    
    public double getAdminFeePm(double year) {
 
    		double output = 0;
    		if (bean.getPlanType().equalsIgnoreCase("Single")) {
    			output = 50;
    		} else {
    			if (year == 1 || year == 2 || year == 3 || year == 4 || year == 5) {
    				output = 0;
    			} else if (year == 6 || year == 7 || year == 8 || year == 9 || year == 10 || year == 11 || year == 12) {
    				output = 60;
    			} else {
    				output = 0;
    			}
    		}
    		return output;
    	}
    
    
    public double getPolicyAdministrationCharge(double year) {
    	if(year==0)
    		return 0;
    	else
    		return getAdminFeePm(year); 	
      }
    
    //================================for ppwb charges
    
    public double PPWBCharge_Inputpg(double year) {
		double output = 0;
		
		if (year > 0 && year <= bean.getPolicyTerm()) {
			output = 0;
		} else {
			output = 0;
		}
		return output;
	}
   
    public double AnnualPrem_InputPg() {
		
		return bean.getBasePremium();
	}
    
    public double getPPWBCharges(double month, double year) {
    	double val1 = 0;
		double val2 = 0;
		if (year != 0 && month <= premiumPayingTerm() * 12 -12 * getpremiumMode()) {
			val1 = PPWBCharge_Inputpg(year) / 12 * AnnualPrem_InputPg() / 1000;
		} else {
			val1 = 0;
		}
		if (prop.Mortality_and_Rider_Charges == true) {
			val2 = 1;
		} else {
			val2 = 0;
		}
		
		return val1*val2;
	
    }
    
    //==================================================  sum asuured
    
    public double SumAssured() {
		double output = 0;
		double SAMF = 0;
		if (prop.SMAFatthediscretionofPolicyholder.equals("No")) {
			if (bean.getPlanType().equalsIgnoreCase("Regular")) {
				if (prop.samfMin_regular_PPT == prop.samfMax_regular_PPT) {
					output = prop.samfMax_regular_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (bean.getPlanType().equalsIgnoreCase("Single")) {
				if (prop.samfMin_single_PPT == prop.samfMax_single_PPT) {
					output = prop.samfMax_single_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (bean.getPlanType().equalsIgnoreCase("LPPT")) {
				if (prop.samfMin_LPPT_PPT == prop.samfMax_LPPT_PPT) {
					output = prop.samfMax_LPPT_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			}
		} else {
			output = SAMF * AnnualPrem_InputPg();
		}
		return output;
	}
    
    
    public double getAdbAtpdcharges(double  year) {
    	
    	double output = 0;

		double val1 = Math.min(SumAssured() , 5000000);
		double val2 = 0;
		double res = 0;
		double res2 = 0;
		if (year == 0) {
			res = 0;
		} else {
			res = val1 * val2 / 12000;
		}

		if (prop.moralityCharges == true) {
			res2 = 1;
		} else {
			res2 = 0;
		}

		output = res * res2;
		
		return output;
    }
   //==========================morality charges
    
    public double getMortalityChargesTable() {
		double arr[] = db.getMortalityChargesTable();
		double output = 0;
		for (int i = 0; i < arr.length; i++) {
			if (29 == i) {
				output = arr[i];
			}
		}
		return output;
	}
  
    public double getMortalityAndMorbidityCharges4(double year, double month, boolean bancdiss, double sumPrem){
    	double mortalityCharge = getMortalityChargesTable();
		double AW = 0;
		if (month == 1) {
			AW = 0;
		} else {
		AW = getFundValueAtEnd4(year, month, bancdiss,sumPrem);
		}

		double inner1max1 = Math.max(0, SumAssured());
		double max1 = Math.max(inner1max1, sumPrem);

		double inner1max2 = Math.max(SumAssured(), (sumPrem * 1.05 - AW));

		double val1 = mortalityCharge / 12;
		double val2 = 1 - 0;
		double val3 = Math.max((max1 - (getAmtAvailForInvestment(month, year, bancdiss) + AW)), 0);
		double val4 = 0;
		double val5 = Math.max(inner1max2, 0);
		double val6 = 0;
		if (prop.moralityCharges ==true) {
			val6 = 1;
		}

		double s = (val1 * val2 * val3 + val4 * val5)  * val6;
		String k =comm.getRoundOffLevel2(String.valueOf(s));
		return Double.parseDouble(k);
		
  	}
    
   
    
    

    
    
    
    
    //========================================total tax
    
	public double totalTax() {
		return 0.18;
	}

	public double getTotalCharges4(double year, double month,boolean bancaDiss,double sumPrem) {
		     double totalCharges =0;
		if (year == 0) {
			return  0;

		} else {
			totalCharges= getMortalityAndMorbidityCharges4(year, month, bancaDiss, sumPrem)+getAdbAtpdcharges(year)+getPPWBCharges(month, year)+getPolicyAdministrationCharge(year);
		}
		return totalCharges;
	}

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
	public double AM3() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = null, date2 = null;
		try {
			date1 = dateFormat.parse(bean.getProposalDate());
			date2 = dateFormat.parse(prop.kfcDate);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		double diff = comm.getMonthDiff(date2, date1) + 1;
		return diff;
	}
    public double getTotalTaxSurr4(double year, double month, boolean bancaDiss, double sumPrem)
    {
    	double res = 0;
    	double res2=0;
    	double res3=0;
    	
    	if(prop.admistration_charge == true)
    	{
    		res=  getPolicyAdministrationCharge(year);
    	}
    	else
    		res= 0;
    	
    	if(prop.Mortality_and_Rider_Charges== true)
    	{
    		res2=getMortalityAndMorbidityCharges4(year, month, bancaDiss, sumPrem)+ getAdbAtpdcharges(year)+getPPWBCharges(month, year);
    	}
    	else
    		res2=0;
    	
    	if(month <= AM3())
    	{
    		res3= totalTax();
    		
    	}
    	else
    		res3 = prop.ServiceTax;
    	
    	double k =(res+res2)* res3  ;
    	String l = comm.getRoundOffLevel2(String.valueOf(k));
    	return Double.parseDouble(l);
    }
    
    
    public double getTotalTax4(double month, double year, boolean bancdiss,double sumPrem) {
    	

    	double res = 0;
    	double res2=0;
    	double res3=0;
    	double AA = 9.41;
    	
    	if(prop.riderCharges==true)
    	{
    		res= getDonotuse();
    	}
    	else
    		res= 0;
    	
    	if(month<= AM3())
    		res2=totalTax();
    	else
    		res2 = prop.ServiceTax;
    	
    	
    	res3 = getTotalTaxSurr4(year, month, bancdiss, sumPrem)+getTaxOnAllocation_K(month, year, bancdiss)+AA;//pending tax fms=+===========================
    	String l = comm.getRoundOffLevel2(String.valueOf(res3));
    	return Double.parseDouble(l);
    }
public double getAdditiontoFund4(double year,double month, boolean bancaDiss,double sumPrem) {
	   	
		double res = 0;
		double use= 0;
		
		if (month == 1) {
			use = 0;
		} else {
			use = getFundValueAtEnd4(year, month-1, bancaDiss, sumPrem);
		}
		
		if(year ==0)
		{
			return 0;
		}
		
		else 
			res= (use+getAmtAvailForInvestment(month, year, bancaDiss)-getTotalCharges4(year, month, bancaDiss, sumPrem)-getTotalTaxSurr4(year, month, bancaDiss, sumPrem)) *0.00327373978219891;
		
		return comm.roundUP(res, 2);
   	}

public double getfundBeforeFmc4(double year,double month,boolean bancaDiss,double sumPrem) {
		double res = 0;
		double AE=0;
		if (month==1)
		{
			AE=0;
		}
		else
		{
			AE= getFundValueAtEnd4(year, month-1, bancaDiss, sumPrem);
		}
	
if (year ==0 )
{
	res=0;
}

else {
	res=AE+getAmtAvailForInvestment(month, year, bancaDiss)+getAdditiontoFund4(year, month, bancaDiss, sumPrem)-getTotalCharges4(year, month, bancaDiss, sumPrem)- getTotalTaxSurr4(year, month, bancaDiss, sumPrem);
	}

 

	
	return res;
}




	public double getfundManagementCharge4(double year,double month, boolean bancaDiss,double sumPrem) {
   		double res=0;
   		if(year==0)
   			return 0;
   		else
   			res =( getfundBeforeFmc4(year, month, bancaDiss,sumPrem) * 0.012525)/12;
   		
   		String  l = comm.getRoundOffLevel2(String.valueOf(res));
   		return Double.parseDouble(l);
   	}
	
	public double getGuarantedcharges4()
   	{
   		return 0;
   	}
   	
	public double getTaxonFmc4(double year, double month,boolean bancaDiss,double sumPrem) {
   		double a =0;
   		double b =0;
   		double c= 0;
   		double res =0;
   		if(year == 0)
   		{
   			a =0;
   		}
   	
   		else
   			a=getfundManagementCharge4(year, month, bancaDiss,sumPrem)*0.12525/0.12525;
   		
   		if(month<=0)
   			b = prop.totalTax;
   		else
   			b = prop.ServiceTax;
   		
   		if(prop.fund_management_charge== true)
   			c= 1;
   		else 
   			c =0;
   		 
   		res= a*b*c;
   		String l = comm.getRoundOffLevel2(String.valueOf(res));
   		return Double.parseDouble(l);
   			}
	
	
	public double getFundValueAfterFmc4(double year,double month, boolean bancaDiss,double sumPrem) {
   		double res =0;
   		if(year ==0)
   			return 0;
   		else {
   			res =getfundBeforeFmc4(year, month, bancaDiss,sumPrem)-getfundManagementCharge4(year, month, bancaDiss,sumPrem) -getTaxonFmc4(year, month, bancaDiss,sumPrem);
   		}
   		String l = comm.getRoundOffLevel2(String.valueOf(res));
   		return  Double.parseDouble(l);
   		 	}
	
    //================================================AA onword
   	public double getGuranteeAddition4() {
   		return 0;
   	}
   	public double getTerminalAddition4()
   	{
   		return 0;
   	}
   	
   	public double getFundValueAtEnd4(double year,double month, boolean bancaDiss,double sumPrem) {
   		
   		return getFundValueAfterFmc4(year, month, bancaDiss, sumPrem);
         	}
	public double getFundValueAtEndd4(double year,double month, boolean bancaDiss,double sumPrem) {
   		
   		return getFundValueAfterFmc4(year, month, bancaDiss, sumPrem);
         	}
   	
   	
   
   	
   
   	
	
	
   
   
   	
   	
  
   	
   
   	
   	//========================================complete  upto AE===============================================
   	
   	//=============================for sureender charges percentage
   	public double getSurrenderChargePer(double year) {  
		double rate = 0;
		
		if (bean.getPlanType().equalsIgnoreCase("Single")) {
			if (bean.getBasePremium() > 25000) {
				if (year == 1) {
					rate = 0.02;
				} else if (year == 2) {
					rate = 0.015;
				} else if (year == 3) {
					rate = 0.01;
				} else if (year == 4) {
					rate = 0.005;
				} else {
					rate = 0;
				}
			} else {
				rate = 0;
			}
		} else

		{
			

				if (bean.getBasePremium() > 50000) {

					if (year == 1) {
						rate = 0.06;
					} else if (year == 2) {
						rate = 0.04;
					} else if (year == 3) {
						rate = 0.03;
					} else if (year == 4) {
						rate = 0.02;
					} else {
						rate = 0;
					}
				} else {
					if (year == 1) {
						rate = 0.2;
					} else if (year == 2) {
						rate = 0.15;
					} else if (year == 3) {
						rate = 0.1;
					} else if (year == 4) {
						rate = 0.05;
					} else {
						rate = 0;
					}		}
			
		}

		return rate;
	}
   	
   	
   	public double getSurrenderChargesCap(double year,double month) {  
		double rate = 0;
		
		if (bean.getPlanType().equalsIgnoreCase("Single")) {
			if (bean.getBasePremium() > 25000) {
				if (year == 1) {
					rate = 3000;
				} else if (year == 2) {
					rate = 2000;
				} else if (year == 3) {
					rate = 1500;
				} else if (year == 4) {
					rate = 1000;
				} else {
					rate = 0;
				}
			} else {
				rate = 0;
			}
		} else

		{
			

				if (bean.getBasePremium() > 50000) {

					if (year == 1) {
						rate = 6000;
					} else if (year == 2) {
						rate = 5000;
					} else if (year == 3) {
						rate = 4000;
					} else if (year == 4) {
						rate = 1000;
					} else {
						rate = 0;
					}
				} else {
					if (year == 1) {
						rate = 3000;
					} else if (year == 2) {
						rate = 2000;
					} else if (year == 3) {
						rate = 1500;
					} else if (year == 4) {
						rate = 1000;
					} else {
						rate = 0;
					}
				}
			
		}

		return rate;
	}

    
   	

     
     public double getSurrenderCharges4(double year,double month)
     {
    	 double res= 0;
    	 double res1 =0;
    	 double output =0;
    	 res = bean.getBasePremium();
    	 res1= res*getSurrenderChargePer(year);
    	
    	 output=Math.min(res1, getSurrenderChargesCap(year,month));
    	 return comm.roundUP(output, 2);	 
    	 
     }
    
     ///////////tax on surrender charges/////////////////////////////////////////
     public double getTaxSurrenderCharges4(double year,double month, boolean bancaDiss,double sumPrem)
     
     {  double res =0;
    	 if(prop.surrender_charge == true)
    	 {
    		 res = getSurrenderCharges4(year, month)*0.18;
    		 
    	 }
    	 return comm.roundUP(res, 2);
    	 
     }
     
     public double getSurrenderValue4(double year,double month, boolean bancaDiss,double sumPrem)
     {
    	 double res= 0;
    	 double a =0;
    	 if(bean.getPlanType().equalsIgnoreCase("Retire Smart Plus"))
    		 a=getTerminalAddition4();
    	 else
    		 a=0;
    	 
    	 res = getFundValueAtEnd4(year, month, bancaDiss,sumPrem)-getSurrenderCharges4(year, month) -getTaxSurrenderCharges4(year, month, bancaDiss,sumPrem)-a;
    	 
    	 return res;
    	 
     }
     public double getDeathBenifit_AI(double year,double month, boolean bancaDiss,double sumPrem) {
 		
 		double output = 0;
 		
 		double AE = getFundValueAtEnd4(year, month, bancaDiss,sumPrem);
 		double max1val1 = (AE + 0);
 		double max1val2 = SumAssured() * 1 ;
 		double max1val3 = sumPrem * 1.05;

 		double val1val2 = Math.max(max1val1, max1val2);

 		double max1 = Math.max(val1val2, max1val3);

 		// ---------------

 		double max2val1 = AE + (SumAssured() * 1);
 		double max2val2 = sumPrem * 1.05;
 		double max2 = Math.max(max2val1, max2val2);

 		double val2 = 0 * max2;
 		output = max1 + val2;
 		return output;
 	}
     
     
     
    
    
   
   
   
   
}
   
   
   
   
   
   
   
   
   
  
 

