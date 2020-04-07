/**
 * @author Chen
 */
package csce247_moive_theater;
import java.util.ArrayList;
import java.util.Scanner;

public class TheaterManager {
	Scanner sc=new Scanner(System.in);
	private static TheaterManager theaterManager;
	private TheaterManager() {}
	public static TheaterManager getInstance() {
		if(theaterManager==null) {
			System.out.println("Creating a theater manager");
			theaterManager=new TheaterManager();					
		}		
		return theaterManager;
	}
	private ArrayList<Venue>venues;
	private ArrayList<User>users;
	private ArrayList<Event>events;
	private ArrayList<Showtime>showtimes;
	private ArrayList<String>reviews; 
	public Event createEvent() {			
		System.out.println("Enter name of event");
		String name=sc.nextLine();
		System.out.println("Enter run time of event");
		int runTime=Integer.parseInt(sc.nextLine());;
		System.out.println("Enter actors/performers");
		String stars=sc.nextLine();
		System.out.println("Enter genre of event");
		String genre=sc.nextLine();
		System.out.println("Enter description of event");
		String description=sc.nextLine();	
		System.out.println("Enter type of event: movie/play/concert");
		String type=sc.nextLine();
		if(!type.equalsIgnoreCase("movie")&&!type.equalsIgnoreCase("play")&&!type.equalsIgnoreCase("concert"))				
			System.out.println("Wrong type");
		String rating="rating";
		Event newEvent=new Event(name,runTime,stars,genre,description,type,rating);
		events.add(newEvent);
		return newEvent;
	}	
	public Venue createVenue() {
		System.out.println("Enter name of venue");
		String name=sc.nextLine();
		System.out.println("Enter address of venue");
		String address=sc.nextLine();
		System.out.println("Enter type of venue");
		String type=sc.nextLine();
		System.out.println("Enter price of adult ticket");
		double adultTicketPrice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter price of child ticket");
		double childTicketPrice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter price of handicap ticket");
		double handicapTicketPrice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter size of auditoriums");
		int i=Integer.parseInt(sc.nextLine());		
		String[][] seatingMap=new String[i][i];
		System.out.println("Enter number of auditoriums");
		int numberOfAuditoriums=Integer.parseInt(sc.nextLine());
		System.out.println("Enter name of auditorium");
		sc.nextLine();
		Venue newVenue=new Venue(name,address,type,adultTicketPrice,childTicketPrice,handicapTicketPrice,seatingMap,numberOfAuditoriums);
		venues.add(newVenue);
		return newVenue;
	}	
	public User createUser() {
		System.out.println("Enter your first name");
		String firstName=sc.nextLine();
		System.out.println("Enter your last name");
		String lastName=sc.nextLine();
		System.out.println("Enter your email");
		String email=sc.nextLine();
		System.out.println("Enter your phone number");
		String phoneNumber=sc.nextLine();		
		User newUser=new User(firstName,lastName,email,phoneNumber) ;
		users.add(newUser);
		return newUser;
	}	
	public Showtime createShowtime(Venue venue,Event event) {
		System.out.println("Choose event:");
		for(Event e:events) 
			System.out.println(e.getName());
		String i1=sc.nextLine();
		for(int i=0;i<events.size();i++) {
			if(events.get(i).getName().equalsIgnoreCase(i1))			
				event=events.get(i);
			else 
				System.out.println("Event DNE");
		}
		System.out.println("Choose venue:");
		for(Venue v:venues)
			System.out.println(v.getName());
		String i2=sc.nextLine();
		for(int i=0;i<venues.size();i++) {
			if(venues.get(i).getName().equalsIgnoreCase(i2))
				venue=venues.get(i);
			else
				System.out.println("Venue DNE");
		}		
		System.out.println("Enter name of auditorium");
		String auditoriumNumber=sc.nextLine();
		Showtime newShowtime=new Showtime(venue,event,auditoriumNumber);
		return newShowtime;
	}
	public ArrayList<Showtime> titleSearch(String name){
		for(int i=0;i<showtimes.size();i++) {
			if(showtimes.get(i).getEvent().getName().equalsIgnoreCase(name))
				System.out.println(showtimes.get(i));
			else System.out.println("Event DNE");
		}
		return showtimes;
	}	
	public ArrayList<Showtime> categorySearch(){
		System.out.println("Enter Movie or Play or Concert");
		String c=sc.nextLine();
		if(c.equalsIgnoreCase("movie"))	{
			for(int i=0;i<showtimes.size();i++) {
				if(showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
					System.out.println(showtimes.get(i));					
			}				
		}
		else if(c.equalsIgnoreCase("play")) {
			for(int i=0;i<showtimes.size();i++) {
				if(showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
					System.out.println(showtimes.get(i));					
			}				
		}
		else if(c.equalsIgnoreCase("concert")) {
			for(int i=0;i<showtimes.size();i++) {
				if(showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
					System.out.println(showtimes.get(i));					
			}				
		}
		else 
			System.out.println("Type DNE");					
		return showtimes;
	}	
	public void addReview(String review,String eventName) {
		System.out.println("Enter name of event you want to review:");
		String n=sc.nextLine();
		for(int i=0;i<events.size();i++) {
			if(events.get(i).getName().equalsIgnoreCase(n)) {			
				System.out.println("Enter your review:");			
				String r=sc.nextLine();
				events.get(i).getReviews().add(r);
				System.out.println("Review submitted");
			}
			else 
				System.out.println("Event DNE");
		}				
	}
	public ArrayList<String> displayReviews() {
		System.out.println("Enter name of event you want to check reviews");
		String n=sc.nextLine();
		for(int i=0;i<events.size();i++) {
			if(events.get(i).getName().equalsIgnoreCase(n)) {
				for(String r:events.get(i).getReviews())
					System.out.println(r);
			}
			else 
				System.out.println("Event DNE");			
		}
		return reviews;
	}
	public void removeShowtime(String venueName,String eventName) {
		for(int i=0;i<showtimes.size();i++) {
			if(showtimes.get(i).getVenue().getName().equalsIgnoreCase(venueName)) {
				if(showtimes.get(i).getEvent().getName().equalsIgnoreCase(eventName)) {
					showtimes.remove(i);
					System.out.println("Showtime removed");
				}
				else
					System.out.println("Showtime DNE");				
			}
			else 
				System.out.println("Such showtime DNE");			
		}
	}
	public void removeVenue(String venueName) {
		for(int i=0;i<venues.size();i++) {
			if(venues.get(i).getName().equalsIgnoreCase(venueName)) {
				venues.remove(i);
				System.out.println("Venue removed");					
			}
			else
				System.out.println("Such venue DNE");
		}
		for(int i=0;i<showtimes.size();i++) {
			if(showtimes.get(i).getVenue().getName().equalsIgnoreCase(venueName)) {
				showtimes.remove(i);
				System.out.println("Related showtimes removed");
			}
		}
	}
	public void removeEvent(String eventName) {
		for(int i=0;i<events.size();i++) {
			if(events.get(i).getName().equalsIgnoreCase(eventName)) {
				events.remove(i);
				System.out.println("Event removed");				
			}
			else
				System.out.println("Such event DNE");
		}
		for(int i=0;i<showtimes.size();i++) {
			if(showtimes.get(i).getEvent().getName().equalsIgnoreCase(eventName)) {
				showtimes.remove(i);
				System.out.println("Related showtimes removed");
			}
		}
	}
	public void removeReview(String review,String eventName) {
		for(int i=0;i<events.size();i++) {
			if(events.get(i).getName().equalsIgnoreCase(eventName)) {
				for(int j=0;j<events.get(i).getReviews().size();j++) {
					if(events.get(i).getReviews().get(j).equals(review)) {					
						events.get(i).getReviews().remove(j);					
						System.out.println("Review removed");
					}
					else
						System.out.println("Such review DNE");
				}
			}
			else
				System.out.println("Such event DNE");
		}
	}
}
