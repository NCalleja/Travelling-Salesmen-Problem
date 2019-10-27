import java.util.*;

// This Class is the Path Way, helping create the tour
// It maintains a list of Edges between Cities (which is what will be the main thing being compared)
// Comparable (learned from COSC 311) should let us play with different types representing the path
// Thus letting us to attempt increasing performence and saving space
public class Tour implements Comparable<Tour> {
	
	// List of Edges to keep track of the Tour
	List<Edges> edges = new ArrayList<Edges>();
	
	// Various var's being used for calculations
	double totalDist;
	
	// Constructor for the Tour, requires a list of edges to evaluate
	public Tour(List<Edges> edges)	{
		
		setTour(edges);
	}
	
	// This prints the tour order (with weights) to the console
	public void printTour()	{
		
		for(int i = 0; i < edges.size(); i++)	{
			
			edges.get(i).printCityToCity();
		}
	}
	
	// Setting Tour to start with a total distance of 0
	public Tour()	{
		
		totalDist = 0;
	}
	
	// Byte because we're trying to use smaller data to save space and performence
	// The Tour takes the CurrentTour as (bytes) 
	public Tour(List<Byte> currentTour, MapInfo map)	{
		
		totalDist = 0;
		
		// Cyclying through creating the current tour from bytes
		for (byte i = 0; i < currentTour.size() - 1; i++)	{
			
			totalDist += map.distances[currentTour.get(i)][currentTour.get(i + 1)];
			edges.add(new Edges(map.Cities.get(currentTour.get(i)), map.Cities.get(currentTour.get(i + 1)), totalDist));
		}
	}
	
	// Creates the Tour for the map, and keeps track of the current distance
	public void setTour(List<Edges> edges)	{
		
		// Setting the Edges to loop through
		this.edges = new ArrayList<Edges>(edges);
		
		// Starting at a total distance of 0
		totalDist = 0;
		
		// Enhanced For Loop (learned this through doing the AI Checkers project)
		// It only has two parameters it needs
		// 1st, the type of Data, then the Array
		// e stores the value of the edges as it loops through the array of "edges"
		// This will allow an easy way to add everything in from edges
		for(Edges edge: edges)	{
			
			totalDist += edge.getDist();
		}
	}
	
	// Adds an Edge to the Tour, and keeps track of total distance
	public void addEdgeToTour(Edges edge)	{
		
		edges.add(edge);
		totalDist += edge.getDist();
	}
	
	// Returns total distance of the tour
	public double getDist()	{
		
		return totalDist;
	}
	
	// Returns the List of Edges
	public List<Edges> getEdges()	{
		
		return edges;
	}
	
	// Returns the City after the given city
	@SuppressWarnings("null")
	public int getCityAfter(int name) {
		
		// Using Enhanced For Loop
		for(Edges edge: edges)	{
			
			// If this is the city you're looking for
			if(edge.getStartingCity().getCityName() == name)	{
				
				// Return the City at the end of the Edge
				return edge.getDestinationCity().getCityName();
			}
		}
		
		// Incase that it's not found
		return (Integer) null;
	}
	
	// Auto Generated because of Comparable
	@Override
	public int compareTo(Tour path) {
		
		if (path.totalDist < this.totalDist)	{
			return 1;
		}
		else if (path.totalDist > this.totalDist)	{
			return -1;
		}
		else {
			return 0;
		}
	}
	
	
}
