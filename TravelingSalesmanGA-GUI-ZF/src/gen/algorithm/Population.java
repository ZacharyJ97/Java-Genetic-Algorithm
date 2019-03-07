package gen.algorithm;

import java.util.*;

/**
 * @author copyright Zachary Fitzpatrick, 2019.
 * Created under educational circumstances for an Intelligent Systems Undergraduate Course, a capstone for the Computer Science Program at Thomas College.
 *
 * Population will manage our sets of paths as potential solutions
 */
public class Population {
	
	//Declarations
	private ArrayList<Path> popPaths;
	
	//Constructor
	public Population(int popSize, ArrayList<Place> places, boolean generate) {
		
		popPaths = new ArrayList<Path>(popSize);
		if (generate)
		{
			for (int index = 0; index < popSize; index++)
			{
				Path p = new Path();
				p.CreatePath();
				addPathToPop(p,index);
			}
		}
	}
	
	//Getters
	public ArrayList<Path> getPopulation() {return popPaths;}
	public int getPopSize() {return popPaths.size();}
	public Path getPathFromPop(int index) {return popPaths.get(index);}
	
    /**
     * Retrieves the path deemed to be most fit
     * @return Return the path determined to be most fit
     */
	public Path getTopFitPath() {
        Path fit = popPaths.get(0);
        //Go through our population and return the top fit path
        for (Path p : popPaths) 
        {
        	if (fit.GetPathFitness() <= p.GetPathFitness()) 
            {
                fit = p;
            }
        }
        return fit;
    }
    /**
     * Adds the path to the population at the specified index position
     * @param p Path to add to population
     * @param index Position within the population to add the path to
     */
    public void addPathToPop(Path p, int index)
    {
    	popPaths.add(index, p);
    }
    
    /**
     * Function meant to sort a population of paths by fittest paths near the front and least fit near the end
     */
    public void sortPopByFittest() {
    	int index2 = 1;
    	for (Path p : popPaths)
    	{
    		Path next = new Path();
			
			if (index2 < popPaths.size())
			{
				next = popPaths.get(index2);
				if (p.GetPathFitness() < next.GetPathFitness())
	    		{
	    			popPaths.set(index2, p);
	    			popPaths.set(index2-1, next);
	    		}
			}
			index2++;
    	}
    }
	
	
}
