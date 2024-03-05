
package com.sbilife.BuilderNew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sbilife.builder.BuilderBean;
import com.sbilife.common.CommonForAllProd;

public class BuilderNewLogic {
 CommonForAllProd comm = new CommonForAllProd();
 BuilderNewBean bean = new BuilderNewBean();
 
 BuilderNewDb db = new BuilderNewDb();
 BuilderNewProperties prop = new BuilderNewProperties();
 
 
 public BuilderNewLogic( BuilderNewBean bean) {
	 this.bean= bean;

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
	 {  if(bean.getPremiumPayingTerm()==7 || bean.getPremiumPayingTerm()==10|| bean.getPremiumPayingTerm() == 12)
		   ppt = bean.getPremiumPayingTerm();
	 else
		 System.out.println("wrong input in Premium Paying Term it will be either 7,10 or 12");
	    
	 }
	 return premiumPayingTerm();
 }
   public double getpremiumMode()
   {    double mod= 0;
     if( bean.getPremiumPaymentMode().equalsIgnoreCase("yearly"))
    	 mod= 1;
     
     return mod;
    	 
   }
   // premium
   public double getPremium(double month, double year) {
		double val1 = month - 1;
		double val2 = 12 / getpremiumMode();
		double mod = val1 % val2;
		double premium = 0;

		if (year > 0 && year <= premiumPayingTerm() && mod == 0) {
			premium = bean.getBasePremium();
		} else {
			premium=0;
		}
		return premium;
	}

   //allocation charge
   
