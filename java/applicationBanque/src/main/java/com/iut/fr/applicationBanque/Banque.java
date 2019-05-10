package com.iut.fr.applicationBanque;

import java.util.ArrayList;

public class Banque {

	private float montant;
	private String nom_client;
	private String num_compte;
	
//	pas demandé dans l'énoncé
//	ArrayList<Client> clients = new ArrayList();
//	ArrayList<Compte> comptes = new ArrayList();
		
	public Banque(){
	}
	
	public void retrait(String num_compte, String nom_client, float montant) {
	}
	
	public void depot(String num_compte, String nom_client, float montant) {
	}
	
	public void ouverture_compte(String nom_client) {
	}
	
	public void consultation(String num_compte) {
	}
	
	public double conversionFromEuro(double montant) {
		// changement euro -> dollar
		montant /= .89046;
		return montant;
	}
	
	public double conversionToEuro(double montant) {
		// changement dollar -> euro
		montant *= .89046;
		return montant;
	}
	

}
