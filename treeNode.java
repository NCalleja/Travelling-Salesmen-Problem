import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class treeNode {
	
	PriorityQueue<treeNode> frontier = new PriorityQueue<treeNode>();
	
	treeNode[] visited;
	treeNode source, state, parent;
	
	int numOfNodes;
	int[][] data;

	public treeNode(int[][] data, int numOfNodes)	{
		
		this.data = data;
		this.numOfNodes = numOfNodes;
	}
	
	public treeNode UniformCost()	{
		
		return null;
	}
	
	public treeNode UniCostNoCross()	{
		
		return null;
	}
	
	public treeNode GreedyAlgo()	{
		
		return null;
	}
	
}
