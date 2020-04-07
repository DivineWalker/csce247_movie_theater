/**
 * @author Chen
 */
package csce247_moive_theater;
import java.util.ArrayList;
import java.util.Scanner;

public class TheaterManager {
	Scanner sc=new Scanner(System.in);
	private static TheaterManager theaterManager;
	TheaterManager() {}
	public static TheaterManager getInstance() {
		if(theaterManager==null) {
			System.out.println("Creating a theater manager.......");
			theaterManager=new TheaterManager();					
		}		
		return theaterManager;
	}
	ArrayList<Venue>venues=new ArrayList<Venue>();
	ArrayList<User>users=new ArrayList<User>();
	ArrayList<Event>events=new ArrayList<Event>();
	ArrayList<Showtime>showtimes=new ArrayList<Showtime>();
	ArrayList<String>reviews=new ArrayList<String>();
	public ArrayList<Venue>getVenues(){
		return venues;
	}
	
	public ArrayList<User>getUsers(){
		return users;
	}
	public void setEvents(ArrayList events){
		this.events=events;
		}
	public ArrayList<Event>getEvents(){
		return events;
	}
	public ArrayList<Showtime>getShowtimes(){
		return showtimes;
	}
	
	public void createEvent() {		
		System.out.println("Creating a new event");
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
		System.out.println("New event created\n");
	}	
	public void createVenue() {
		System.out.println("Creating a new venue");
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
		int numberOfAuditoriums=1;
		Venue newVenue=new Venue(name,address,type,adultTicketPrice,childTicketPrice,handicapTicketPrice,seatingMap,numberOfAuditoriums);
		venues.add(newVenue);
		System.out.println("New venue created\n");
	}	
	public void createShowtime() {
		/*System.out.println("Enter name of auditorium");
		String auditoriumNumber=sc.nextLine();*/
		String auditoriumNumber="";		
		System.out.println("Creating a new showtime");	
		for(int i=0;i<venues.size();i++) {
			System.out.println("Enter size of seats at this venue");
			int s=Integer.parseInt(sc.nextLine());
			String[][] availableSeats=new String[s][s];
			for(int j=0;j<events.size();i++) {
				System.out.println("Enter time of show\nat venue: "+venues.get(i).getName()+"\nfor event: "+events.get(j).getName());
				String timeOfShow=sc.nextLine();
				Showtime newShowtime=new Showtime(venues.get(i),events.get(j),availableSeats,timeOfShow,auditoriumNumber);	
				showtimes.add(newShowtime);
			}					
		}
		System.out.println("New showtime created\n");
	}
	public void createUser() {
		System.out.println("Creating a new user");
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
	}		
	public ArrayList<Showtime> titleSearch(String name){
		for(int i=0;i<showtimes.size();i++) {
			if(showtimes.get(i).getEvent().getName().equalsIgnoreCase(name))
				System.out.println(showtimes.get(i).toString());
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
			System.out.println("Wrong type");					
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
