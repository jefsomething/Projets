package com.iut.fr.applicationBanque;


public class Client {
	
	private String numeroClient;
	private String adresse;
	private String nom;

	public Client(String numeroClient, String nom, String adresse) {
		this.setNumeroClient(numeroClient);
		this.setAdresse(adresse);
		this.setNom(nom);
	}

	public String getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

