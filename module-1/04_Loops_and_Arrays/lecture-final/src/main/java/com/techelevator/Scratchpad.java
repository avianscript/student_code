package com.techelevator;

public class Scratchpad {


    public void examples() {
        forLoopNoBlock();
    }


    public String getLetterGrade(int percent) {

//        if (percent >= 90) {
//            return "You are star.";
//        }



        if (percent >= 90) {
            return "A";
        } else if (percent >= 80 && percent <= 89) {
            return "B";
        } else if (percent >= 70 && percent < 80) {
            return "C";
        } else if (percent >= 60 && percent < 70) {
            return "D";
        }

        int num = 100;

        if (num > 50) {
            System.out.println(">50");
        }

        if (num > 55) {
            System.out.println(">55");
        }

//        else {
//            return "F";
//        }

        // do some stuff

//        return "Sorry you are not a star.";
        return "F";
    }

    public void forLoopNoBlock() {

        for (int linda = 1; linda <= 5; linda++)
            System.out.println("linda: " + linda);
        System.out.printf("linda again");

    }
    


    // don't worry about what this is doing yet

    public static void main(String[] args) {

        Scratchpad scratchpad = new Scratchpad();
        scratchpad.examples();
    }
}
