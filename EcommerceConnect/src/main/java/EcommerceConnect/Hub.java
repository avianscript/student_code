package EcommerceConnect;

import java.io.*;
import java.util.Scanner;



public class Hub extends CalculationMethods {
    static Scanner scanner = new Scanner(System.in);


    public static double inputSourcePrice;
    static double desiredProfitMargin;
    static double handlingCost;
    static double sellAtPrice;
    static double salePrice;

    public Hub() throws IOException {
    }

    public static void newProduct() throws FileNotFoundException {
        System.out.print("Please enter a name for the product: ");
        String newProductName = scanner.nextLine();
        System.out.print("Sourcing price for the item: ");
        String newProductSourcePrice = scanner.nextLine();
        System.out.print("Handling cost: ");
        String newProductHandling = scanner.nextLine();
        System.out.print("Typical sale price: ");
        String newProductSalePrice = scanner.nextLine();

        try (PrintWriter printWriter = new PrintWriter (new FileOutputStream(new File("Inventory.txt"), true))) {
            String newProductCat = newProductName + ", " + newProductSourcePrice + ", " + newProductHandling + ", " + newProductSalePrice;
            printWriter.println(newProductCat);
        } catch (FileNotFoundException exception) {
            System.out.println("File not Found");
        }
        run();
    }

    public static void run() throws FileNotFoundException {
        System.out.println("(1) Add Product" + "\n" + "(2) Calculator");
        String firstMenuInput = scanner.nextLine();
        if (firstMenuInput.equals("1")) {
            newProduct();
        } else {


            System.out.print("Source Price: ");
            inputSourcePrice = Double.parseDouble(scanner.nextLine());
            System.out.print("On Sale Price: ");
            salePrice = Double.parseDouble(scanner.nextLine());
            System.out.println("(1) Create Sell Price based on set margin against Source Price");
            System.out.println("(2) See current Profit Margin against Source Price");
            System.out.print("Please enter a selection: ");
            String menuSelection1 = scanner.nextLine();
            if (menuSelection1.equals("1")) {
                System.out.print("Please set the desired Profit Margin against Source Price: ");
                String menuSelection2 = scanner.nextLine();
                desiredProfitMargin = Integer.parseInt(menuSelection2) * 1.0;
                System.out.print("Handling Costs: ");
                handlingCost = Integer.parseInt(scanner.nextLine()) * 1.0;
                System.out.println("The Sell Price for this item should be: " + CalculationMethods.sellAtPrice());
                if (!listOrNot()) {
                    System.out.println("This sell-at price is higher than the typical sale price. Don't list.");
                    run();
                } else {
                    System.out.println("This sell-at price is equal to or less than the typical sale price. List!");
                    System.out.println("Your profit value from this item would be: $" + calcProfitValue());
                    run();
                }
            } else {
                System.out.print("Sell-At Price: ");
                String sellPrice = scanner.nextLine();
                sellAtPrice = Integer.parseInt(sellPrice) * 1.0;
                System.out.print("Handling Costs: ");
                handlingCost = Integer.parseInt(scanner.nextLine()) * 1.0;
                System.out.println("Current Profit Margin is: " + calcProfit());
                run();
            }
        }
    }

//    @Override
//    public void setCreatePrice() {
//        super.setCreatePrice();
//        double createPrice = Double.parseDouble(scanner.nextLine());
//
//    }

    public static void main(String[] args) throws FileNotFoundException {
run();
//        newProduct();


    }
}

