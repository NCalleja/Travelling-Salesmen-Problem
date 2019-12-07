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
		int[] tour = new int[mapTool.n];
		
		// Simply a Random Number
		Random ran = new Random();
		
		// Making Cities Array List the same Size
		for(int i = 0; i < mapTool.n; i++)	{
			
			cities.add(i);
		}
		
		// Randomly creating a list of ints
		for(int i = mapTool.n; i > 0; i--)	{
			
			int deleted = cities.remove(ran.nextInt(i));
			tour[i - 1] = deleted;
		}
		
		// Now creating edges from the random tour int array
		for(int i = 0; i < mapTool.n; i++)	{
			
			City here = mapTool.Cities.get(tour[i]);
			City there = mapTool.Cities.get(tour[i + 1]);
			
			double dist = mapTool.distances[tour[i]][tour[i + 1]];
			
			edges.add(new Edges(here, there, dist));
		}
		
		// Vars are used to connect the last city to the starting city
		City here = mapTool.Cities.get(tour[tour.length - 1]);
		City there = mapTool.Cities.get(0);
		
		double dist = mapTool.distances[tour[tour.length - 1]][tour[0]];
		
		edges.add(new Edges(here, there, dist));
		
		// Return our new Random Tour
		return new Tour(edges);
	}
}
