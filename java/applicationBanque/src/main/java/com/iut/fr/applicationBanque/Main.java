package com.iut.fr.applicationBanque;

public class Main {
	
	public static String ad  = "157 bvd Làbas, Caen";
	public static String num = "3358856H";
	public static String nom = "Azerty";
	
	public static double euros = 999.;
	public static double dollars = 889.46;

	
	
	

	public static void main(String[] args) {
		
		Banque b = new Banque();
		System.out.println("conv. :"+euros+" euros = "+b.conversionFromEuro(euros) +" dollars");
		System.out.println("conv. :"+dollars+" dollars = "+ b.conversionToEuro(dollars)+" euros");

		Client c = new Client(num, nom, ad);
		System.out.println(ad == c.getAdresse());
		System.out.println(nom == c.getNom());
		System.out.println(num == c.getNumeroClient());

	}

}
