import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class treeNode {
	
	treeNode[] visited;
	treeNode source;
	
	int numOfNodes;
	int[][] data;

	public treeNode(int[][] data, int numOfNodes)	{
		
		this.data = data;
		this.numOfNodes = numOfNodes;
		
	}
}
