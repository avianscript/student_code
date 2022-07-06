package EcommerceMachine;

import java.io.*;
import java.util.*;

public class Processor {
    List<String[]> listOfProducts = new ArrayList<>();


    //Scanner for use throughout class
    File csvFilePath = new File("custom_file.csv");
    Scanner input = new Scanner(csvFilePath);

    public Processor() throws FileNotFoundException {
    }

    //Place to keep methods

    //extract data from csv for display method
    public void printProductList() {
        while (input.hasNextLine()) {
            String nextLine = input.nextLine();
            System.out.println(nextLine);
        }
    }

    //extract data from csv and place into a list method
    public List<String[]> csvToList() {
        while (input.hasNextLine()) {
            String[] inputArray = input.nextLine().split(",");
            listOfProducts.add(inputArray);
        }
        return listOfProducts;
    }

    //extract data from inventory list and place into ProductPojo
    public void listToProduct() {
        ProductPojo productPojo = new ProductPojo();
        for (String [] product : csvToList()) {
            productPojo.setProductUpc(product[0]);
            productPojo.setProductName(product[1]);
            productPojo.setSourcePrice(Double.parseDouble(product[2]));
            productPojo.setRetailPrice(Double.parseDouble(product[3]));
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

    //create new productPojo with input for attributes
    public ProductPojo newProductPojoFromInput (String productUpc, String productName, double sourcePrice, double retailPrice) {
        ProductPojo newProductPojo = new ProductPojo();
        newProductPojo.setProductUpc(productUpc);
        newProductPojo.setProductName(productName);
        newProductPojo.setSourcePrice(sourcePrice);
        newProductPojo.setRetailPrice(retailPrice);
        return newProductPojo;
    }

    //input new item, including printwriter method , still needs a bunch of work! Not actually writing to the file.
    public void newInputProductPojo (ProductPojo productPojo) {
        String[] newInputArray = new String[]{productPojo.getProductUpc(), productPojo.getProductName(), Double.toString(productPojo.getSourcePrice()), Double.toString(productPojo.getRetailPrice())};
        try {
//            FileWriter fileWriter = new FileWriter("custom_file.txt", true);
            PrintWriter printWriter = new PrintWriter("custom_file.txt");
            printWriter.println(Arrays.toString(newInputArray));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    //ascertain recommendations based on desired profit margin and printwrite to recommendations txt file


    //create method to printwrite recommendations to txt file


}