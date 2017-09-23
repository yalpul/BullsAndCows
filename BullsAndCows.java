public class BullsAndCows{
	
	private int[] remaining;

	public BullsAndCows(int length)
	{
		int min = 1;
		for (int i = 1; i < length; i++)
			min *= 10;

		int max = min * 10 - 1;

		remaining = new int[max-min+1];

		for (int i = min, idx=0; i <= max; i++)
			remaining[idx++] = i;
	}

	public void printRems()
	{
		for (int i = 0; i < remaining.length; i++)
			System.out.println(remaining[i]);
	}
}

			

