
public interface GeneticTour {
	
	double getFit();
	
	double setSelectRange(double totalPopFit, double oldMax);
	
	double getProb();
	
	boolean isInRange(double prob);
}
