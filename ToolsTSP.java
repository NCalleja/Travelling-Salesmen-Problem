import java.util.*;

// Class that contains tools used for Simulated Annealing and Genetic Algorithms
public abstract class ToolsTSP implements Answer {
	
	// Vars: MapInfo for a random Map, and a Random number
	public MapInfo mapTool;
	public static Random ranNum = new Random();
	
	// Constructor for ToolsTSP
	public ToolsTSP(MapInfo map)	{
		
		this.mapTool = map;
	}
	
	// Method to create a Random Tour
	public Tour giveRandomTour()	{
		
		// List of Integers, Int Array size of the Map, and a List of Edges
		List<Integer> cities = new ArrayList<Integer>();
		List<Edges> edges = new ArrayList<Edges>();
		int[] tourRan = new int[mapTool.n];
		
		// Simply a Random Number
		Random ran = new Random();
		
		// Making Cities Array List the same Size
		for(int i = 0; i < mapTool.n; i++)	{
			
			// Add the City
			cities.add(i);
		}
		
		// Randomly creating a list of ints
		for(int i = mapTool.n; i > 0; i--)	{
			
			// Create the Random Tour
			int deleted = cities.remove(ran.nextInt(i));
			tourRan[i - 1] = deleted;
		}
		
		// Now creating edges from the random tour int array
		for(int i = 0; i < mapTool.n - 1; i++)	{
			
			City here = mapTool.Cities.get(tourRan[i]);
			City there = mapTool.Cities.get(tourRan[i + 1]);
			
			double dist = mapTool.distances[tourRan[i]][tourRan[i + 1]];
			
			edges.add(new Edges(here, there, dist));
		}
		
		// Vars are used to connect the last city to the starting city
		City here = mapTool.Cities.get(tourRan[tourRan.length - 1]);
		City there = mapTool.Cities.get(0);
		
		double dist = mapTool.distances[tourRan[tourRan.length - 1]][tourRan[0]];
		
		edges.add(new Edges(here, there, dist));
		
		// Return our new Random Tour
		return new Tour(edges);
	}
	
	// Creates Random Number Array
	public int[] ranNums(int nums) {
		
		// Random int array
		int[] ran = new int[nums];
		
		// Go through the Array
		for(int i = 0; i < ran.length; i++)	{
			
			// Place Random Numbers
			ran[i] = ranNum.nextInt(mapTool.n - 1) + 1;
		}
		
		// Return the Random Number Array
		return ran;
	}
	
	// Checks to see if it's adjecent
	public boolean isAdjacent(int[] num)	{
		
		for(int i = 0; i < num.length - 1; i++)	{
			
			for(int j = 0; j < num.length; j++)	{
				
				if((1 >= Math.abs(num[i] - num[j])) && (i != j))	{
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Changing the Cities
	public int[] changeCities(int numOfCities)	{
		
		int[] changePath = ranNums(numOfCities);
		
		while(isAdjacent(changePath))	{
			
			changePath = ranNums(numOfCities);
		}
		
		Arrays.sort(changePath);
		return changePath;
	}
	
	/*
	 * The 2-Opt heuristic is a operation to delete two of the edges in the path,
	 * and re-connect them in the remaining possible ways. If the modified path is an
	 * improvement over the previouw one, it becomes the best solution, otherwise it is discarded
	 * (I had to look up formulas on how to do this)
	 */
	public Tour twoOptPath(Tour path)	{
		
		// Two Random Cities change
		int[] changeCity = changeCities(2);
		
		// The Complete Given Path
		Integer[] cityOrder = path.giveCompletePath();
		
		List<Integer> agitated = new ArrayList<Integer>();
		
		for(int i = 0; i < changeCity[0]; i++)	{
			
			agitated.add(cityOrder[i]);
		}
		
		for(int i = changeCity[1]; i >= changeCity[0]; i--)	{
			
			agitated.add(cityOrder[i]);
		}
		
		for(int i = changeCity[1] + 1; i < cityOrder.length; i++)	{
			
			agitated.add(cityOrder[i]);
		}
		
		List<Edges> edges = new ArrayList<Edges>();
		
		for(int i = 0; i < agitated.size() - 1; i++)	{
			
			int start = agitated.get(i);
			int end = agitated.get(i + 1);
			
			City here = mapTool.Cities.get(agitated.get(i));
			City there = mapTool.Cities.get(agitated.get(i + 1));
			
			edges.add(new Edges(here, there, mapTool.distances[start][end]));
		}
		
		return new Tour(edges);
	}
}
