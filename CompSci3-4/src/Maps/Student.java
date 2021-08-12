package Maps;
import java.lang.Comparable;
import java.util.Objects;

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class Student implements Comparable {
    
    private String fName;
    private String lName;

    /**
     * Creates a Student object
     * @param first name
     * @param last name
     */
    public Student(String first, String last){
        fName = first;
        lName = last;

    }
    
    /**
     * Get the first name
     * @return fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Get the last name
     * @return lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * Returns if the current object matches the one
     * being compared to
     * @param obj the object to test against
     * @return true if they are the same student, false
     * if otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        return true;
    }

    /**
     * Return the first and last name of the Student
     * @return first name and last name
     */
    @Override
    public String toString(){
        
        return " " + fName + " " + lName;
    }

    /**
     * Checks the last names between two Student objects
     * @param o the object to check against
     * @return 
     */
    @Override
    public int compareTo(Object o) {

        String thisName = lName;
        String thatName = ((Student)o).getlName();
        
        int compare = thisName.compareToIgnoreCase(thatName);
        
        if(compare < 0){
            return -1;
        } else if(compare == 0){
            return 0;
        } else {
            return 1;
        }
        
//        char [] array1 = lName.toCharArray();
//        char [] array2 = ((Student)o).getlName().toCharArray();
//        if(array1.equals(array2))
//            return 0;       
//        int min = Math.min(array1.length, array2.length);    
//        char ch1 = ' ';
//        char ch2 = ' ';     
//        int ctr1 = 0;
//        int ctr2= 0;     
//        for(;;){
//            
//            if(ch1.equals(ch2))
//                
//        }
    }
}
