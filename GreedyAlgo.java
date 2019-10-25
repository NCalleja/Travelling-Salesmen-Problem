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
	
	@Override
	public Tour ComputePath() {
		
		int StartingCity = 0;
		int CurrentCity = StartingCity;
		
		visited.add(CurrentCity);
		
		while (visited.size() < map.n)
		
		return null;
	}
}
