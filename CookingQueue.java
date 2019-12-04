package Project3;

public interface CookingQueue
{
	public boolean HasNext();
	public Object Next();
}

class CookingIterator implements CookingQueue
{
	Ingredients[] recipes;
	int position;
	
	public CookingIterator(Ingredients[] recipes)
	{
		this.recipes = recipes;
		position = 0;
	}
	
	public boolean HasNext()
	{
		return recipes.length < position;
	}
	
	public Ingredients Next()
	{
		return recipes[position++];
	}
}