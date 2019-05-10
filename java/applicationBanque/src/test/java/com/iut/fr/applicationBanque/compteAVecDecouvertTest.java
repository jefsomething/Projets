package com.iut.fr.applicationBanque;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iut.fr.applicationBanque.CompteAVecDecouvert;

public class compteAVecDecouvertTest {
	private CompteAVecDecouvert compte;

	@Before
	public void setUp() {
		this.compte=new CompteAVecDecouvert();
		compte.solde=20;
		compte.setDecouvertAutorise(5);
	}

	@Test
	public void debiterTest0(){
		this.compte.debiter(0);
		assertTrue(compte.solde ==20);
	}
	
	@Test
	public void debiterTestPInfDec(){
		this.compte.debiter(5);
		assertTrue(compte.solde ==15);
	}
	@Test
	public void debiterTestPSupDec(){
		this.compte.debiter(26);
		assertTrue(compte.solde == 20);
	}
	@Test
	public void debiterTestN(){
		this.compte.debiter(-5);
		assertTrue(compte.solde == 20);
	}
}
