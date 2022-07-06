package EcommerceConnect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Product {


    private static Double unitSourcePrice;
//    private static Double unitOnSalePrice;
//    private static Double createPrice;
    private static int productIdentifier;
//    private static Double handlingCosts;
    private static String productName;
    private static String productUPC;


    public void Product (int productIdentifier, String productUPC, double unitSourcePrice, String productName) {
        this.unitSourcePrice = unitSourcePrice;
//        this.unitOnSalePrice = unitOnSalePrice;
//        this.createPrice = createPrice;
        this.productIdentifier = productIdentifier;
//        this.handlingCosts = handlingCosts;
        this.productName = productName;
        this.productUPC = productUPC;
    }

    public int getProductIdentifier () {
        return productIdentifier;
    }

//    public static Double getUnitOnSalePrice() {
//        return unitOnSalePrice;
//    }

    public static Double getUnitSourcePrice() {
        return unitSourcePrice;
    }

    public static String getProductName () { return productName; }

    public static String getProductUPC () { return productUPC; }

//    public static Double getCreatePrice() {
//        return createPrice;
//    }

//    public void setCreatePrice() {
//        this.createPrice = createPrice;
//    }

//    public static Double getHandlingCosts() {
//        return handlingCosts;
//    }

    //places csv file row by row into a list<String[]> , The goal
    //is to break down the list by product number (generated) into separate
    //String[], which can then be indexed and converted to appropriate
    //data types. (e.g. Product 1 shows getDetails.get(0) and gives price at [3] index of that array)
    File newFile = new File("custom_file (6).csv");


    public void getDetails () {
        List<String[]> productDetails = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(newFile);
            int x = 1;
            while (fileReader.hasNextLine()) {

                String nextProduct = "Product number: " + x + ", " + fileReader.nextLine();
                String[] delimProduct = nextProduct.split(", ");
                productDetails.add(delimProduct);
                x++;
                System.out.println(Arrays.toString(delimProduct));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
