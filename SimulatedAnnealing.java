// Simulated Annealing
public class SimulatedAnnealing extends ToolsTSP implements Answer {
	
	// Vars: The Optimal Path, The Map
	private Tour optimalPath;
	
	// Constructor for Simulated Annealing, takes in a Map to create a Tour
	public SimulatedAnnealing(MapInfo map)	{
		
		super(map);
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
	
	// Computing the Path
	@Override
	public Tour ComputePath()	{
		
		// The Current Path (which is random to start with)
		Tour currentPath = giveRandomTour();
		
		// The Best Current Path (which starts as the current path)
		Tour bestCurrentPath = currentPath;
		
		// The Optimal Path is the best current path
		optimalPath = bestCurrentPath;
		
		// Vars to help
		int i = 0;
		double temp = 10;
		
		// While temp is greater than zero....
		while(temp > 0)	{
			
			// If the best path is worse than the current path
			if(bestCurrentPath.getDist() > currentPath.getDist())	{
				
				// Update the Best Path
				bestCurrentPath = currentPath;
				
				// If the Optimal Path is worse than the Best Path
				if(optimalPath.getDist() > bestCurrentPath.getDist())	{
					
					// Update the Optimal Path
					optimalPath = bestCurrentPath;
				}
			}
			// If the Path isn't sutiable
			else if(isPathBad(bestCurrentPath, currentPath, temp, i))	{
				
				// Update the best path
				bestCurrentPath = currentPath;
			}
			
			// Change the Current Path by changing the edges
			currentPath = twoOptPath(bestCurrentPath);
			
			if(i % 100000 == 0)	{
				
				// Update on the temp... get it because its temprature... and we use temp as temporary... 
				System.out.println(temp);
			}
			
			// Cooling Down
			temp -= .000001;
			i++;
		}
		
		// Return the Best Path
		return bestCurrentPath;
	}
	
}
