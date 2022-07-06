package EcommerceMachine;

public class ProductPojo {

//    private int productNumber;
    private String productUpc;
    private String productName;
    private double sourcePrice;
    private double retailPrice;

public ProductPojo (int productNumber, String productUpc, String productName, double sourcePrice, double retailPrice) {
//    this.productNumber = productNumber;
    this.productUpc = productUpc;
    this.productName = productName;
    this.sourcePrice = sourcePrice;
    this.retailPrice = retailPrice;
}

    public ProductPojo() {

    }


    public double getRetailPrice() {
        return retailPrice;
    }

    public double getSourcePrice() {
        return sourcePrice;
    }

//    public int getProductNumber() {
//        return productNumber;
//    }

    public String getProductUpc() {
        return productUpc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public void setProductNumber(int productNumber) {
//        this.productNumber = productNumber;
//    }

    public void setProductUpc(String productUpc) {
        this.productUpc = productUpc;
    }

    public void setRetailPrice(double retailPrice) { this.retailPrice = retailPrice; }

    public void setSourcePrice(double sourcePrice) {
        this.sourcePrice = sourcePrice;
    }


    public double calculatedListPrice (int profitMargin) {
        return sourcePrice + (sourcePrice * (profitMargin/100.0));
    }
    public boolean isWithin5PercentOfRetail (int profitMargin) {
        if (calculatedListPrice(profitMargin) <= (retailPrice + (retailPrice * .05))
                && calculatedListPrice(profitMargin) >= (retailPrice - (retailPrice * .05))) {
            return true;
        }
        return false;
    }
    public boolean isWellBelow (int profitMargin) {
        if (calculatedListPrice(profitMargin) < retailPrice && !isWithin5PercentOfRetail(profitMargin) ) {
            return true;
        }
        return false;
    }
    public boolean isWellAbove (int profitMargin) {
        if (calculatedListPrice(profitMargin) > retailPrice && !isWithin5PercentOfRetail(profitMargin)) {
            return true;
        }
        return false;
    }
}