   public double premallocationchargeInputPG(boolean bancaDiss, double year) {
		double allocCharge = 0;
		double ot = 0;
		if (bean.getPlanType().equals("Regular")) {
			if (year == 1) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 3) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 5) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 7) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}

		} else if (bean.getPlanType().equals("Single")) {
			if (year == 1) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.02 * 1;
				}
			} else {
				return 0;
			}

		} else if (bean.getPlanType().equals("LPPT")) {
			if (year == 1) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2 || year == 3) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4 || year == 5) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6 || year == 7) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (bean.isStaffDis() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (bean.isStaffDis() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}
		}
		return ot;
	}
   //  allocation result
   public double getPremiumAllocCharge(double month, double year, boolean bancaDiss) {
		double  allo= getPremium(month, year) * premallocationchargeInputPG(bancaDiss, year);
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
			double invest = getPremium(month, year)
					- getPremiumAllocCharge(month, year, bancaDiss) - (getTaxOnAllocation_K(month, year, bancaDiss));
			
			String res = comm.getRoundUp(String.valueOf(invest));
			return  Double.parseDouble(res);
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
			if (bean.getPlanType().equals("Regular")) {
				if (prop.samfMin_regular_PPT == prop.samfMax_LPPT_PPT) {
					output = prop.samfMax_regular_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (bean.getPlanType().equals("Single")) {
				if (prop.samfMin_single_PPT == prop.samfMax_single_PPT) {
					output = prop.samfMax_single_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (bean.getPlanType().equals("LPPT")) {
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
			if (bean.getAge()-1 == i) {
				output = arr[i];
			}
		}
		return output;
	}
    public double getMortalityAndMorbidityCharges4(double year, double month, boolean bancdiss, double sumprem){
    	double mortalityCharge = getMortalityChargesTable();
		double AW = 0;
		if (month == 1) {
			AW = 0;
		} else {
		AW = getFundValueAtEnd4(year, month, bancdiss);//getFundValueAtEnd_AW_pass()   needed
		}

		double inner1max1 = Math.max(0, SumAssured());
		double max1 = Math.max(inner1max1, sumprem);

		double inner1max2 = Math.max(SumAssured(), (sumprem * 1.05 - AW));

		double val1 = mortalityCharge / 12;
		double val2 = 1 - 0;
		double val3 = Math.max((max1 - (getAmtAvailForInvestment(month, year, bancdiss) + AW)), 0);
		double val4 = 0;
		double val5 = Math.max(inner1max2, 0);
		double val6 = 0;
		if (prop.moralityCharges) {
			val6 = 1;
		}

		double s = (val1 * val2 * val3 + val4 * val5)  * val6;
		return Math.round(s);
  	}
    
   
    
    

    
    
  /*  public double getOtherCharges4()
    {  double output = getPremiumAllocCharge(getMoralityCharges4(), getDonotuse(), false)+getPolicyAdministrationCharge(getDonotuse())+
    getPPWBCharges(getMoralityCharges4(), getDonotuse())+getAdbAtpdcharges(getDonotuse())+
    	
    }
    */
    
    //========================================total tax
    
	public double totalTax() {
		return 0.18;
	}

	public double getTotalCharges4(double year, double month) {
		     double totalCharges =0;
		if (year == 0) {
			return  0;

		} else {
			totalCharges= getMortalityAndMorbidityCharges4(year, month, false, totalCharges)+getAdbAtpdcharges(year)+getPPWBCharges(month, year)+getDonotuse()+getPolicyAdministrationCharge(year);
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double diff = comm.getMonthDiff(date2, date1) + 1;
		return diff;
	}
    public double getTotalTaxSurr4(double year, double month)
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
    		res2=getMortalityAndMorbidityCharges4(year, month, false, res)+0+ getAdbAtpdcharges(year)+getPPWBCharges(month, year);
    	}
    	else
    		res2=0;
    	
    	if(month <= AM3())
    	{
    		res3= totalTax();
    		
    	}
    	else
    		res3 = prop.ServiceTax;
    	
    	return (res+res2)* res3;
    }
    
    
    public double getTotalTax4(double month, double year, boolean bancdiss) {
    	

    	double res = 0;
    	double res2=0;
    	double res3=0;
    	
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
    	
    	
    	res3 = getTotalTaxSurr4(year, month)+getTaxOnAllocation_K(month, year, bancdiss);//pending tax fms=+===========================
    	
    	return  (res3+res)*res2;
    }
    
    //================================================AA onword
   	public double getGuranteeAddition4() {
   		return 0;
   	}
   	public double getTerminalAddition4()
   	{
   		return 0;
   	}
   	public double getFundValueAtEnd4(double year,double month, boolean bancaDiss) {
   		return getGuranteeAddition4()+getTerminalAddition4()+getFundValueAfterFmc4(year, month, bancaDiss);
   	}
   	public double getFundValueAfterFmc4(double year,double month, boolean bancaDiss) {
   		if(year ==0)
   			return 0;
   		else
   			return getfundBeforeFmc4(year, month, bancaDiss)-getfundManagementCharge4(year, month, bancaDiss) - getGuarantedcharges4()-getTaxonFmc4(year, month, bancaDiss);
   		 	}
   	
   	public double getTaxonFmc4(double year, double month,boolean bancaDiss) {
   		double a =0;
   		double b =0;
   		double c= 0;
   		double res =0;
   		if(year == 0)
   		{
   			a =0;
   		}
   		else
   			a=getfundManagementCharge4(year, month, bancaDiss)*0.12525/0.12525;
   		
   		if(month<=0)
   			b = prop.totalTax;
   		else
   			b = prop.ServiceTax;
   		
   		if(prop.fund_management_charge== true)
   			c= 1;
   		else 
   			c =0;
   		 
   		res= a*b*c;
   		return comm.roundUP(res, 2);
   		
   		
   	}
   	
   	public double getGuarantedcharges4()
   	{
   		return 0;
   	}
   	
   	public double getfundBeforeFmc4(double year,double month,boolean bancaDiss) {
   		double res = 0;
		if (month == 1) {
			res = 0;
		} else {
			res = getFundValueAtEnd4(year, month, bancaDiss);
			
			return comm.roundUP(res, 2);
		}
   			
		
		if(year==0)
			return 0;
		else
			return res+getAmtAvailForInvestment(month, year, bancaDiss)+getAdditiontoFund4(year, month, bancaDiss)-getTotalCharges4(year, month)- getTotalTaxSurr4(year, month);
   	}
   	
   	
   	public double getfundManagementCharge4(double year,double month, boolean bancaDiss) {
   		double res=0;
   		if(year==0)
   			return 0;
   		else
   			res = getfundBeforeFmc4(year, month, bancaDiss) * 0.12525/12;
   		
   		return comm.roundUP(res, 2);
   	}
   	
   	public double getAdditiontoFund4(double year,double month, boolean bancaDiss) {
   	
		double res = 0;
		double use= 0;
		
		if (month == 1) {
			use = 0;
		} else {
			use = getFundValueAtEnd4(year, month, bancaDiss);
		}
		
		if(year ==0)
		{
			return 0;
		}
		
		else 
			res= (use+getAmtAvailForInvestment(month, year, bancaDiss)-getTotalCharges4(year, month)-getTotalTaxSurr4(year, month)) *0.00327;
		
		return comm.roundUP(res, 2);
   	}
   	
   	//========================================complete  upto AE===============================================
   	
   	
     
   
    
    
    
   
   
   
   
}
   
   
   
   
   
   
   
   
   
  
 

