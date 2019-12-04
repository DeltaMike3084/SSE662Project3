package Project3;

import java.util.ArrayList;

public class Devices
{
	public interface Observer
	{
		void Update(String status);
	}
	
	private ArrayList<Observer> devices = new ArrayList<Observer>();
	
	public void UpdateDevices(String status)
	{
		for(Observer o : devices)
		{
			o.Update(status);
		}
	}
	
	public void AddDevice(Observer device)
	{
		devices.add(device);
	}
	
	public void RemoveDevice(Observer device)
	{
		devices.remove(device);
	}
}

class Device implements Devices.Observer
{
	ArrayList<String> statusHistory = new ArrayList<String>();
	
	@Override
	public void Update(String status)
	{
		statusHistory.add(status);
	}
	
	public String Status()
	{
		return statusHistory.get(statusHistory.size() - 1);
	}
	
	public void History()
	{
		for(String s : statusHistory)
		{
			System.out.println(s);
		}
	}
}