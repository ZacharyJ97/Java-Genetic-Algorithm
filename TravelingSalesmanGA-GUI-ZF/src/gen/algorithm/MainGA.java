package gen.algorithm;

/**
 * The Main code executing the algorithm in order of its necessary operations. It controls the number of places in the map, generations of evolution, 
 * Population size, and the options available for evolution operations
 * 
 * @author copyright Zachary Fitzpatrick, 2019
 *Created under educational circumstances for an Intelligent Systems Undergraduate Course, a capstone for the Computer Science Program.
 */
public class MainGA {
	
	
	public static void main(String[] args) {
		
		int numPlaces = 100;
		for (int i=0; i < numPlaces; i++)
		{
			Place place = new Place();
			Path.GetMap().add(place);
		}
	    
	    int numGenerations = 500;
	    
	    Population initPop = new Population(100,null,true);
	    System.out.println("First Path Length: " + initPop.getTopFitPath().calcPathDistance());
	    
	    initPop = Algorithm.generateNewPop(initPop,true,false,false,true, true);
	    for (int gen = 0; gen < numGenerations; gen++)
	    {
	    	initPop = Algorithm.generateNewPop(initPop,true,false,false,true, true);
	    	
	    }
	    
        System.out.println("Final Path Length: " + initPop.getTopFitPath().calcPathDistance());
        System.out.println("Final Fitness Score: " + initPop.getTopFitPath().GetPathFitness());
        System.out.println("Final Path:");
        System.out.println(initPop.getTopFitPath().toString());
        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
	}

}
