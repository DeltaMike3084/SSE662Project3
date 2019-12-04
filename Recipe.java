package Project3;

public class Recipe
{
	private Ingredients spicyBeef;
	private Ingredients basicChicken;
	private Ingredients basicFish;
	private Ingredients spicyChickpeas;
	private Ingredients spicyPaneer;
	private Ingredients basicEggs;
	private Ingredients basicBacon;
	
	public Recipe()
	{
		spicyBeef = new Salt(new Pepper(new Paprika(new Cayenne(new Beef()))));
		basicChicken = new Salt(new Pepper(new Chicken()));
		basicFish = new Salt(new Pepper(new Paprika(new Fish())));
		spicyChickpeas = new Salt(new Pepper(new Garlic(new Cayenne(new Chickpeas()))));
		spicyPaneer = new Salt(new Pepper(new Garlic(new Cayenne(new Paneer()))));
		basicEggs = new Pepper(new Salt(new Eggs()));
		basicBacon = new Salt(new Bacon());
		
	}
	
	public Ingredients SpicyBeef()
	{
		return spicyBeef;
	}
	
	public Ingredients BasicChicken()
	{
		return basicChicken;
	}
	
	public Ingredients BasicFish()
	{
		return basicFish;  
	}
	
	public Ingredients SpicyChickpeas()
	{
		return spicyChickpeas;
	}
	
	public Ingredients SpicyPaneer()
	{
		return spicyPaneer;
	}
	
	public Ingredients BasicEggs()
	{
		return basicEggs;
	}
	
	public Ingredients BasicBacon()
	{
		return basicBacon;
	}
}