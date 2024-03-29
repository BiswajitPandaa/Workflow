package com.sbilife.smartannuityplusversion6;

import com.sbilife.common.CommonForAllProd;

public class SmartAnnuityPlusBussinessLogic {

	CommonForAllProd cfap = null;
	SmartAnnuityPlusBean smartAnnuityPlusBean = null;
	SmartAnnuityPlusDB db = null;
	SmartAnnuityPlusProperties prop = null;

	public SmartAnnuityPlusBussinessLogic(SmartAnnuityPlusBean bean) {
		this.smartAnnuityPlusBean = bean;
		cfap = new CommonForAllProd();
		db = new SmartAnnuityPlusDB();
		prop = new SmartAnnuityPlusProperties();
	}

	public int numberAsPerOptionType() {
		int val = 0;
		String OptionType= smartAnnuityPlusBean.getOptionType();
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
		} else if (OptionType.equals("Deferred Life Annuity with Return of Purchase Price")) {
			val = 10;
		} else if (OptionType.equals("Life & Last Survivor - 100% Annuity")) {
			val = 11;
		} else if (OptionType
				.equals("Life and Last Survivor - 100% Annuity with Return of Purchase price")) {
			val = 12;
		} else if (OptionType
				.equals("Deferred Life & Last Survivor Annuity with Return of Purchase price")) {
			val = 13;
		}
		return val;
	}

	public String getN3() {
		String N3 = "";
		String OptionType= smartAnnuityPlusBean.getOptionType();
		if (OptionType.equals("Life Annuity")) {
			N3 = "1.1";
		} else if (OptionType.equals("Life Annuity with Return of Purchase Price")) {
			N3 = "1.2";
		} else if (OptionType.equals("Life Annuity with Return of Balance Purchase Price")) {
			N3 = "1.3";
		} else if (OptionType.equals("Life Annuity with Annual Simple Increase of 3%")) {
			N3 = "1.4";
		} else if (OptionType.equals("Life Annuity with Annual Simple Increase of 5%")) {
			N3 = "1.5";
		} else if (OptionType.equals("Life Annuity with certain period of 10 years")) {
			N3 = "1.6";
		} else if (OptionType.equals("Life Annuity with certain period of 20 years")) {
			N3 = "1.7";
		} else if (OptionType.equals("Life Annuity with Annual Compound Increase of 3%")) {
			N3 = "1.8";
		} else if (OptionType.equals("Life Annuity with Annual Compound Increase of 5%")) {
			N3 = "1.9";
		} else if (OptionType.equals("Deferred Life Annuity with Return of Purchase Price")) {
			N3 = "1.10";
		} else if (OptionType.equals("Life & Last Survivor - 100% Annuity")) {
			N3 = "2.1";
		} else if (OptionType
				.equals("Life and Last Survivor - 100% Annuity with Return of Purchase price")) {
			N3 = "2.2";
		} else if (OptionType
				.equals("Deferred Life & Last Survivor Annuity with Return of Purchase price")) {
			N3 = "2.3";
		}
		return N3;
	}

	public String getServiceTax() { // Y Output Screen
		double vestingAmount = smartAnnuityPlusBean.getAnnuAmt();
		double val = vestingAmount - vestingAmount / (1 + 0.018);

		String serviceTax = cfap.getRoundOffLevel2(val + "");
		return serviceTax;
	}

	public String getAmountAfterServiceTax() { // Z Output Screen
		double vestingAmount = smartAnnuityPlusBean.getAnnuAmt();
		double serviceTax = Double.parseDouble(getServiceTax());
		double val = vestingAmount - serviceTax;
		String AmountAfterServiceTax = cfap.getRoundOffLevel2(val + "");
		return AmountAfterServiceTax;
	}

	public String getAnnuityAmount(int numberAsPerOptionType,double getHPP) {
		double output = 0;
		double annuRateMulodalFac = getAnnuityRateModalFactor(numberAsPerOptionType);
		double HPP = getHPP;
		double frequencyFactor = getFrequencyFactor();
		double AmtAfterServTax = Double.parseDouble(getAmountAfterServiceTax());
		if (prop.AI9 == 5) {
			output = ((annuRateMulodalFac + HPP) / frequencyFactor) / 972.5 * AmtAfterServTax;
		} else {
			if (smartAnnuityPlusBean.isStaff() == true
					|| smartAnnuityPlusBean.getChannelType().equals("Direct Marketing")
					|| smartAnnuityPlusBean.getChannelType().equals("Online channel")) {
				output = ((annuRateMulodalFac + HPP) / frequencyFactor) / 980 * AmtAfterServTax;
			} else {
				output = ((annuRateMulodalFac + HPP) / frequencyFactor) / 1000 * AmtAfterServTax;
			}

		}
		return output + "";
	}

	// =========================== Output Screen L to P

	// for Annuity rates
	public double getAnnuityRates_SingleLife_Immediate(int numberAsPerOptionType) {
		int plantypeNum = numberAsPerOptionType;
		String lifeType = smartAnnuityPlusBean.getLifeType();
		String planType = smartAnnuityPlusBean.getPlantype();

		double annuityRate = 0;
		double arr_rates[] = null;
		if (lifeType.equals("Single Life") && planType.equals("IMMEDIATE ANNUITY")) {
			arr_rates = db.getSingleLifeImmediate(plantypeNum);
		}

		for (int i = 0; i <= 100; i++) {
			if (smartAnnuityPlusBean.getAge() == i) {
				annuityRate = arr_rates[i];
			}
		}

		return annuityRate;
	}

	public double getAnnuityRates_SingleLife_Deferred() {
		String lifeType = smartAnnuityPlusBean.getLifeType();
		String planType = smartAnnuityPlusBean.getPlantype();

		double annuityRate = 0;
		double arr_rates[] = null;
		if (lifeType.equals("Single Life") && planType.equals("DEFERRED ANNUITY")) {
			arr_rates = db.getDeferred_Life_annuity_with_Return_of_Purchase_Price();
		}

		int count = 0;
		for (int i = 45; i <= 75; i++) {
			for (int j = 1; j <= 10; j++) {
				if (smartAnnuityPlusBean.getAge() == i && smartAnnuityPlusBean.getDerferedPeriod() == j) {
					annuityRate = arr_rates[count];
					break;
				}
				count++;
			}
		}
		return annuityRate;
	}
	////////////////////////////////////////////////////////////////////////////////

	public double getAnnuityRates_Joint_Life_Immediate() {
		String rates = null;
		String[] ratesArr;
		int count = 0;
		double output = 0;
		rates = db.getLifeAndLastSurvivor100perIncome();
		ratesArr = cfap.split(rates, ",");
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (i == smartAnnuityPlusBean.getAge() && j == smartAnnuityPlusBean.getSecAnuAge()) {
					output = Double.parseDouble(ratesArr[count]);
					break;
				}
				count++;
			}
		}
		System.out.println("rates " + output);
		return output;
	}

	public double getAnnuityRates_Joint_Life_Immediate100perROC() {
		String rates = null;
		String[] ratesArr;
		int count = 0;
		double output = 0;
		rates = db.getLifeAndLastSurvivor100perIncomewithRefundofPurchasePrice();
		ratesArr = cfap.split(rates, ",");
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (i == smartAnnuityPlusBean.getAge() && j == smartAnnuityPlusBean.getSecAnuAge()) {
					output = Double.parseDouble(ratesArr[count]);
					break;
				}
				count++;
			}
		}
		System.out.println("rates " + output);
		return output;
	}

	public double getAnnuityRates_Joint_Life_Deferred() {

		String[] check = db.getcheck();
		String forCheck = smartAnnuityPlusBean.getSecAnuAge() + "," + smartAnnuityPlusBean.getDerferedPeriod();
		String rates = null;
		String[] ratesArr;
		int count = 0;
		double output = 0;
		// System.out.println(check.length);
		rates = db.getJointLifeDeferred();
		ratesArr = cfap.split(rates, ",");
		// System.out.println("len" +ratesArr.length);
		for (int i = 45; i <= 85; i++) {
			for (int j = 0; j < check.length; j++) {
				if (i == smartAnnuityPlusBean.getAge() && forCheck.equals(check[j])) {
					output = Double.parseDouble(ratesArr[count]);
					break;
				}
				count++;
			}
		}
//		System.out.println( "rates newwwww " +output);
		return output;
	}

	public double getFinalAnnuityRate(int numberAsPerOptionType) {
		double output = 0;
		String lifeType = smartAnnuityPlusBean.getLifeType();
		String planType = smartAnnuityPlusBean.getPlantype();
		String optionType = smartAnnuityPlusBean.getOptionType();
		if (lifeType.equals("Single Life")
				&& planType.equals("IMMEDIATE ANNUITY")) {
			output = getAnnuityRates_SingleLife_Immediate(numberAsPerOptionType);
		} else if (lifeType.equals("Single Life")
				&& planType.equals("DEFERRED ANNUITY")) {
			output = getAnnuityRates_SingleLife_Deferred();
		} else if (lifeType.equals("Joint Life")
				&& planType.equals("IMMEDIATE ANNUITY")) {
			if (optionType.equals("Life & Last Survivor - 100% Income")) {
				output = getAnnuityRates_Joint_Life_Immediate();
			} else if (optionType.equals("Life & Last Survivor - 100% Income with Refund of Purchase Price")) {
				output = getAnnuityRates_Joint_Life_Immediate100perROC();
			}
		} else if (lifeType.equals("Joint Life")
				&& planType.equals("DEFERRED ANNUITY")) {
			output = getAnnuityRates_Joint_Life_Deferred();
		}
		return output;
	}
	// ============

	public double getFrequencyFactor() { // Output Screen M
		double output = 0;
		if (smartAnnuityPlusBean.getModePayout().equals("Yearly")) {
			output = 1.0;
		} else if (smartAnnuityPlusBean.getModePayout().equals("Half-Yearly")) {
			output = 2.0;
		} else if (smartAnnuityPlusBean.getModePayout().equals("Quarterly")) {
			output = 4.0;
		} else {
			output = 12.0;
		}
		return output;
	}

	public double getModalFactor() { // Output Screen N
		double output = 0;
		if (smartAnnuityPlusBean.getModePayout().equals("Yearly")) {
			output = 1.0275;
		} else if (smartAnnuityPlusBean.getModePayout().equals("Half-Yearly")) {
			output = 1.0125;
		} else if (smartAnnuityPlusBean.getModePayout().equals("Quarterly")) {
			output = 1.005;
		} else {
			output = 1;
		}
		return Double.parseDouble((output + ""));
	}

	public double getAnnuityRateModalFactor(int numberAsPerOptionType) { // Output Screen O
		double annuityRate = getFinalAnnuityRate(numberAsPerOptionType); // changer here
		double modalFactor = getModalFactor();
		double output = annuityRate * modalFactor;

		// System.out.println(Double.parseDouble(cfap.getRoundUp_Level2((cfap.getRoundOffLevel2New(output+"")))));
		//return Double.parseDouble((cfap.getRoundOffLevel2(output + "")));
		return Double.parseDouble(((output + "")));

	}

	public double getHPP(int numberAsPerOptionType) {
		double output = 0;

		String optfor = smartAnnuityPlusBean.getOptfor();
		String optiontype = smartAnnuityPlusBean.getOptionType();
		double V = Double.parseDouble(getRefering_for_higher_purchase_amount(numberAsPerOptionType));
		double Z = Double.parseDouble(getAmountAfterServiceTax());
		if (optfor.equals("Annuity Amount")) {
			if (optiontype.equals("Life Annuity with Annual Simple Increase of 3%")
					|| optiontype.equals("Life Annuity with Annual Simple Increase of 5%")) {
				if (V >= 1000000 && V <= 2499999) {
					output = 0.2;
				} else if (V >= 2500000 && V <= 4999999) {
					output = 0.5;
				} else if (V >= 5000000 && V <= 9999999) {
					output = 0.6;
				} else if (V >= 10000000) {
					output = 0.7;
				}
			} else if (optiontype.equals("Life Annuity with Annual Compound Increase of 3%")
					|| optiontype.equals("Life Annuity with Annual Compound Increase of 5%")) {
				if (V >= 1000000 && V <= 2499999) {
					output = 0.15;
				} else if (V >= 2500000 && V <= 4999999) {
					output = 0.3;
				} else if (V >= 5000000 && V <= 9999999) {
					output = 0.4;
				} else if (V >= 10000000) {
					output = 0.5;
				}
			} else {
				if (V >= 1000000 && V <= 2499999) {
					output = 0.25;
				} else if (V >= 2500000 && V <= 4999999) {
					output = 0.75;
				} else if (V >= 5000000 && V <= 9999999) {
					output = 0.95;
				} else if (V >= 10000000) {
					output = 1.05;
				}
			}
		} else {
			if (optiontype.equals("Life Annuity with Annual Simple Increase of 3%")
					|| optiontype.equals("Life Annuity with Annual Simple Increase of 5%")) {
				if (Z >= 1000000 && V <= 2499999) {
					output = 0.2;
				} else if (Z >= 2500000 && V <= 4999999) {
					output = 0.5;
				} else if (Z >= 5000000 && V <= 9999999) {
					output = 0.6;
				} else if (Z >= 10000000) {
					output = 0.7;
				}
			} else if (optiontype.equals("Life Annuity with Annual Compound Increase of 3%")
					|| optiontype.equals("Life Annuity with Annual Compound Increase of 5%")) {
				if (Z >= 1000000 && V <= 2499999) {
					output = 0.15;
				} else if (Z >= 2500000 && V <= 4999999) {
					output = 0.3;
				} else if (Z >= 5000000 && V <= 9999999) {
					output = 0.4;
				} else if (Z >= 10000000) {
					output = 0.5;
				}
			} else {
				if (Z >= 1000000 && V <= 2499999) {
					output = 0.25;
				} else if (Z >= 2500000 && V <= 4999999) {
					output = 0.75;
				} else if (Z >= 5000000 && V <= 9999999) {
					output = 0.95;
				} else if (Z >= 10000000) {
					output = 1.05;
				}
			}
		}
		return output;
	}

	// ============

	// ====================================== Coloumn R - V

	public String getPurchaseTemp(int numberAsPerOptionType) { // Output Screen S
		double output = 0;
		double annuityAmt = smartAnnuityPlusBean.getAnnuAmt();
		double freqfac = getFrequencyFactor();
		double O = getAnnuityRateModalFactor(numberAsPerOptionType);
		if (smartAnnuityPlusBean.isStaff() == true || smartAnnuityPlusBean.getChannelType().equals("Direct Marketing")
				|| smartAnnuityPlusBean.getChannelType().equals("Online channel")) {
			output = (annuityAmt * 980 * freqfac) / O;
		} else {
			output = (annuityAmt * 1000 * freqfac) / O;
		}

		String ot = cfap.getRoundOffLevel2((cfap.roundUp_Level4(cfap.getStringWithout_E(output))));

		// return String.format("%.3f", output);
		return ot;
	}

	public String getPurchasePrice(int numberAsPerOptionType,double getHPP) {
		double output = 0;
		double annuityAmt = smartAnnuityPlusBean.getAnnuAmt();
		double freqfac = getFrequencyFactor();
		double O = getAnnuityRateModalFactor(numberAsPerOptionType);
		double Hpp = getHPP;
		if (smartAnnuityPlusBean.isStaff() == true || smartAnnuityPlusBean.getChannelType().equals("Direct Marketing")
				|| smartAnnuityPlusBean.getChannelType().equals("Online channel")) {
			output = annuityAmt * 980 * freqfac / (O + Hpp);
		} else {
			output = annuityAmt * 1000 * freqfac / (O + Hpp);
		}

		String ot = cfap.getRoundOffLevel2((cfap.getStringWithout_E(output)));

		// return String.format("%.3f", output);
		return ot;
	}

	public String getServiceTaxOnPurchase(int numberAsPerOptionType,double getHPP) {
		double T9 = Double.parseDouble(getPurchasePrice(numberAsPerOptionType, getHPP));
		double val = T9 * 0.009;
		//String output = cfap.getRoundUp((T9 * 0.009) + "") + cfap.getRoundUp((T9 * 0.009) + "");
		String output = (val + val)+"";
		return  cfap.getRoundUp(output) ;
	}

	public String getRefering_for_higher_purchase_amount(int numberAsPerOptionType) {
		double purchaseTemp = Double.parseDouble(getPurchaseTemp(numberAsPerOptionType));
		double output = purchaseTemp / (1 + 0);
		return  cfap.getRoundOffLevel2(cfap.roundUp_Level4(cfap.getStringWithout_E(output)));
	}
	// ============

	public String getPurchasePrice_Capital(int numberAsPerOptionType,double getHPP) {
		String output;
		if (smartAnnuityPlusBean.getOptfor().equals("Premium Amount")) {
			output = getAmountAfterServiceTax();
		} else {
			output = getPurchasePrice(numberAsPerOptionType, getHPP);
		}

		//return cfap.getRoundUp(output);
		return cfap.getRound(cfap.getStringWithout_E(Double.parseDouble(output)));
	}

	public String getApplicablePremiumPayable() {
		return "0";
	}

	public String getApplicableTax(int numberAsPerOptionType,double getHPP) {
		String output;
		if (smartAnnuityPlusBean.getOptfor().equals("Premium Amount")) {
			output = getServiceTax();
		} else {
			output = getServiceTaxOnPurchase(numberAsPerOptionType, getHPP);
		}
		return output;
	}

	public String getTotalPremium(int numberAsPerOptionType,double getHPP) {
		double PurchasePrice_Capital = Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType, getHPP));
		double ApplicablePremiumPayable = Double.parseDouble(getApplicablePremiumPayable());
		double ApplicableTax = Double.parseDouble(getApplicableTax(numberAsPerOptionType, getHPP));
		double val = 0;
		if (smartAnnuityPlusBean.isAdvAnnuPayout() == false) {
			val = 0;
		} else {
			val =ApplicablePremiumPayable;
		}

		double output = PurchasePrice_Capital + ApplicableTax + val;
		return  cfap.roundUp_Level4(cfap.getStringWithout_E(output));
	}

	public String getAK_AG(int numberAsPerOptionType,double getHPP) {
		String output;
		if (smartAnnuityPlusBean.getOptfor().equals("Premium Amoun")) {
			output = getAnnuityAmount(numberAsPerOptionType,getHPP) + "";
		} else {
			output = smartAnnuityPlusBean.getAnnuAmt() + "";
		}
		return output;
	}

	// ===========================BI
	
	public String getAnnulizedPrem(int policyYr,int numberAsPerOptionType,double getHPP) {
		String output;
		if(policyYr == 1) {
			output = getPurchasePrice_Capital(numberAsPerOptionType, getHPP);
		}else {
			output = 0+"";
		}
		return output;
	}

	public String getSurvivalBenifit_pol1(int policyYr,int numberAsPerOptionType,String getN3,double getHPP) {
		String output = "";
		double AG = Double.parseDouble(getAK_AG(numberAsPerOptionType, getHPP));
		if (numberAsPerOptionType == 10 || getN3.equals("2.3")) {
			if (policyYr > smartAnnuityPlusBean.getDerferedPeriod()) {
				if (smartAnnuityPlusBean.getModePayout().equals("Half-Yearly")) {
					output = (AG * 2) + "";
				} else if (smartAnnuityPlusBean.getModePayout().equals("Quarterly")) {
					output = (AG * 4) + "";
				} else if (smartAnnuityPlusBean.getModePayout().equals("Monthly")) {
					output = (AG * 12) + "";
				} else {
					output = (AG) + "";
				}
			}else {
				output = 0+"";
			}
		} else {
			if (smartAnnuityPlusBean.getModePayout().equals("Half-Yearly")) {
				output = (AG * 2) + "";
			} else if (smartAnnuityPlusBean.getModePayout().equals("Quarterly")) {
				output = (AG * 4) + "";
			} else if (smartAnnuityPlusBean.getModePayout().equals("Monthly")) {
				output = (AG * 12) + "";
			} else {
				output = (AG) + "";
			}
		}

		return output;
	}
	
	public String getSurvivalBenifit(int policyYr,int numberAsPerOptionType,String getN3,double getHPP) {
		String output;
		double surpol1 =Double.parseDouble(getSurvivalBenifit_pol1(policyYr,numberAsPerOptionType,getN3,getHPP));
		if(getN3.equals("1.4")) {
			output = (surpol1 + (0.03 * surpol1)) + "" ;
		}else if(getN3.equals("1.8")) {
			output = (surpol1 + (0.03 * surpol1)) + "" ;
		}else if(getN3.equals("1.5")) {
			output = (surpol1 + (0.05 * surpol1)) + "" ;
		}else if(getN3.equals("1.9")) {
			output = (surpol1 + (0.05 * surpol1)) + "" ;
		}else {
			if(numberAsPerOptionType == 10 || getN3.equals("2.3")) {
				output = Life_time_Income_with_Capital(policyYr,numberAsPerOptionType,getHPP);
			}else {
				output = surpol1 + "";
			}
		}
		return output;
	}
	
	public String Life_time_Income_with_Capital(int policyYr,int numberAsPerOptionType,double getHPP) {
		String output="";
		double AG = Double.parseDouble(getAK_AG(numberAsPerOptionType,getHPP));
		if(policyYr > smartAnnuityPlusBean.getDerferedPeriod()) {
			if (smartAnnuityPlusBean.getModePayout().equals("Half-Yearly")) {
				output = (AG * 2) + "";
			} else if (smartAnnuityPlusBean.getModePayout().equals("Quarterly")) {
				output = (AG * 4) + "";
			} else if (smartAnnuityPlusBean.getModePayout().equals("Monthly")) {
				output = (AG * 12) + "";
			} else {
				output = (AG) + "";
			}
		}else {
			output = 0+"";
		}
		return output;
	}
	
	public String getGuaranteed_Addition(int policyYr,int numberAsPerOptionType,String getN3,double getHPP) {
		String output="";
		double annuityRates = getFinalAnnuityRate(numberAsPerOptionType);
		double instPremWithServTax = Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType, getHPP)); 
		double HPP = getHPP(numberAsPerOptionType);
		double val = 0;
		double val1 = 0;
		if(smartAnnuityPlusBean.isStaff() == true || 
				smartAnnuityPlusBean.getChannelType().equals("Direct Marketing") ||
				smartAnnuityPlusBean.getChannelType().equals("Online channel")) {
			val1 = 980;
		}else {
			val1 = 1000;
		}
		
		if(policyYr <= smartAnnuityPlusBean.getDerferedPeriod()) {
			if(numberAsPerOptionType == 10) {
				val = Double.parseDouble(cfap.getRound(((((annuityRates + HPP)/12)/val1)*instPremWithServTax) + "")) * 12;
			}else {
				if(getN3.equals("2.3")) {
					val = Double.parseDouble(cfap.getRound(((((annuityRates + HPP)/12)/val1)*instPremWithServTax) + "")) * 12;
				}else {
					val = 0;
				}
			}
		}
		return val+"";
	}
	
	public String getDeathBenifit(int policyYr,double sumSurbenifit,double sumGuaBenifit,double annulizedPrem1,int numberAsPerOptionType,String getN3,double getHPP) {
		double insPremWithoutAppTax = Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType, getHPP));
		
		double val1 = 0;
		if(numberAsPerOptionType == 10 || getN3.equals("2.3")) {
			if(policyYr <= smartAnnuityPlusBean.getDerferedPeriod()) {
				val1 = Math.max(1.05 * insPremWithoutAppTax,(annulizedPrem1 + sumGuaBenifit - sumSurbenifit));
			}else {
				val1 = Math.max((annulizedPrem1 + sumGuaBenifit - sumSurbenifit), annulizedPrem1);
			}
		}else {
			if(getN3.equals("1.2") || getN3.equals("2.4") || getN3.equals("2.2")) {
				val1 = insPremWithoutAppTax;
			}else {
				if(getN3.equals("1.3")) {
					val1 = annulizedPrem1 - sumSurbenifit;
				}
			}
		}
		
		String output = (Math.max(0, val1)) + "";
		return  cfap.getRound(cfap.roundUp_Level4(cfap.getStringWithout_E(Double.parseDouble(output))));
	}
	
	public double GSV(int policyYr) {
		double output = 0;
		double [] GSV = {0.1327,0.144,0.1562,0.1695,0.1839,0.1995,0.2165,0.2349,0.2548,0.2765,0.3};
//		int[] years = {1,2,3,4,5,6,7,8,9,10};
//		for(int i =0;i<GSV.length;i++) {
//			if(i<=10) {
//				output = GSV[smartAnnuityPlusBean.getDerferedPeriod() - years[i]];
//			}else {
//				output = 0;
//			}
//		}
		
		for (int i = GSV.length - 1; i >= 0; i--) {
	        
	        if (policyYr == i) {
	            output = GSV[i];
	            break; 
	        }
	    }
 		return output;
	}
	
	public  double SSV(int policyYr) {
		double output = 0;
		int count = 0;
		double[] ssv = db.getSSV();
		
		for(int i=1;i<=25;i++) {
			for(int j=1;j<=10;j++) {
				if(i == policyYr && j == smartAnnuityPlusBean.getDerferedPeriod()) {
					output = ssv[count];
					break;
				}
				count++;
			}
		}
		return output;
	}
	
	public String GuaranteedSurVal(int policyYr,double sumSurbenifit,double sumGuaBenifit,double annulizedPrem1,int numberAsPerOptionType,String getN3) {
		double val = 0;
		double output = 0 ;
		double GSV = GSV(policyYr);
		double statval = 0;
		if(policyYr <= 3) {
			statval = 0.75;
		}else {
			statval = 0.90;
		}
		
		if(numberAsPerOptionType == 10 || getN3.equals("2.3")) {
			val = (statval * annulizedPrem1) - sumSurbenifit + GSV * sumGuaBenifit;
		}else {
			if(getN3.equals("1.2") || getN3.equals("2.4") ||getN3.equals("2.2")) {
				val = (statval * annulizedPrem1) - sumSurbenifit;
			}
		}
		
		output = Math.max(0, val);
		return cfap.getRound(cfap.roundUp_Level4(cfap.getStringWithout_E(output)));
	}
