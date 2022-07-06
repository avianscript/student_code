package EcommerceMachine;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    //This is where I will have all of the menu navigation take place
 ProductPojo productPojo = new ProductPojo();

    public static void main(String[] args) throws FileNotFoundException {
        Processor processor = new Processor();
//        processor.printProductList();
//        System.out.println(processor.csvToList().get(0)[1]);

        processor.keywordSearch("tick");
//        processor.newInputItem("01234", "new product", "12.00", "13.00");
    }
}
