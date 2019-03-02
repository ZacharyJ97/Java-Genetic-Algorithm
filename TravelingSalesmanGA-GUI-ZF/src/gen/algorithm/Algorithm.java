package gen.algorithm;
import java.util.*;

/*Handles performing the operations of a genetic algorithm, such as selection, crossover,
 * mutation, etc
 */
public class Algorithm {
	private static boolean tournamentStyle = false;
	private static boolean elitism = false;
	private static boolean rouletteStyle = false;
	
	private static boolean randCrossover = false;
	private static boolean halfCrossover = false;
	
	public static int popSize = 100;
	private static double m_rate = .2;
	private static int tournPool = (popSize / 2);
	
	//This version of crossover first takes a subset from p1 and inserts it into an empty child
	//It then fills in the empty spaces of the child with the places from parent 2 ignoring any duplicates
	//Crossover methods like this can be found here https://www.tutorialspoint.com/genetic_algorithms/genetic_algorithms_crossover.htm
	public static Path crossover(Path p1, Path p2, boolean rCross, boolean hCross)
	{
		Path resultChild = new Path();
		
		//Random subset of the path is chosen for crossover
		if (rCross == true && hCross == false)
		{
			//Parent 1's random subset of places to cross
			Random br = new Random();
			Random er = new Random();
			int begin = br.nextInt((int)p1.PathSize());
			int end = er.nextInt((int)p1.PathSize());
			while (begin > end)
			{
				end = er.nextInt((int)p1.PathSize());
			}
			
			//Take the subset from p1 and insert it into the child
			for (int index = 0; index < resultChild.PathSize(); index++)
			{
				//Take the subset range
				if(index >= begin && index <= end)
				{
					resultChild.addPlaceToPath(index, p1.GetPlaceFromPath(index));
				}
			}
			
			//Take the other cities from p2 and insert into child
			for (int index2 = 0; index2 < p2.PathSize(); index2++)
			{
				//Check to make sure the child does not already have the city
				if(!resultChild.HasDuplicatePlace(p2.GetPlaceFromPath(index2)))
				{
					//Roll through the child's positions
					for (int ichild = 0; ichild < resultChild.PathSize(); ichild++)
					{
						//if position is null we will add p2's path (avoids overwriting the subset already inserted)
						if(resultChild.GetPlaceFromPath(ichild)==null)
						{
							resultChild.addPlaceToPath(ichild, p2.GetPlaceFromPath(index2));
							break;
						}
					}
				}
			}
			//System.out.println("Used Random Crossover");
		}
		
		//Half the entire path crossover
		if (rCross == false && hCross == true)
		{
			//Taking Half of parent 1
			int end = (int)(p1.PathSize()/2);
			
			//Take the subset from p1 and insert it into the child
			for (int index = 0; index <= end; index++)
			{

				resultChild.addPlaceToPath(index, p1.GetPlaceFromPath(index));

			}
			
			//Take the other cities from p2 and insert into child
			for (int index2 = 0; index2 < p2.PathSize(); index2++)
			{
				//Check to make sure the child does not already have the city
				if(!resultChild.HasDuplicatePlace(p2.GetPlaceFromPath(index2)))
				{
					//Roll through the child's positions
					for (int ichild = 0; ichild < resultChild.PathSize(); ichild++)
					{
						//if position is null we will add p2's path (avoids overwriting the subset already inserted)
						if(resultChild.GetPlaceFromPath(ichild)==null)
						{
							resultChild.addPlaceToPath(ichild, p2.GetPlaceFromPath(index2));
							break;
						}
					}
				}
			}
			//System.out.println("Used Half Path Crossover");
		}
		
		return resultChild;
	}
		
		
		
		
	