//===================	
	public int M(int policyYr) {
		int output = 0;
		if(policyYr <= (smartAnnuityPlusBean.getDerferedPeriod()+1)) {
			output = smartAnnuityPlusBean.getAge() + smartAnnuityPlusBean.getDerferedPeriod();
		}else {
			output = M(policyYr -1) + 1;
		}
		return output;
	}
	
//============	
	public String getSpecialSurVal(int policyYr,double deathbenifit,int numberAsPerOptionType,String getN3,double getHPP,int M) {
		
		double factor_B_1[] = db.factor_B_1();
		double factor_C_1[] =db.factor_C_1();
		
		double factor_B[] = db.factor_B();
		double factor_C[] = db.factor_C();
		double val=0;
		double loopvalB_1 = 0;
		double loopvalC_1 = 0;
		
		int count1=0;
		for(int i=30;i<=120;i++) {
			if(i == M) {
				loopvalB_1 = factor_B_1[count1];
				break;
			}
			count1++;
		}
		
		int count2=0;
		for(int i=30;i<=120;i++) {
			if(i == M) {
				loopvalC_1 = factor_C_1[count2];
				break;
			}
			count2++;
		}
		
//		double loop3 = 0;
//		for(int j=0;j<=24;j++) {
//			loop3 = factor_C[smartAnnuityPlusBean.getDerferedPeriod() - j];
//			}
		double loop3 = 0;
		int cnt =0;
		for(int i=30;i<=120;i++) {
				if(i == (smartAnnuityPlusBean.getAge() + policyYr-1)) {
					loop3 = factor_B[cnt];
					break;
			}
				cnt++;
		}
		
		double loop4 = 0;
		int cnt4 = 0;
		for (int i = 30; i <= 120; i++) {
			if (i == (smartAnnuityPlusBean.getAge() + policyYr - 1)) {
				loop4 = factor_C[cnt4];
				break;
			}
			cnt4++;

		}
		
		double surben = Double.parseDouble(getSurvivalBenifit(smartAnnuityPlusBean.getDerferedPeriod() + 1, numberAsPerOptionType,getN3, getHPP));
		double purchase_cap =  Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType, getHPP));
		if (numberAsPerOptionType == 10 || getN3.equals("2.3")) {
				val = SSV(policyYr) * (loopvalB_1 * surben
						+ loopvalC_1 * purchase_cap);
			} else {
				if (getN3.equals("1.2") || getN3.equals("2.4") || getN3.equals("2.2")) {
//					val = SSV(policyYr) * Double.parseDouble(getSurvivalBenifit(policyYr))
//							+ loop3 * Double.parseDouble(getPurchasePrice_Capital());
					val = loop3 * Double.parseDouble(getSurvivalBenifit_pol1(1,numberAsPerOptionType,getN3, getHPP)) + loop4 * Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType, getHPP));
				}
			}
		//==========================
		
		double output =  Math.min( deathbenifit ,val);
		return cfap.roundUp_Level4(cfap.getStringWithout_E(output)) ;
	}
	
	
	public String getInstPremWithTaxesfirstyear(int numberAsPerOptionType,double getHPP) {
		double output = Double.parseDouble(getPurchasePrice_Capital(numberAsPerOptionType,getHPP)) +  Double.parseDouble(getApplicableTax(numberAsPerOptionType,getHPP));
		return cfap.getRoundOffLevel2(cfap.roundUp_Level4(cfap.getStringWithout_E(output)));
	}
	
}
