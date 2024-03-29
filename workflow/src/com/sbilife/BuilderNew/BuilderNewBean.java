package com.sbilife.BuilderNew;

public class BuilderNewBean {
	int age, policyTerm,ageOfProposer;
	private String genderOfLifeInsured,genderOfProposer,premiumPaymentMode,planType,proposalDate;
	private double basePremium;
	boolean stafDisc;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}
	public int getAgeOfProposer() {
		return ageOfProposer;
	}
	public void setAgeOfProposer(int ageOfProposer) {
		this.ageOfProposer = ageOfProposer;
	}
	public String getGenderOfLifeInsured() {
		return genderOfLifeInsured;
	}
	public void setGenderOfLifeInsured(String genderOfLifeInsured) {
		this.genderOfLifeInsured = genderOfLifeInsured;
	}
	public String getGenderOfProposer() {
		return genderOfProposer;
	}
	public void setGenderOfProposer(String genderOfProposer) {
		this.genderOfProposer = genderOfProposer;
	}
	public String getPremiumPaymentMode() {
		return premiumPaymentMode;
	}
	public void setPremiumPaymentMode(String premiumPaymentMode) {
		this.premiumPaymentMode = premiumPaymentMode;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(String proposalDate) {
		this.proposalDate = proposalDate;
	}
	public double getBasePremium() {
		return basePremium;
	}
	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}
	public boolean isStafDisc() {
		return stafDisc;
	}
	public void setStafDisc(boolean stafDisc) {
		this.stafDisc = stafDisc;
	}
	
	
	
	
	/*BuilderNewBean(int policyTerm,String planType,double basePremium )
	{
		this.policyTerm= policyTerm;
		this.planType = planType;
		this.basePremium=basePremium;
		
		
	}*/

}
