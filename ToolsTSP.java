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
		for(int i = 0; i < mapTool.n; i++)	{
			
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
	
	/*
	 * The 2-Opt heuristic is a operation to delete two of the edges in the path,
	 * and re-connect them in the remaining possible ways. If the modified path is an
	 * improvement over the previouw one, it becomes the best solution, otherwise it is discarded
	 */
	public Tour twoOptPath(Tour path)	{
		
		
		
		return null;
	}
}
