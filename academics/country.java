import java.io.*;
import java.util.*;

public class country
{

	//Variables.
	private int troops;
	private ArrayList Adjacent;
	private String Name;
	private String PlayerName;
	
	public country(ArrayList Adjacent, int troops, String Name, String PlayerName)
	{
		//Lists adjacent countries
		this.Adjacent = Adjacent;
		//total troops currently in the country
		this.troops = troops;
		//Name of the country
		this.Name = Name;
		//Player that currently controls the country
		this.PlayerName = PlayerName;
	}
	
	//Get/Set methods.
	public ArrayList getAdjacent()
	{
		return Adjacent;
	}
	
	public void setAdjacent(country x)
	{
		this.Adjacent.add(x);
	}
	public int getTroops()
	{
		return troops;
	}
	public void setTroops(int x)
	{
		this.troops+=x;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public String getPlayerName()
	{
		return PlayerName;
	}
	public void setPlayerName(String PlayerName)
	{
		this.PlayerName = PlayerName;
	}
}