package greatlearning.factorypattern;

/**
 * This is the factory design pattern
 */
public class FactoryPatterDemo {
    public static void main(String[] args) {
        //convert 500 GBP and 700 Dollars into INR
        double inr1 = new GBPConverter().convertToINR(500);
        System.out.println("The INR value of 500 GBP is " + inr1);
        double inr2 = new GBPConverter().convertToINR(700);
        System.out.println("The INR value of 700 USD is " + inr2);
    }
}
