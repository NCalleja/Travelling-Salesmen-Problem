import java.util.*;

// Simulated Annealing
public class SimulatedAnnealing extends ToolsTSP implements Answer {
	
	// Vars: The Optimal Path, The Map
	private Tour optimalPath;
	private MapInfo map;
	
	// Constructor for Simulated Annealing, takes in a Map to create a Tour
	public SimulatedAnnealing(MapInfo map)	{
		
		super(map);
		this.map = map;
	}
	
	// isPathBad will decide if the Path is worth taking
	public boolean isPathBad(Tour optimal, Tour current, double temp, int counter)	{
		
		// Random Number
		double ran = Math.random();
		
		// Getting a value to compare
		double diff = optimal.getDist() - current.getDist();
		double val = Math.exp(diff / temp);
		
		// Comparing Value
		return ran < val;
	}
	
	@Override
	public Tour ComputePath()	{
		
		Tour currentPath = giveRandomTour();
		Tour bestCurrentPath = currentPath;
		
		optimalPath = bestCurrentPath;
		
		int i = 0;
		double temp = 10;
		
		while(temp > 0)	{
			
			if(bestCurrentPath.getDist() > currentPath.getDist())	{
				
				bestCurrentPath = currentPath;
				
				if(optimalPath.getDist() > bestCurrentPath.getDist())	{
					
					optimalPath = bestCurrentPath;
				}
			}
			else if(isPathBad(bestCurrentPath, currentPath, temp, i))	{
				
				bestCurrentPath = currentPath;
			}
			
			currentPath = twoOptPath(bestCurrentPath);
			
			if(i % 100000 == 0)	{
				
				System.out.println(temp);
			}
			
			temp -= .000001;
			i++;
		}
		
		return bestCurrentPath;
	}
	
}
