package gen.algorithm;

import java.util.*;

/*Population will manage our sets of paths as potential solutions*/
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
	
	// Retrieves the path deemed to be the most fit
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
    
    public void addPathToPop(Path p, int index)
    {
    	popPaths.add(index, p);
    }
    
    public void sortPathsByFittest() {
    	int index = 1;
    	for (Path p : popPaths)
    	{
    		if (p.GetPathFitness() < popPaths.get(index).GetPathFitness())
    		{
    			popPaths.set(index-1, popPaths.get(index));
    			popPaths.set(index, p);
    		}
    		if (index < popPaths.size())
    		{
    			index++;
    		}
    	}
    }
	
	
}
