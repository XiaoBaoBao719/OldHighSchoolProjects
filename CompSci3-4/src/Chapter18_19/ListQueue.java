package Chapter6;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Queue;

public class ListQueue<E> extends ArrayList<E> implements Queue<E>
{
	// Do NOT add any additional instance variables!!!
	// You already have the ArrayList class by extension
	
	// The following statement is needed to remove a warning
	private static final long serialVersionUID = 1L;

	public ListQueue()
	{
		// Place your code here
                super();
	}
	
	
	/***************************************************************
	 *	Here are the methods to override from the Queue Interface
	 ***************************************************************/
	 
	/**
	 * Retrieves, but does not remove, the head of this queue. This method 
	 * differs from the peek method only in that it throws an exception 
	 * if this queue is empty. 
	 */
	public E element()
	{
		// Place your code here
            if(this.isEmpty())
            {
                throw new NoSuchElementException();
            }
            else
                return this.get(0);
	}

	/**
	 * Inserts the specified element into this queue, if possible. When using 
	 * queues that may impose insertion restrictions (for example capacity 
	 * bounds), method offer is generally preferable to method Collection.add(E),
	 * which can fail to insert an element only by throwing an exception.
	 */
	public boolean offer(E x)
	{
		// Place your code here
            try{
            this.add(x);
            return true;
            } catch(Exception e)
            {
                System.out.println("Offer Failed");
                return false;
            }
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty. 
	 */
	public E peek()
	{
		// Place your code here
                if(this.isEmpty())
                    return null;
                else
                    return this.get(0);
	}

	/**
	 * Retrieves and removes the head of this queue, 
         * or null if this queue is empty. 
	 */
	public E poll()
	{
		// Place your code here
            if(this.isEmpty())
                return null;
            else
            {
                E temp = this.get(0);
                this.remove(0);
                return temp;
            }
	}
	

	/**
	 * Retrieves and removes the head of this queue. 
         * This method differs from 
	 * the poll method in that it throws an exception 
         * if this queue is empty.
	 */
	public E remove()
	{
		// Place your code here
            if(this.isEmpty())
                throw new NoSuchElementException();
            else
            {
                E temp = this.get(0);
                this.remove(0);
                return temp;
            }
	}


	/**
	 *	Use the add & isEmpty methods from the ArrayList class.  
         *  You do NOT need to write them
	 *  here because they are inherited from the ArrayList class!
	 */
}
