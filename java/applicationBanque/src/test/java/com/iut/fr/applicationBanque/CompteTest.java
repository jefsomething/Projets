package com.iut.fr.applicationBanque;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iut.fr.applicationBanque.CompteAVecDecouvert;

import static org.junit.Assert.assertEquals;
public class CompteTest {
	private CompteAVecDecouvert compte;
	
	
	@Before
	public void setUp() {
		this.compte=new CompteAVecDecouvert();
		compte.solde=20;
		
	}



	
	@Test
	public void crediterTest0(){
		this.compte.crediter(0);
		assertTrue(compte.solde ==20 );
	}
	
	
	@Test
	public void crediterTestP(){
		this.compte.crediter(5);
		assertTrue(compte.solde ==25 );
	}
	

	@Test
	public void crediterTestN(){
		this.compte.crediter(-5);
		assertTrue(compte.solde ==20 );
	}
}
