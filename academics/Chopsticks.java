public class Chopsticks
{
	//Class for chopsticks
	private int Stick;
	private boolean inUse;
	public Chopsticks( boolean inUse)
	{
		//Creates one chopstick and tracks its state
		this.inUse = inUse;
	}
	public void setState(boolean inUse)
	{
		this.inUse = inUse;
	}
	public boolean getState()
	{
		return inUse;
	}
	
}