/*
 * The Answer Interface will allow the different methods of
 * solving the Traveling Salesmen Problem to use and override 
 * ComputePath() for their own way of solving the problem.
 */
public interface Answer {
	
	// The Answer is the Tour of which Algorithm you decide to use
	public Tour ComputePath();
}
