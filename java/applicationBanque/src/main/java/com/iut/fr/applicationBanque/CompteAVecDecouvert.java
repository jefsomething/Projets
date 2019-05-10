package com.iut.fr.applicationBanque;

public class CompteAVecDecouvert extends Compte{
	
	private double decouvertAutorise;
	public void debiter(double montant) {
		if(solde-montant>-decouvertAutorise && montant>=0) {
		solde=solde-montant;
		}
		
	}
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}
	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}	
	
	

}
