package com.sbilife.builder;

import com.sbilife.common.CommonForAllProd;

public class Builder {
	CommonForAllProd cfap = new CommonForAllProd();
	StringBuilder retval = null;
	StringBuilder retvalnew = null;

	public String CalculatePrem(String age,String gender,String plan,String premiumAmount,String policyTerm,String premFreqMode,
			String stafDisc , String proposalDate) {
		BuilderBean swbBean = new BuilderBean();
		try {
			swbBean.setAge(Integer.parseInt(age));
			swbBean.setGenderoflifensured(gender);
			swbBean.setPlan(plan);
			swbBean.setBaseprem(Double.parseDouble(premiumAmount));
			swbBean.setPolicyTerm(Integer.parseInt(policyTerm));
			swbBean.setPremPayingMode(premFreqMode);
//			swbBean.setPf(1);
			
			swbBean.setStafDisc(Boolean.parseBoolean(stafDisc));
			swbBean.setProposalDate(proposalDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return BuilderPgOut(swbBean);
	}

	public String BuilderPgOut(BuilderBean swbBean) {
		BuilderLogic swbBuss = new BuilderLogic(swbBean);
		retval = new StringBuilder();
		retvalnew = new StringBuilder();
		boolean bancaDiss = false;
		  double sum_R=0;
		  double mortality=0;
		  double Aptax =0;
		  double polAcharges=0;
		  double fmc =0;
		  double fundMangementCharges =0;
		  double applicableTax=0;
		  double premallocchg=0;
		  retvalnew.append("<?xml version='1.0' encoding='utf-8' ?><Builder>");
		for (int i = 1; i <= swbBean.getPolicyTerm() * 12; i++) {
			swbBuss.setMonth_E(i);
			double month_ph = Double.parseDouble(swbBuss.getMonth_E());
			retval.append("<Month>" + month_ph + "</Month>");

			swbBuss.setYear_F();  
			double year_ph = Double.parseDouble(swbBuss.getYear_F());
			retval.append("<Year>" + year_ph + "</Year>");

			swbBuss.setAge();
			double age_ph = Double.parseDouble(swbBuss.getAge());
			retval.append("<Age>" + age_ph + "</Age>");

			swbBuss.setPremium_I(month_ph, year_ph);
			double premium = Double.parseDouble(swbBuss.getPremium_I());
			retval.append("<Premium>" + premium + "</Premium>");

			double sum_premium = 0;
			sum_premium = sum_premium + premium;

			swbBuss.setPremAllocCharge_J(month_ph, year_ph, bancaDiss);
			double premAllocCharge = Double.parseDouble(swbBuss.getPremAllocCharge_J());
			retval.append("<premAllocCharge>" + premAllocCharge + "</premAllocCharge>");

			swbBuss.setTaxOnAllocation_K(month_ph, year_ph, bancaDiss);
			double taxOnAllocation = Double.parseDouble(swbBuss.getTaxOnAllocation_K());
			retval.append("<tax_On_Allocation>" + taxOnAllocation + "</tax_On_Allocation>");

			swbBuss.setAmtAvailForInvestment(month_ph, year_ph, bancaDiss);
			double AmtAvailForInvestment = Double.parseDouble(swbBuss.getAmtAvailForInvestment());
			retval.append("<Amt_Avail_For_Investment>" + AmtAvailForInvestment + "</Amt_Avail_For_Investment>");

			swbBuss.setpolicyAdministrationCharge_N(year_ph);
			double policyAdministrationCharge = Double.parseDouble(swbBuss.getpolicyAdministrationCharge_N());
			retval.append(
					"<Policy_Administration_Charge>" + policyAdministrationCharge + "</Policy_Administration_Charge>");

			swbBuss.setPPWBCharges_O(month_ph, year_ph);
			double ppwbCharges = Double.parseDouble(swbBuss.getPPWBCharges_O());
			retval.append("<ppwbCharges>" + ppwbCharges + "</ppwbCharges>");

			swbBuss.setMortalityRate_R(year_ph, month_ph, bancaDiss, sum_premium);
			double MortalityRate = Double.parseDouble(swbBuss.getMortalityRate_R());
			retval.append("<MortalityRate>" + MortalityRate + "</MortalityRate>");

			swbBuss.setTotalCharges_T(year_ph, month_ph, bancaDiss, sum_premium);
			double TotalCharges = Double.parseDouble(swbBuss.getTotalCharges_T());
			retval.append("<TotalCharges>" + TotalCharges + "</TotalCharges>");

			swbBuss.setTotalTax_U(year_ph, month_ph, bancaDiss, sum_premium);
			double TotalTax = Double.parseDouble(swbBuss.getTotalTax_U());
			retval.append("<TotalTax>" + TotalTax + "</TotalTax>");

			swbBuss.setTotalTax_V(month_ph, year_ph, bancaDiss);
			double TotalTax_V = Double.parseDouble(swbBuss.getTotalTax_V());
			retval.append("<TotalTax_V>" + TotalTax_V + "</TotalTax_V>");

			swbBuss.setAdditionToFund_W(month_ph, year_ph, bancaDiss, sum_premium);
			double AdditionToFund_W = Double.parseDouble(swbBuss.getAdditionToFund_W());
			retval.append("<AdditionToFund_W>" + AdditionToFund_W + "</AdditionToFund_W>");

			swbBuss.setFundBeforeFMC_X(month_ph, year_ph, bancaDiss, sum_premium);
			double FundBeforeFMC_X = Double.parseDouble(swbBuss.getFundBeforeFMC_X());
			retval.append("<FundBeforeFMC_X>" + FundBeforeFMC_X + "</FundBeforeFMC_X>");

			swbBuss.setFundManagementCharge_Y(month_ph, year_ph, bancaDiss, sum_premium);
			double FundManagementCharge_Y_ = Double.parseDouble(swbBuss.getFundManagementCharge_Y());
			retval.append("<FundManagementCharge_Y_>" + FundManagementCharge_Y_ + "</FundManagementCharge_Y_>");

			swbBuss.setGuaranteeCharge_Z(month_ph, year_ph, bancaDiss, sum_premium);
			double GuaranteeCharge_Z = Double.parseDouble(swbBuss.getGuaranteeCharge_Z());
			retval.append("<GuaranteeCharge_Z>" + GuaranteeCharge_Z + "</GuaranteeCharge_Z>");

			swbBuss.setTaxOnFMCAndGuaranteeCharge_AA(month_ph, year_ph, bancaDiss, sum_premium);
			double FMCAndGuaranteeCharge_AA = Double.parseDouble(swbBuss.getTaxOnFMCAndGuaranteeCharge_AA());
			retval.append("<FMCAndGuaranteeCharge_AA>" + FMCAndGuaranteeCharge_AA + "</FMCAndGuaranteeCharge_AA>");

			swbBuss.setFundValueAfterFMC_AB(month_ph, year_ph, bancaDiss, sum_premium);
			double FundValueAfterFMC_AB = Double.parseDouble(swbBuss.getFundValueAfterFMC_AB());
			retval.append("<FundValueAfterFMC_AB>" + FundValueAfterFMC_AB + "</FundValueAfterFMC_AB>");

			swbBuss.setGuranteeAddition_AC(month_ph);
			double GuranteeAddition_AC = Double.parseDouble(swbBuss.getGuranteeAddition_AC());
			retval.append("<GuranteeAddition_AC>" + GuranteeAddition_AC + "</GuranteeAddition_AC>");

			swbBuss.setTerminalAddition_AD(month_ph, year_ph, bancaDiss, sum_premium);
			double TerminalAddition_AD = Double.parseDouble(swbBuss.getTerminalAddition_AD());
			retval.append("<TerminalAddition_AD>" + TerminalAddition_AD + "</TerminalAddition_AD>");

			swbBuss.setFundValueAtEnd_AE_pass(month_ph, year_ph, bancaDiss, sum_R);
			double FundValueAtEnd_AE = Double.parseDouble(swbBuss.getFundValueAtEnd_AE_pass());
			retval.append("<FundValueAtEnd_AE>" + FundValueAtEnd_AE + "</FundValueAtEnd_AE>");

			swbBuss.setFundValueAtEnd_AE_pass(month_ph - 1, year_ph, bancaDiss, sum_premium);

			swbBuss.setSurrenderCharges_AF(month_ph, year_ph, bancaDiss, sum_premium);
			double SurrenderCharges_AF = Double.parseDouble(swbBuss.getSurrenderCharges_AF());
			retval.append("<SurrenderCharges_AF>" + SurrenderCharges_AF + "</SurrenderCharges_AF>");

			swbBuss.setTaxOnSurrenderCharge_AG(month_ph, year_ph, bancaDiss, sum_premium);
			double TaxOnSurrenderCharge_AG = Double.parseDouble(swbBuss.getTaxOnSurrenderCharge_AG());
			retval.append("<TaxOnSurrenderCharge_AG>" + TaxOnSurrenderCharge_AG + "</TaxOnSurrenderCharge_AG>");

			swbBuss.setSurrenderValue_AH(month_ph, year_ph, bancaDiss, sum_premium);
			double SurrenderValue_AH = Double.parseDouble(swbBuss.getSurrenderValue_AH());
			retval.append("<SurrenderValue_AH>" + SurrenderValue_AH + "</SurrenderValue_AH>");

			swbBuss.setDeathBenifit_AI(sum_premium);
			double DeathBenifit_AI = Double.parseDouble(swbBuss.getDeathBenifit_AI());
			retval.append("<DeathBenifit_AI>" + DeathBenifit_AI + "</DeathBenifit_AI>");

			swbBuss.setMortalityRate_AJ(year_ph, month_ph, bancaDiss, sum_R);
			double MortalityMorbality_AJ = Double.parseDouble(swbBuss.getMortalityRate_AJ());
			retval.append("<MortalityMorbality_AJ>" + MortalityMorbality_AJ + "</MortalityMorbality_AJ>");

			swbBuss.setTotalCharges_AL(year_ph);
			double TotalCharges_AL = Double.parseDouble(swbBuss.getTotalCharges_AL());
			retval.append("<TotalCharges_AL>" + TotalCharges_AL + "</TotalCharges_AL>");

			swbBuss.setTotalTaxSurr_AM(year_ph, month_ph, sum_premium);
			double TotalTax_AM = Double.parseDouble(swbBuss.getTotalTaxSurr_AM());
			retval.append("<TotalTax_AM>" + TotalTax_AM + "</TotalTax_AM>");

			swbBuss.setTotalTax_AN(month_ph, year_ph, bancaDiss, sum_premium);
			double TotalTax_AN = Double.parseDouble(swbBuss.getTotalTax_AN());
			retval.append("<TotalTax_AN>" + TotalTax_AN + "</TotalTax_AN>");

			swbBuss.setAdditionToFund_AO(month_ph, year_ph, bancaDiss, sum_premium);
			double AdditionToFund_AO = Double.parseDouble(swbBuss.getAdditionToFund_AO());
			retval.append("<AdditionToFund_AO>" + AdditionToFund_AO + "</AdditionToFund_AO>");

			swbBuss.setFundBeforeFMC_AP(month_ph, year_ph, bancaDiss, sum_premium);
			double FundBeforeFMC_AP = Double.parseDouble(swbBuss.getFundBeforeFMC_AP());
			retval.append("<FundBeforeFMC_AP>" + FundBeforeFMC_AP + "</FundBeforeFMC_AP>");

			swbBuss.setFundManagementCharge_AQ(month_ph, year_ph, bancaDiss, sum_premium);
			double FundManagementCharge_AQ = Double.parseDouble(swbBuss.getFundManagementCharge_AQ());
			retval.append("<FundManagementCharge_AQ>" + FundManagementCharge_AQ + "</FundManagementCharge_AQ>");

			swbBuss.setTaxOnFMCAndGuaranteeCharge_AS(month_ph, year_ph, bancaDiss, sum_premium);
			double TaxOnFMCAndGuaranteeCharge_AS = Double.parseDouble(swbBuss.getTaxOnFMCAndGuaranteeCharge_AS());
			retval.append("<TaxOnFMCAndGuaranteeCharge_AS>" + TaxOnFMCAndGuaranteeCharge_AS
					+ "</TaxOnFMCAndGuaranteeCharge_AS>");

			swbBuss.setFundValueAfterFMC_AT(month_ph, year_ph, bancaDiss, sum_premium);
			double FundValueAfterFMC_AT = Double.parseDouble(swbBuss.getFundValueAfterFMC_AT());
			retval.append("<FundValueAfterFMC_AT>" + FundValueAfterFMC_AT + "</FundValueAfterFMC_AT>");

			
			double GuranteeAddition_AU = swbBuss.getGurantedAddition_AR(month_ph);
			retval.append("<GuranteeAddition_AU>" + GuranteeAddition_AU + "</GuranteeAddition_AU>");

			
			double TerminalAddition_AV =swbBuss.getTerminalAddition_AV();
			retval.append("<TerminalAddition_AV>" + TerminalAddition_AV + "</TerminalAddition_AV>");

			// =========================== AW SECTION
			swbBuss.setFundValueAtEnd_AW_pass(month_ph, year_ph, bancaDiss, sum_R);
			double FundValueAtEnd_AW1 = Double.parseDouble(swbBuss.getFundValueAtEnd_AW_pass());
			retval.append("<FundValueAtEnd_AW>" + FundValueAtEnd_AW1 + "</FundValueAtEnd_AW>");

		
			// =========================== AW SECTION

			swbBuss.setSurrenderCharges_AX(month_ph, year_ph, bancaDiss, sum_premium);
			double SurrenderCharges_AX = Double.parseDouble(swbBuss.getSurrenderCharges_AX());
			retval.append("<SurrenderCharges_AX>" + SurrenderCharges_AX + "</SurrenderCharges_AX>");

			swbBuss.setTaxOnSurrenderCharge_AY(month_ph, year_ph, bancaDiss, sum_premium);
			double TaxOnSurrenderCharge_AY = Double.parseDouble(swbBuss.getTaxOnSurrenderCharge_AY());
			retval.append("<TaxOnSurrenderCharge_AY>" + TaxOnSurrenderCharge_AY + "</TaxOnSurrenderCharge_AY>");
			
			swbBuss.setSurrenderValue_AZ(month_ph, year_ph, bancaDiss, sum_premium);
			double SurrenderValue_AZ = Double.parseDouble(swbBuss.getSurrenderValue_AZ());
			retval.append("<SurrenderValue_AZ>" + SurrenderValue_AZ + "</SurrenderValue_AZ>");

			swbBuss.setDeathBenifit_BA(sum_premium);
			double DeathBenifit_BA = Double.parseDouble(swbBuss.getDeathBenifit_BA());
			retval.append("<DeathBenifit_BA>" + DeathBenifit_BA + "</DeathBenifit_BA>");	
			
			 
			 int year = (int)year_ph;
	            if (month_ph % 12 == 1) {
	                double prem = premium;


	                retvalnew.append("<AnnualPremium"+ year +">" + prem + "</AnnualPremium"+ year +">");
//	                 premallocchg = premAllocCharge;
//	                retvalnew.append("<premallocchg" + year + ">" + premallocchg + "</premallocchg" + year + ">");
//	                
//	                double prem_minus_alloccharge = prem - premallocchg;
//	                retvalnew.append("<prem_minus_alloccharge" + year + ">" + prem_minus_alloccharge + "</prem_minus_alloccharge" + year + ">");
	            }
             sum_R += MortalityRate;
	            Aptax+=TotalTax_V;
              fmc+=FundManagementCharge_Y_;
                polAcharges+=policyAdministrationCharge;
                premallocchg+=premAllocCharge;
	            applicableTax+=TotalTax_AN;
	            fundMangementCharges+=FundManagementCharge_AQ;
	          mortality+=MortalityMorbality_AJ;
	          
	            
	            if((month_ph%12)==0)
          {
            
	            	 retvalnew.append("<Year>" + year+ "</Year>");
	                retvalnew.append("<MortChrg4Pr"+ year +">" + Math.round(sum_R) + "</MortChrg4Pr"+ year +">");
	                retvalnew.append("<OtherCharges"+year+">" +Math.round(premallocchg+polAcharges+fmc) +"</OtherCharges"+year+">");
	                retvalnew.append("<ApplicableTax" +year+">" + Math.round(Aptax)+"</ApplicableTax"+year+">");
	                retvalnew.append("<fundAtEnd" +year+">" + Math.round(FundValueAtEnd_AE)+"</fundAtEnd"+year+">");
	                retvalnew.append("<SurrenderValue"+year+">" + Math.round(SurrenderValue_AH)+"</SurrenderValue"+year+">");
	                retvalnew.append("<DeathBenifits"+year+">" + Math.round(DeathBenifit_AI)+"</DeathBenifits"+year+">");
	            	 retvalnew.append("<MortChrg8Pr"+ year +">" + Math.round(mortality) + "</MortChrg8Pr"+ year +">");
	            	 retvalnew.append("<OtherCharges8pr"+year+">" +Math.round(premallocchg+polAcharges+fundMangementCharges) +"</OtherCharges8pr"+year+">");
	            retvalnew.append("<ApplicableTax8pr" +year+">" + Math.round(applicableTax)+"</ApplicableTax8pr"+year+">");
	            retvalnew.append("<fundAtEnd8pr" +year+">" + Math.round(FundValueAtEnd_AW1)+"</fundAtEnd8pr"+year+">");
	            retvalnew.append("<SurrenderValue8pr"+year+">" + Math.round(SurrenderValue_AZ)+"</SurrenderValue8pr"+year+">");
            retvalnew.append("<DeathBenifits"+year+">" + Math.round(DeathBenifit_BA)+"</DeathBenifits"+year+">");
	                
	              
	                sum_R = 0;
	                Aptax=0;
	                fmc=0;
              mortality=0;
             polAcharges=0;
            applicableTax =0;
            fundMangementCharges=0;
            premallocchg=0;
            
	}
		
		
		
	}
		 retvalnew.append("</Builder>");
		return retvalnew.toString();
}
}
