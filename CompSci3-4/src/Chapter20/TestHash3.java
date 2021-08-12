package Chapter20;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestHash3
{
	public static void main(String[] args)
	{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader console = new BufferedReader(reader);

		HashTable table = new HashTable(1000);
				
		for (;;)
		{
			System.out.print("Enter name: ");
			String input = "";
			try
			{
				input = console.readLine();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			Name n = new Name(input);
			System.out.println(n + " hashes to " + table.hash(n) + "\n");
		}
	}
}