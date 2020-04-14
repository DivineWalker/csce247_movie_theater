package csce247_moive_theater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EventTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
	}

	@Test
	void testGetName() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getName = "Name";
		assertEquals(getName, test.getName());
	}
	
	@Test
	void testGetRunTime() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		int getRun = 100;
		assertEquals(getRun, test.getRunTime());
	}
	
	@Test
	void testGetStars() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getStarsTest = "Stars";
		assertEquals(getStarsTest, test.getStars());
	}
	
	@Test
	void testGetGenre() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getGenreTest = "Genre";
		assertEquals(getGenreTest, test.getGenre());
	}
	
	@Test
	void testGetDesc() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getDesc = "Description";
		assertEquals(getDesc, test.getDescription());
	}
	
	@Test
	void testGetType() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getTy = "Type";
		assertEquals(getTy, test.getType());
	}
	
	@Test
	void testGetRating() {
		Event test = new Event("Name", 100,"Stars","Genre","Description","Type","Rating" );
		String getRate= "Rating";
		assertEquals(getRate, test.getRating());
	}

}
