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
		return "Chicken with";
	}
}

class Beef implements Ingredients
{
	@Override
	public String Description()
	{
		return "Beef with";
	}
}

class Fish implements Ingredients
{
	@Override
	public String Description()
	{
		return "Fish with";
	}
}

class Bacon implements Ingredients
{
	@Override
	public String Description()
	{
		return "Bacon with";
	}
}

class Paneer implements Ingredients
{
	@Override
	public String Description()
	{
		return "Paneer with";
	}
}

class Chickpeas implements Ingredients
{
	@Override
	public String Description()
	{
		return "Chickpeas with";
	}
}

class Eggs implements Ingredients
{
	@Override
	public String Description()
	{
		return "Eggs with";
	}
}

abstract class Seasoning implements Ingredients
{
	Ingredients recipe;
	
	public Seasoning(Ingredients recipe)
	{
		this.recipe = recipe;
	}
	
	@Override
	public String Description()
	{
		return recipe.Description();
	}
}

class Cayenne extends Seasoning
{
	public Cayenne(Ingredients recipe)
	{
		super(recipe);
	}
	
	@Override
	public String Description()
	{
		return super.Description() + " cayenne pepper,";
	}
}

class Salt extends Seasoning
{
	public Salt(Ingredients recipe)
	{
		super(recipe);
	}
	
	@Override
	public String Description()
	{
		return super.Description() + " salt,";
	}
}

class Pepper extends Seasoning
{
	public Pepper(Ingredients recipe)
	{
		super(recipe);
	}
	
	@Override
	public String Description()
	{
		return super.Description() + " pepper,";
	}
}

class Garlic extends Seasoning
{
	public Garlic(Ingredients recipe)
	{
		super(recipe);
	}
	
	@Override
	public String Description()
	{
		return super.Description() + " garlic,";
	}
}

class Paprika extends Seasoning
{
	public Paprika(Ingredients recipe)
	{
		super(recipe);
	}
	
	@Override
	public String Description()
	{
		return super.Description() + " paprika,";
	}
}