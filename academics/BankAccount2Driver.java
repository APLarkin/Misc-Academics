
public class BankAccount2Driver
{
	public static void main(String[] args)
	{
		BankAccount2 bank = new BankAccount2(1000, "Juan", .03);
		
		bank.applyInterest();
		System.out.println(bank.getAmount());
		bank.setInterestRate(.02);
		bank.applyInterest();
		System.out.println(bank.getAmount());
		
	}
}
