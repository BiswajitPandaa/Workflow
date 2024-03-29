package com.sbilife.builderN;

public class calci {
	public static void main(String[] args) {
		
	
	
	Builder b = new Builder();
	String output = b.CalculatePrem("true", "29", "Female", "Regular", "Yearly", "12", "30", "12",
		"50000", "10", "0", "5", "5", "5", "5", "5", "5", "5", "false", "5", "5", "50", "5", "30/06/2020");
	System.out.println(output);
	}

}
