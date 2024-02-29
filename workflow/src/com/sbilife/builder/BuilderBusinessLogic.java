package com.sbilife.builder;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sbilife.common.CommonForAllProd;

public class BuilderBusinessLogic {
	public CommonForAllProd cfap = null;
	public BuilderBean swbBean = null;
	public BuilderDB db = null;
	public BuilderProperties prop = null;

	String month_E = null, year_F = null, policyInforce_G = null, age_H = null, premium_I = null,
			premalloccharge_J = null, taxonallocation_K = null, AmtAvailForInvestment_L = null,
			policyAdministrationCharge_N = null, DoNotUse_M = null, PPWBCharges_O = null, mortality_rate_R = null,
			TotalCharges_T = null, TotalTax_U = null, TotalTax_V = null, AdditionToFund_W = null,
			FundBeforeFMC_X = null, FundManagementCharge_Y = null, GuaranteeCharge_Z = null,
			TaxOnFMCAndGuaranteeCharge_AA = null, FundValueAfterFMC_AB = null, GuranteeAddition_AC = null,
			TerminalAddition_AD = null, FundValueAtEnd_AE = null, FundValueAtEnd_AE_pass = null,
			SurrenderCharges_AF = null, TaxOnSurrenderCharge_AG = null, SurrenderValue_AH = null,
			DeathBenifit_AI = null, MortalityMorbality_AJ = null, DeathBenifit_BA = null, TotalCharges_AL = null,
			setTotalTax_AM = null, TotalTax_AN = null, AdditionToFund_AO = null, FundBeforeFMC_AP = null,
			FundManagementCharge_AQ = null, GuaranteeCharge_AR = null, TaxOnFMCAndGuaranteeCharge_AS = null,
			FundValueAfterFMC_AT = null, GuranteeAddition_AU = null, TerminalAddition_AV = null,
			SurrenderCharges_AX = null, TaxOnSurrenderCharge_AY = null,SurrenderValue_AZ=null;

	public BuilderBusinessLogic(BuilderBean swbBean) {
		this.swbBean = swbBean;
		cfap = new CommonForAllProd();
		db = new BuilderDB();
		prop = new BuilderProperties();
	}

	// ============================ Month_E
	public void setMonth_E(int rowNumber) {
		this.month_E = (rowNumber + "");
	}

	public String getMonth_E() {
		return month_E;
	}
	// ============================ Year_F

	public void setYear_F() {
		String output = cfap.getRoundUp("" + (Double.parseDouble(getMonth_E()) / 12));
		this.year_F = output;
	}

	public String getYear_F() {
		return year_F;
	}

	// ============================ policyInforce_G

	public void setPolicyInForece() {
		this.policyInforce_G = "" + 0;
	}

	public String getPolicyInForece() {
		return policyInforce_G;
	}

	// ============================= AGE_H

	public void setAge() {
		this.age_H = (swbBean.getAge() + Double.parseDouble(getYear_F()) - 1) + "";
	}

	public String getAge() {
		return age_H;
	}

	// ============================= Required for Premium_I

	public double get_PPT_Input() {
		double PPT = 0;
		if (swbBean.getPlan().equals("LPPT")) {
			PPT = swbBean.getPolicyTerm();
		} else {
			if (swbBean.getPlan().equals("LPPT")) {
				PPT = 1;
			} else {
				PPT = swbBean.getPolicyTerm();
			}
		}
		return PPT;
	}

	public double get_premMode_input() {
		double mode = 0;
		if (swbBean.getPremPayingMode().equals("Yearly") || swbBean.getPremPayingMode().equals("Not Required")) {
			mode = 1;
		} else {
			if (swbBean.getPremPayingMode().equals("Half Yearly")) {
				mode = 2;
			} else {
				if (swbBean.getPremPayingMode().equals("Quarterly")) {
					mode = 4;
				} else {
					mode = 12;
				}
			}
		}
		return mode;
	}

	// ============================= Pemium_I

	public void setPremium_I(double month, double year) {
		double val1 = month - 1;
		double val2 = 12 / get_premMode_input();
		double mod = val1 % val2;
		double premium = 0;

		if (year > 0 && year <= get_PPT_Input() && mod == 0) {
			this.premium_I = swbBean.getBaseprem() + "";
		} else {
			this.premium_I = 0 + "";
		}

	}

	public String getPremium_I() {
		return premium_I;
	}

	// =======================================Required for premium allocation

