/**
 * @author Divine
 */
package csce247_moive_theater;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author divinew
 *
 */
class ShowtimeTest {

	/**
	 * Test method for getVenue
	 */
	@Test
	void testGetVenue() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getVenue(), vn);
	}

	/**
	 * Test method for getEvent
	 */
	@Test
	void testGetEvent() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getEvent(), ev);
	}

	/**
	 * Test method for getAvailableSeats
	 */
	@Test
	void testGetAvailableSeats() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getAvailableSeats(), vn.getAuditorium("2").getSeatingMap());

	}

	/**
	 * Test method for getTimeOfShow
	 */
	@Test
	void testGetTimeOfShow() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getTimeOfShow(), "12:00");
	}

	/**
	 * Test method for getAuditoriumNumber
	 */
	@Test
	void testGetAuditoriumNumber() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getAuditoriumNumber(), "2");
	}

	/**
	 * Test method for TakeSeat
	 */
	@Test
	void testTakeSeat() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		sh.takeSeat(0, 0);
		assertEquals(sh.getAvailableSeats()[0][0], " ");
	}

	/**
	 * Test method for toString
	 */
	@Test
	void testToString() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.toString(),
				"Venue: USC Movie Theater\nEvent: Frozen\nTime of Show: 12:00\nAuditorium Number: 2");
	}

}
