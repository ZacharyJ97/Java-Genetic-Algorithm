package gen.algorithm;
import java.util.*;

/*Signifies a stop on our path and the characteristics that define it.
 * Will contain the formula to calculate distance between stops and basic
 * getter functions.
 *  */
public class Place {
	
	//Declarations
	private double locx;
	private double locy;
	private String name;
	
	//Variables to aid randomness
	int max = 500;
	int min = 5;
	int distrange = max-min;
	Random n = new Random();
	
	//Getters
	public String getName() { return name; }
	public double getX() {return locx;}
	public double getY() {return locy;}
	
	//Constructor for random place distances between 5 and just about 500
	public Place() {
		locx = ((Math.random() * distrange) + min);
		locy = ((Math.random() * distrange) + min);
		name = "Place #" + n.nextInt(200);
	}
	
	//Constructor for place distance and name manual assignment
	public Place(double distx, double disty, String placeName)
	{
		locx = distx;
		locy = disty;
		name = placeName;
	}

}
