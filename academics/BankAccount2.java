
public class BankAccount2
{
	private double amount;
	private String name;
	private double interestRate;
	
	public BankAccount2(double amount, String name, double interestRate)
	{
		this.amount = amount;
		this.name = name;
		this.interestRate = interestRate;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	
	public void applyInterest()
	{
		amount = amount + (amount * interestRate);
	}
	
}
