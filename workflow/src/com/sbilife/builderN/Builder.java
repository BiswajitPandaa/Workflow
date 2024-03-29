package com.sbilife.builderN;

import com.sbilife.common.CommonForAllProd;

public class Builder {
	CommonForAllProd cfap = new CommonForAllProd();
	StringBuilder retval = null;
	StringBuilder retvalnew = null;

	public String CalculatePrem(String isStaff, String age, String gender, String plan, String premFreqMode,
			String premPayingTerm, String proposerAge, String policyTerm, String premiumAmount, String sAMF,
			String noOfYrElapsed, String perInvEquityFund, String perInvEquityOptimiserFund, String perInvgrowthFund,
			String perInvBalancedFund, String perInvBondFund, String perInvMoneyMarketFund, String perInvTop300Fund,
			String kFC, String perInvBondOptimiserFund, String perInvMidcapFund, String perInvPureFund,
			String perInvCorpBondFund, String proposalDate) {
		BuilderBean swbBean = new BuilderBean();
		try {
			swbBean.setAge(Integer.parseInt(age));
			swbBean.setGenderoflifensured(gender);
			swbBean.setPlan(plan);
			swbBean.setBaseprem(Double.parseDouble(premiumAmount));
			swbBean.setPolicyTerm(Integer.parseInt(policyTerm));
			swbBean.setPremPayingMode(premFreqMode);
			swbBean.setPf(1);
			swbBean.setBaseprem(Double.parseDouble(premiumAmount));
			swbBean.setStafDisc(Boolean.parseBoolean(isStaff));
			swbBean.setProposalDate(proposalDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return BuilderPgOut(swbBean);
	}

	public String BuilderPgOut(BuilderBean swbBean) {
		BuilderBusinessLogic swbBuss = new BuilderBusinessLogic(swbBean);
		retval = new StringBuilder();
		retvalnew = new StringBuilder();
		boolean bancaDiss = false;
		  double sum_R=0;

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
			retval.append("<prem_Alloc_Charge>" + premAllocCharge + "</premAllocCharge>");

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

			swbBuss.setGuranteeAddition_AC();
			double GuranteeAddition_AC = Double.parseDouble(swbBuss.getGuranteeAddition_AC());
			retval.append("<GuranteeAddition_AC>" + GuranteeAddition_AC + "</GuranteeAddition_AC>");

			swbBuss.setTerminalAddition_AD(month_ph, year_ph, bancaDiss, sum_premium);
			double TerminalAddition_AD = Double.parseDouble(swbBuss.getTerminalAddition_AD());
			retval.append("<TerminalAddition_AD>" + TerminalAddition_AD + "</TerminalAddition_AD>");

			swbBuss.setFundValueAtEnd_AE(month_ph, year_ph, bancaDiss, sum_premium);
			double FundValueAtEnd_AE = Double.parseDouble(swbBuss.getFundValueAtEnd_AE());
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

			swbBuss.setMortalityMorbality_AJ(month_ph, year_ph, bancaDiss, sum_premium);
			double MortalityMorbality_AJ = Double.parseDouble(swbBuss.getMortalityMorbality_AJ());
			retval.append("<MortalityMorbality_AJ>" + MortalityMorbality_AJ + "</MortalityMorbality_AJ>");

			swbBuss.setTotalCharges_AL(year_ph);
			double TotalCharges_AL = Double.parseDouble(swbBuss.getTotalCharges_AL());
			retval.append("<TotalCharges_AL>" + TotalCharges_AL + "</TotalCharges_AL>");

			swbBuss.setTotalTax_AM(year_ph, month_ph, sum_premium);
			double TotalTax_AM = Double.parseDouble(swbBuss.getTotalTax_AM());
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

			swbBuss.setGuaranteeCharge_AR(month_ph, year_ph, bancaDiss, sum_premium);
			double GuaranteeCharge_AR = Double.parseDouble(swbBuss.getGuaranteeCharge_AR());
			retval.append("<GuaranteeCharge_AR>" + GuaranteeCharge_AR + "</GuaranteeCharge_AR>");

			swbBuss.setTaxOnFMCAndGuaranteeCharge_AS(month_ph, year_ph, bancaDiss, sum_premium);
			double TaxOnFMCAndGuaranteeCharge_AS = Double.parseDouble(swbBuss.getTaxOnFMCAndGuaranteeCharge_AS());
			retval.append("<TaxOnFMCAndGuaranteeCharge_AS>" + TaxOnFMCAndGuaranteeCharge_AS
					+ "</TaxOnFMCAndGuaranteeCharge_AS>");

			swbBuss.setFundValueAfterFMC_AT(month_ph, year_ph, bancaDiss, sum_premium);
			double FundValueAfterFMC_AT = Double.parseDouble(swbBuss.getFundValueAfterFMC_AT());
			retval.append("<FundValueAfterFMC_AT>" + FundValueAfterFMC_AT + "</FundValueAfterFMC_AT>");

			swbBuss.setGuranteeAddition_AU();
			double GuranteeAddition_AU = Double.parseDouble(swbBuss.getGuranteeAddition_AU());
			retval.append("<GuranteeAddition_AU>" + GuranteeAddition_AU + "</GuranteeAddition_AU>");

			swbBuss.setTerminalAddition_AV(month_ph, year_ph, bancaDiss, sum_premium);
			double TerminalAddition_AV = Double.parseDouble(swbBuss.getTerminalAddition_AV());
			retval.append("<TerminalAddition_AV>" + TerminalAddition_AV + "</TerminalAddition_AV>");

			// =========================== AW SECTION
			swbBuss.setFundValueAtEnd_AW(month_ph, year_ph, bancaDiss, sum_premium);
			double FundValueAtEnd_AW1 = Double.parseDouble(swbBuss.getFundValueAtEnd_AW());
			retval.append("<FundValueAtEnd_AW>" + FundValueAtEnd_AW1 + "</FundValueAtEnd_AW>");

			swbBuss.setFundValueAtEnd_AW_pass(month_ph - 1, year_ph, bancaDiss, sum_premium);
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
	        
	                retvalnew.append("<premium" + year + ">" + prem + "</premium" + year + ">");
	                
	                double premallocchg = premAllocCharge;
	                retvalnew.append("<premallocchg" + year + ">" + premallocchg + "</premallocchg" + year + ">");
	                
	                double prem_minus_alloccharge = prem - premallocchg;
	                retvalnew.append("<prem_minus_alloccharge" + year + ">" + prem_minus_alloccharge + "</prem_minus_alloccharge" + year + ">");
	            }
	            
	            sum_R += MortalityRate;
	            if((month_ph%12)==0)
	            {
	                
//	                System.out.println("SUM="+sum_R);
	                
	                retvalnew.append("<MortChrg4Pr"+ year +">" + Math.round(sum_R) + "</MortChrg4Pr"+ year +">");
	                sum_R = 0;
		}
		
	}
		return retvalnew.toString();
}
}
