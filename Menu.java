package Project3;

public abstract class Menu {
    String menuTitle = "Menu";
    String menuDivider = "--------------------------------------------------------------------------------";

    public String displayMenu() {
        Ingredients[] menuItems = generateAvailableMenuItems();

        String menuString = "" + menuTitle;

        System.out.println(menuTitle);
        for (int i = 0; i < menuItems.length; i++)
        {
            menuString = menuString + "\n";
            menuString = menuString + menuDivider +"\n";
            menuString = menuString +
                    (i + 1) +
                    ": " +
                    menuItems[i].Description();
        }

        return menuString;
    }

    protected abstract Ingredients[] generateAvailableMenuItems();
}
