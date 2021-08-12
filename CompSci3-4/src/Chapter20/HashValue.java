
package Chapter20;

/**
 *
 * @author Xiao Bao Bao
 * This class is responsible for implementing HashValue objects.
 * HashValue objects contain the element of the key that was given 
 * on the insertion. They also hold a boolean value that tells
 * if they were deleted or not
 */
public class HashValue {
    
    //element of key to store
    public Object element; 
    
    //the 'active' state, tells us if it is deleted or not
    //TRUE MEANS IT IS ACTIVE
    //FALSE MEANS IT IS DELETED (NON-ACTIVE)
    public boolean isActive; 
    
    /**
     * Create HashValue objects, greatly helps lazy deletion
     * @param e the object that we want to make a Hash Value object of
     * @param active the boolean variable that determines if an object
     * has been deleted or not
     */
    public HashValue(Object e, boolean active){
        
        element = e;
        isActive = active;
    }
    
    /**
     * Tells us the state of the HashValue object
     * @return true if the object is active, false if it
     * has been deleted
     */
    public boolean getState(){
        return isActive;
    }
    
    /**
     * Sets the state of the object
     * @param state a bool that determines if an Hash Value object is
     * active or not
     */
    public void setState(boolean state)
    {
        isActive = state;
    }
    
    /**
     * Gives us the element that we stored in the HashValue object
     * also a form of encapsulation?
     * @return the element of the object that we stored
     */
    public Object getElement(){
        return element;
    }
    
    /**
     * Sets the element of a HashValue object
     * @param e the object that we are inserting
     */
    public void setElement(Object e)
    {
        element = e;
    }
}
