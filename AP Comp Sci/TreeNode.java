/**
 * Utility binary-tree (Huffman tree) node for Huffman coding
 * 
 * @author Owen Astrachan
 * @version 1.0 July 2000
 */
public class TreeNode implements Comparable
{
    int myValue;
    int myWeight;
    TreeNode myLeft;
    TreeNode myRight;
       
    /**
     * construct leaf node (null children)
     * @param value is the value stored in the node (e.g., character)
     */
    
    public TreeNode(int value)
    {
	myValue = value;
    }
    /**
     * construct leaf node (null children)
     * @param value is the value stored in the node (e.g., character)
     * @param weight is used for comparison (e.g., count of # occurrences)
     */
    
    public TreeNode(int value, int weight)
    {
	myValue = value;
	myWeight = weight;
    }
    /**
     * construct internal node (with children)
     * @param value is stored as value of node
     * @param weight is weight of node
     * @param ltree is left subtree
     * @param rtree is right subtree
     */

    public TreeNode(int value, int weight, TreeNode ltree, TreeNode rtree)
    {
	this(value,weight);
	myLeft = ltree;
	myRight = rtree;
    }

    public int getVal()
    {
        return myValue;
    }
    
    public int getWeight()
    {
        return myWeight;
    }
    /**
     * @return -1 if this < o, +1 if this > o, and 0 if this == 0
     */
    
    public int compareTo(Object o)
    {
	TreeNode rhs = (TreeNode) o;
	if (myWeight < rhs.myWeight)      return -1;
	else if (myWeight > rhs.myWeight) return  1;
	else                              return  0;
    }

    /**
     * Determines if a node is a leaf in a binary tree
     *
     * @param t a node in a binary tree
     * @return returns true if t is a node with empty left & right subtrees,
     * otherwise returns false
     */
    public static boolean isLeaf(TreeNode t) {
        if (t != null && t.getMyLeft() == null & t.getMyRight() == null) {
            return true;
        }
        return false;
    }
    
    
    public TreeNode getMyLeft() {
        return myLeft;
    }

    public void setMyLeft(TreeNode myLeft) {
        this.myLeft = myLeft;
    }

    public TreeNode getMyRight() {
        return myRight;
    }

    public void setMyRight(TreeNode myRight) {
        this.myRight = myRight;
    }
 
}
