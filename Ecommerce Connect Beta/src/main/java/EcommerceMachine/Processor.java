package EcommerceMachine;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Processor {

    public final String listAffirmative = "LIST THIS ITEM! Desired margin places list price well below retail price.";
    public final String listWithCaution = "LIST WITH CAUTION! Desired margin places list price within 5% of retail price.";
    public final String listFalse = "DO NOT LIST! Desired margin places list price well above retail price.";
    public final String listRange = "A list price within 5% of retail price would be ";
    public final String listRangeProfit = "Listing within 5% of retail price would yield a profit margin range of ";

    List<String[]> listOfProducts = new ArrayList<>();
    List<String> recommendations = new ArrayList<>();

    //Scanner for use throughout class
    File csvFilePath = new File("custom_file.csv");
    Scanner fileInput = new Scanner(csvFilePath);
    Scanner userInput = new Scanner(System.in);

    public Processor() throws FileNotFoundException {
    }

    //Place to keep methods

    //extract data from csv and place into a list method
    public List<String[]> csvToList() {
        while (fileInput.hasNextLine()) {
            String[] inputArray = fileInput.nextLine().split(",");
            listOfProducts.add(inputArray);
        }
        return listOfProducts;
    }

    public void printProducts() {
        String productString = "";
        for (int i = 0; i < csvToList().size(); i++) {
        productString = Arrays.toString(csvToList().get(i));
            System.out.println(productString);
            }
    }

    //search products by keyword and list output method
    public void keywordSearch(String keyword) {
        for (int i = 0; i < csvToList().size(); i++) {
            if (csvToList().get(i)[1].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(Arrays.toString(csvToList().get(i)));
            }
        }
    }

    //create new product String with input for attributes
    public String newProductFromInput () {
        String newProduct;
        System.out.print("UPC: ");
        String upcInput = userInput.nextLine();
        System.out.print("Product Name: ");
        String prodNameInput = userInput.nextLine();
        System.out.print("Source Price: ");
        double sourcePriceInput = userInput.nextDouble();
        System.out.print("Retail Price: ");
        double retailPriceInput = userInput.nextDouble();
        newProduct = upcInput + ", " + prodNameInput + ", " + Double.toString(sourcePriceInput) + ", " + Double.toString(retailPriceInput);
        return newProduct;
    }

    //filewrites newProduct to designate file
    public void newInputProduct () {
        String destination = "custom_file.csv";

        try (FileWriter fileWriter = new FileWriter(destination, true)) {
            fileWriter.write(newProductFromInput());
            System.out.println("Thank you for adding a product to " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public boolean within5Percent(double x, double y) {
        double highX = x + (x * .05);
        double lowX = x - (x * .05);
        if (y <= highX && y >= lowX) {
            return true;
        }
        return false;
    }


    //ascertain recommendations based on desired profit margin and printwrite to recommendations txt file
public List<String> getRecommendations() {
        System.out.print("Please input a whole percentage for your desired profit margin: ");
        String profitMargin = userInput.nextLine();
        int percentage = Integer.parseInt(profitMargin);
        for (String[] product : csvToList()) {
            String recommendationFull = "";
            double marginPrice = Double.parseDouble(product[2]) * (1 + percentage / 100.0);
            if (within5Percent(Double.parseDouble(product[3]), marginPrice)) {
                recommendationFull = product[0] + " Margin price: " + marginPrice + ". " + listWithCaution;
            } else if (marginPrice > Double.parseDouble(product[3])) {
                recommendationFull = product[0] + " Margin price: " + marginPrice + ". " + listFalse;
            } else if (marginPrice < Double.parseDouble(product[3])) {
                recommendationFull = product[0] + " Margin price: " + marginPrice + ". " + listAffirmative;
            }
            recommendations.add(recommendationFull);
        }
        return recommendations;
}

    //create method to printwrite recommendations to txt file
public void printRecs() {
        getRecommendations();
        String destinationFile = "Recommendations_for_" + LocalDate.now();

        try (PrintWriter printWriter = new PrintWriter(destinationFile)) {
            String recommendationsPrint = "";
            for (int i = 0; i < recommendations.size(); i++) {
                recommendationsPrint = recommendations.get(i);
                printWriter.println(recommendationsPrint);
            }
            System.out.println("Thanks. Please see your recommendations in " + destinationFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
}

}