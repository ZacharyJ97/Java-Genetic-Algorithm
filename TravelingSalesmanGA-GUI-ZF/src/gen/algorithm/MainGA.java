package gen.algorithm;

/*Main executing class*/
public class MainGA {
	
	
	public static void main(String[] args) {
		
		int numPlaces = 100;
		for (int i=0; i < numPlaces; i++)
		{
			Place place = new Place();
			Path.GetMap().add(place);
		}
	    
	    int numGenerations = 1000;
	    
	    Population initPop = new Population(100,null,true);
	    System.out.println("First Path Length: " + initPop.getTopFitPath().calcPathDistance());
	    
	    initPop = Algorithm.generateNewPop(initPop,true,false,false,true);
	    for (int gen = 0; gen < numGenerations; gen++)
	    {
	    	initPop = Algorithm.generateNewPop(initPop,true,false,false,true);
	    	
	    }
	    
        System.out.println("Final Path Length: " + initPop.getTopFitPath().calcPathDistance());
        System.out.println("Final Fitness Score: " + initPop.getTopFitPath().GetPathFitness());
        System.out.println("Final Path:");
        System.out.println(initPop.getTopFitPath().toString());
        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
	}

}
