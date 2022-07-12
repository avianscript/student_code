package EcommerceMachine;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class Menus {

    Processor processor = new Processor();
    Scanner userInput = new Scanner(System.in);

    private static final String mainMenuProdInfo = "(1) View product information";
    private static final String mainMenuPrintOut = "(2) Print recommendations";
    private static final String mainMenuAddProd = "(3) Add product";
    private static final String mainMenuExit = "(4) Exit program";
    private static final String viewProdMenuList = "(1) List all products";
    private static final String viewProdMenuSearch = "(2) Search products by keyword";
    private static final String returnToMainMenu = "(R)eturn to main menu";
    private static final String recommendationsMenuRecommendations = "(1) Assign profit margin and see recommendations";
    private static final String addProdMenuInput = "(1) Input new product details";

    public Menus() throws FileNotFoundException {
    }

    public void mainMenu() {
        System.out.println(mainMenuProdInfo);
        System.out.println(mainMenuPrintOut);
        System.out.println(mainMenuAddProd);
        System.out.println(mainMenuExit);
        System.out.print("Please select an option: ");
    }

    public void prodMenu() {
        System.out.println(viewProdMenuList);
        System.out.println(viewProdMenuSearch);
        System.out.println(returnToMainMenu);
        System.out.print("Please select an option: ");
    }

    public void mainMenuRun() {
        String menuInput = "";
        while (!menuInput.equals("4")) {
            mainMenu();
            menuInput = userInput.nextLine();
            if (menuInput.equals("1")) {
                viewProdMenu();
                continue;
            } else if (menuInput.equals("2")) {
                recommendationsMenu();
                continue;
            } else if (menuInput.equals("3")) {
                addProdMenu();
                continue;
            }
        }
        System.out.println("Thanks. Goodbye.");
    }

    public void viewProdMenu() {
        String prodMenuInput = "";
        while (!prodMenuInput.equals("R")) {
            prodMenu();
            prodMenuInput = userInput.nextLine();
            if (prodMenuInput.equals("1")) {
                processor.printProducts();
                continue;
            } else if (prodMenuInput.equals("2")) {
                System.out.println("Please input a search term: ");
                String searchTerm = userInput.nextLine();
                processor.keywordSearch(searchTerm);
                continue;
            }
            }
        }


    public void recommendationsMenu() {
        System.out.println(recommendationsMenuRecommendations);
        System.out.println(returnToMainMenu);
        System.out.print("Please select an option: ");
        String recMenuInput = userInput.nextLine();
            if (recMenuInput.equals("1")) {
                processor.printRecs();
            }
    }

    public void addProdMenu() {
        System.out.println(addProdMenuInput);
        System.out.println(returnToMainMenu);
        System.out.print("Select an option: ");
        String addProdMenuSelection = userInput.nextLine();
            if (addProdMenuSelection.equals("1")) {
                processor.newInputProduct();
            }
        }
}


