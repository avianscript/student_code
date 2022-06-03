package com.techelevator;

public class ScratchPad {

    public void run() {

        System.out.println(addTwo(5.5, 7.25));

        System.out.println(addTwo(5.5, 7.25, true));
        System.out.println(addTwo(5.5, 7.25, false));


        System.out.println("*******************");
        Adder myAdder = new Adder(5.5, 7.25);
        System.out.println(myAdder.addNums());

        myAdder = new Adder(5.5, 7.25, false);
        System.out.println(myAdder.addNums());

    }

    public double addTwo(double num1, double num2) {
        return addTwo(num1, num2, true);
    }


    public double addTwo(double num1, double num2, boolean round) {
        if (round) {
            return Math.floor(num1 + num2);
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        ScratchPad pad = new ScratchPad();
        pad.run();
    }
}
