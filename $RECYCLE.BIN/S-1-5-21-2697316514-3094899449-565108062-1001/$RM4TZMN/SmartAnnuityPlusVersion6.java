package com.sbilife.smartannuityplusversion6;

import java.security.Policy;

import com.sbilife.common.CommonForAllProd;

public class SmartAnnuityPlusVersion6 {

	StringBuilder retVal = null;

	public String CalculatePrem(String isStaff, String advAnnuPayout, String age, String gender, String annuAmt,
			String plantype, String srcOfBuss, String modePayout, String lifeType, String optfor,
			String secAnuGender, String secAnuAge, String derferedPeriod,String OptionType,String channelType) {

		SmartAnnuityPlusBean bean = new SmartAnnuityPlusBean();

		try {
			bean.setStaff(Boolean.parseBoolean(isStaff));
			bean.setAdvAnnuPayout(Boolean.parseBoolean(advAnnuPayout));
			bean.setAge(Integer.parseInt(age));
			bean.setGender(gender);
			bean.setAnnuAmt(Double.parseDouble(annuAmt));
			bean.setPlantype(plantype);
			bean.setSrcOfBuss(srcOfBuss);
			bean.setModePayout(modePayout);
			bean.setLifeType(lifeType);
			bean.setOptfor(optfor);
			
			
			if(bean.getPlantype().equals("DEFERRED ANNUITY")) {
				bean.setDerferedPeriod(Integer.parseInt(derferedPeriod));
			}
			
			if(bean.getLifeType().equals("Joint Life")) {
				bean.setSecAnuAge(Integer.parseInt(secAnuAge));
				bean.setSecAnuGender(secAnuGender);
			}
			
			bean.setOptionType(OptionType);
			bean.setChannelType(channelType);
		} catch (Exception e) {
			// TODO: handle exception

		}
		
		

		return showSmartAnnuityPlusVer6outputPg(bean);
	}

