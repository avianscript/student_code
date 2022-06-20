package EcommerceConnect;

public class Product {

    private static Double unitSourcePrice;
    private static Double unitOnSalePrice;
    private static Double createPrice;
    private static String productIdentifier;
    private static Double handlingCosts;


    public void Product (String productIdentifier, double unitSourcePrice, double unitOnSalePrice, double createPrice, double handlingCosts) {
        this.unitSourcePrice = unitSourcePrice;
        this.unitOnSalePrice = unitOnSalePrice;
        this.createPrice = createPrice;
        this.productIdentifier = productIdentifier;
        this.handlingCosts = handlingCosts;
    }

    public String getProductIdentifier () {
        return productIdentifier;
    }

    public static Double getUnitOnSalePrice() {
        return unitOnSalePrice;
    }

    public static Double getUnitSourcePrice() {
        return unitSourcePrice;
    }

    public static Double getCreatePrice() {
        return createPrice;
    }

    public void setCreatePrice() {
        this.createPrice = createPrice;
    }

    public static Double getHandlingCosts() {
        return handlingCosts;
    }

}