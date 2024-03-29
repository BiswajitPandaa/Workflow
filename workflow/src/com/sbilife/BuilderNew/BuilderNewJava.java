package com.sbilife.BuilderNew;

import com.sbilife.common.CommonForAllProd;

import newSaralSwadhan.newSaralSwadhanDb;

public class BuilderNewJava {
//	CommonForAllProd comm  = new CommonForAllProd();
//	StringBuilder reVal= null;
	
//	public String calculatePrem(String age, String policyTerm,String ageOfProposer,
//			String genderOfLifeInsured,String genderOfProposer, String premiumPaymentMode,String planType,String proposalDate,
//		String	basePremium, String StaffDis) {
//		
//		BuilderNewBean bean = new BuilderNewBean();
//		try {
//			bean.setAge(Integer.parseInt(age));
//			bean.setPolicyTerm(Integer.parseInt(policyTerm));
//			bean.setAgeOfProposer(Integer.parseInt(ageOfProposer));
//			bean.setGenderOfLifeInsured(genderOfLifeInsured);
//			bean.setGenderOfProposer(genderOfProposer);
//			bean.setPremiumPaymentMode(premiumPaymentMode);
//			bean.setPlanType(planType);
//			bean.setProposalDate(proposalDate);
//			bean.setBasePremium(Double.parseDouble(basePremium));
//			bean.setStafDisc(Boolean.parseBoolean(StaffDis));
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	// return builderOutput(bean);
//	}
	
//	 public String builderOutput(BuilderNewBean bean) {
		 
//		 BuilderNewLogic = new BuilderNew(bean);
//		 reVal = new StringBuilder();
//		 boolean bancaDiss = false;
//		 double sumPrem=0;
//		 
//		
//		 reVal.append("<?xml version='1.0' encoding='utf-8' ?><Builder>");
//		
//		 reVal.append("<BasePremium>"+bean.getBasePremium()+"</BasePremium>");
//		 reVal.append("<SumAssured>" + log.SumAssured() +"</SumAssured>");
//		for (int i = 1; i <= bean.getPolicyTerm() *12 ; i++) {
//			log.setMonth_E(i);
//			int month = Integer.parseInt(log.getMonth_E());
//		   reVal.append("<Month>"+month+"</Month>");
//		   log.setYear_F();
//		     int year =  Integer.parseInt(log.getYear_F());
//	         reVal.append("<Year>"+ year+"</Year>");	
//	         log.setAge();
//	         double  Age =  Double.parseDouble(log.getAge());
//	       	 reVal.append("<Age>"+Age+"</Age>");
//      		 sumPrem+=bean.getBasePremium();
//      		 
//      		 log.setPremium_I(month, year);
//      		 double annualprem =Double.parseDouble(log.getPremium_I());
//     	   reVal.append("<AnnualPremium>" + annualprem+"</AnnualPremium>");
//     	    
//     	log.setPremAllocCharge_J(month, year, bancaDiss);
//      	double premallocCharge= Double.parseDouble(log.getPremAllocCharge_J());
//     		reVal.append("<PremiumAllocationCharges>"+ premallocCharge+"</PremiumAllocationCharges>");
//     		
//     		log.setTaxOnAllocation_K(month, year, bancaDiss);
//     		double taxalloc = Double.parseDouble(log.getTaxOnAllocation_K());
//	        reVal.append("<taxAllocationCharges>" + taxalloc + "</taxAllocationCharges>");
//	        
//	        log.setAmtAvailForInvestment(month, year, bancaDiss);
//	        double amountAvl = Double.parseDouble(log.getAmtAvailForInvestment());
//		reVal.append("<AmountAvailableForInvestment>" + amountAvl + "</AmountAvailableForInvestment>");
//		
//		log.setpolicyAdministrationCharge_N(year);
//		double policyadmin = Double.parseDouble(log.getpolicyAdministrationCharge_N());
//	    reVal.append("<PolicyAdminiStrationCharges>" + policyadmin + "</PolicyAdminiStrationCharges>");
//	    
//	    log.setPPWBCharges_O(month, year);
//	    double ppwbCharges = Double.parseDouble(log.getPPWBCharges_O());
//  reVal.append("<ppwbCharges>" + ppwbCharges + "</ppwbCharges>");
//  
//  
//			//============================================++++++++++++++++++++++++++++++++++++++++++++++++++///////////////////
//		  log.setMortalityRate_R(year, month, bancaDiss, sumPrem);
//		   double mortality = Double.parseDouble(log.getMortalityRate_R());
//        reVal.append("<MortalityAndMobidityCharges>" + mortality+ "</MortalityAndMobidityCharges>");
//        
//            log.setTotalCharges_T(year, month, bancaDiss, sumPrem);
//            double totalCharges = Double.parseDouble(log.getTotalCharges_T());
//      reVal.append("<TotalCharges>" + totalCharges + "</TotalCharges>");	
//      
//      log.setTotalTax_U(year, month, bancaDiss, sumPrem);
//      double taxtotalSurr = Double.parseDouble(log.getTotalTax_U());
//	    reVal.append("<TotalTaxSurr>" + taxtotalSurr+ "</TotalTaxSurr>");
//	    
//	    log.setTotalTax_V(month, year, bancaDiss);
//	    double totaTax = Double.parseDouble(log.getTotalTax_V());
// reVal.append("<TotalTax>" + totaTax+ "</TotalTax>");
// 
// log.setAdditionToFund_W(month, year, bancaDiss, sumPrem);
// double addition = Double.parseDouble(log.getAdditionToFund_W());
//	    reVal.append("<AdditionToFund>" + addition+ "</AdditionToFund>");
//  
//  log.setFundBeforeFMC_X(month, year, bancaDiss, sumPrem);
//  double fundBeforefmc = Double.parseDouble(log.getFundBeforeFMC_X());
//    reVal.append("<FundBeforeFmc>" +fundBeforefmc+ "</FundBeforeFmc>");
//  
//     log.setFundManagementCharge_Y(month, year, bancaDiss, sumPrem);
//     double fundMangmentCharg = Double.parseDouble(log.getFundManagementCharge_Y());
//	    reVal.append("<FundManagementCharges>" + fundMangmentCharg+ "</FundManagementCharges>");
//  
//        log.setTaxOnFMCAndGuaranteeCharge_AA(month, year, bancaDiss, sumPrem);
//        double taxOnFmc = Double.parseDouble(log.getTaxOnFMCAndGuaranteeCharge_AA());
//        reVal.append("<TaxOnFmc>" +taxOnFmc+ "</TaxOnFmc>");
//  
//      log.setFundValueAfterFMC_AB(month, year, bancaDiss, sumPrem);
//      double fundValueAfterFmc= Double.parseDouble(log.getFundValueAfterFMC_AB());
//    reVal.append("<FundValueAfterFmc>" + fundValueAfterFmc+ "</FundValueAfterFmc>");
//    
//     reVal.append("<GuranteedAddition>" + log.getGuranteeAddition_AC()+ "</GuranteedAddition>");
//     reVal.append("<TerminalAddition>" + log.getTerminalAddition_AD()+ "</TerminalAddition>");
//           log.setFundValueAtEnd_AE_pass(month, year, bancaDiss, sumPrem);
//          double fundValueAtEnd = Double.parseDouble(log.getFundValueAtEnd_AE_pass());
//          reVal.append("<FundValueAtEnd>" + fundValueAtEnd+ "</FundValueAtEnd>");
//		    
////		reVal.append("<SurrenderCharges>" + log.getSurrenderCharges4(year, month) + "</SurrenderCharges>");
////			reVal.append("<TaxOnSurrenderCharges>" + log.getTaxSurrenderCharges4(year, month, bancaDiss, sumPrem) + "</TaxOnSurrenderCharges>");
////		   reVal.append("<SurrenderValue>" + log.getSurrenderValue4(year, month, bancaDiss, sumPrem) + "</SurrenderValue>");
////		   reVal.append("<DeathBenifit>" + log.getDeathBenifit_AI(year, month, bancaDiss, sumPrem) + "</DeathBenifit>");
          
      	
			 
//			
//		}
//		 reVal.append("</Builder>");
//		 return reVal.toString();
//	 }

}
