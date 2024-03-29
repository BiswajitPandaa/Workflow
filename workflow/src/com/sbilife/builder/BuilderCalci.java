  package com.sbilife.builder;

public class BuilderCalci {

	public static void main(String[] args) {
		Builder obj = new Builder();
String res=obj.CalculatePrem("29", "male", "Regular", "50000", "12", "yearly", "true", "31/06/2017");
System.out.println(res);

	}

}
