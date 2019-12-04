package Project3;

public class Recipes
{
	public enum MenuTypes
	{
		Regular,
		Vegetarian,
		Breakfast
	}
	
	public static Ingredients[] GetRecipes(MenuTypes menuType)
	{
		Recipe mi = new Recipe();
		
		switch(menuType)
		{
		case Regular:
			return new Ingredients[] { mi.BasicChicken(), mi.BasicFish(), mi.SpicyBeef() };
		case Vegetarian:
			return new Ingredients[] { mi.SpicyChickpeas(), mi.SpicyPaneer() };
		case Breakfast:
			return new Ingredients[] { mi.BasicBacon(), mi.BasicEggs() };
		default:
			return new Ingredients[] {};
		}
	}
}