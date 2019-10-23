import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class treeNode<T> {
	
	PriorityQueue<treeNode<T>> frontier = new PriorityQueue<treeNode<T>>();
	
	treeNode<T>[] visited;
	treeNode<T> source = null;
	treeNode<T> parent = null;
	
	List<treeNode<T>> children = new ArrayList<>();
	
	int numOfNodes;
	T data;

	public treeNode(T data)	{
		
		this.data = data;
	}
	
	// Setting total number of Nodes
	public void setNumOfNodes(int n)	{
		
		this.numOfNodes = n;
	}
	
	public void setSource(treeNode<T> source)	{
		
		this.source = source;
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
