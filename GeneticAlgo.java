import java.util.*;

// Genetic Algorithm
public class GeneticAlgo extends ToolsTSP implements Answer {
	
	// Random Number
	public static Random ran = new Random();
	
	// Population of Tours
	public Tour[] pop = new Tour[30];
	
	public MapInfo map;
	
	// Mutation Rate
	double mutationRate = 0.00001;
	
	// Constructor for Genetic Algo
	public GeneticAlgo(MapInfo map) {
		
		super(map);
		this.map = map;
	}
	
	// Evaluate the Population
	public void evaluate()	{
		
		// Set to 0
		double maxFit = 0;
		
		// Adding up all the Fit's
		for(Tour t : pop)	{
			
			maxFit += t.getFit();
		}
		
		double oldSingleMax = 0;
		
		// Getting the Old Max
		for(Tour t : pop)	{
			
			oldSingleMax = t.setSelectRange(maxFit, oldSingleMax);
		}
	}
	
	// Choosing a Random Parent
	public Tour randomParent()	{
		
		// Random Double
		double random = Math.random();
		
		// Search the Population
		for(int i = 0; i < pop.length; i++)	{
			
			// If it's within range of Random
			if(pop[i].isInRange(random))	{
				
				// Return Parent Tour
				return pop[i];
			}
		}
		
		// Wasn't able to select a Parent
		System.out.println("Error: Could not Select a Parent");
		return null;
	}
	
	// Creates a Child Tour between a Dad and Mom
	public Tour makeBebe(Tour dad, Tour mom)	{
		
		// Child Path
		List<Integer> childPath = new ArrayList<Integer>();
		
		// Creating Cities Considered
		List<Integer> pathConsidered = new LinkedList<Integer>();
		
		for(int i = 0; i < map.n; i++)	{
			
			pathConsidered.add(i);
		}
		
		// Both Parents Path
		Integer[] dadPath = dad.givePath();
		Integer[] momPath = mom.givePath();
		
		if(ran.nextInt(2) == 0)	{
			
			childPath.add(dadPath[0]);
		}
		else {
			
			childPath.add(momPath[0]);
		}
		
		pathConsidered.remove(childPath.get(0));
		
		for(int i = 0; i < map.n - 1; i++)	{
			
			// Get's the Cities After
			int dadNext = dad.getCityAfter(childPath.get(i));
			int momNext = mom.getCityAfter(childPath.get(i));
			
			// Get's the Distances
			double dadNextDist = map.distances[childPath.get(i)][dadNext];
			double momNextDist = map.distances[childPath.get(i)][momNext];
			
			// If the Child Path doesn't have Dad or Mom's next city
			if(!childPath.contains(dadNext) && !childPath.contains(momNext))	{
				
				// If Dad is closer than Mom
				if(dadNextDist < momNextDist)	{
					
					// Add the Dad's next City
					childPath.add(dadNext);
				}
				// Else, Mom is closer than Dad
				else {
					
					// Add the Mom's next City
					childPath.add(momNext);
				}
			}
			// Else If, the Child path contains Dad and Mom's next city
			else if (childPath.contains(dadNext) && childPath.contains(momNext))	{
				
				// Add a random city form Path Considered
				childPath.add(pathConsidered.get(ran.nextInt(pathConsidered.size())));
			}
			else	{
				
				// If the Child doesn't have Dad's next city
				if(!childPath.contains(dadNext))	{
					
					// Add Dad's next city
					childPath.add(dadNext);
				}
				// Else, the Child doesn't have Mom's next city
				else	{
					
					// Add Mom's next city
					childPath.add(momNext);
				}
			}
			
			// Remove the city from path considered
			pathConsidered.remove(childPath.get(childPath.size() - 1));
		}
		
		childPath.add(childPath.get(0));
		
		List<Edges> edges = new ArrayList<Edges>();
		
		// Creating Edges for the Child Path
		for(int i = 0; i < childPath.size() - 1; i++)	{
			
			int start = childPath.get(i);
			int end = childPath.get(i + 1);
			
			City here = map.Cities.get(start);
			City there = map.Cities.get(end);
			
			edges.add(new Edges(here, there, map.distances[start][end]));
		}
		
		// Finished new Child Tour
		Tour child = new Tour(edges);
		
		// Return the Child Tour
		return child;
	}
	
	// Reproducing new Population with the Old Population
	public Tour[] reproduce()	{
		
		// Making a new population
		Tour[] newPop = new Tour[pop.length];
		
		for(int i = 0; i < pop.length - 1; i += 2)	{
			
			// Random parent tours
			Tour Daddy = randomParent();
			Tour Mommy = randomParent();
			
			// Making children for new population
			newPop[i] = makeBebe(Daddy, Mommy);
			newPop[i + 1] = makeBebe(Daddy, Mommy);
		}
		
		// Return the new population
		return newPop;
	}
	
	// Mutation of a Tour
	public Tour mutate(Tour t)	{
		
		// Get complete path of cities
		Integer[] cities = t.giveCompletePath();
		
		// Need a temp
		Tour temp = t;
		
		// Cycle through all the cities
		for(int i = 1; i < cities.length - 1; i++)	{
			
			// Using Mutation Rate
			if(Math.random() < mutationRate)	{
				
				// Changing the Tour
				Tour changed = twoOptPath(temp);
				
				// Is the Tour better now that it's changed?
				if(changed.getDist() < temp.getDist())	{
					
					// Make the new Temp Changed
					temp = changed;
				}
			}
		}
		
		// Return the Mutated Tour
		return temp;
	}
	
	// Compute the Path
	@Override
	public Tour ComputePath() {
		
		// Go through the Population Array
		for(int i = 0; i < pop.length; i++)	{
			
			// Add a Random Tour to the Population
			pop[i] = giveRandomTour();
		}
		
		for(int i = 0; i < 1000001; i++)	{
			
			
		}
		
		return null;
	}
}
