package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.Produit;

public class CtlProduct {

	@FXML
	private Produit leProduit;
	
	// champs de saisie
	@FXML
	private TextField nom;
	
	@FXML
	private TextField tarif;

	@FXML
	private TextField stock;
	
	@FXML
	private TextField tva;
	
	// Champ d'affichage du modèle
	@FXML
	private Label produit;
	
	
	/**
	 * Méthode liée au bouton d'affichage du produit
	 */
	public void b_showProd() {
		
		String nom = this.nom.getText();
		double tarif = Double.parseDouble(this.tarif.getText());
		int stock = Integer.parseInt(this.stock.getText());
		double tva = Double.parseDouble(this.tva.getText());
		
		this.leProduit=new Produit(nom, tarif, stock, tva );
		
		produit.setText(leProduit.toString());
	}

}