	public double premallocationchargeInputPG(boolean bancaDiss, double year) {
		double allocCharge = 0;
		double ot = 0;
		if (swbBean.getPlan().equals("Regular")) {
			if (year == 1) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 3) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 5) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 7) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}

		} else if (swbBean.getPlan().equals("Single")) {
			if (year == 1) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.02 * 1;
				}
			} else {
				return 0;
			}

		} else if (swbBean.getPlan().equals("LPPT")) {
			if (year == 1) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.09 - 0.1;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = (0.09 - 0.1 * 1);
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 2 || year == 3) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.065 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.065 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 4 || year == 5) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.06 - 0.02;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.06 - 0.02 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 6 || year == 7) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.035 - 0.015;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.035 - 0.015 * 0;
				}
				ot = Math.max(allocCharge, 0);
			} else if (year == 8 || year == 9 || year == 10) {
				if (swbBean.isStafDisc() == true && bancaDiss == false) {
					allocCharge = 0.03 - 0.01;
				} else if (swbBean.isStafDisc() == false && bancaDiss == true) {
					allocCharge = 0.03 - 0.01 * 0;
				}
				ot = Math.max(allocCharge, 0);
			}
		}
		return ot;
	}

	// ============================ Premium Allocation Charge J

	public void setPremAllocCharge_J(double month, double year, boolean bancaDiss) {
		String ans = cfap.getRoundOffLevel2New(
				"" + (Double.parseDouble(getPremium_I()) * premallocationchargeInputPG(bancaDiss, year)));
		this.premalloccharge_J = ans;
	}

	public String getPremAllocCharge_J() {
		return premalloccharge_J;
	}

	// ============================ Tax on Allocation K
	public void setTaxOnAllocation_K(double month, double year, boolean bancaDiss) {
		if (prop.AllocationCharges == true) {
			this.taxonallocation_K = cfap.getRoundUp("" + prop.ServiceTax * Double.parseDouble(getPremAllocCharge_J()));
		} else {
			this.taxonallocation_K = ("" + 0);
		}
	}

	public String getTaxOnAllocation_K() {
		return taxonallocation_K;
	}

	// ============================= Amount available for investment L

	public void setAmtAvailForInvestment(double month, double year, boolean bancaDiss) {
		if (year == 0) {
			this.AmtAvailForInvestment_L = ("" + 0);
		} else {
			this.AmtAvailForInvestment_L = cfap.getRoundUp("" + (Double.parseDouble(getPremium_I())
					- Double.parseDouble(getPremAllocCharge_J()) - Double.parseDouble(getTaxOnAllocation_K())));
		}

	}

	public String getAmtAvailForInvestment() {
		return AmtAvailForInvestment_L;
	}

	// =================================== Do not Use_M
//	public void setDoNotUse_M() {
//		this.DoNotUse_M=""+0;
//	}

	public String getDoNotUse_M() {
		this.DoNotUse_M = "" + 0;
		return DoNotUse_M;
	}
	// =================================== Required for policyAdministrationCharge

	public double AdminFeePm_Inputpg(double year) {
		double output = 0;
		if (swbBean.getPlan().equals("Single")) {
			output = 50;
		} else {
			if (year == 1 || year == 2 || year == 3 || year == 4 || year == 5) {
				output = 0;
			} else if (year == 6 || year == 7 || year == 8 || year == 9 || year == 10 || year == 11 || year == 12
					|| year == 13) {
				output = 60;
			} else {
				output = 0;
			}
		}
		return output;
	}

