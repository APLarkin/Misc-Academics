
public class SomeClassDriver
{

	public static void main(String[] args)
	{
		SomeClass a = new SomeClass(44, "hello");
		SomeClass b = new SomeClass(22, "hello");
		
		System.out.println(a.getX());
		
		a.setX(77);
		a.addStuffToList(4);
		a.addStuffToList(54);
		a.addStuffToList(34);
		a.addStuffToList(14);
		
		System.out.println(a.getList());
		a = new SomeClass(44, "goodbye");
		
		System.out.println(a.getList());
		
		System.out.println(a);
		
		if (a.equals(b))
			System.out.println("EQUAL");
		
	}

}
