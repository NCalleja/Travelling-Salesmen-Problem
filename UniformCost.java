import java.util.*;

// Uniform-Cost Algorithm
public class UniformCost implements Answer {
	
	// Priority Queue of Queue Nodes, which is the data we want to use
	// Using AI Book Section "3.4 Uniformed Search Strategies" page 84
	public PriorityQueue<QueueNode> frontier = new PriorityQueue<QueueNode>();
	
	// Vars: The Map, Starting City, and a List of Byte's to represent the Tour
	public MapInfo map;
	public int StartingCity;
	public List<Byte> checkPath;
	
	@Override
	public Tour ComputePath() {
		// TODO Auto-generated method stub
		return null;
	}

}
