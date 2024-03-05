package com.sbilife.builder;

public class BuilderCalci {

	public static void main(String[] args) {
		Builder obj = new Builder();
String res=obj.CalculatePrem("false", "35", "Female",
				  "Regular", "Yearly","12", "29", "12", "50000", "10", "0", "5", "5", "5", "5",
				  "5", "5", "5","false", "5", "5", "50","5","30/06/2020");
System.out.println(res);

	}

}
