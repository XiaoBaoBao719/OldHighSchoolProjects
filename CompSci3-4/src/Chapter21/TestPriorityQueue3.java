package Chapter21;
import java.util.Random;

public class TestPriorityQueue3
{
	public static void main(String[] args)
	{
		PriorityQueue pq = new OrderedList();
		Random r = new Random();
		
		for (int k = 0; k < 100; k++)
		{
			int row = r.nextInt(1000);
			int col = r.nextInt(1000);
			Location loc = new Location(row,col);
			String name = "" + (char) (r.nextInt(26) + 65);
			name += (char) (r.nextInt(26) + 65);
			name += (char) (r.nextInt(26) + 65);
			pq.add(new Data(name, loc));
		}
		
		for (int k = 0; k < 10; k++)
			System.out.println(pq.removeMin());
			
		System.out.println("*************************");
		System.out.println(pq.peekMin());
		System.out.println(pq.peekMin());
		
		System.out.println("*************************");
		Object x = null;
		while (!pq.isEmpty())
			x = pq.removeMin();
		System.out.println(x);
	}
}