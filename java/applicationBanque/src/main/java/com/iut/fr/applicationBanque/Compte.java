package com.iut.fr.applicationBanque;

abstract  class Compte {

	protected double solde;
	protected String numeroCompte;
	abstract void debiter(double montant);
	public void crediter (double montant) {
		if(montant>=0) {
			solde=solde+montant;
			
		}
	}
	
}

