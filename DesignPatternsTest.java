package Project3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project3.Recipes.MenuTypes;

import java.time.*;

class DesignPatternsTest
{
	@Test
	void DecoratorTest()
	{
		Seasoning all = new Salt(new Pepper(new Cayenne(new Garlic(new Paprika(new Beef())))));
		Seasoning chicken = new Salt(new Pepper(new Chicken()));
		Seasoning fish = new Paprika(new Fish());
		Seasoning chickpeas = new Salt(new Chickpeas());
		Seasoning paneer = new Pepper(new Paneer());
		Seasoning eggs = new Salt(new Pepper(new Eggs()));
		Seasoning bacon = new Salt(new Bacon());
		
		assertEquals(all.Description(), ("Beef with paprika, garlic, cayenne pepper, pepper, salt"));
		assertEquals(chicken.Description(), ("Chicken with pepper, salt"));
		assertEquals(fish.Description(), ("Fish with paprika"));
		assertEquals(chickpeas.Description(), ("Chickpeas with salt"));
		assertEquals(paneer.Description(), ("Paneer with pepper"));
		assertEquals(eggs.Description(), ("Eggs with pepper, salt"));
		assertEquals(bacon.Description(), ("Bacon with salt"));
		assertEquals(("Beef"), (new Beef()).Description());
		assertEquals(("Chicken"), (new Chicken()).Description());
		assertEquals(("Fish"), (new Fish()).Description());
		assertEquals(("Chickpeas"), (new Chickpeas()).Description());
		assertEquals(("Paneer"), (new Paneer()).Description());
		assertEquals(("Eggs"), (new Eggs()).Description());
		assertEquals(("Bacon"), (new Bacon()).Description());
	}
	
	@Test
	void FacadeTest()
	{
		Recipe recipe = new Recipe();
		assert(recipe.BasicChicken().Description().equals("Chicken with pepper, salt"));
		assert(recipe.SpicyBeef().Description().equals("Beef with cayenne pepper, paprika, pepper, salt"));
		assert(recipe.BasicFish().Description().equals("Fish with paprika, pepper, salt"));
		assert(recipe.SpicyChickpeas().Description().equals("Chickpeas with cayenne pepper, garlic, pepper, salt"));
		assert(recipe.SpicyPaneer().Description().equals("Paneer with cayenne pepper, garlic, pepper, salt"));
		assert(recipe.BasicBacon().Description().equals("Bacon with salt"));
		assert(recipe.BasicEggs().Description().equals("Eggs with salt, pepper"));
		
	}
	
	@Test
	void FactoryTest()
	{
		// Iterate over all enums
		for(MenuTypes mt : MenuTypes.values())
		{
			// Iterate over all menu items for each enum
			for(Ingredients i : Recipes.GetRecipes(mt))
			{
				// Assert the description is not null
				assertNotNull(i.Description());
			}
		}

		System.out.println(LocalTime.now());
		Menu dinerMenu = new DinerMenu();
		dinerMenu.displayMenu();
		// Test concrete Creator class implementing the Factory Method design pattern
		Clock testClock;
		// Test DinerMenu for breakfast
		String expectedBreakfastMenu = "Breakfast Menu\n" +
				"--------------------------------------------------------------------------------\n" +
				"1: Bacon with salt\n" +
				"--------------------------------------------------------------------------------\n" +
				"2: Eggs with salt, pepper";
		testClock = Clock.fixed(
				Instant.from(
						LocalDateTime.of(2019, 12, 7, 8, 30, 0)
								.atZone(ZoneId.systemDefault())
								.toInstant()),
				ZoneId.systemDefault());
		DinerMenu testBreakfastMenu = new DinerMenu(testClock);
		assertEquals(expectedBreakfastMenu, testBreakfastMenu.displayMenu());

		// Test DinerMenu for normal menu
		String expectedNormalMenu = "Menu\n" +
				"--------------------------------------------------------------------------------\n" +
				"1: Chicken with pepper, salt\n" +
				"--------------------------------------------------------------------------------\n" +
				"2: Fish with paprika, pepper, salt\n" +
				"--------------------------------------------------------------------------------\n" +
				"3: Beef with cayenne pepper, paprika, pepper, salt";
		testClock = Clock.fixed(
				Instant.from(
						LocalDateTime.of(2019, 12, 7, 12, 30, 0)
								.atZone(ZoneId.systemDefault())
								.toInstant()),
				ZoneId.systemDefault());
		DinerMenu testNormalMenu = new DinerMenu(testClock);
		assertEquals(expectedNormalMenu, testNormalMenu.displayMenu());



	}
	
	@Test
	void IteratorTest()
	{
		Recipe r = new Recipe();
		Ingredients[] recipes = new Ingredients[] { r.BasicBacon(), r.BasicEggs(), r.SpicyChickpeas() };
		
		CookingIterator cq = new CookingIterator(recipes);
		
		int index = 0;
		while(cq.HasNext())
		{
			assertEquals(recipes[index].Description(), cq.Next().Description());
			index++;
		}
	}
	
	@Test
	void ObserverTest()
	{
		String[] testStrings = new String[] 
		{
			"This is a test", 
			"This is also a test"
		};
		
		Devices devices = new Devices();
		Device[] deviceList = new Device[5];
		
		for(int i = 0; i < deviceList.length; i++)
		{
			deviceList[i] = new Device();
			devices.AddDevice(deviceList[i]);
		}
		
		devices.UpdateDevices(testStrings[0]);

		for(Device device : deviceList)
		{
			assert(device.Status().equals(testStrings[0]));
		}
		
		devices.UpdateDevices(testStrings[1]);
		
		for(Device device : deviceList)
		{
			int index = 0;
			for(String s : device.statusHistory)
			{
				assert(s.equals(testStrings[index++]));
			}
		}
	}
	
	@Test
	void CommandTest()
	{
		RemoteKitchen remote = new RemoteKitchen();
		Stove stove = new Stove();
		int stoveTemp = 350;
		
		remote.setCommand(new StoveOnCommand(stove), 0);
		remote.setCommand(new StoveSetTemperatureCommand(stove, 350), 1);
		
		assertEquals("Stove is now set to " + stoveTemp + " degrees", remote.Activate(1));
		assertEquals("Stove turned on to " + stoveTemp + " degrees", remote.Activate(0));
		
		remote.setCommand(new StoveOffCommand(stove), 0);
		
		assertEquals("Stove turned off", remote.Activate(0));
	}
}