import java.util.*;

// Uniform-Cost Algorithm
public class UniformCost implements Answer {
	
	// Priority Queue of Queue Nodes, which is the data we want to use
	// Using AI Book Section "3.4 Uniformed Search Strategies" page 84
	public PriorityQueue<QueueNode> frontier = new PriorityQueue<QueueNode>();
	
	// Vars: The Map, Starting City, and a List of Byte's to represent the Tour
	public MapInfo map;
	public int StartingCity = 0;

	// Byte is essential to creating a program that will run fast and efficiently
	// In class the professor expressed how important it was that we choose
	// what kind of data we represent in the Queue.
	public List<Byte> checkPath;
	public int farthest = 1;
	public double overEstimate;
	
	// Constructor, Uniform Cost needs a over estimate. Using Greedy for that.
	// Since Greedy won't give you the optimal answer compared to Uniform Cost
	// That makes Greedy a good over estimate of the answer
	public UniformCost(MapInfo map)	{
		
		this.map = map;
		this.overEstimate = new GreedyAlgo(map).ComputePath().totalDist; 
	}
	
	// Follows the Current Node up to his Parent, and to that Parent's Parent, and so on...
	// Eventually getting back to the root, which won't have a parent
	public void followParent(QueueNode currentCity)	{
		
		// If the current node doesn't have a parent
		if (currentCity.getParent() == null)	{
			
			// Add the current node to the path we're checking out then stop
			checkPath.add(currentCity.getCurrent());
		}
		else	{
			
			// Follow the Parent first
			// Then add the current node to the path we're checking out
			followParent(currentCity.getParent());
			checkPath.add(currentCity.getCurrent());
		}
	}
	
	// Finds all the children of the city you're asking for
	public void findAllChildren(QueueNode currentCity)	{
		
		for (int i = 0; i < map.n; i++)	{
			
			// Checks if the Path makes it back to the first city and that we've visited all the cities
			boolean BackToHome = (i == 0 && checkPath.size() == map.n);
			
			// Have we been to this City?
			boolean BeenToCity = checkPath.contains(new Byte((byte) i));
			
			// If we haven't been to this city i or if we are back to the first city after the complete tour
			if(!BeenToCity || BackToHome)	{
				
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
	
	public void printAfterTime()	{
		
		
	}
	
	// Computing the Path
	@Override
	public Tour ComputePath() {
		
		// Adding the First City to the Queue
		frontier.add(new QueueNode((byte) 0));
		
		// While the Queue isn't empty
		while (!frontier.isEmpty())	{
			
			// Grabbing the City at the front of the Queue
			QueueNode headCity = frontier.poll();
			
			// Finding the Path from the headCity
			checkPath = new ArrayList<Byte>();
			followParent(headCity);
			
			// Printing the Current Path
			System.out.println(checkPath);
			
			// Setting the farthest to the size of the path
			if(farthest < checkPath.size())	{
				
				farthest = checkPath.size();
			}
			
			// Returns the new Tour if we've visited every city
			if (map.n == headCity.getDepth())	{
				
				return new Tour(checkPath, map);
			}
			
			// else find the children of the head city, which will change the frontier headCity
			else	{
				
				findAllChildren(headCity);
			}
		}
		return null;
	}
}
