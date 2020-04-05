package csce247_moive_theater;
import java.util.ArrayList;
/**
 * 
 * @author brandon
 *	Base Event type, will be extended by different event types: Movie, Play, and Concert
 */
public abstract class Event {
	protected String name;
	protected ArrayList<String> reviews;
	protected int runTime;
	protected String stars;
	protected String genre;
	protected String description;
	
	public Event(String name) {
		this.name = name;
		
		reviews = new ArrayList<>();
	}
}
