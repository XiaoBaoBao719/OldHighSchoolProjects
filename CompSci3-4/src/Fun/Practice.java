/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fun;

/**
 *
 * @author Xiao Bao Bao
 */
public class Practice {
    
    public static void main(String[] args)
    {
        System.out.println("1" + new Integer(2) + 3);
        test();
        System.out.println(2 + 6 / 3);
    }
    
    
    public static void changer(String x, int y)
    {
        x = x + "peace";
        y = y * 2;
    }
    
    public static void test()
    {
        
        String s = "world";
        int n = 6;
        changer(s, n);
        
        System.out.println(s + " " + n);
    }
}
