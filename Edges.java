import java.math.*;

// This class will be an Edge between two Cities
public class Edges {
	
	// Vars: Starting City, Destination City, and the Distance between the Cities
	City here, there;
	double dist;
	
	//  Constructor for intializing an Edge between two Cities
	public Edges(City here, City there, double dist)	{
		
		this.here = here;
		this.there = there;
		this.dist = dist;
	}
	
	// Printing City -- # --> City to show the Edge
	public void printCityToCity()	{
		
		System.out.println(here.getCityName() + " --- " + String.format("%.2f", dist) +" ---> " + there.getCityName());
	}
	
	// Returns the Distance between two Cities
	public double getDist()	{
		
		return dist;
	}
	
	// Returns the City at the start of the Edge
	public City getStartingCity()	{
		
		return here;
	}
	
	// Returns the City at the end of the Edge 
	public City getDestinationCity()	{
		
		return there;
	}
	
	// Sets the distance between the two Cities
	public void setDist(double distance)	{
		
		dist = distance;
	}
	
	// Sets the Beginning of the Edge
	public void setStartingCity(City A)	{
		
		here = A;
	}
	
	// Sets the Destination of the Edge
	public void setDestinationCity(City B)	{
		
		there = B;
	}
}
