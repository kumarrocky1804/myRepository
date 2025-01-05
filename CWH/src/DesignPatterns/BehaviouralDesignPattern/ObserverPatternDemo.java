package DesignPatterns.BehaviouralDesignPattern;
/* This pattern is used when a lot of objects are dependent upon one object's state. For ex.-
 * Cricbuzz has to update everything when cricketData is updated.
 * 
 * This pattern is heavily used in java for GUI listeners.
 * 
 * Behavioral Design Pattern
 */

import java.util.ArrayList;
import java.util.Iterator;

interface Observer
{
	public void update(int runs, int overs, int wickets);
}

class CricketData
{
	int runs;
	int overs;
	int wickets;
	
	ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	public void addObserver(Observer ob)
	{
		observerList.add(ob);
	}
	
	public void deleteObserver(Observer ob)
	{
		observerList.remove(ob);
	}
	
	private void notifyUpdateToAllObservers()
	{
		Iterator<Observer> it = observerList.iterator();
		while(it.hasNext())
		{
			Observer ob = it.next();
			ob.update(this.runs, this.overs, this.wickets);
		}
	}
	
	public void updateData(int runs, int overs, int wickets)
	{
		// First update data
		this.runs = runs;
		this.overs = overs;
		this.wickets = wickets;
		// then call all observers waiting for the data
		notifyUpdateToAllObservers();
	}
}

// Now we will create 2 observers which are 2 scoreboards- 1 for current score and other for avg
class CurrentScoreBoard implements Observer
{
	@Override
	public void update(int runs, int overs, int wickets) 
	{
		System.out.println();
		System.out.println("Current Score is - ");
		System.out.println(runs + "-" + wickets + " in " + overs + " overs.");
	}	
}

class AverageScoreBoard implements Observer
{

	@Override
	public void update(int runs, int overs, int wickets) 
	{
		System.out.println();
		System.out.println("Run rate - " + ((float)runs/overs));
		System.out.println("Predicted Score - " + ((float)((runs/overs)*50)));
	}
}

public class ObserverPatternDemo 
{
	public static void main(String[] args) {
		// create score boards and cricket data
		CurrentScoreBoard currentScore = new CurrentScoreBoard();
		AverageScoreBoard avgScore = new AverageScoreBoard();
		CricketData data = new CricketData();
		
		// register/add all observers
		// Here we can add any number of observers in future without changing code of cricketData
		data.addObserver(currentScore);
		data.addObserver(avgScore);
		
		data.updateData(4, 2, 1);
		
		//data.deleteObserver(avgScore);
		
		data.updateData(160, 32, 5);
		
	}
}
