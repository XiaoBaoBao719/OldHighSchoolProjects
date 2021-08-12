/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Xiao Bao Bao
 */
public class School {

    private TreeMap tree;

    public School() {
        
        tree = new TreeMap();
    }

    public void add(Student stu, String grade) {

        tree.put(stu, grade);
    }

    public Student remove(Student stu) {
        
        if(tree.containsKey(stu)) {
            tree.remove(stu);
            return stu;
        } else {
             return null;
        }
    }

    public boolean find(Student stu) {
        
        if(tree.containsKey(stu))
            return true;
        return false;
    }

    public boolean modify(Student stu, String grade) {
        
        if(tree.containsKey(stu)){
            tree.remove(stu);
            tree.put(stu, grade);
            return true;
        }
        return false;
   }

    public void display() {

         System.out.println("Students Enrolled \n ------------" );
        
        if(tree.isEmpty()){
            System.out.println("There are no students enrolled");
            return;
        }
        
        Set<Student> keys = tree.keySet();
        
        for(Student stu : keys){
            
            System.out.print("\n" + stu);
            System.out.print(" " + tree.get(stu));
        }
        
    }

}
