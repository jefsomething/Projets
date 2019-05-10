package com.iut.fr.applicationBanque;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.iut.fr.applicationBanque.Banque;


public class BanqueTest{

	private Banque b;
	public static double euros = 999.;
	public static double dollars = 1121.89;
	

	@Before
	public void setUp() {
		b = new Banque();
	}
	
	// tests simples sur les conversions :
	@Test
	public void conversionFromEuro_shouldReturn80() {
		double expected = dollars;
		double actual = b.conversionFromEuro(euros);
		double delta = 0.01; 
			assertEquals(expected, actual, delta);
	}
	@Test
	public void conversionToEuro_shouldReturn120() {
		double expected = euros;
		double actual = b.conversionToEuro(dollars);
		double delta = 0.01; 
			assertEquals(expected, actual, delta);
	}
	
	

}
