public class Philosopher
{

	private int state;
	private String name;
	
	public Philosopher(int state, String name)
	{
		//3 states - ready, waiting, active (hungry, thinking, eating)
		this.state = state;
		//The philosopher's name as a string
		this.name = name;
	}
	//Returns which state the philosopher is currently in
	public String getState()
	{
		if(state == 1)
		{
			return "Thinking";
		}
		if(state == 2)
		{
			return "Eating";
		}
		if(state > 2)
		{
			return "Invalid state";
		}
		return "Hungry";
	}
	//Returns the philosopher's name
	public String getName()
	{
		return name;
	}
	//Sets the state to the specified state.
	public void setState(int newState)
	{
		this.state = newState;
	}
}