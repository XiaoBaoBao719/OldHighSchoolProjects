package Chapter20;
public class TestHash2
{
	public static void main(String[] args)
	{
		HashTable table = new HashTable(1000);
		Name n;
				
		System.out.println("Storing items in hash table");
		System.out.println("---------------------------");
		table.store(new Name("Michelle"));
		table.store(new Name("Tallh"));
		table.store(new Name("Alama"));
		table.store(new Name("Harish"));
		table.store(new Name("Jane"));
		table.store(new Name("Bryan"));
		table.store(new Name("Ryan"));
		table.store(new Name("Mark"));
		table.store(new Name("Jarl"));
		table.store(new Name("Tarm"));
		table.store(new Name("Spark"));
		table.store(new Name("Caitlin"));
		table.store(new Name("Rachel"));
		table.store(new Name("Matthew"));
		table.store(new Name("Collin"));
		table.store(new Name("Justin"));
		table.store(new Name("Kristin"));
		table.store(new Name("Martin"));
		table.store(new Name("Tim"));
		table.store(new Name("Anne"));
		table.store(new Name("Klaulb"));
		table.store(new Name("Paula"));
		table.store(new Name("a"));
		table.store(new Name("Killi"));
		table.store(new Name("Battn"));
		System.out.println();
		System.out.println(table);
		System.out.println();
		
		System.out.println("Searching for items");
		System.out.println("-------------------");
		n = new Name("Battn");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Lark");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Martin");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Tim");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Spark");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Tarm");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		n = new Name("Ryan");
		if (table.search(n) != -1)
			System.out.println("Found " + n + " at location " + table.search(n));
		else
			System.out.println("Could not find " + n);
		System.out.println();
		
		System.out.println("Deleting items from hash table");
		System.out.println("------------------------------");
		n = new Name("Justin");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		n = new Name("Jane");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		n = new Name("Bryan");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		n = new Name("Killi");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		n = new Name("Tallh");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		n = new Name("Mary");
		if (table.delete(n))
			System.out.println(n + " was deleted from the hash table");
		else
			System.out.println(n + " could not be found to be deleted from hash table");
		System.out.println();
		
		System.out.println(table);
		
		System.out.println("Cleaning up hash table");
		System.out.println("----------------------");
		//table.cleanup();
		System.out.println(table);
	}
}