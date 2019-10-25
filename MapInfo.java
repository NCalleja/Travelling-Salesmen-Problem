import java.util.*;

// This is the MapInfo Class which represents the entire map, and all the data on it.
public class MapInfo {
	
	// These are Public because these are the most essential parts of the program
	// It's Final because they shouldn't be changed under any circumstances
	public final List<City> Cities;
	public final double[][] distances;
	public final int n;
	
	// Constructor for Creating a Map that contains all the info needed
	public MapInfo(List<City> Cities, double[][] distances, int n)	{
		
		this.n = n;
		this.Cities = Cities;
		this.distances = distances;
	}
}
