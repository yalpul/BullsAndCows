import java.util.*;

class Program{
	public static void main(String[] args)
	{
		BullsAndCows bac = new BullsAndCows(3);
		bac.eliminate(123, new Feedback(-3));
		bac.printRems();
		bac.eliminate(312, new Feedback(-3));
		bac.printRems();
	}
}
