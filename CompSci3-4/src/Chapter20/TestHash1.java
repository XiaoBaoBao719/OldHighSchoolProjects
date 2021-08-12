package Chapter20;
public class TestHash1
{
	public static void main(String[] args)
	{
		HashTable table = new HashTable(7);
				
		System.out.println("Storing items in hash table");
		Coin c1 = new Coin("Quarter", 25);
		if (!table.store(c1))
			System.out.println("Can't store " + c1);
		Coin c2 = new Coin("Dime", 10);
		if (!table.store(c2))
			System.out.println("Can't store " + c2);
		Coin c3 = new Coin("Penny", 1);
		if (!table.store(c3))
			System.out.println("Can't store " + c3);
		Coin c4 = new Coin("Quarter", 25);
		if (!table.store(c4))
			System.out.println("Can't store " + c4);
		Coin c5 = new Coin("Quarter", 25);
		if (!table.store(c5))
			System.out.println("Can't store " + c5);
		Coin c6 = new Coin("Quarter", 25);
		if (!table.store(c6))
			System.out.println("Can't store " + c6);
		Coin c7 = new Coin("Quarter", 25);
		if (!table.store(c7))
			System.out.println("Can't store " + c7);
		Coin c8 = new Coin("Quarter", 25);
		if (!table.store(c8))
			System.out.println("Can't store " + c8);
		System.out.println();
		System.out.println(table);
		System.out.println();
		
		System.out.println("Searching for items");
		if (table.search(c1) != -1)
			System.out.println("Found " + c1 + " at location " + table.search(c1));
		else
			System.out.println("Could not find " + c1);
		if (table.search(c7) != -1)
			System.out.println("Found " + c7 + " at location " + table.search(c7));
		else
			System.out.println("Could not find " + c7);
		if (table.search(c8) != -1)
			System.out.println("Found " + c8 + " at location " + table.search(c8));
		else
			System.out.println("Could not find " + c8);
		
		System.out.println("Deleting items from hash table");
		if (table.delete(c1))
			System.out.println(c1 + " was deleted from the hash table");
		else
			System.out.println(c1 + " could not be found to be deleted from hash table");
		if (table.delete(c7))
			System.out.println(c7 + " was deleted from the hash table");
		else
			System.out.println(c7 + " could not be found to be deleted from hash table");
		if (table.delete(c8))
			System.out.println(c8 + " was deleted from the hash table");
		else
			System.out.println(c8 + " could not be found to be deleted from hash table");
		System.out.println();
		
		System.out.println(table);
		
		System.out.println("Cleaning up hash table");
		table.cleanup();
		System.out.println(table);
	}
}


/*
	Output is:
	
	Storing items in hash table
	Can't store Quarter - 25 - Heads
	
	Index   Value
	0       Quarter - 25 - Heads
	1       Quarter - 25 - Tails
	2       Quarter - 25 - Tails
	3       Penny - 1 - Heads
	4       Quarter - 25 - Tails
	5       Quarter - 25 - Tails
	6       Dime - 10 - Heads
	
	7 out of 7 items in hash table
	
	
	Searching for items
	Found Quarter - 25 - Tails at location 4
	Found Quarter - 25 - Tails at location 1
	Could not find Quarter - 25 - Heads
	Deleting items from hash table
	Quarter - 25 - Tails was deleted from the hash table
	Quarter - 25 - Tails was deleted from the hash table
	Quarter - 25 - Heads could not be found to be deleted from hash table
	
	Index   Value
	0       Quarter - 25 - Heads
	1       _DELETED
	2       Quarter - 25 - Tails
	3       Penny - 1 - Heads
	4       _DELETED
	5       Quarter - 25 - Tails
	6       Dime - 10 - Heads
	
	5 out of 7 items in hash table
	
	Cleaning up hash table
	Index   Value
	0       Quarter - 25 - Heads
	2       Quarter - 25 - Tails
	3       Penny - 1 - Heads
	4       Quarter - 25 - Tails
	6       Dime - 10 - Heads
	
	5 out of 7 items in hash table

*/	