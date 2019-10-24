import java.util.*;
import java.io.*;
import java.lang.*;

// This Class is the Path Way, helping create the tour
// It maintains a list of Edges between Cities
public class PathWay implements Comparable<PathWay> {
	
	List<Edges> edges = new ArrayList<Edges>();
	double max, min, fitness, dist;
	
	public PathWay(List<Edges> edges)	{
		
		setEdges(edges);
	}
	
	public PathWay()	{
		
		dist = 0;
	}
	
	public PathWay(List<Byte> path, MapInfo map)	{
		
		dist = 0;
		
		for (byte i = 0; i < path.size() - 1; i++)	{
			
			double distance = map.distances[path.get(i)][path.get(i + 1)];
			dist += distance;
			
		}
	}
	
	public void setEdges(List<Edges> edges)	{
		
		this.edges = new ArrayList<Edges>(edges);
		
		dist = 0;
		
		for(Edges e : edges)	{
			
			dist += e.getDist();
		}
	}
	
	public double getDist()	{
		
		return dist;
	}
	
	@Override
	public int compareTo(PathWay path) {
		
		if (path.dist < this.dist)	{
			return 1;
		}
		else if (path.dist > this.dist)	{
			return -1;
		}
		else {
			return 0;
		}
	}
	
	
}
