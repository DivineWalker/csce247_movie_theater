/**
 * @author Divine
 */
package csce247_moive_theater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuditoriumTest {

	/**
	 * Test method for getAuditoriumNumber
	 */
	@Test
	void testGetAuditoriumNumber() {
		Auditorium aud = new Auditorium("1", new String[5][5]);
		assertEquals(aud.getAuditoriumNumber(), "1");
	}

	/**
	 * Test method for getSeatingMap
	 */
	@Test
	void testGetSeatingMap() {
		String[][] sm = new String[2][2];
		Auditorium aud = new Auditorium("1", sm);
		assertEquals(aud.getSeatingMap(), sm);
	}

}
