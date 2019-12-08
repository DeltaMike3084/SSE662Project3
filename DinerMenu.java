package Project3;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

public class DinerMenu extends Menu {
    Clock clock;

    public DinerMenu() {
        this.clock = Clock.systemDefaultZone();
    }

    public DinerMenu(Clock clock) {
        this.clock = clock;
    }

    @Override
    protected Ingredients[] generateAvailableMenuItems() {
        Recipes recipes = new Recipes();
        Ingredients[] currentItems = recipes.GetRecipes(Recipes.MenuTypes.Regular);
        LocalTime currentTime = LocalTime.from(clock.instant().atZone(ZoneId.systemDefault()));
        LocalTime endBreakfastTime = LocalTime.of(10, 30, 0);

        if (currentTime.compareTo(endBreakfastTime) <= 0)
        {
            this.menuTitle = "Breakfast Menu";
            currentItems = recipes.GetRecipes(Recipes.MenuTypes.Breakfast);
        }

        return currentItems;
    }
}
