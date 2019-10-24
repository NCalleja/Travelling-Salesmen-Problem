// This class will be an Edge between two points
public class Edges {
	
	City here, there;
	double dist;
	
	public Edges(City here, City there, double dist)	{
		
		this.here = here;
		this.there = there;
		this.dist = dist;
	}
	
	public double getDist()	{
		
		return dist;
	}
}
