package Chapter20;
public class TestHash
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
		//table.cleanup();
		System.out.println(table);


		HashTable table2 = new HashTable(1000);
		Name n;
				
		System.out.println("Storing items in hash table2");
		System.out.println("---------------------------");
		table2.store(new Name("Michelle"));
		table2.store(new Name("Tallh"));
		table2.store(new Name("Alama"));
		table2.store(new Name("Harish"));
		table2.store(new Name("Jane"));
		table2.store(new Name("Bryan"));
		table2.store(new Name("Ryan"));
		table2.store(new Name("Mark"));
		table2.store(new Name("Jarl"));
		table2.store(new Name("Tarm"));
		table2.store(new Name("Spark"));
		table2.store(new Name("Caitlin"));
		table2.store(new Name("Rachel"));
		table2.store(new Name("Matthew"));
		table2.store(new Name("Collin"));
		table2.store(new Name("Justin"));
		table2.store(new Name("Kristin"));
		table2.store(new Name("Martin"));
		table2.store(new Name("Tim"));
		table2.store(new Name("Anne"));
		table2.store(new Name("Klaulb"));
		table2.store(new Name("Paula"));
		table2.store(new Name("a"));
		table2.store(new Name("Killi"));
		table2.store(new Name("Battn"));
		System.out.println();
		System.out.println(table2);
		System.out.println();
		
		System.out.println("Searching for items");
		System.out.println("-------------------");
		n = new Name("Battn");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Lark");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Martin");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Tim");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Spark");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Tarm");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Ryan");
		if (table2.search(n) != -1)
			System.out.println("Found " + n + " at location " + table2.search(n));
		else
			System.out.println("Could not find " + n);
		System.out.println();
		
		System.out.println("Deleting items from hash table2");
		System.out.println("------------------------------");
		n = new Name("Justin");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		n = new Name("Jane");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		n = new Name("Bryan");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		n = new Name("Killi");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		n = new Name("Tallh");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		n = new Name("Mary");
		if (table2.delete(n))
			System.out.println(n + " was deleted from the hash table2");
		else
			System.out.println(n + " could not be found to be deleted from hash table2");
		System.out.println();
		
		System.out.println(table2);
		
		System.out.println("Cleaning up hash table2");
		System.out.println("----------------------");
		//table2.cleanup();
		System.out.println(table2);
	}
}