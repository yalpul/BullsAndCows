import java.util.*;

public class BullsAndCows{
	
	private List remaining;

	@SuppressWarnings("unchecked")
	public BullsAndCows(int length)
	{
		int min = 1;
		for (int i = 1; i < length; i++)
			min *= 10;

		int max = min * 10 - 1;

		remaining = new ArrayList(max-min+1);

		for (int i = min; i <= max; i++)
			if (Integer.toString(i).length() == Integer.toString(i).chars().distinct().count())
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
				
	@SuppressWarnings("unchecked")
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

	public void play()
	{
		Scanner scanner = new Scanner(System.in);

		while (remaining.size() > 1)
		{
			System.out.print(remaining.get(0) + "? -> ");
			int plus = scanner.nextInt();
			int minus = scanner.nextInt();
			Feedback fb = new Feedback(plus,minus);
			eliminate((int)remaining.get(0), fb);
		}
		System.out.println("Your number is: " + remaining.get(0));
	}
}

			

