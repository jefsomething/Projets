package com.iut.fr.applicationBanque;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	
	private Client c;
	public String ad  = "157 bvd Làbas, Caen";
	public String num = "3358856H";
	public String nom = "Azerty";

	//générer le constructeur permet de tester les setters de client
	@Before
	public void setUp() {
		c = new Client(num, nom, ad);
	}
	
	// test sur les getters de client:
	@Test
	public void getAdresse_ShouldBeIdentical() {
	    //assertThat(c.getAdresse(), containsString(ad));
	    assertTrue(ad == c.getAdresse());
	}
	
	@Test
	public void getNumeroClient_ShouldBeIdentical() {
	    assertTrue(num == c.getNumeroClient());
	}
	
	@Test
	public void getNom_ShouldBeIdentical() {
	    assertTrue(nom == c.getNom());
	}


}