	//Mutation function based on swap mutation and scramble subset mutation as detailed in: https://www.geeksforgeeks.org/mutation-algorithms-for-string-manipulation-ga/
	private static void mutation(double rate, Path p, boolean swap)
	{
		m_rate = rate;
		double rand = Math.random();
		//Random Swap mutation checking at each Place in the path
		for(int i = 0; i < p.PathSize(); i++)
		{
			if(rand < m_rate)
			{
				if (swap == true)
				{
					Place n1 = p.GetPlaceFromPath(i);
					int rand2 = new Random().nextInt((int)p.PathSize());
					Place n2 = p.GetPlaceFromPath(rand2);
					
					p.addPlaceToPath(rand2, n1);
					p.addPlaceToPath(i, n2);
				}
				//If not swap, scramble a random subset of Path p
				else
				{
					ArrayList<Place> p2 = new ArrayList<Place>();
					
					Random br = new Random();
					Random er = new Random();
					int begin = br.nextInt((int)p.PathSize());
					int end = er.nextInt((int)p.PathSize());
					while (begin > end)
					{
						end = er.nextInt((int)p.PathSize());
					}
					
					for (int index = 0; index <= end; index++)
					{
						//Take the subset range
						if(index >= begin && index <= end)
						{
							p2.add(p.GetPlaceFromPath(index));
						}
					}
					//scrambling the extracted subset
					Collections.shuffle(p2);
					
					int index3 = 0;
					for (int index2 = 0; index2 < p.PathSize(); index2++)
					{
						if (index2 >= begin && index2 <= end)
						{
							p.addPlaceToPath(index2, p2.get(index3));
							index3++;
						}

					}
				}
				
			}
			rand = Math.random();
		}
		
	}
	
	//Selection function for choosing parents via tournament style
	//Info for coding obtained from: https://www.geeksforgeeks.org/tournament-selection-ga/ and 
	//https://www.tutorialspoint.com/genetic_algorithms/genetic_algorithms_parent_selection.htm
	private static Path tourneyStyleSelection(Population p)
	{
		Population t1 = new Population(tournPool,null, false);
		Random r1 = new Random();
		for(int i = 0; i < tournPool; i++)
		{
			//Selects a random path from the population and adds it to the tourney ppol
			int randomPath = r1.nextInt(p.getPopSize());
			Path randP = p.getPathFromPop(randomPath);
			t1.addPathToPop(randP, i);
		}
		//The fittest path in the tourney pool is returned and can be used for parents in crossover
		Path champion = t1.getTopFitPath();
		return champion;
	}
	
	private static Path rouletteSelection(Population pop)
	{
		pop.sortPopByFittest();
		Random select = new Random();
		double prob = select.nextDouble();
		int subSize = (pop.getPopSize() / 4);
		if (prob <= .49)
		{
			Random quarter1 = new Random();
			int index = quarter1.nextInt(subSize);
			return pop.getPathFromPop(index);
		}
		else if (prob > .49 && prob <= .79)
		{
			Random quarter2 = new Random();
			int index = quarter2.nextInt(((subSize*2) - subSize)+1) + subSize;
			return pop.getPathFromPop(index);
		}
		else if (prob > .79 && prob <= .94)
		{
			Random quarter3 = new Random();
			int index = quarter3.nextInt(((subSize*3) - (subSize*2))+1) + (subSize*2);
			return pop.getPathFromPop(index);
		}
		else
		{
			Random quarter4 = new Random();
			int index = quarter4.nextInt(((subSize*4) - (subSize*3))) + (subSize*3);
			return pop.getPathFromPop(index);
		}
	}
	
	public static Population generateNewPop(Population p, boolean randomCrossover, boolean halfPathCrossover, boolean elite, boolean tourney, boolean roulette )
	{
		Population nextGeneration = new Population(p.getPopSize(),null, false);
		tournamentStyle = tourney;
		elitism = elite;
		rouletteStyle = roulette;
		halfCrossover = halfPathCrossover;
		randCrossover = randomCrossover;
		
		
		//Code for tournament selection only
		
			for (int index = 0; index < p.getPopSize(); index = index+2)
			{
				Path p1 = new Path();
				Path p2 = new Path();
				
				if (tournamentStyle==true && rouletteStyle == false)
				{
					//Start with parents chosen by the tournament selection
					p1 = tourneyStyleSelection(p);
					p2 = tourneyStyleSelection(p);
				}
				if (tournamentStyle == false && rouletteStyle == true)
				{
					p1 = rouletteSelection(p);
					p2 = rouletteSelection(p);
				}
				
				
				//Apply crossover and add it to the new generation
				Path resultChild = crossover(p1,p2,randCrossover,halfCrossover);
				Path resultChild2 = crossover(p2,p1,randCrossover,halfCrossover);
				
				//Sprinkle mutation
				mutation(.01, resultChild, false);
				mutation(.01, resultChild2, false);
				
				nextGeneration.addPathToPop(resultChild, index);
				nextGeneration.addPathToPop(resultChild2, index+1);
				
				
				
			}
		
		return nextGeneration;
		
	}

}
