// Priority Queue Data
public class QueueNode implements Comparable<QueueNode> {
	
	// Byte is an attempt to save space and increase performance
	byte current, depth;
	
	// Starts a null because the first Node won't have a parent
	QueueNode parent = null;
	double weight;
	
	// Constructor for the first node without a parent
	public QueueNode(byte current, byte depth, double weight)	{
		
		this.current = current;
		this.depth = 0;
		this.weight = 0;
	}
	
	// Contructor for a QueueNode with a parent, current
	// info (which is comparable), depth, and distance
	public QueueNode(byte current, byte depth, QueueNode parent, double weight)	{
		
		this.current = current;
		this.depth = depth;
		this.parent = parent;
		this.weight = weight;
	}
	
	// Returns the Current Node
	public byte getCurrent()	{
		
		return current;
	}
	
	// Returns the Depth
	public byte getDepth()	{
		
		return depth;
	}
	
	// Returns the Weight
	public double getWeight()	{
		
		return weight;
	}
	
	// Returns the Parent of the current node
	public QueueNode getParent()	{
		
		return parent;
	}
	
	// Sets the Current Node
	public void setCurrent(byte current)	{
		
		this.current = current;
	}
	
	// Sets the Depth for a Node
	public void setDepth(byte depth)	{
		
		this.depth = depth;
	}
	
	// Sets the weight
	public void setWeight(double weight)	{
		
		this.weight = weight;
	}
	
	// Sets the parent
	public void setParent(QueueNode parent)	{
		
		this.parent = parent;
	}
	
	// Compares the weights of two nodes to help decide which one to use
	@Override
	public int compareTo(QueueNode nodeCompare) {
		
		if (nodeCompare.weight > this.weight)	{
			
			return -1;
		} 
		else if (nodeCompare.weight < this.weight)	{
			
			return 1;
		}
		else {
			
			return 0;
		}
	}
}
