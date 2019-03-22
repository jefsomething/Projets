package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.Tva;

public class CtlTax {
	
	private Tva tva;
		
	// champs de saisie
	@FXML
	private TextField txtLibelle;
	
	@FXML
	private TextField txtTaux;
	
	// Champ d'affichage du modèle
	@FXML
	private Label labelModele;
	
	
	/**
	 * Méthode liée au bouton d'affichage du modèle
	 */
	public void afficherTVA() {
		
		String lib = this.txtLibelle.getText();
		double taux = Double.parseDouble(this.txtTaux.getText());
		
		this.tva=new Tva(taux, lib);
		
		labelModele.setText(this.tva.toString());
	}


}
