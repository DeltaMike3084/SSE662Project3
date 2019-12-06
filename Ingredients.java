package Project3;

public interface Ingredients
{
	public String Description();
}

class Chicken implements Ingredients
{
	@Override
	public String Description()
	{
		return "Chicken";
	}
}

class Beef implements Ingredients
{
	@Override
	public String Description()
	{
		return "Beef";
	}
}

class Fish implements Ingredients
{
	@Override
	public String Description()
	{
		return "Fish";
	}
}

class Bacon implements Ingredients
{
	@Override
	public String Description()
	{
		return "Bacon";
	}
}

class Paneer implements Ingredients
{
	@Override
	public String Description()
	{
		return "Paneer";
	}
}

class Chickpeas implements Ingredients
{
	@Override
	public String Description()
	{
		return "Chickpeas";
	}
}

class Eggs implements Ingredients
{
	@Override
	public String Description()
	{
		return "Eggs";
	}
}

abstract class Seasoning implements Ingredients
{
	Ingredients recipe;
	protected String description = "";
	
	public Seasoning(Ingredients recipe)
	{
		this.recipe = recipe;
		setDescription();
	}
	
	@Override
	public String Description()
	{
		return recipe.Description() + formatDescription() + this.description;
	}

	abstract void setDescription();

	private String formatDescription() {
		String contextFormat = "";

		if (recipe.getClass().getSuperclass() != this.getClass().getSuperclass())
			contextFormat = " with ";
		else
			contextFormat = ", ";

		return contextFormat;
	}

}

class Cayenne extends Seasoning
{

	public Cayenne(Ingredients recipe) {
		super(recipe);
	}

	@Override
	void setDescription() {
		this.description = "cayenne pepper";
	}
}

class Salt extends Seasoning
{
	public Salt(Ingredients recipe)
	{
		super(recipe);
	}

	@Override
	void setDescription() {
		this.description = "salt";
	}
}

class Pepper extends Seasoning
{
	public Pepper(Ingredients recipe)
	{
		super(recipe);
	}

	@Override
	void setDescription() {
		this.description = "pepper";
	}
}

class Garlic extends Seasoning
{
	public Garlic(Ingredients recipe)
	{
		super(recipe);
	}

	@Override
	void setDescription() {
		this.description = "garlic";
	}
}

class Paprika extends Seasoning
{
	public Paprika(Ingredients recipe)
	{
		super(recipe);
	}

	@Override
	void setDescription() {
		this.description = "paprika";
	}
}