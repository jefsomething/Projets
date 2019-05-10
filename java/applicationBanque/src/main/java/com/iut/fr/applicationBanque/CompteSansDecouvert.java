package com.iut.fr.applicationBanque;

public class CompteSansDecouvert extends Compte {
		
	public void debiter(double montant) {
		if(solde-montant>=0 && montant>=0) {
			solde=solde-montant;
		}
	}
	

}
