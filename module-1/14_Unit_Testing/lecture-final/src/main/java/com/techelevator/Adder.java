package com.techelevator;

public class Adder {

    private double num1;
    private double num2;
    private boolean round;

    public Adder(double num1, double num2) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.round = true;
        this(num1, num2, true);
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public Adder(double num1, double num2, boolean doRound) {
        this.num1 = num1;
        this.num2 = num2;
        round = doRound;
    }

    public double addNums() {
        if (round) {
            return Math.floor(num1 + num2);
        } else {
            return num1 + num2;
        }
    }
}
