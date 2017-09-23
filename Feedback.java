class Feedback{

	public Feedback(int plus, int minus)
	{
		this.plus = plus;
		this.minus = minus;
	}

	public Feedback(int num)
	{
		plus = minus = 0;
		if (num > 0)
			plus = num;
		else
			minus = -num;
	}

	public boolean equals(Feedback fb)
	{
		return plus == fb.plus && minus == fb.minus;
	}
	public int getPlus()
	{
		return plus;
	}
	public void setPlus(int plus)
	{
		this.plus = plus;
	}

	public int getMinus()
	{
		return minus;
	}
	public void setMinus(int minus)
	{
		this.minus = minus;
	}
	
	private int plus;
	private int minus;
}
