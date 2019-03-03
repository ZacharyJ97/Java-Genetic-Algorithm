package gen.algorithm;

import java.util.*;

/**
 * @author copyright Zachary Fitzpatrick, 2019
 * Created under educational circumstances for an Intelligent Systems Undergraduate Course, a capstone for the Computer Science Program.
 *
 *Manages a path through all the places contained in a map.
 * Characterized by a beginning point, visiting all places once, and then
 * returning to the origin.
 */
public class Path {
	
	//Declarations
	
	//A map to hold all my places and subsequent getters
	private static ArrayList<Place> map = new ArrayList<Place>();
	public static Place GetPlaceFromMap(int i){ return map.get(i); }
	public static ArrayList<Place> GetMap() {return map;}
	//Add place into the Map
	public static void AddPlaceToMap(Place d){ map.add(d);}
	/**************************************************************/
	
	//Arraylist for a path through all the places
    private ArrayList<Place> travelPath = new ArrayList<Place>();
    
    private double fitnessScore;
    private double totalDistance;
    private double placeDistance;
    
    /**
     * 
     * Path is decidedly filled with nulls according to the map size that becomes useful in content checks later for crossover
     */
    public Path()
    {
    	for(Place place : map)
    	{
    		place=null;
    		travelPath.add(place);
    	}
    }
    
    //Getters for the travelPath and its Fitness
    public ArrayList<Place> GetTravelPath() {return travelPath;}
    public Place GetPlaceFromPath(int i) {return travelPath.get(i);}
    public double GetPathFitness() { calcFitness(); return fitnessScore;}
    public double PathSize() {return travelPath.size();}
    ///////////////////////////////////////////////
    
    /**
     * Adds a place to the path at a specific index (position)
     * @param index The spot to put the place at
     * @param p The passed in Place to be put in the path
     */
    public void addPlaceToPath(int index, Place p) { travelPath.set(index, p); }
    
    @Override
    /**
     * Outputs a string detailing all the places in the path with their name, x coord, and y coord
     */
    public String toString()
    {
    	String path = "(";
    	for (Place p : travelPath)
    	{
    		path += p.getName() + " at X: " + p.getX() + " and Y: " + p.getY() + ") (";
    	}
    	return path;
    }
    
    /**
     * Sums up the distances between each consecutive city in a path and returns the total distance
     * @return The distance as a double
     */
    public double calcPathDistance()
    {
    	if (totalDistance == 0) 
    	{
    		double pathDistance = 0;
            //Roll through all places in path
            for (int i = 0; i < PathSize(); i++) 
            {
                //Origin
                Place origin = GetPlaceFromPath(i);
                //Immediate following Place
                Place next;
                
                //Check for the possible end of the path, else we will be returning to beginning point of whole path
                if( i+1 < PathSize() )
                {
                    next = GetPlaceFromPath(i+1);
                }
                else
                {
                    next = GetPlaceFromPath(0);
                }
                // Get the distance between the two cities
                pathDistance = pathDistance + MeasurePlaceDistance(origin, next);
            }
            totalDistance = pathDistance;
        }
        return totalDistance;
    }
    
    //Fitness scoring such as this was detailed in the pdf at this location: https://pdfs.semanticscholar.org/c31b/fd16935da83e419d631245272d7838262308.pdf
    
    /**
     * Calculates fitnessScore by associating larger fitnessScore values with shorter distances
     * 
     */
    public void calcFitness()
    {
    	//Multiplying by ten thousand to just make it more readable upon output
    	fitnessScore = ((1/calcPathDistance())*10000);
    }
    
    /**
     * Returns boolean if the path currently has the place passed in as a parameter
     * To be handy later for crossover functionalities
     * @param p Place to check whether or not is is present
     * @return Boolean indicating if the place is already present in the path
     */
    public boolean HasDuplicatePlace(Place p)
    {
    	return travelPath.contains(p);
    }
    
    /**
     * Rolls through the map of places and adds them all to the path
     */
    public void CreatePath() {
    	int index = 0;
       // Loop through all our places in the map and add them to the current path
       for (Place p : map) {
         addPlaceToPath(index, p);
         index++;
       }
    }
    
    //Distance formula can be found here: https://www.khanacademy.org/math/basic-geo/basic-geometry-pythagorean-theorem/pythagorean-theorem-distance/a/distance-formula
    /**
     * Measures distance from place to place
     * @param p1 Place 1 for distance measurement
     * @param p2 Place 2 for distance measurement
     * @return Return a double that is the distance between the two input places
     */
    public double MeasurePlaceDistance(Place p1, Place p2)
    {
    	double x = Math.abs(p2.getX() - p1.getX());
		double y = Math.abs(p2.getY() - p1.getY());
		placeDistance = Math.sqrt((x*x) + (y*y));
		return placeDistance;
    }

}
