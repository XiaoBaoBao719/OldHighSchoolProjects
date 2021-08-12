package Chapter21;
import java.lang.RuntimeException;
import java.util.NoSuchElementException;

public class BinaryHeap implements PriorityQueue
{
	private int currentSize;
	private Comparable[] array;
	
	private final int DEFAULT_CAPACITY = 10;
	
	/**
	 *	Creates a Binary Heap using an array representation.
	 */
	 public BinaryHeap()
	{
		currentSize = 0;
		array = new Comparable[DEFAULT_CAPACITY + 1];
	}
	
	/******************************************************
	 *	Implementing the Priority Queue methods          *
	 *****************************************************/
	
	/**
	 *	Determines if the priority queue is empty or not.
	 *	@return returns true if the prioroty queue is empty, otherwise
	 *			returns false.
	 */
	public boolean isEmpty()
	{
		return (currentSize == 0);
	}
	
	/*
	 *	Insert a Comparable object to the priority queue.
	 *	@param obj the object to insert into the priority queue.
	 *	@postcondition The tree remains a heap.
	 */
	public void add(Object x)
	{
		if (!(x instanceof Comparable))
			throw new ClassCastException("Must be Comparable");
		Comparable value = (Comparable) x;
		if (currentSize + 1 == array.length)
			doubleArray();
		
		// Percolate up
		int hole = ++currentSize;
		array[0] = value;
		while (value.compareTo(array[hole/2]) < 0)
		{
			array[hole] = array[hole/2];
			hole /= 2;
		}
		array[hole] = value;
	}
	
	/**
	 *	Removes the minimum value from the priority queue.
	 *	@return returns the minimum Comparable object in the 
	 *			priority queue.
	 */
	public Object removeMin()
	{
		if (isEmpty())
			throw new NoSuchElementException("Priority Queue is empty");
		Comparable min = array[1];
		array[1] = array[currentSize--];
		percolateDown(1);
		return min;
	}

	/**
	 *	Returns the minimum value from the priority queue.
	 *	@return returns the minimum Comparable object in the 
	 *			priority queue.
	 */
	public Object peekMin()
	{
		if (isEmpty())
			throw new NoSuchElementException("Priority Queue is empty");
		Comparable min = array[1];
		return min;
	}
	
	/******************************************************
	 *	 Other Methods                                   *
	 *****************************************************/

	/**
	 *	Sets the priority queue to empty.
	 *	@postcondition The priority queue is empty.
	 */
	public void makeEmpty()
	{
		currentSize = 0;
	}
	
	/**
	 *	Rearranges the tree to be a heap.
	 */
	private void buildHeap()
	{
		for (int i = currentSize/2; i > 0; i--)
			percolateDown(i);
	}
	
	/**
	 *	Percolates the object at "hole" down the heap to its correct location.
	 *	@param hole the index at which the percolation begins.
	 */
	private void percolateDown(int hole)
	{
		int child;
		Comparable tmp = array[hole];
		
		for ( ; hole * 2 <= currentSize; hole = child)
		{
			child = hole * 2;
			if (child != currentSize && array[child+1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}
	
	/**
	 *	Doubles the size of the array preserving the contents of
	 *	the old array.
	 */
	private void doubleArray()
	{
		Comparable[] temp = new Comparable[array.length*2];
		for (int k = 0; k < array.length; k++)
			temp[k] = array[k];
		array = temp;
	}	
}