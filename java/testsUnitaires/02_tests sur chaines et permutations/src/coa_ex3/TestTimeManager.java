package coa_ex3;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestTimeManager {

//	private static final String NOT_POSSIBLE = null;
	private static final String NOT_POSSIBLE = "NOT_POSSIBLE";
	private TimeManager manager;

	@Before
	public void setUp() {
		manager = new TimeManager();
	}
	
	@Test
	public void testNull_shouldReturnNOT_POSSIBLE() {
		assertEquals(NOT_POSSIBLE, TimeManager.getFirstTimeAvailable(null));
	}

	@Test
	public void testEmpty_shouldReturnNOT_POSSIBLE() {
		assertEquals(NOT_POSSIBLE, TimeManager.getFirstTimeAvailable(""));
	}

	@Test
	public void test123456_shouldReturn12h34m56() {
		assertEquals("12h34m56s", TimeManager.getFirstTimeAvailable("123456"));
	}

	@Test
	public void test132845_shouldReturn12h34m58() {
		assertEquals("12h34m58s", TimeManager.getFirstTimeAvailable("132845"));
	}

	@Test
	public void test438129_shouldReturn12h38m49s() {
//		assertEquals("12h48m39s", manager.getFirstTimeAvailable("438129"));
		assertEquals("12h38m49s", TimeManager.getFirstTimeAvailable("438129"));
	}

	@Test
	public void test709324_shouldReturn02h37m49s() {
//		assertEquals("23h47m09s", manager.getFirstTimeAvailable("709324"));
		assertEquals("02h37m49s", TimeManager.getFirstTimeAvailable("709324"));
	}

	@Test
	public void test183679_shouldReturnNOT_POSSIBLE() {
		assertEquals(NOT_POSSIBLE, TimeManager.getFirstTimeAvailable("183679"));
	}
}
