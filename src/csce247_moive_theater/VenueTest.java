/**
 * @author Divine
 */
package csce247_moive_theater;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class VenueTest {

	/**
	 * Test method for getAuditorium
	 */
	@Test
	void testGetAuditorium() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Auditorium ad = new Auditorium("3", new String[2][2]);
		assertEquals(vn.getAuditorium("2").getAuditoriumNumber(), ad.getAuditoriumNumber());
	}

	/**
	 * Test method for getName
	 */
	@Test
	void testGetName() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		assertEquals(vn.getName(), "USC Movie Theater");
	}
	
	/**
	 * Test method for getAddress
	 */
	@Test
	void testGetAddress() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		assertEquals(vn.getAddress(), "123 Main St.");
	}

	/**
	 * Test method for getType
	 */
	@Test
	void testGetType() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		assertEquals(vn.getType(), "Movie Theater");
	}

	/**
	 * Test method for getAdultTicketPrice
	 */
	@Test
	void testGetAdultTicketPrice() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		assertEquals(vn.getAdultTicketPrice(), 5);
	}

	/**
	 * Test method for getChildTicketPrice
	 */
	@Test
	void testGetChildTicketPrice() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		assertEquals(vn.getChildTicketPrice(), 3);
	}

	/**
	 * Test method for getHandicapTicketPrice
	 */
	@Test
	void testGetHandicapTicketPrice() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5.50, new String[2][2], 5);
		assertEquals(vn.getHandicapTicketPrice(), 5.50);
	}

	/**
	 * Test method for getAditoriumList
	 */
	@Test
	void testGetAuditoriumList() {
		String[][] sm = new String[2][2];
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, sm, 2);
		List<Auditorium> auditoriums = new ArrayList<>();
		for(int i = 0; i < 2; i++)
			auditoriums.add(new Auditorium(""+(i+1), sm));
		assertEquals(vn.getAuditoriumList().get(1).getAuditoriumNumber(), auditoriums.get(1).getAuditoriumNumber());
		
	}

}
