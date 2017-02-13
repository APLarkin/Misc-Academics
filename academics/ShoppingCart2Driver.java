
public class ShoppingCart2Driver
{

	public static void main(String[] args)
	{
		ShoppingCart s = new ShoppingCart();
		s.addItem("gum", .45);
		s.addItem("computer", 1000.00);
		
		System.out.println(s.total());
	}

}
