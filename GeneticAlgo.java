import java.util.*;

// Genetic Algorithm
public class GeneticAlgo extends ToolsTSP implements Answer {
	
	// Random Number
	public static Random ran = new Random();
	
	// Population of Tours
	public Tour[] pop = new Tour[30];
	
	// Mutation Rate
	double mutationRate = 0.00001;
	
	// Constructor for Genetic Algo
	public GeneticAlgo(MapInfo map) {
		
		super(map);
	}
	
	public void evaluate()	{
		
		double max = 0;
		
		for(Tour t : pop)	{
			
			
		}
	}
	
	// Compute the Path
	@Override
	public Tour ComputePath() {
		
		// Go through the Population Array
		for(int i = 0; i < pop.length; i++)	{
			
			// Add a Random Tour to the Population
			pop[i] = giveRandomTour();
		}
		
		for(int i = 0; i < 1000001; i++)	{
			
			
		}
		
		return null;
	}
}
