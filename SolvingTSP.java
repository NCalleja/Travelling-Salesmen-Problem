import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

// This class will hold all of the Algorithms to Solve the Traveling Salesmen Problem
public class SolvingTSP {
	
	private double distance;
	private int[][] graph;
	
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
	
	public double dist(int x1, int y1, int x2, int y2)	{
		
		int x = (x2 - x1);
		int y = (y2 - y1);
		
		double d = Math.sqrt( (x*x) + (y*y) );
		d = Math.abs(d);
		
		System.out.println("This is a test, the Distance is... " + d);
		System.out.println();
		
		distance = d;
		
		return d;
	}
}
