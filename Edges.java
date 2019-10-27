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
	
	// These next methods are for Uniform Cost, without crossing paths
	// Citing: geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	
	// We have to find the orientation before we can find out if it intersects
	// It's either clockwise (1), counterclockwise (-1), or it's co-linear (0)
	public int orientation(City a, City b, City c)	{
		
		int n = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());
		
		if (n == 0)	{
			
			return 0;
		}
		
		return n > 0 ? 1 : -1;
	}
	
	
	// This will check all the orientations and see if the path is crossing. 
	public boolean isPathCrossing(Edges edge)	{
		
		int o1 = orientation(here, there, edge.here);
		int o2 = orientation(here, there, edge.there);
		int o3 = orientation(edge.here, edge.there, here);
		int o4 = orientation(edge.here, edge.there, there);
		
		return (o1 != o2 && o3 != o4);
	}
}
