package gen.algorithm;
import java.util.*;

/**
 * @author copyright Zachary Fitzpatrick, 2019.
 * Created under educational circumstances for an Intelligent Systems Undergraduate Course, a capstone for the Computer Science Program.
 * 
 * Place signifies a stop on our path and the characteristics that define it.
 * Except for manual Place creation, automatic (parameter-less constructor) randomly generates x and y positions from 1-500
 */
public class Place {
	
	//Declarations
	private double locx;
	private double locy;
	private String name;
	
	//Variables to aid randomness
	int max = 500;
	int min = 1;
	int distrange = max-min;
	Random n = new Random();
	
	//Getters
	public String getName() { return name; }
	public double getX() {return locx;}
	public double getY() {return locy;}
	
	/**
	 * Default constructor for a place that picks a random distance between 1 and 500 for x and y coords
	 */
	public Place() {
		locx = ((Math.random() * distrange) + min);
		locy = ((Math.random() * distrange) + min);
		//Places may have duplicate names, but it helped to check whether or not exact x and y duplicates were occurring during crossover testing
		name = "Place #" + n.nextInt(200);
	}
	
	/**
	 * Constructor for place distance and name manual assignment
	 * @param distx the x coordinate of the place
	 * @param disty the y coordinate of the place
	 * @param placeName the name of the place
	 */
	public Place(double distx, double disty, String placeName)
	{
		locx = distx;
		locy = disty;
		name = placeName;
	}

}
