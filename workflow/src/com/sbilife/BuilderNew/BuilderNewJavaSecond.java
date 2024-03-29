package com.sbilife.BuilderNew;

import com.sbilife.common.CommonForAllProd;

public class BuilderNewJavaSecond {
	CommonForAllProd comm  = new CommonForAllProd();
	StringBuilder reVal= null;
	
	public String calculatePrem(String age, String policyTerm,String ageOfProposer,
			String genderOfLifeInsured,String genderOfProposer, String premiumPaymentMode,String planType,String proposalDate,
		String	basePremium, String StaffDis) {
		
		BuilderNewBean bean = new BuilderNewBean();
		try {
			bean.setAge(Integer.parseInt(age));
			bean.setPolicyTerm(Integer.parseInt(policyTerm));
			bean.setAgeOfProposer(Integer.parseInt(ageOfProposer));
			bean.setGenderOfLifeInsured(genderOfLifeInsured);
			bean.setGenderOfProposer(genderOfProposer);
			bean.setPremiumPaymentMode(premiumPaymentMode);
			bean.setPlanType(planType);
			bean.setProposalDate(proposalDate);
			bean.setBasePremium(Double.parseDouble(basePremium));
			bean.setStafDisc(Boolean.parseBoolean(StaffDis));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 return builderOutput(bean);
	}
	
	 public String builderOutput(BuilderNewBean bean) {
		 
		 BuilderNewLogic log = new BuilderNewLogic(bean);
		 reVal = new StringBuilder();
		 boolean bancaDiss = false;
		 double sumPrem=0;
		 
		
		 reVal.append("<?xml version='1.0' encoding='utf-8' ?><Builder>");
		
		 reVal.append("<BasePremium>"+bean.getBasePremium()+"</BasePremium>");
		 reVal.append("<SumAssured>" + log.SumAssured() +"</SumAssured>");
		for (int i = 1; i <= bean.getPolicyTerm() *12 ; i++) {
			
			int month = (int)log.month(i);
		   reVal.append("<Month>"+month+"</Month>");
		   
		     int year =  (int)log.year(i);
	         reVal.append("<Year>"+ year+"</Year>");	
	        
	       
	       	 reVal.append("<Age>"+log.age(year)+"</Age>");
      		 sumPrem+=bean.getBasePremium();
      		 
      		
      		 double annualprem =log.getAnnualPremium(month, year);
     	   reVal.append("<AnnualPremium>" + annualprem+"</AnnualPremium>");
     	    
     
      	double premallocCharge= log.getPremiumAllocCharge(month, year, bancaDiss);
     		reVal.append("<PremiumAllocationCharges>"+ premallocCharge+"</PremiumAllocationCharges>");
     		
			reVal.append("<taxAllocationCharges>" + log.getTaxOnAllocation_K(month, year, bancaDiss)+ "</taxAllocationCharges>");
			reVal.append("<AmountAvailableForInvestment>" + log.getAmtAvailForInvestment(month, year, bancaDiss) + "</AmountAvailableForInvestment>");
		    reVal.append("<PolicyAdminiStrationCharges>" + log.getPolicyAdministrationCharge(year) + "</PolicyAdminiStrationCharges>");
			reVal.append("<ppwbCharges>" + log.getPPWBCharges(month, year) + "</ppwbCharges>");
			//============================================++++++++++++++++++++++++++++++++++++++++++++++++++///////////////////
			
	    reVal.append("<MortalityAndMobidityCharges>" + log.getMortalityAndMorbidityCharges4(year, month, bancaDiss, sumPrem)+ "</MortalityAndMobidityCharges>");
		    reVal.append("<TotalCharges>" + log.getTotalCharges4(year, month, bancaDiss, sumPrem) + "</TotalCharges>");	
		    reVal.append("<TotalTaxSurr>" + log.getTotalTaxSurr4(year, month, bancaDiss, sumPrem)+ "</TotalTaxSurr>");
		    reVal.append("<TotalTax>" + log.getTotalTax4(month, year, bancaDiss, sumPrem)+ "</TotalTax>");
		    reVal.append("<AdditionToFund>" + log.getAdditiontoFund4(year, month, bancaDiss, sumPrem)+ "</AdditionToFund>");
		    reVal.append("<FundBeforeFmc>" + log.getfundBeforeFmc4(year, month, bancaDiss, sumPrem)+ "</FundBeforeFmc>");
		    reVal.append("<FundManagementCharges>" + log.getfundManagementCharge4(year, month, bancaDiss, sumPrem)+ "</FundManagementCharges>");
		    reVal.append("<TaxOnFmc>" + log.getTaxonFmc4(year, month, bancaDiss, sumPrem)+ "</TaxOnFmc>");
		    reVal.append("<FundValueAfterFmc>" + log.getFundValueAfterFmc4(year, month, bancaDiss, sumPrem)+ "</FundValueAfterFmc>");
		    reVal.append("<GuranteedAddition>" + log.getGuranteeAddition4()+ "</GuranteedAddition>");
		    reVal.append("<TerminalAddition>" + log.getTerminalAddition4()+ "</TerminalAddition>");
		    reVal.append("<FundValueAtEnd>" + log.getFundValueAtEndd4(year, month, bancaDiss, sumPrem)+ "</FundValueAtEnd>");
		    
		reVal.append("<SurrenderCharges>" + log.getSurrenderCharges4(year, month) + "</SurrenderCharges>");
			reVal.append("<TaxOnSurrenderCharges>" + log.getTaxSurrenderCharges4(year, month, bancaDiss, sumPrem) + "</TaxOnSurrenderCharges>");
		   reVal.append("<SurrenderValue>" + log.getSurrenderValue4(year, month, bancaDiss, sumPrem) + "</SurrenderValue>");
		   reVal.append("<DeathBenifit>" + log.getDeathBenifit_AI(year, month, bancaDiss, sumPrem) + "</DeathBenifit>");
			
		}
		 reVal.append("</Builder>");
		 return reVal.toString();
	 }


}
