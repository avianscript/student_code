package EcommerceMachine;

public class Menus {

private static final String mainMenuProdInfo = "(1) View product information";
private static final String mainMenuPrintOut = "(2) Print recommendations";
private static final String mainMenuAddProd = "(3) Add product";
private static final String mainMenuExit = "(4) Exit program";
private static final String viewProdMenuList = "(1) List all products";
private static final String viewProdMenuSearch = "(2) Search products by keyword";
private static final String returnToMainMenu = "(R)eturn to main menu";
private static final String recommendationsMenuRecommendations = "(1) Assign profit margin and see recommendations";
private static final String addProdMenuInput = "(1) Input new product details";


public void mainMenu () {
    System.out.println(mainMenuProdInfo);
    System.out.println(mainMenuPrintOut);
    System.out.println(mainMenuAddProd);
    System.out.println(mainMenuExit);
}

public void viewProdMenu () {
    System.out.println(viewProdMenuList);
    System.out.println(viewProdMenuSearch);
    System.out.println(returnToMainMenu);
}

public void recommendationsMenu () {
    System.out.println(recommendationsMenuRecommendations);
    System.out.println(returnToMainMenu);
}

public void addProdMenu () {
    System.out.println(addProdMenuInput);
    System.out.println(returnToMainMenu);
}

}
