package Chapter21;
import java.util.Random;

public class TestPriorityQueue1
{
	public static void main(String[] args)
	{
		PriorityQueue pq = new BinaryHeap();
		Random r = new Random();
		
		for (int k = 0; k < 100; k++)
		{
			Integer i = new Integer(r.nextInt(1000));
			pq.add(i);
		}
		for (int k = 0; k < 10; k++)
			System.out.println(pq.removeMin());
	}
}