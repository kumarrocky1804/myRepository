package DesignPatterns.BehaviouralDesignPattern;
/*
 * Used when you need to encapsulate request to a command. Frequently used where we need to 
 * support commands undo/redo, history etc. operations
 * link- https://www.geeksforgeeks.org/command-pattern/
 * 
 * Behavioural design pattern.
 * 
 * Use When - 
 * In order to separate the requester making the request (the sender) from the object executing it, 
 * use the Command Pattern.
 * If you need to support undo and redo operations in your application, the Command Pattern is a good fit.
 */
interface Command{
	void execute();
}

interface Device{
	void turnOn();
	void turnOff();
}

class TurnOnCommand implements Command{
	private Device device;
	
	public TurnOnCommand(Device device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.turnOn();
	}	
}

class TurnOffCommand implements Command{
	private Device device;
	
	public TurnOffCommand(Device device) {
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.turnOff();
	}	
}

class ChangeChannelComamnd implements Command{
	private TV tv;
	
	public ChangeChannelComamnd(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.changeChannel();		
	}
}

class TV implements Device{

	@Override
	public void turnOn() {
		System.out.println("TV is turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("TV is turned off");
	}
	
	public void changeChannel()
	{
		System.out.println("Channel of TV changed");
	}
}

class Remote
{
	private Command command;
	
	public void setCommand(Command command)
	{
		this.command = command;
	}
	
	public void pressButton() {
		command.execute();
	}
}

public class CommandPatterndemo 
{
	public static void main(String args[])
	{
		// Here we can dynamically create commands and keep a record of them too in case we need a history of them.
		TV tv = new TV();
		
		Command TVturnOnCommand = new TurnOnCommand(tv);
		Command TVturnOffCommand = new TurnOffCommand(tv);
		Command TVChangeChannelCommand = new ChangeChannelComamnd(tv);
		
		Remote r = new Remote();
		
		r.setCommand(TVturnOnCommand);
		r.pressButton();
		
		r.setCommand(TVturnOffCommand);
		r.pressButton();
		
		r.setCommand(TVChangeChannelCommand);
		r.pressButton();
	}	
}
