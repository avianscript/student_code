package EcommerceConnect;

import static EcommerceConnect.Hub.*;

public class CalculationMethods extends Product{
    static double profitMarginSource;
    static double sellPrice;
    static int setProfit;

    public static double calcProfit () {
        profitMarginSource = (((sellAtPrice - inputSourcePrice - handlingCost) / (inputSourcePrice + handlingCost)) * 100);

        return profitMarginSource;
    }

    public static double sellAtPrice () {
        sellPrice = inputSourcePrice + handlingCost + ((desiredProfitMargin / 100) * (inputSourcePrice + handlingCost));

        return sellPrice;
    }

    public static boolean listOrNot () {
        if (sellPrice < salePrice) {
            return true;
        }
        return false;
    }
}
