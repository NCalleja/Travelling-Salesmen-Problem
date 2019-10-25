import java.util.*;

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
		
		// Retruning the Closest City to "city"
		return closestCity;
	}
	
	// The Greedy Algorithm
	@Override
	public Tour ComputePath() {
		
		// Tour Starts at the First City "0"
		int CurrentCity = 0;
		
		// Add the first city to visited
		visited.add(CurrentCity);
		
		// This loops through every City on the map until they all have been evaluated
		while (visited.size() < map.n)	{
			
			// Get the closest city to the current city
			int nextCity = closestCity(CurrentCity);
			
			// Adding a Edge to the Tour from current city to the closest city, and giving the distance
			path.addEdgeToTour(new Edges(map.Cities.get(CurrentCity), map.Cities.get(nextCity), map.distances[CurrentCity][nextCity]));
			
			// Add that city to the visited array
			visited.add(nextCity);
			
			// Start again from the next City
			CurrentCity = nextCity;
		}
		
		// Returning to the Starting City
		path.addEdgeToTour(new Edges(map.Cities.get(CurrentCity), map.Cities.get(0), map.distances[CurrentCity][0]));
		
		// Return the entire Tour
		return path;
	}
}
