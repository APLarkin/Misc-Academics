<<<<<<< HEAD
import java.util.*;
import java.io.*;

//After struggling to get the code given in the handout to work I eventually just said screw it and decided to use threads the way I already knew how to. So I know that it won't function exactly as required, but I believe that my methodology is correct.

public class DiningPhilosophers
{
	//Creating instances of the philosophers
	static Philosopher Descartes = new Philosopher(0, "Descartes");
	static Philosopher Rousseau = new Philosopher(0, "Rousseau");
	static Philosopher Socrates = new Philosopher(0, "Socrates");
	static Philosopher Aristotle = new Philosopher(0, "Aristotle");
	static Philosopher Hobbes = new Philosopher(0, "Hobbes");
	
	//Chopsticks
	static Chopsticks DesRou = new Chopsticks(false);
	static Chopsticks RouSoc = new Chopsticks(false);
	static Chopsticks SocAri = new Chopsticks(false);
	static Chopsticks AriHob = new Chopsticks(false);
	static Chopsticks HobDes = new Chopsticks(false);
			
			
	//Threads for each philosopher
	static DescActivity Desc = new DescActivity();
	static RousActivity Rous = new RousActivity();
	static SocrActivity Socr = new SocrActivity();
	static ArisActivity Aris = new ArisActivity();
	static HobbActivity Hobb = new HobbActivity();
	
	public static void main(String[] args)
	{
		boolean exit = false;
		//Keeps the main method in a permanent loop until the user says to exit
		while(exit != true)
		{
			Desc.run();
			Rous.run();
			Socr.run();
			Aris.run();
			Hobb.run();
			if(exit == true)
			{
				break;
			}

		}
		
	}
	//Contents of the thread
	//Would have preferred a more general approach, but this seemed easier at the time
	//DesRou/HobDes
	public static class DescActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Descartes.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Descartes.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(DesRou.getState() == true || HobDes.getState() == true)
					{
						Descartes.setState(1);
						System.out.println(Descartes.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(DesRou.getState() == false && HobDes.getState() == false)
					{
						Descartes.setState(2);
						System.out.println(Descartes.getState());
						//Picks up chopsticks, sets both to in-use
						DesRou.setState(true);
						HobDes.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				DesRou.setState(false);
				HobDes.setState(false);
			
			}
		}
	}
	public static class RousActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Rousseau.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Rousseau.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(DesRou.getState() == true || RouSoc.getState() == true)
					{
						Rousseau.setState(1);
						System.out.println(Rousseau.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(DesRou.getState() == false && RouSoc.getState() == false)
					{
						Rousseau.setState(2);
						System.out.println(Rousseau.getState());
						//Picks up chopsticks, sets both to in-use
						DesRou.setState(true);
						RouSoc.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				DesRou.setState(false);
				RouSoc.setState(false);
			}
		}
	}
	public static class SocrActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Socrates.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Socrates.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(SocAri.getState() == true || RouSoc.getState() == true)
					{
						Socrates.setState(1);
						System.out.println(Socrates.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(SocAri.getState() == false && RouSoc.getState() == false)
					{
						Socrates.setState(2);
						System.out.println(Socrates.getState());
						//Picks up chopsticks, sets both to in-use
						SocAri.setState(true);
						RouSoc.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				SocAri.setState(false);
				RouSoc.setState(false);
			
			}
		}
	}
	public static class ArisActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
			
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Aristotle.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Aristotle.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(SocAri.getState() == true || AriHob.getState() == true)
					{
						Aristotle.setState(1);
						System.out.println(Aristotle.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(SocAri.getState() == false && AriHob.getState() == false)
					{
						Aristotle.setState(2);
						System.out.println(Aristotle.getState());
						//Picks up chopsticks, sets both to in-use
						SocAri.setState(true);
						AriHob.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				SocAri.setState(false);
				AriHob.setState(false);
			
			}
		}
	}
	public static class HobbActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Hobbes.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Hobbes.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(HobDes.getState() == true || AriHob.getState() == true)
					{
						Hobbes.setState(1);
						System.out.println(Hobbes.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(HobDes.getState() == false && AriHob.getState() == false)
					{
						Hobbes.setState(2);
						System.out.println(Hobbes.getState());
						//Picks up chopsticks, sets both to in-use
						HobDes.setState(true);
						AriHob.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				HobDes.setState(false);
				AriHob.setState(false);
			}
		}
	}
	
