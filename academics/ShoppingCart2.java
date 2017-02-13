import java.util.ArrayList;
import java.util.List;


public class ShoppingCart2
{	
	private List<item> list;
	
	public ShoppingCart2()
	{
		list = new ArrayList<item>();
	}
	
	// s.addItem("gum", .45);
	public void addItem(String name, double price)
	{
		list.add(new item(name, price));
	}
	
	public double total()
	{
		double sum = 0;
		for (int i=0; i<list.size(); i++)
			sum += list.get(i).getPrice();
		return sum;
	}
	
	public String CartInfo()
	{
		String Info = "";
		for(int i = 0; i < list.size(); i++)
		{
			Info = Info + list.get(i).getDetails();
		}
		return Info;
	
	}
	
	
}
