package maths;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/* test des methodes plus(n1, n2) | minus(n1, n2) | times(n1, n2) | divBy(n1, n2)
 * définies dans la classe MesMaths.java
 */
public class TestMesMaths{

	private MesMaths maths;
	
	//mes variables d'entrées qui doivent être positifs; les modifs pour obtenir des nb négatifs sont prévues dans les methodes:
	int a = 3;
	int b = 4;
	
	//résultats attendus: exemple 'pp' vaut (positive)3 + (positive)4 = 7

	//solution1, on ne fait pas confiance à ce qui se trouve entre la chaise et le clavier
	final  int pp = a+b;
	final int pn = a+(-1*b);
	final int np = (-1*a)+b;
	final int nn = (-1*a)+(-1*b);
	
	/*
	//solution2, on est optimiste.
	int pp = 7;
	int pn = -1;
	int np = 1;
	int nn = -7;
	*/
	
	public boolean checkInputs(int a, int b) {
		boolean res = true;
		if (a <=0 || b<=0) { res = false; }
		return res;
	}
	
	@Before
	public void setup() {
		this.maths = new MesMaths();
	}
	
	@Test
	public void testPositivePlusPositiveNb() {
		if (checkInputs(a,b) == true) { assertEquals(pp,maths.plus(a, b));}
		else { System.out.println("[debug pos+pos] erreur sur les valeurs à tester");}
	}
	
	@Test
	public void testPositivePlusNegativeNb() {
		if (checkInputs(a,b) == true) { assertEquals(pn,maths.plus(a, -1*b)); }
		else { System.out.println("[debug pos+neg] erreur sur les valeurs à tester");}
	}
	
	@Test
	public void testNegativePlusPositiveNb() {
		if (checkInputs(a,b) == true) { assertEquals(np,maths.plus(-1*a, b)); }
		else { System.out.println("[debug neg+pos] erreur sur les valeurs à tester");}
	}
	
	@Test
	public void testNegativePlusNegativeNb() {
		if (checkInputs(a,b) == true) { assertEquals(nn,maths.plus(-1*a, -1*b)); }
		else { System.out.println("[debug neg+neg] erreur sur les valeurs à tester");}
	}
	
}
