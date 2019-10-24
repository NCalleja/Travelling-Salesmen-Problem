import java.util.*;
import java.io.*;
import java.lang.*;

public class MapInfo {
	
	// These are Public because these are the most essential parts of the program
	// It's Final because they shouldn't be changed under any circumstances
	public final List<City> Cities;
	public final double[][] distances;
	public final int n;
	
	public MapInfo(List<City> Cities, double[][] distances, int n)	{
		
		this.n = n;
		this.Cities = Cities;
		this.distances = distances;
	}
}
