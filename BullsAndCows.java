import java.util.*;

public class BullsAndCows{
	
	private List remaining;

	@SuppressWarnings("unchecked")
	public BullsAndCows(int length)
	{
		int min = 1;
		for (int i = 1; i < length ; i++)
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
	public List eliminate(int num, Feedback response)
	{
		List l = new ArrayList();
		List m = new ArrayList();

		for (int i = 0; i < remaining.size(); i++)
		{
			Feedback fb = compare((int)remaining.get(i), num);
			if (fb.equals(response))
				l.add(remaining.get(i));
			else
				m.add(remaining.get(i));
		}
		remaining = l;

		return m;
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

	public void play_vs_pc()
	{
		Scanner scanner = new Scanner(System.in);

		Random rnd = new Random();

		int rnum = rnd.nextInt(remaining.size());
		int num = (int)remaining.get(rnum);

		int number = scanner.nextInt();
		while (number != num)
		{
			Feedback fb = compare(number, num);

			System.out.println(fb.getPlus() + " bulls " + fb.getMinus() + " cows");
			number = scanner.nextInt();
		}
		System.out.println("You found: " + num);
	}

	private List select(List discarded, int difficulty)
	{
		int size = discarded.size();
		int selectednum = size / 5 * difficulty;
		Random rnd = new Random();
		List l = new ArrayList();

		for (int i = 0; i < selectednum; i++)
			l.add(discarded.get(rnd.nextInt(size)));
		return l;
	}

	public void human_vs_pc()
	{
		Scanner scn = new Scanner(System.in);
		Random rnd = new Random();

		int pc_num = (int)remaining.get(rnd.nextInt(remaining.size()));
		System.out.println("Select difficulty: (1-5) ");
		int difficulty = 5 - scn.nextInt();
		int guess = 0;

		while (remaining.size() > 1)
		{
			int max = rnd.nextInt(remaining.size());
			int num = (int)remaining.get(max);

			System.out.print(num + "? -> ");

			int plus = scn.nextInt();
			int minus = scn.nextInt();
			guess = scn.nextInt();
			if (guess == pc_num)
				break;

			Feedback fb = new Feedback(plus, minus);
			Feedback pc = compare(guess, pc_num);
			System.out.println(pc.getPlus() + " Bulls " + pc.getMinus() + " Cows");
			List discarded = eliminate(num, fb);

			List surplus = select(discarded, difficulty);
			remaining.addAll(surplus);
		}
		if (remaining.size() == 1)
			System.out.println("Yout number is " + remaining.get(0));
		else
			System.out.println("You found my number: " + guess);
	}
}

			

