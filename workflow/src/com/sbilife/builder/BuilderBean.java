package com.sbilife.builder;

public class BuilderBean {

	
	int Age,policyTerm,
			permPayTerm,
			Ageofproposer,
			pf;
	
	
	String Genderoflifensured,
		Genderofproposer,
		plan,
		PremPayingMode,
		proposalDate;
	
	
	double sumAssured,
		Baseprem,
		equityFund,
		equityOptimiserFund;
	
	boolean stafDisc;

	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}

	public int getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}

	public int getPermPayTerm() {
		return permPayTerm;
	}
	public void setPermPayTerm(int permPayTerm) {
		this.permPayTerm = permPayTerm;
	}

	public int getAgeofproposer() {
		return Ageofproposer;
	}
	public void setAgeofproposer(int ageofproposer) {
		Ageofproposer = ageofproposer;
	}

	public String getGenderoflifensured() {
		return Genderoflifensured;
	}
	public void setGenderoflifensured(String genderoflifensured) {
		Genderoflifensured = genderoflifensured;
	}
	
	public String getGenderofproposer() {
		return Genderofproposer;
	}
	public void setGenderofproposer(String genderofproposer) {
		Genderofproposer = genderofproposer;
	}

	public String getPremPayingMode() {
		return PremPayingMode;
	}
	public void setPremPayingMode(String premPayingMode) {
		PremPayingMode = premPayingMode;
	}
	
	public int getPf() {
		return pf;
	}
	public Double getBaseprem() {
		return Baseprem;
	}
	public void setBaseprem(Double baseprem) {
		Baseprem = baseprem;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}

	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public boolean isStafDisc() {
		return stafDisc;
	}
	public void setStafDisc(boolean stafDisc) {
		this.stafDisc = stafDisc;
	}
	public String getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(String proposalDate) {
		this.proposalDate = proposalDate;
	}

}
