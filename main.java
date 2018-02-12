class Program{
	public static void main(String[] args)
	{
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("Enter digit length: ");
		int digit = scanner.nextInt();
		BullsAndCows bac = new BullsAndCows(digit);
		System.out.println("0 - human_vs_pc (default)");
		System.out.println("1 - play_vs_pc (you guess PC's number)");
		System.out.println("2 - play (PC guesses your number)");
		System.out.print("Enter mode (0/1/2): ");
		int mode = scanner.nextInt();

		if (mode == 1)
			bac.play_vs_pc();
		else if (mode == 2)
			bac.play();
		else
			bac.human_vs_pc();
	}
}
