import java.util.*;

// Uniform-Cost Algorithm
public class UniformCost implements Answer {
	
	// Priority Queue of Queue Nodes, which is the data we want to use
	// Using AI Book Section "3.4 Uniformed Search Strategies" page 84
	public PriorityQueue<QueueNode> frontier = new PriorityQueue<QueueNode>();
	
	// Vars: The Map, Starting City, and a List of Byte's to represent the Tour
	public MapInfo map;
	public int StartingCity = 0;
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
	
	// Computing the Path
	@Override
	public Tour ComputePath() {
		
		// Adding the First City to the Queue
		frontier.add(new QueueNode((byte) 0));
		
		while (!frontier.isEmpty())	{
			
			
		}
		
		return null;
	}

}