//=================================== policyAdministrationCharge_N 
	public void setpolicyAdministrationCharge_N(double year) {
		if (year == 0) {
			this.policyAdministrationCharge_N = "" + 0;
		} else {
			this.policyAdministrationCharge_N = "" + AdminFeePm_Inputpg(year);
		}

	}

	public String getpolicyAdministrationCharge_N() {
		return policyAdministrationCharge_N;
	}

	// ===================================Required for PPWB charges_O
	public double PPWB_Charge_Inputpg(double year) {
		double output = 0;
		// double ppwbChargeDB=0;
		if (year > 0 && year <= swbBean.getPolicyTerm()) {
			output = 0;
		} else {
			output = 0;
		}
		return output;
	}

	public double AnnualPrem_InputPg() {
		double output = get_premMode_input() * swbBean.getBaseprem();
		return output;
	}

	// =================================== PPWB charges_O

	public void setPPWBCharges_O(double month, double year) {
		double val1 = 0;
		double val2 = 0;

		double ppwbchargeInputpg = PPWB_Charge_Inputpg(year);
		double AnuualpremInputpg = AnnualPrem_InputPg();
		if (year != 0 && month <= get_PPT_Input() * 12 * 12 * get_premMode_input()) {
			val1 = ppwbchargeInputpg / 12 * AnuualpremInputpg / 1000;
		} else {
			val1 = 0;
		}

		if (prop.Mortality_and_Rider_Charges == true) {
			val2 = 1;
		} else {
			val2 = 0;
		}

		String ot = cfap.getRoundUp("" + val1 * val2);
		this.PPWBCharges_O = ot;
	}

	public String getPPWBCharges_O() {
		return PPWBCharges_O;
	}

	// =========================================== Not printing
	public double Mortality_rates_last_bday(double age) {

		double[] mortalityRate = db.getIAIarray();
		double val = 0;

		double fix_charge = prop.Mortality_Charge;
		int[] ageArr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
				50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,
				76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };

		for (int i = 0; i <= mortalityRate.length - 2; i++) {
			val = (((mortalityRate[(int) age] + mortalityRate[(int) age + 1]) / 2) * fix_charge) / 12;

		}
		return val;

	}

	public double to_compare(double sum_premium, double AmtAvailForInvestment) {
		double fundvalatend = 0;
		double ans = sum_premium * 1.05 - (AmtAvailForInvestment + fundvalatend);

		double sum_Assured = 0;

		double maxval = Math.max(sum_Assured, ans);

		return maxval;
	}

	public double comparetwoval(double sum_premium, double AmtAvailForInvestment) {
		double fundvalatend = 0;
		double ans = sum_premium * 1.05 - fundvalatend;

		double sum_Assured = 0;

		double max1 = Math.max(ans, sum_Assured);

		double max2 = Math.max(max1, 0);

		return max2;
	}

	public double SumAssured() {
		double output = 0;
		double SAMF = 0;
		if (prop.SMAF_at_the_discretion_of_Policyholder.equals("No")) {
			if (swbBean.getPlan().equals("Regular")) {
				if (prop.Min_regular_PPT == prop.Max_regular_PPT) {
					output = prop.Max_regular_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (swbBean.getPlan().equals("Single")) {
				if (prop.Min_single_PPT == prop.Max_single_PPT) {
					output = prop.Max_single_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			} else if (swbBean.getPlan().equals("LPPT")) {
				if (prop.Min_LPPT_PPT == prop.Max_LPPT_PPT) {
					output = prop.Max_LPPT_PPT * AnnualPrem_InputPg();
				} else {
					output = SAMF * AnnualPrem_InputPg();
				}
			}
		} else {
			output = SAMF * AnnualPrem_InputPg();
		}
		return output;
	}

	public double getAdbAtpdcharges(int year) {
		double output = 0;

		double val1 = Math.min(SumAssured(), 5000000);
		double val2 = 0;
		double conditionVal = 0;
		double conditionVal2 = 0;
		if (year == 0) {
			conditionVal = 0;
		} else {
			conditionVal = val1 * val2 / 12000;
		}

		if (prop.mor_charge == true) {
			conditionVal2 = 1;
		} else {
			conditionVal2 = 0;
		}

		output = conditionVal * conditionVal2;
		return 0.0;
	}

	// to Iterate mortality charges table BF coloumn

	public double mortalityChargesIterate() {
		double arr[] = db.mortalityChargesTable();
		double output = 0;
		for (int i = 0; i < arr.length; i++) {
			if (Double.parseDouble(getAge()) == i) {
				output = arr[i];
			}
		}
		return output;
	}

	// ====================================================== Mortality_R

	public void setMortalityRate_R(double year, double month, boolean bankdiss, double sumprem) {

		double mortalityCharge = mortalityChargesIterate();
		double AE = 0;
		if (month == 1) {
			AE = 0;
		} else {
//			AE= getFundValueAtEnd_AE();
//			AE = getFundValueAtEnd_AE(month, year, bankdiss, sumprem);
			AE = Double.parseDouble(getFundValueAtEnd_AE_pass());
		}

		double inner1max1 = Math.max(0, SumAssured());
		double max1 = Math.max(inner1max1, sumprem);

		double inner1max2 = Math.max(SumAssured(), (sumprem * 1.05 - AE));

		double val1 = mortalityCharge / 12;
		double val2 = 1 - 0;
		double val3 = Math.max((max1 - (Double.parseDouble(getAmtAvailForInvestment()) + AE)), 0);
		double val4 = 0;
		double val5 = Math.max(inner1max2, 0);
		double val6 = 0;
		if (prop.mor_charge) {
			val6 = 1;
		}

		this.mortality_rate_R = ""
				+ Double.parseDouble(cfap.getRoundOffLevel2New((val1 * val2 * val3 + val4 * val5) + "")) * val6;
	}

	public String getMortalityRate_R() {
		return mortality_rate_R;
	}

	// ====================================================== Required

	public double AM3() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = null, date2 = null;
		try {
			date1 = dateFormat.parse(swbBean.getProposalDate());
			date2 = dateFormat.parse(prop.kfcDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double diff = cfap.getMonthDiff(date2, date1) + 1;
		return diff;
	}

	public double totalTax() {
		return 0.18;
	}

	// ====================================================== Total_Charges_T
	public void setTotalCharges_T(double year, double month, boolean bankdiss, double sumPrem) {

		double getDoNotUse_M = Double.parseDouble(getDoNotUse_M());
		double getMortalityRate_R = Double.parseDouble(getMortalityRate_R());
		double getPPWBCharges_O = Double.parseDouble(getPPWBCharges_O());
		double getpolicyAdministrationCharge_N = Double.parseDouble(getpolicyAdministrationCharge_N());
		if (year == 0) {
			this.TotalCharges_T = "" + 0;

		} else {
			this.TotalCharges_T = "" + (getDoNotUse_M + getMortalityRate_R + getDoNotUse_M + getDoNotUse_M
					+ getPPWBCharges_O + getpolicyAdministrationCharge_N + getDoNotUse_M + 0);
		}
	}

	public String getTotalCharges_T() {
		return TotalCharges_T;
	}

	// ====================================================== TotalTax_U
	public void setTotalTax_U(double year, double month, boolean bankdiss, double sumPrem) {

		double getDoNotUse_M = Double.parseDouble(getDoNotUse_M());
		double getMortalityRate_R = Double.parseDouble(getMortalityRate_R());
		double getPPWBCharges_O = Double.parseDouble(getPPWBCharges_O());
		double a = 0;
		double b = 0;
		double c = 0;
		double val = 0;

		if (prop.admistration_charge == true) {
			a = Double.parseDouble(getpolicyAdministrationCharge_N());

		} else {
			a = 0;

		}
		if (prop.mor_charge == true) {
			b = getMortalityRate_R + getDoNotUse_M + getDoNotUse_M + getPPWBCharges_O + getDoNotUse_M + getDoNotUse_M;
		} else {
			b = 0;

		}
		if (month <= AM3()) {
			c = totalTax();
		} else {
			c = prop.ServiceTax;
		}

		this.TotalTax_U = cfap.getRoundUp_Level2(((a + b) * c) + "");
	}

	public String getTotalTax_U() {
		return TotalTax_U;
	}

	// ====================================================== TotalTax_V
	public void setTotalTax_V(double month, double year_F, boolean bankdiss) {
		double colU = Double.parseDouble(getTotalTax_U());
		double taxOnAllocation = Double.parseDouble(getTaxOnAllocation_K());
		double AA10 = 37.49; // ========================change here
		double val = 0;
		if (month <= AM3()) {
			val = totalTax();
		} else {
			val = prop.ServiceTax;
		}

		double output = colU + taxOnAllocation + AA10 + 0 * val;

		this.TotalTax_V = cfap.getRoundOffLevel2New(output + "");
	}

	public String getTotalTax_V() {
		return TotalTax_V;
	}

	// ======================================================
	public double W4() {
		// Add 1 to int_1, raise it to the power of 1/12, and subtract 1

		double result = Math.pow(1 + prop.int1, 1.0 / 12) - 1;
		return Double.parseDouble(cfap.getRoundOffLevel5New(result + ""));
	}

	// ====================================================== AdditionToFund_W
	public void setAdditionToFund_W(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;

		double AE = 0;
		if (month == 1) {
			AE = 0;
		} else {
//			AE = getFundValueAtEnd_AE();
//			AE = getFundValueAtEnd_AE(month-1,year,bankdiss,sumprem);
//			AE = Double.parseDouble(getFundValueAtEnd_AE_pass());
			setFundValueAtEnd_AE_pass(month - 1, year, bankdiss, sumprem);
			AE = Double.parseDouble(getFundValueAtEnd_AE_pass());
		}

		//
		if (year == 0) {
			output = 0;
		} else {
			output = (AE + Double.parseDouble(getAmtAvailForInvestment()) - Double.parseDouble(getTotalCharges_T())
					- Double.parseDouble(getTotalTax_U()) + Double.parseDouble(getDoNotUse_M())) * W4();
//			output=651.12;
		}
		this.AdditionToFund_W = cfap.roundUp_Level2(output + "");
	}

	public String getAdditionToFund_W() {
		return AdditionToFund_W;
	}

	// ====================================================== FundBeforeFMC_X
	public void setFundBeforeFMC_X(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;

		double AE = 0;
		if (month == 1) {
			AE = 0;
		} else {
			AE = Double.parseDouble(getFundValueAtEnd_AE_pass());
		}

		if (year == 0) {
			this.FundBeforeFMC_X = "" + 0;
		} else {
			this.FundBeforeFMC_X = "" + (AE + Double.parseDouble(getAmtAvailForInvestment())
					+ Double.parseDouble(getAdditionToFund_W()) - Double.parseDouble(getTotalCharges_T())
					- Double.parseDouble(getTotalTax_U()) + Double.parseDouble(getDoNotUse_M()));
		}
	}

	public String getFundBeforeFMC_X() {
		return FundBeforeFMC_X;
	}

	// ======================================================
	public double FMCInputPg(double year) {
		double output = 0;
		if (year > 0 && year < swbBean.getPolicyTerm()) {
			output = prop.weightedFMC;
		}
		return output;
	}

	public double guaranteedChargeInputPg(double year) {
		double output = 0;
		if (year > 0 && year < swbBean.getPolicyTerm()) {
			output = prop.guaranteedCharge;
		}
		return output;
	}

	// ====================================================== FundManagementCharge_Y
	public void setFundManagementCharge_Y(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		if (year == 0) {
			output = 0;
		} else {
			output = (Double.parseDouble(getFundBeforeFMC_X()) * FMCInputPg(year) / 12);
		}
		// return Double.parseDouble(cfap.getRoundUp(output + "")) ;
		this.FundManagementCharge_Y = cfap.getRoundUp(output + "");
	}

	public String getFundManagementCharge_Y() {
		return FundManagementCharge_Y;
	}

	// ====================================================== GuaranteeCharge_Z
	public void setGuaranteeCharge_Z(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		if (year == 0) {
			output = 0;
		} else {
			output = Double.parseDouble(getFundBeforeFMC_X()) * guaranteedChargeInputPg(year) / 12;
		}
		this.GuaranteeCharge_Z = cfap.getRoundUp(output + "");
	}

	public String getGuaranteeCharge_Z() {
		return GuaranteeCharge_Z;
	}

	// ======================================================
	// TaxOnFMCAndGuaranteeCharge_AA
	public void setTaxOnFMCAndGuaranteeCharge_AA(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		double FMC = FMCInputPg(year);
		double val1 = 0;
		double val2 = 0;
		double val3 = 0;

		if (year == 0) {
			val1 = 0;
		} else {
			val1 = Double.parseDouble(getGuaranteeCharge_Z()) + Double.parseDouble(getFundManagementCharge_Y());

//			val1 = getGuaranteeCharge_Z(month, year, bankdiss, sumprem)
//					+ 208.27 ;

		}

		if (month <= AM3()) {
			val2 = totalTax();
		} else {
			val2 = prop.ServiceTax;
		}

		if (prop.fund_management_charge) {
			val3 = 1;
		} else {
			val3 = 0;
		}

		output = val1 * val2 * val3;
		this.TaxOnFMCAndGuaranteeCharge_AA = cfap.getRoundOffLevel2New(output + "");
	}

	public String getTaxOnFMCAndGuaranteeCharge_AA() {
		return TaxOnFMCAndGuaranteeCharge_AA;
	}

	// ====================================================== FundValueAfterFMC_AB
	public void setFundValueAfterFMC_AB(double month, double year, boolean bankdiss, double sumprem) {
		double val = 0;
		if (year == 0) {
			val = 0;
		} else {

			val = (Double.parseDouble(getFundBeforeFMC_X()) - Double.parseDouble(getFundManagementCharge_Y())
					- Double.parseDouble(getGuaranteeCharge_Z())
					- Double.parseDouble(getTaxOnFMCAndGuaranteeCharge_AA()));
		}

		this.FundValueAfterFMC_AB = cfap.getRoundOffLevel2(val + "");
	}

	public String getFundValueAfterFMC_AB() {
		return FundValueAfterFMC_AB;
	}

	// ====================================================== GuranteeAddition_AC
	public void setGuranteeAddition_AC() {
		this.GuranteeAddition_AC = "" + 0;
	}

	public String getGuranteeAddition_AC() {
		return GuranteeAddition_AC;
	}

	// ====================================================== TerminalAddition_AD
	public void setTerminalAddition_AD(double month, double year, boolean bankdiss, double sumprem) {
		double value = 0;
		if (month == swbBean.getPolicyTerm() * 12) {
			value = (Double.parseDouble(getFundValueAfterFMC_AB()) + Double.parseDouble(getGuranteeAddition_AC())) * 0;

		} else {
			value = 0;

		}

		this.TerminalAddition_AD = "" + value;
	}

	public String getTerminalAddition_AD() {
		return TerminalAddition_AD;
	}

	// ====================================================== FundValueAtEnd_AE
	public void setFundValueAtEnd_AE(double month, double year, boolean bankdiss, double sumprem) {
//		this.FundValueAtEnd_AE =""+ Double.parseDouble(getGuranteeAddition_AC()) + Double.parseDouble(getFundValueAfterFMC_AB())
//		+ Double.parseDouble(getTerminalAddition_AD()) ;

		double guaranteeAddition = Double.parseDouble(getGuranteeAddition_AC().replaceAll(",", ""));
		double fundValueAfterFMC = Double.parseDouble(getFundValueAfterFMC_AB().replaceAll(",", ""));
		double terminalAddition = Double.parseDouble(getTerminalAddition_AD().replaceAll(",", ""));

		this.FundValueAtEnd_AE = String.valueOf(guaranteeAddition + fundValueAfterFMC + terminalAddition);
	}

	public String getFundValueAtEnd_AE() {
		return FundValueAtEnd_AE;
	}

	// ====================================================== FundValueAtEnd_AE (for
	// passing value in other dependenet methods)
	public void setFundValueAtEnd_AE_pass(double month, double year, boolean bankdiss, double sumprem) {
//		this.FundValueAtEnd_AE =""+ Double.parseDouble(getGuranteeAddition_AC()) + Double.parseDouble(getFundValueAfterFMC_AB())
//		+ Double.parseDouble(getTerminalAddition_AD()) ;

		double guaranteeAddition = Double.parseDouble(getGuranteeAddition_AC().replaceAll(",", ""));
		double fundValueAfterFMC = Double.parseDouble(getFundValueAfterFMC_AB().replaceAll(",", ""));
		double terminalAddition = Double.parseDouble(getTerminalAddition_AD().replaceAll(",", ""));

		this.FundValueAtEnd_AE_pass = String.valueOf(guaranteeAddition + fundValueAfterFMC + terminalAddition);
	}

	public String getFundValueAtEnd_AE_pass() {
		return FundValueAtEnd_AE_pass;
	}

	// ==================================================== Required for surrender
	// charge

	public double getSurrenderCharge() {
		double surrenderCharge = 0;
		double getYear_F = Double.parseDouble(getYear_F());
		if (swbBean.getPlan().equals("Single")) {
			if (swbBean.getBaseprem() > 25000) {
				if (getYear_F == 1) {
					surrenderCharge = 0.02;
				} else if (getYear_F == 2) {
					surrenderCharge = 0.015;
				} else if (getYear_F == 3) {
					surrenderCharge = 0.01;
				} else if (getYear_F == 4) {
					surrenderCharge = 0.005;
				} else {
					surrenderCharge = 0;
				}
			} else {
				surrenderCharge = 0;
			}
		} else

		{
			if (swbBean.getBaseprem() > 25000) {

				if (swbBean.getBaseprem() > 50000) {

					if (getYear_F == 1) {
						surrenderCharge = 0.06;
					} else if (getYear_F == 2) {
						surrenderCharge = 0.04;
					} else if (getYear_F == 3) {
						surrenderCharge = 0.03;
					} else if (getYear_F == 4) {
						surrenderCharge = 0.02;
					} else {
						surrenderCharge = 0;
					}
				} else {
					if (getYear_F == 1) {
						surrenderCharge = 0.2;
					} else if (getYear_F == 2) {
						surrenderCharge = 0.15;
					} else if (getYear_F == 3) {
						surrenderCharge = 0.1;
					} else if (getYear_F == 4) {
						surrenderCharge = 0.05;
					} else {
						surrenderCharge = 0;
					}
				}
			} else {
				surrenderCharge = 0;
			}
		}

		return surrenderCharge;
	}

	public double getSurrenderCap() {
		double surrenderCharge = 0;
		double getYear_F = Double.parseDouble(getYear_F());
		if (swbBean.getPlan().equals("Single")) {
			if (swbBean.getBaseprem() > 25000) {
				if (getYear_F == 1) {
					surrenderCharge = 0.02;
				} else if (getYear_F == 2) {
					surrenderCharge = 0.015;
				} else if (getYear_F == 3) {
					surrenderCharge = 0.01;
				} else if (getYear_F == 4) {
					surrenderCharge = 0.005;
				} else {
					surrenderCharge = 0;
				}
			} else {
				surrenderCharge = 0;
			}
		} else

		{
			if (swbBean.getBaseprem() > 25000) {

				if (swbBean.getBaseprem() > 50000) {

					if (getYear_F == 1) {
						surrenderCharge = 6000;
					} else if (getYear_F == 2) {
						surrenderCharge = 5000;
					} else if (getYear_F == 3) {
						surrenderCharge = 4000;
					} else if (getYear_F == 4) {
						surrenderCharge = 2000;
					} else {
						surrenderCharge = 0;
					}
				} else {
					if (getYear_F == 1) {
						surrenderCharge = 0.2;
					} else if (getYear_F == 2) {
						surrenderCharge = 0.15;
					} else if (getYear_F == 3) {
						surrenderCharge = 0.1;
					} else if (getYear_F == 4) {
						surrenderCharge = 0.05;
					} else {
						surrenderCharge = 0;
					}
				}
			} else {
				surrenderCharge = 0;
			}
		}

		return surrenderCharge;
	}
	// ==================================================== SurrenderCharges_AF

	public void setSurrenderCharges_AF(double month, double year, boolean bankdiss, double sumprem) {
		String ans = null;

		double getFundValueAtEnd_AE = Double.parseDouble(getFundValueAtEnd_AE());
		double a = Math.min(getFundValueAtEnd_AE, swbBean.getBaseprem());

		double b = getSurrenderCharge();

		ans = cfap.roundUp_Level2(cfap.getStringWithout_E(Math.min((a * b), getSurrenderCap())));
		this.SurrenderCharges_AF = ans;
	}

	public String getSurrenderCharges_AF() {
		return SurrenderCharges_AF;
	}

	// ==================================================== TaxOnSurrenderCharge_AG
	public void setTaxOnSurrenderCharge_AG(double month, double year, boolean bankdiss, double sumprem) {
		double val = 0;
		double b = 0;
		double output = 0;

		if (prop.surrender_charge == true) {
			val = Double.parseDouble(getSurrenderCharges_AF());
		} else {
			val = 0;

		}
		if (month <= AM3()) {
			b = totalTax();
		} else {
			b = prop.ServiceTax;

		}
		output = val * b;
		this.TaxOnSurrenderCharge_AG = (cfap.getRoundOffLevel2New(output + ""));
	}

	public String getTaxOnSurrenderCharge_AG() {
		return TaxOnSurrenderCharge_AG;
	}

	// ==================================================== SurrenderValue_AH
	public void setSurrenderValue_AH(double month, double year, boolean bankdiss, double sumprem) {
		double a = Double.parseDouble(getFundValueAtEnd_AE());
		double b = Double.parseDouble(getSurrenderCharges_AF());
		double c = Double.parseDouble(getTaxOnSurrenderCharge_AG());

		double val = a - b - c;
		this.SurrenderValue_AH = "" + val;
	}

	public String getSurrenderValue_AH() {
		return SurrenderValue_AH;
	}

	// ====================================================
	public double IncreasingOptionInputPg() {
		return 0.0;
	}

	// ==================================================== DeathBenifit_AI
	public void setDeathBenifit_AI(double sumprem) {
		// here replace sstatic value with coloumn AE
		double output = 0;
		// MAX1
		double AE = Double.parseDouble(getFundValueAtEnd_AE());
		double max1val1 = (AE + 0);
		double max1val2 = SumAssured() * (1 + IncreasingOptionInputPg());
		double max1val3 = sumprem * 1.05;

		double val1val2 = Math.max(max1val1, max1val2);

		double max1 = Math.max(val1val2, max1val3);

		// ---------------

		double max2val1 = AE + (SumAssured() * IncreasingOptionInputPg());
		double max2val2 = sumprem * 1.05;
		double max2 = Math.max(max2val1, max2val2);

		double val2 = 0 * max2;
		output = max1 + val2;
		this.DeathBenifit_AI = "" + output;
	}

	public String getDeathBenifit_AI() {
		return DeathBenifit_AI;
	}

	// ==================================================== MortalityMorbality_AJ

	public void setMortalityMorbality_AJ(double year, double month, boolean bankdiss, double sumprem) {

		double mortalityCharge = mortalityChargesIterate();
		double AW = 0;
		if (month == 1) {
			AW = 0;
		} else {
//				AE= getFundValueAtEnd_AE();
//				AE = getFundValueAtEnd_AE(month, year, bankdiss, sumprem);
			AW = Double.parseDouble(getFundValueAtEnd_AW_pass());
		}

		double inner1max1 = Math.max(0, SumAssured());
		double max1 = Math.max(inner1max1, sumprem);

		double inner1max2 = Math.max(SumAssured(), (sumprem * 1.05 - AW));

		double val1 = mortalityCharge / 12;
		double val2 = 1 - 0;
		double val3 = Math.max((max1 - (Double.parseDouble(getAmtAvailForInvestment()) + AW)), 0);
		double val4 = 0;
		double val5 = Math.max(inner1max2, 0);
		double val6 = 0;
		if (prop.mor_charge) {
			val6 = 1;
		}

		this.MortalityMorbality_AJ = ""
				+ Double.parseDouble(cfap.getRoundOffLevel2New((val1 * val2 * val3 + val4 * val5) + "")) * val6;
	}

	public String getMortalityMorbality_AJ() {
		return MortalityMorbality_AJ;
	}
	// ADD HERE FROM AL TO AV

	public void setTotalCharges_AL(double year) {
		double val = 0;
		if (year == 0) {
			val = 0;
		} else {
			val = Double.parseDouble(getDoNotUse_M()) + Double.parseDouble(getMortalityMorbality_AJ())
					+ Double.parseDouble(getDoNotUse_M()) + Double.parseDouble(getDoNotUse_M())
					+ Double.parseDouble(getPPWBCharges_O()) + Double.parseDouble(getpolicyAdministrationCharge_N())
					+ Double.parseDouble(getDoNotUse_M()) + 0;
		}

		this.TotalCharges_AL = "" + val;

	}

	public String getTotalCharges_AL() {

		return TotalCharges_AL;
	}

	public void setTotalTax_AM(double year, double month, double sumPrem) {
		double a = 0;
		double b = 0;
		double c = 0;
		double val = 0;

		if (prop.admistration_charge == true) {
			a = Double.parseDouble(getpolicyAdministrationCharge_N());

		} else {
			a = 0;

		}
		if (prop.mor_charge == true) {
			b = Double.parseDouble(getMortalityMorbality_AJ()) + Double.parseDouble(getDoNotUse_M())
					+ Double.parseDouble(getDoNotUse_M()) + Double.parseDouble(getPPWBCharges_O())
					+ Double.parseDouble(getDoNotUse_M()) + Double.parseDouble(getDoNotUse_M());
		} else {
			b = 0;

		}
		if (month <= AM3()) {
			c = totalTax();
		} else {
			c = prop.ServiceTax;
		}

		val = Double.parseDouble(cfap.getRoundUp_Level2(((a + b) * c) + ""));

		this.setTotalTax_AM = "" + val;
	}

	public String getTotalTax_AM() {

		return setTotalTax_AM;
	}

	public void setTotalTax_AN(double month, double year_F, boolean bankdiss, double sumPrem) {
		double totalTax_AM = Double.parseDouble(getTotalTax_AM());
		double taxOnAllocation = Double.parseDouble(getTaxOnAllocation_K());
		double AS10 = 37.61;
		double val = 0;
		if (month <= AM3()) {
			val = totalTax();
		} else {
			val = prop.ServiceTax;
		}

		double output = totalTax_AM + taxOnAllocation + AS10 + 0 * val;

		this.TotalTax_AN = output + "";
	}

	public String getTotalTax_AN() {

		return TotalTax_AN;
	}

	public double AO4() {

		double result = Math.pow(1 + prop.int2, 1.0 / 12) - 1;
		return Double.parseDouble(cfap.getRoundOffLevel5New(result + ""));
	}

	public void setAdditionToFund_AO(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		double finalval = 0;

		double AW = 0;
		if (month == 1) {
			AW = 0;
		} else {
			AW = Double.parseDouble(getFundValueAtEnd_AW_pass());
		}

		if (year == 0) {
			output = 0;
		} else {
			output = (AW + Double.parseDouble(getAmtAvailForInvestment()) - Double.parseDouble(getTotalCharges_AL())
					- Double.parseDouble(getTotalTax_AM()) + Double.parseDouble(getDoNotUse_M())) * AO4();
			finalval = Double.parseDouble(cfap.roundUp_Level2(output + ""));
			this.AdditionToFund_AO = "" + finalval;

		}

	}

	public String getAdditionToFund_AO() {

		return AdditionToFund_AO;
	}

	public void setFundBeforeFMC_AP(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;

		double AW = 0;
		if (month == 1) {
			AW = 0;
		} else {
			AW = Double.parseDouble(getFundValueAtEnd_AW_pass());
		}

		if (year == 0) {
			this.FundBeforeFMC_X = "" + 0;
		} else {
			this.FundBeforeFMC_AP = "" + (AW + Double.parseDouble(getAmtAvailForInvestment())
					+ Double.parseDouble(getAdditionToFund_AO()) - Double.parseDouble(getTotalCharges_AL())
					- Double.parseDouble(getTotalTax_AM()) + Double.parseDouble(getDoNotUse_M()));
		}
	}

	public String getFundBeforeFMC_AP() {
		return FundBeforeFMC_AP;
	}

	public void setFundManagementCharge_AQ(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		if (year == 0) {
			output = 0;
		} else {
			output = (Double.parseDouble(getFundBeforeFMC_AP()) * FMCInputPg(year) / 12);
		}

		this.FundManagementCharge_AQ = cfap.getRoundUp(output + "");
	}

	public String getFundManagementCharge_AQ() {
		return FundManagementCharge_AQ;
	}

	public void setGuaranteeCharge_AR(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		if (year == 0) {
			output = 0;
		} else {
			output = Double.parseDouble(getFundBeforeFMC_AP()) * guaranteedChargeInputPg(year) / 12;
		}
		this.GuaranteeCharge_AR = cfap.getRoundUp(output + "");
	}

	public String getGuaranteeCharge_AR() {
		return GuaranteeCharge_AR;
	}

	public void setTaxOnFMCAndGuaranteeCharge_AS(double month, double year, boolean bankdiss, double sumprem) {
		double output = 0;
		double FMC = FMCInputPg(year);
		double val1 = 0;
		double val2 = 0;
		double val3 = 0;

		if (year == 0) {
			val1 = 0;
		} else {
			val1 = Double.parseDouble(getGuaranteeCharge_AR()) + Double.parseDouble(getFundManagementCharge_AQ());

		}

		if (month <= AM3()) {
			val2 = totalTax();
		} else {
			val2 = prop.ServiceTax;
		}

		if (prop.fund_management_charge) {
			val3 = 1;
		} else {
			val3 = 0;
		}

		output = val1 * val2 * val3;
		this.TaxOnFMCAndGuaranteeCharge_AS = cfap.getRoundOffLevel2New(output + "");
	}

	public String getTaxOnFMCAndGuaranteeCharge_AS() {
		return TaxOnFMCAndGuaranteeCharge_AS;
	}

	public void setFundValueAfterFMC_AT(double month, double year, boolean bankdiss, double sumprem) {
		double val = 0;
		if (year == 0) {
			val = 0;
		} else {

			val = (Double.parseDouble(getFundBeforeFMC_AP()) - Double.parseDouble(getFundManagementCharge_AQ())
					- Double.parseDouble(getGuaranteeCharge_AR())
					- Double.parseDouble(getTaxOnFMCAndGuaranteeCharge_AS()));
		}

		this.FundValueAfterFMC_AT = cfap.getRoundOffLevel2(val + "");
	}

	public String getFundValueAfterFMC_AT() {
		return FundValueAfterFMC_AT;
	}

	public void setGuranteeAddition_AU() {
		this.GuranteeAddition_AU = "" + 0;
	}

	public String getGuranteeAddition_AU() {
		return GuranteeAddition_AU;
	}

	public void setTerminalAddition_AV(double month, double year, boolean bankdiss, double sumprem) {
		double value = 0;
		if (month == swbBean.getPolicyTerm() * 12) {
			value = (Double.parseDouble(getFundValueAfterFMC_AB()) + Double.parseDouble(getGuranteeAddition_AC())) * 0;

		} else {
			value = 0;

		}

		this.TerminalAddition_AV = "" + value;
	}

	public String getTerminalAddition_AV() {
		return TerminalAddition_AV;
	}

	// ====================================================== FundValueAtEnd_AW
	public void setFundValueAtEnd_AW(double month, double year, boolean bankdiss, double sumprem) {
//			this.FundValueAtEnd_AE =""+ Double.parseDouble(getGuranteeAddition_AC()) + Double.parseDouble(getFundValueAfterFMC_AB())
//			+ Double.parseDouble(getTerminalAddition_AD()) ;

		double guaranteeAddition = Double.parseDouble(getGuranteeAddition_AU().replaceAll(",", ""));
		double fundValueAfterFMC = Double.parseDouble(getFundValueAfterFMC_AT().replaceAll(",", ""));
		double terminalAddition = Double.parseDouble(getTerminalAddition_AV().replaceAll(",", ""));

		this.FundValueAtEnd_AE = String.valueOf(guaranteeAddition + fundValueAfterFMC + terminalAddition);
	}

	public String getFundValueAtEnd_AW() {
		return FundValueAtEnd_AE;
	}

	// ====================================================== FundValueAtEnd_AW (for
	// passing value in other dependenet methods)
	public void setFundValueAtEnd_AW_pass(double month, double year, boolean bankdiss, double sumprem) {
//			this.FundValueAtEnd_AE =""+ Double.parseDouble(getGuranteeAddition_AC()) + Double.parseDouble(getFundValueAfterFMC_AB())
//			+ Double.parseDouble(getTerminalAddition_AD()) ;

		double guaranteeAddition = Double.parseDouble(getGuranteeAddition_AU().replaceAll(",", ""));
		double fundValueAfterFMC = Double.parseDouble(getFundValueAfterFMC_AT().replaceAll(",", ""));
		double terminalAddition = Double.parseDouble(getTerminalAddition_AV().replaceAll(",", ""));

		this.FundValueAtEnd_AE_pass = String.valueOf(guaranteeAddition + fundValueAfterFMC + terminalAddition);
	}

	public String getFundValueAtEnd_AW_pass() {
		return FundValueAtEnd_AE_pass;
	}

	public void setSurrenderCharges_AX(double month, double year, boolean bankdiss, double sumprem) {
		String ans = null;

		double getFundValueAtEnd_AW = Double.parseDouble(getFundValueAtEnd_AW());
		double a = Math.min(getFundValueAtEnd_AW, swbBean.getBaseprem());

		double b = getSurrenderCharge();

		ans = cfap.roundUp_Level2(cfap.getStringWithout_E(Math.min((a * b), getSurrenderCap())));
		this.SurrenderCharges_AX = ans;
	}

	public String getSurrenderCharges_AX() {
		return SurrenderCharges_AX;
	}

	public void setTaxOnSurrenderCharge_AY(double month, double year, boolean bankdiss, double sumprem) {
		double val = 0;
		double b = 0;
		double output = 0;

		if (prop.surrender_charge == true) {
			val = Double.parseDouble(getSurrenderCharges_AX());
		} else {
			val = 0;

		}
		if (month <= AM3()) {
			b = totalTax();
		} else {
			b = prop.ServiceTax;

		}
		output = val * b;
		this.TaxOnSurrenderCharge_AY = (cfap.getRoundOffLevel2New(output + ""));
	}

	public String getTaxOnSurrenderCharge_AY() {
		return TaxOnSurrenderCharge_AY;
	}
	
public void setSurrenderValue_AZ(double month, double year, boolean bankdiss, double sumprem) {
	double a = Double.parseDouble(getFundValueAtEnd_AW());
	double b = Double.parseDouble(getSurrenderCharges_AX());
	double c = Double.parseDouble(getTaxOnSurrenderCharge_AY());

	double val = a - b - c;
	this.SurrenderValue_AZ = "" + val;
}

public String getSurrenderValue_AZ() {
	return SurrenderValue_AZ;
}

	
	// ====================================================== DeathBenifit_BA
	public void setDeathBenifit_BA(double sumprem) {
		// here replace sstatic value with coloumn AW
		double output = 0;
		// MAX1
		double max1val1 = (199925.12 + 0);
		double max1val2 = SumAssured() * (1 + IncreasingOptionInputPg());
		double max1val3 = sumprem * 1.05;

		double val1val2 = Math.max(max1val1, max1val2);

		double max1 = Math.max(val1val2, max1val3);

		// ---------------

		double max2val1 = 199925.12 + (SumAssured() * IncreasingOptionInputPg());
		double max2val2 = sumprem * 1.05;
		double max2 = Math.max(max2val1, max2val2);

		double val2 = 0 * max2;
		output = max1 + val2;
		this.DeathBenifit_BA = "" + output;
	}

	public String getDeathBenifit_BA() {
		return DeathBenifit_BA;
	}

}
