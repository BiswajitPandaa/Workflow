package com.sbilife.builderN;

public class BuilderProperties {

	public boolean AllocationCharges = true, Mortality_and_Rider_Charges = true, riderCharges = true,
			admistration_charge = true, fund_management_charge = true, surrender_charge = true;

	double ServiceTax=0.18,
		Mortality_Charge=1.2,
		int1 = 0.04,
		int2 = 0.08,
		weightedFMC = 0.0125,
		guaranteedCharge = 0.0;
	
	
		
	
		
	String FVSA="higher(FV,SA)";
	
	double Increasing_Cover_Option=0;
	
	boolean mor_charge=true;
	
	String SMAF_at_the_discretion_of_Policyholder = "No",
			database_BM4 = "higher(FV,SA)",
			kfcDate = "31/07/2021";
	
	final double Min_regular_PPT = 10;
	final double Max_regular_PPT = 10;
	
	
	final double Min_single_PPT = 1.25;
	final double Max_single_PPT = 1.25;
	
	
	final double Min_LPPT_PPT = 10;
	final double Max_LPPT_PPT = 10;
	
	


}
