package Chapter20;

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class Name {
    
    private String name;
    
    /**
     * Creates a Name Object
     * @param name 
     */
    public Name(String name)
    {
        this.name = name;
    }
    
    /**
     * Prints out the Name object's name when
     * the object is called
     * @return the name
     */
    @Override
    public String toString(){
    
        return name;
    }
    
    /**
     * Gets the name
     * @return the name
     */
    public String getName(){
        
        return name;
    }
    
    /**
     * Checks if two strings have equal hash code values
     * @param s the string to compare to
     * @return false if the parameter is null or the hash codes
     * are different. true if they are the same
     */
    public boolean equals(String s){
    
        if(s == null)
            return false;
        
        if(this.getName().equals(s))
            return true;
        return false;
    }
}
