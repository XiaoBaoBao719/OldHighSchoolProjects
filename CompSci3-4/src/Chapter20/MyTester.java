/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chapter20;

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class MyTester {
    public static void main(String[] args)
	{
		HashTable table = new HashTable(7);
//				
//		System.out.println("Storing items in hash table");
//		Coin c1 = new Coin("Quarter", 25);
//		if (!table.store(c1))
//			System.out.println("Can't store " + c1);
//		Coin c2 = new Coin("Dime", 10);
//		if (!table.store(c2))
//			System.out.println("Can't store " + c2);
//		Coin c3 = new Coin("Penny", 1);
//		if (!table.store(c3))
//			System.out.println("Can't store " + c3);
//		Coin c4 = new Coin("Quarter", 25);
//		if (!table.store(c4))
//			System.out.println("Can't store " + c4);
//		Coin c5 = new Coin("Quarter", 25);
//		if (!table.store(c5))
//			System.out.println("Can't store " + c5);
//		Coin c6 = new Coin("Quarter", 25);
//		if (!table.store(c6))
//			System.out.println("Can't store " + c6);
//		Coin c7 = new Coin("Quarter", 25);
//		if (!table.store(c7))
//			System.out.println("Can't store " + c7);
//		Coin c8 = new Coin("Quarter", 25);
//		if (!table.store(c8))
//			System.out.println("Can't store " + c8);
//		System.out.println();
//		System.out.println(table);
//		System.out.println();
//                
//                System.out.println(table.search(c2));
//                
////                Coin c9 = new Coin("Penny", 1);
////                table.store(c9);
//                
//                System.out.println(table);
            Name a = new Name("Bob");
            System.out.println(table.hash(a));
        }
}
