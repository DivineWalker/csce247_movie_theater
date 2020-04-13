/**
 * 
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
	 * Test method for {@link csce247_moive_theater.Showtime#getVenue()}.
	 */
	@Test
	void testGetVenue() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#getEvent()}.
	 */
	@Test
	void testGetEvent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#getAvailableSeats()}.
	 */
	@Test
	void testGetAvailableSeats() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getAvailableSeats(),"IDK");
		
		
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#getTimeOfShow()}.
	 */
	@Test
	void testGetTimeOfShow() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getTimeOfShow(), "12:00");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#getAuditoriumNumber()}.
	 */
	@Test
	void testGetAuditoriumNumber() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.getAuditoriumNumber(), "2");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#showAvailableSeats()}.
	 */
	@Test
	void testShowAvailableSeats() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#takeSeat(int, int)}.
	 */
	@Test
	void testTakeSeat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csce247_moive_theater.Showtime#toString()}.
	 */
	@Test
	void testToString() {
		Venue vn = new Venue("USC Movie Theater", "123 Main St.", "Movie Theater", 5, 3, 5, new String[2][2], 5);
		Event ev = new Event("Frozen", 105, "5", "comedy", "Frozen movie", "Movie", "5");
		Showtime sh = new Showtime(vn, ev, "2", "12:00");
		assertEquals(sh.toString(),"Venue: USC Movie Theater\nEvent: Frozen\nTime of Show: 12:00\nAuditorium Number: 2");
	}

}
