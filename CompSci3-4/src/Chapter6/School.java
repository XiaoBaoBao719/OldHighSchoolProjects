package Chapter6;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Xiao Bao Bao
 */
public class School {
    
    private HashMap map;
    
    /**
     * Instantiates a Hash Map
     */
    public School() {
    
        map = new HashMap();
    }
    
    /** Adds a key-value mapping to the hash map
     * 
     * @param stu the Student object
     * @param grade the student's grade
     */
    public void add(Student stu, String grade) {
    
        map.put(stu, grade);
    }
    
    /** Finds a key-value mapping and removes it
     * 
     * @param stu the Student object
     * @return the Student object if it was found and removed
     * returns null if the Student could not be found
     */
    public Student remove(Student stu) {
    
        if(map.containsKey(stu)) {
            map.remove(stu);
            return stu;
        }
        else {
            return null;
        }
    }
    
    /** Finds a Student key and returns if it found the key or not
     * 
     * @param stu the Student object
     * @return true if the Student object could be found
     * return false if otherwise
     */
    public boolean find(Student stu) {
        
        if(map.containsKey(stu))
            return true;
        
        return false;
    }
    
    /** Modify a key-value mapping if such key was found
     * 
     * @param stu the Student object
     * @param grade the student's grade
     */
    public void modify(Student stu, String grade) {
    
        if(map.containsKey(stu)){
            map.put(stu, grade);
        }
    }
    
    /** Displays all the key-value mappings in a hash map in unsorted 
     * order
     * 
     */
    public void display(){
    
        System.out.println("Students Enrolled \n ------------" );
        
        if(map.isEmpty()){
            System.out.println("There are no students enrolled");
            return;
        }
        
        Set<Student> keys = map.keySet();
        
        for(Student stu : keys){
            
            System.out.println(stu);
            System.out.print(" " + map.get(stu));
        }
    }
}
