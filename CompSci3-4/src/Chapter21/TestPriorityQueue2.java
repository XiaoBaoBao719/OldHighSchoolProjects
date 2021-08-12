package Chapter21;
import java.util.Random;

public class TestPriorityQueue2
{
	public static void main(String[] args)
	{
		PriorityQueue pq = new OrderedList();
		Random r = new Random();
		
		for (int k = 0; k < 100; k++)
		{
			Integer i = new Integer(r.nextInt(1000));
                        System.out.println(i);
			pq.add(i);
                        System.out.println("List: " + pq);
		}
                
                System.out.println("List: " + pq);
                
//		for (int k = 0; k < 10; k++)
//			System.out.println(pq.removeMin());
	}
}