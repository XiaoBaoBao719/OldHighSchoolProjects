package Chapter20;
import java.util.Random;

public class Coin
{
	private static Random generator = new Random();
	private static int serialNumberMaker = 0;
	
	private String name;
	private int value;
	private int serialNumber;
	private String face;
	
	/**
	 *	Creats a coin.
	 *	@param theName the name of the coin.
	 *	@param theValue the value of the coin.
	 *	@postcondition A coin is ceratd with a name, value
	 *				serialNumber number, and the direction
	 *				the coin is facing.
	 */
	public Coin(String theName, int theValue)
	{
		name = theName;
		value = theValue;
		serialNumberMaker++;
		serialNumber = serialNumberMaker;
		if (generator.nextInt(2) == 0)
			face = "Heads";
		else
			face = "Tails";
	}
	
	/**
	 *	Creates a hash code value for a coin.
	 *	@return returns a hash code value for a coin.
	 */
	public int hashCode()
	{
		return value * serialNumber;
	}
	
	/**
	 *	Returns a string with the name, value and direction it is facing.
	 *	@return returns a string with the name, value and direction it is facing.
	 */
	public String toString()
	{
		return name + " - " + value + " - " + face;
	}
	
	/**
	 *	Returns true if two the two coins are the same.
	 *	@return returns true if the two coins are the same.
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof Coin)
		{
			Coin c = (Coin) obj;
			return (name.equals(c.getName()) &&
			        value == c.getValue() &&
			        serialNumber == c.getSerialNumber());
		}
		return false;
	}
	
	/**
	 *	Returns the name of the coin.
	 *	@return returns the name of the coin.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 *	Returns the value of the coin.
	 *	@return return the value of teh coin.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 *	Returns the serial number of the coin.
	 *	@return returns the serial number of the coin.
	 */
	private int getSerialNumber()
	{
		return serialNumber;
	}
}