	public String showSmartAnnuityPlusVer6outputPg(SmartAnnuityPlusBean smartAnnuityPlusBean) {
		retVal = new StringBuilder();
		CommonForAllProd cfap = new CommonForAllProd();
		SmartAnnuityPlusBussinessLogic bussinessLogic = new SmartAnnuityPlusBussinessLogic(smartAnnuityPlusBean);
		
		int numberAsPerOptionType = bussinessLogic.numberAsPerOptionType();
		String getN3= bussinessLogic.getN3();
		double getHPP = bussinessLogic.getHPP(numberAsPerOptionType);
		double sumSurvivalBenifit = 0,sumGuaBen=0,annulizedprem1=0,SurvivalBenifit=0,deathbenifit=0;
		
		
		
		retVal.append("<serviceTax>"+ bussinessLogic.getServiceTax() +"</serviceTax>");
		retVal.append("<AmountAfterServiceTax>"+ bussinessLogic.getAmountAfterServiceTax() +"</AmountAfterServiceTax>");
//		retVal.append("<AnnuityRates>"+ bussinessLogic.getAnnuityRates_SingleLife_Immediate() +"</AnnuityRates>");
		retVal.append("<AnnuityRates>"+ bussinessLogic.getFinalAnnuityRate(numberAsPerOptionType) +"</AnnuityRates>");
		retVal.append("<frequencyFactor>"+ bussinessLogic.getFrequencyFactor() +"</frequencyFactor>");
		retVal.append("<ModalFactor>"+ bussinessLogic.getModalFactor() +"</ModalFactor>");
		retVal.append("<getAnnuityRate_Mul_ModalFactor>"+  bussinessLogic.getAnnuityRateModalFactor(numberAsPerOptionType) +"</getAnnuityRate_Mul_ModalFactor>");
		retVal.append("<HPP>"+getHPP +"</HPP>");
		retVal.append("<PurchaseTemp>"+ bussinessLogic.getPurchaseTemp(numberAsPerOptionType) +"</PurchaseTemp>");
		retVal.append("<PurchasePrice>"+ bussinessLogic.getPurchasePrice(numberAsPerOptionType,getHPP) +"</PurchasePrice>");
		retVal.append("<ServiceTaxOnPurchase>"+ bussinessLogic.getServiceTaxOnPurchase(numberAsPerOptionType,getHPP) +"</ServiceTaxOnPurchase>");
		retVal.append("<Refering_for_higher_purchase_amount>"+ bussinessLogic.getRefering_for_higher_purchase_amount(numberAsPerOptionType) +"</Refering_for_higher_purchase_amount>");
		retVal.append("<AnnuityAmount>"+ cfap.getRound(bussinessLogic.getAnnuityAmount(numberAsPerOptionType,getHPP))+"</AnnuityAmount>");
		retVal.append("<PurchasePriceCapital>"+ bussinessLogic.getPurchasePrice_Capital(numberAsPerOptionType,getHPP) +"</PurchasePriceCapital>");
		retVal.append("<ApplicableTax>"+ bussinessLogic.getApplicableTax(numberAsPerOptionType,getHPP)+"</ApplicableTax>");
		retVal.append("<TotalPremium>"+ bussinessLogic.getTotalPremium(numberAsPerOptionType,getHPP)+"</TotalPremium>");
		
		//BI Printing 
		retVal.append("<InstPremWithoutTaxes>"+ bussinessLogic.getPurchasePrice_Capital(numberAsPerOptionType,getHPP)+"</InstPremWithoutTaxes>");
		retVal.append("<InstPremWithTaxesfirstyear>"+bussinessLogic.getInstPremWithTaxesfirstyear(numberAsPerOptionType,getHPP)+"</InstPremWithTaxesfirstyear>");
		retVal.append("<TotalInstPremWithoutTaxes>"+ bussinessLogic.getPurchasePrice_Capital(numberAsPerOptionType,getHPP)+"</TotalInstPremWithoutTaxes>");
		retVal.append("<TotalInstPremWithTaxesfirstyear>"+bussinessLogic.getInstPremWithTaxesfirstyear(numberAsPerOptionType,getHPP)+"</TotalInstPremWithTaxesfirstyear>");
//		
		
		//Grid
		for(int i=1;i<=25;i++) {
			retVal.append("<AnnulizedPrem"+ i+">" + bussinessLogic.getAnnulizedPrem(i,numberAsPerOptionType,getHPP)+"</AnnulizedPrem"+ i+">");
			annulizedprem1 = Double.parseDouble(bussinessLogic.getAnnulizedPrem(1,numberAsPerOptionType,getHPP));
			
			if(i == 1) {
				SurvivalBenifit = Double.parseDouble(bussinessLogic.getSurvivalBenifit_pol1(i,numberAsPerOptionType,getN3,getHPP));
			}else {
				SurvivalBenifit = Double.parseDouble(bussinessLogic.getSurvivalBenifit(i,numberAsPerOptionType,getN3,getHPP));
			}
			retVal.append("<SurvivalBenifit"+ i+">" + bussinessLogic.getSurvivalBenifit_pol1(i,numberAsPerOptionType,getN3,getHPP)+"</SurvivalBenifit"+ i+">");
			
			sumSurvivalBenifit = sumSurvivalBenifit + SurvivalBenifit;
			
			retVal.append("<GuaranteedAddition"+ i+">" + bussinessLogic.getGuaranteed_Addition(i,numberAsPerOptionType,getN3,getHPP)+"</GuaranteedAddition"+i+">");
			
			sumGuaBen = sumGuaBen + Double.parseDouble(bussinessLogic.getGuaranteed_Addition(i,numberAsPerOptionType,getN3,getHPP));
			retVal.append("<DeathBenifit"+ i+">" + bussinessLogic.getDeathBenifit(i,sumSurvivalBenifit,sumGuaBen,annulizedprem1,numberAsPerOptionType,getN3,getHPP)+"</DeathBenifit"+ i+">");
			deathbenifit = Double.parseDouble(bussinessLogic.getDeathBenifit(i,sumSurvivalBenifit,sumGuaBen,annulizedprem1,numberAsPerOptionType,getN3,getHPP));
			retVal.append("<GuaranteedSurVal"+ i+">" + bussinessLogic.GuaranteedSurVal(i,sumSurvivalBenifit,sumGuaBen,annulizedprem1,numberAsPerOptionType,getN3)+"</GuaranteedSurVal"+i+">");
//			int Mpass= bussinessLogic.M(i);
//			int M=0;;
//			if(i<=smartAnnuityPlusBean.getDerferedPeriod()) {
//				 M= bussinessLogic.M(i);
//			}else {
//				M = bussinessLogic.M(i,Mpass);
//			}
		
			int M = bussinessLogic.M(i);
 			
			retVal.append("<SpecialSurVal"+ i+">" + cfap.getRound(bussinessLogic.getSpecialSurVal(i,deathbenifit,numberAsPerOptionType,getN3,getHPP,M))+"</SpecialSurVal"+i+">");
		}
//		System.out.println("SSV "+bussinessLogic.SSV(3));
		return retVal.toString();
	}

}
