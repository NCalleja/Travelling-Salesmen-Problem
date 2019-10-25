import java.util.*;
import java.io.*;
import java.lang.*;

// The Greedy Algorithm
public class GreedyAlgo implements Answer {
	
	// Vars: MapInfo for the Map, Tour for the current path, And a list of visited Integers
	private MapInfo map;
	private Tour path;
	private List<Integer> visited = new ArrayList<Integer>();
	
	// Constructor for using the Greedy Algorithm, taking a Map and creating a new Tour
	public GreedyAlgo(MapInfo map)	{
		
		this.map = map;
		path = new Tour();
	}
	
	// This chooses the Closest City to the given City
	public int closestCity(int city)	{
		
		// Using a huge number to start with min
		double min = 99999999;
		int closestCity = city;
		
		// Cycling through the Map's distances from a City to all other cities
		for(int i = 0; i < map.distances[city].length; i++)	{
			
			// If i isn't the city, if i isn't in visited, if the distance is less than the min
			if(i != city && !visited.contains(i) && map.distances[city][i] < min)	{
				
				min = map.distances[city][i];
				closestCity = i;
			}
		}
		
		return closestCity;
	}
	
	// The Greedy Algorithm
	@Override
	public Tour ComputePath() {
		
		// Tour Starts at the First City
		int StartingCity = 0;
		int CurrentCity = StartingCity;
		
		visited.add(CurrentCity);
		
		while (visited.size() < map.n)
		
		return null;
	}
}
