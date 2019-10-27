// Uniform Cost without Crossing Paths
// Only two changes to the UniformCost Class, Overriding the findAllChildren methed to check if the Path Crosses
// And creating a method to check if the paths have crossed using new methods added to the Edges Class
public class UniformCostNoCrossing extends UniformCost	{

	public UniformCostNoCrossing(MapInfo map) {
		super(map);
		// TODO Auto-generated constructor stub
	}
	
	// Checks if the path crosses or not
	public boolean doesPathCross(int there)	{
		
		// Where we start is one less than the total size
		int here = checkPath.get(checkPath.size() - 1);
		
		// Creating a third edge to create a triangle
		Edges edge = new Edges(map.Cities.get(here), map.Cities.get(there), map.distances[here][there]);
		
		// New Tour with new edge
		Tour newTour = new Tour(checkPath, map);
		
		// Enhanced For loop that cycles through the new tour of the current path, counting the edges in the tour
		for(Edges edg : newTour.getEdges())	{
			
			if (edg.getDestinationCity() == edge.getStartingCity() || edg.getStartingCity() == edge.getDestinationCity())	{
				
				continue;
			}
			
			if (edge.isPathCrossing(edg))	{
				
				return true;
			}
		}
		
		return false;
	}
	
	// Changing (Overriding) Find All Children method to implement the new doesPathCross method
	@Override
	public void findAllChildren(QueueNode currentCity)	{
		
		for (int i = 0; i < map.n; i++)	{
			
			// Checks if the Path makes it back to the first city and that we've visited all the cities
			boolean BackToHome = (i == 0 && checkPath.size() == map.n);
			
			// Have we been to this City?
			boolean BeenToCity = checkPath.contains(new Byte((byte) i));
			
			// If we haven't been to this city i or if we are back to the first city after the complete tour
			if(!BeenToCity || BackToHome && !doesPathCross(i))	{
				
				// We're creating a new city with it's current name, it's new depth, it's given parent, and it's new distance (adding the distance from parent to the new node + the total weight of the map thus far)
				QueueNode city = new QueueNode((byte) i, (byte) (currentCity.getDepth() + 1), currentCity, map.distances[currentCity.getCurrent()][i] + currentCity.getWeight());
				
				// If the over estimate is greater than the total weight then puth the city into the Queue
				// We need it to be less than the overEstimate because it must be more effiecent than the over estimate.
				if(overEstimate >= city.getWeight())	{
					
					city.setParent(currentCity);
					frontier.offer(city);
				}
			}
		}
	}
}