	public interface DiningServer
	{
		//Called when philosopher wants to eat
		public void takeForks(int philNumber);
		//Called when philosopher is finished eating
		public void returnForks(int philNumber);
	}
	
}
/*
//None of this stuff works at all
public class  DiningPhilosophersMonitor
{
	enum State {THINKING, HUNGRY, EATING};
	State[] states = new State[5];
	Condition[] self = new Condition[5];
		
	public DiningPhilosophers
	{
		for(int i = 0; i < 5; i++)
		{
			state[i] = State.THINKING;
		}
	}
		
	public void takeForks(int i)
	{
		state[i] = State.HUNGRY;
		test(i);
		if(state[i] != State.EATING)
		{
			self[i].wait;
		}
	}
		
	public void returnForks(int i)
	{
		state[i] = State.THINKING;
		//test left and right
		test((i+4) % 5);
		test((i+1) % 5);
			
	}
		
	private void test(int i)
	{
		if((state[(i+4) % 5] != State.EATING) && (state[i] == State.HUNGRY) && (state[(i+1)%5 != State.EATING))
		{
			state[i] = State.EATING;
			self[i].signal;
		}
	}		
}
=======
import java.util.*;
import java.io.*;

//After struggling to get the code given in the handout to work I eventually just said screw it and decided to use threads the way I already knew how to. So I know that it won't function exactly as required, but I believe that my methodology is correct.

public class DiningPhilosophers
{
	//Creating instances of the philosophers
	static Philosopher Descartes = new Philosopher(0, "Descartes");
	static Philosopher Rousseau = new Philosopher(0, "Rousseau");
	static Philosopher Socrates = new Philosopher(0, "Socrates");
	static Philosopher Aristotle = new Philosopher(0, "Aristotle");
	static Philosopher Hobbes = new Philosopher(0, "Hobbes");
	
	//Chopsticks
	static Chopsticks DesRou = new Chopsticks(false);
	static Chopsticks RouSoc = new Chopsticks(false);
	static Chopsticks SocAri = new Chopsticks(false);
	static Chopsticks AriHob = new Chopsticks(false);
	static Chopsticks HobDes = new Chopsticks(false);
			
			
	//Threads for each philosopher
	static DescActivity Desc = new DescActivity();
	static RousActivity Rous = new RousActivity();
	static SocrActivity Socr = new SocrActivity();
	static ArisActivity Aris = new ArisActivity();
	static HobbActivity Hobb = new HobbActivity();
	
	public static void main(String[] args)
	{
		boolean exit = false;
		//Keeps the main method in a permanent loop until the user says to exit
		while(exit != true)
		{
			Desc.run();
			Rous.run();
			Socr.run();
			Aris.run();
			Hobb.run();
			if(exit == true)
			{
				break;
			}

		}
		
	}
	//Contents of the thread
	//Would have preferred a more general approach, but this seemed easier at the time
	//DesRou/HobDes
	public static class DescActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Descartes.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Descartes.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(DesRou.getState() == true || HobDes.getState() == true)
					{
						Descartes.setState(1);
						System.out.println(Descartes.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(DesRou.getState() == false && HobDes.getState() == false)
					{
						Descartes.setState(2);
						System.out.println(Descartes.getState());
						//Picks up chopsticks, sets both to in-use
						DesRou.setState(true);
						HobDes.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				DesRou.setState(false);
				HobDes.setState(false);
			
			}
		}
	}
	public static class RousActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Rousseau.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Rousseau.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(DesRou.getState() == true || RouSoc.getState() == true)
					{
						Rousseau.setState(1);
						System.out.println(Rousseau.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(DesRou.getState() == false && RouSoc.getState() == false)
					{
						Rousseau.setState(2);
						System.out.println(Rousseau.getState());
						//Picks up chopsticks, sets both to in-use
						DesRou.setState(true);
						RouSoc.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				DesRou.setState(false);
				RouSoc.setState(false);
			}
		}
	}
	public static class SocrActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Socrates.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Socrates.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(SocAri.getState() == true || RouSoc.getState() == true)
					{
						Socrates.setState(1);
						System.out.println(Socrates.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(SocAri.getState() == false && RouSoc.getState() == false)
					{
						Socrates.setState(2);
						System.out.println(Socrates.getState());
						//Picks up chopsticks, sets both to in-use
						SocAri.setState(true);
						RouSoc.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				SocAri.setState(false);
				RouSoc.setState(false);
			
			}
		}
	}
	public static class ArisActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
			
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Aristotle.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Aristotle.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(SocAri.getState() == true || AriHob.getState() == true)
					{
						Aristotle.setState(1);
						System.out.println(Aristotle.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(SocAri.getState() == false && AriHob.getState() == false)
					{
						Aristotle.setState(2);
						System.out.println(Aristotle.getState());
						//Picks up chopsticks, sets both to in-use
						SocAri.setState(true);
						AriHob.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				SocAri.setState(false);
				AriHob.setState(false);
			
			}
		}
	}
	public static class HobbActivity extends Thread
	{
		int WaitTime = 0;
		public void run()
		{
			//Infinite loop
			while(true)
			{
				//Resets to hungry after each wait regardless of whether or not chopsticks are in use
				Hobbes.setState(0);
				//Random period of time to wait in the event of a wait
				WaitTime = 0 + (int)(Math.random() * ((2000 - 0) + 0));
				//Checks if guy is hungry
				if(Hobbes.getState().equals("Hungry"))
				{
					//If either chopstick is in use, go to think mode
					if(HobDes.getState() == true || AriHob.getState() == true)
					{
						Hobbes.setState(1);
						System.out.println(Hobbes.getState());
						//Waits in think mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
					//If neither chopstick is in use, go to eat mode
					if(HobDes.getState() == false && AriHob.getState() == false)
					{
						Hobbes.setState(2);
						System.out.println(Hobbes.getState());
						//Picks up chopsticks, sets both to in-use
						HobDes.setState(true);
						AriHob.setState(true);
						//Waits in eat mode
						try{
							sleep(WaitTime);
						}catch(Exception InterruptedException){}
					}
				}
				//Wait again for good measure before setting chopsticks back
				try{
					sleep(WaitTime);
				}catch(Exception InterruptedException){}
				//replaces chopsticks
				HobDes.setState(false);
				AriHob.setState(false);
			}
		}
	}
	
	public interface DiningServer
	{
		//Called when philosopher wants to eat
		public void takeForks(int philNumber);
		//Called when philosopher is finished eating
		public void returnForks(int philNumber);
	}
	
}
/*
//None of this stuff works at all
public class  DiningPhilosophersMonitor
{
	enum State {THINKING, HUNGRY, EATING};
	State[] states = new State[5];
	Condition[] self = new Condition[5];
		
	public DiningPhilosophers
	{
		for(int i = 0; i < 5; i++)
		{
			state[i] = State.THINKING;
		}
	}
		
	public void takeForks(int i)
	{
		state[i] = State.HUNGRY;
		test(i);
		if(state[i] != State.EATING)
		{
			self[i].wait;
		}
	}
		
	public void returnForks(int i)
	{
		state[i] = State.THINKING;
		//test left and right
		test((i+4) % 5);
		test((i+1) % 5);
			
	}
		
	private void test(int i)
	{
		if((state[(i+4) % 5] != State.EATING) && (state[i] == State.HUNGRY) && (state[(i+1)%5 != State.EATING))
		{
			state[i] = State.EATING;
			self[i].signal;
		}
	}		
}
>>>>>>> origin/master
*/