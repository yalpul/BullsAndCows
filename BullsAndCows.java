import java.util.*;

public class BullsAndCows{
	
	private List remaining;

	public BullsAndCows(int length)
	{
		int min = 1;
		for (int i = 1; i < length; i++)
			min *= 10;

		int max = min * 10 - 1;

		remaining = new ArrayList(max-min+1);

		for (int i = min; i <= max; i++)
			remaining.add(i);
	}

	public Feedback compare(int num1, int num2)
	{
		String first  = Integer.toString(num1);
		String second = Integer.toString(num2);

		int plus = 0, minus = 0;

		for (int i = 0; i < second.length(); i++)
			if (second.charAt(i) == first.charAt(i))
				plus++;
			else if (first.indexOf(second.charAt(i)) > -1)
				minus++;

		return new Feedback(plus, minus);
	}
				
	public void eliminate(int num, Feedback response)
	{
		List l = new ArrayList();

		for (int i = 0; i < remaining.size(); i++)
		{
			Feedback fb = compare((int)remaining.get(i), num);
			if (fb.equals(response))
				l.add(remaining.get(i));
		}
		remaining = l;
	}

	public void printRems()
	{
		for (int i = 0; i < remaining.size(); i++)
			System.out.println(remaining.get(i));
	}
}

			

