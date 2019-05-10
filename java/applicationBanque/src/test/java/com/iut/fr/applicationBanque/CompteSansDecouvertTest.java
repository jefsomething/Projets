package com.iut.fr.applicationBanque;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iut.fr.applicationBanque.CompteSansDecouvert;

public class CompteSansDecouvertTest {
	private CompteSansDecouvert compte;
	
	
	@Before
	public void setUp() {
		this.compte=new CompteSansDecouvert();
		compte.solde=20;
		
	}
	@Test
	public void debiterTest0(){
		this.compte.debiter(0);
		assertTrue(compte.solde == 20);
	}
	@Test
	public void debiterTestPInfSolde(){
		this.compte.debiter(18);
		assertTrue(compte.solde == 2);
	}
	@Test
	public void debiterTestPSupSolde(){
		this.compte.debiter(22);
		assertTrue(compte.solde == 20);
	}
}
