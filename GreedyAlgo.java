import java.util.*;
import java.io.*;
import java.lang.*;

// The Greedy Algorithm
public class GreedyAlgo implements Answer {
	
	private MapInfo map;
	private Tour path;
	private List<Integer> visited = new ArrayList<Integer>();
	
	public GreedyAlgo(MapInfo map)	{
		
		this.map = map;
		path = new Tour();
	}
	
	@Override
	public Tour findPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour findPath(int x) {
		// TODO Auto-generated method stub
		return null;
	}
}
