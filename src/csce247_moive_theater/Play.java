package csce247_moive_theater;
/**
 * 
 * @author brandon
 *	Extension of Event to create a Movie listing
 */


public class Play extends Event {
	
	/**
	 * Create a new play listing
	 * @param name - name of event
	 * @param runTime - run time of event
	 * @param stars - actor/performing staring the event
	 * @param genre - genre of the event
	 * @param description -  short description of the event
	 */
	public Play(String name, int runTime, String stars, String genre, String description) {
		super(name, runTime, stars, genre, description);
	}
}
