import java.util.*;
import java.lang.*;
import java.io.*;

public class CityInfo {

	int[][] locations;
	double[][] distances;
	
	public CityInfo(int n)	{
		
		this.locations = new int[n][2];
		this.distances = new double[n][n];
	}
	
	
}
