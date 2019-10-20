import java.util.*;
import java.lang.*;
import java.io.*;

// This class will hold all of the Algorithms to Solve the Traveling Salesmen Problem
public class SolvingTSP {
	
	private double distance;
	private double[] arrayD;
	private int[][] graph;
	private boolean city;
	
	// Contructor for the TS Graph
	public SolvingTSP() {
		
		// The Graph is set with a 100 x 100 area
		graph = new int[100][100];
	}
	
	// Get Size of the Graph
	public int getSize()	{
		
		return graph.length;
	}
	
	// Get the Graph
	public int[][] getGraph()	{
		
		return graph;
	}
	
	public void UniformCost()	{
		
	}
	
	public void UniCostNoCross()	{
		
	}
	
	public void GreedyAlgo()	{
		
	}
}
