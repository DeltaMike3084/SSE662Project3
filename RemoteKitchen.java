package Project3;

interface Command
{
	public String Execute();
}

class Stove
{
	int temperature;
	
	public Stove()
	{
		temperature = 425;
	}
	
	public String TurnOn()
	{
		return "Stove turned on to " + temperature + " degrees";
	}
	
	public String TurnOff()
	{
		return "Stove turned off";
	}
	
	public String SetTemperature(int temp)
	{
		temperature = temp;
		return "Stove is now set to " + temp + " degrees";
	}
}

class StoveOnCommand implements Command
{
	Stove stove;
	
	StoveOnCommand(Stove stove)
	{
		this.stove = stove;
	}
	
	public String Execute()
	{
		return stove.TurnOn();
	}
}

class StoveOffCommand implements Command
{
	Stove stove;
	
	StoveOffCommand(Stove stove)
	{
		this.stove = stove;
	}
	
	public String Execute()
	{
		return stove.TurnOff();
	}
}

class StoveSetTemperatureCommand implements Command
{
	Stove stove;
	int temperature;
	
	StoveSetTemperatureCommand(Stove stove, int temperature)
	{
		this.stove = stove;
		this.temperature = temperature;
	}
	
	public String Execute()
	{
		return stove.SetTemperature(temperature);
	}
}

public class RemoteKitchen
{
	Command[] commands = new Command[2];
	
	public void setCommand(Command command, int index)
	{
		if(index >= commands.length || index < 0)
			return;
		
		commands[index] = command;
	}
	
	public String Activate(int index)
	{
		return commands[index].Execute();
	}
	
	
}