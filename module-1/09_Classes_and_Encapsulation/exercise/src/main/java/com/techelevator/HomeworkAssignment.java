package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks (){
        return this.earnedMarks;
    }
    public int getPossibleMarks () {
        return this.possibleMarks;
    }
    public String getSubmitterName () {
        return this.submitterName;
    }
    public void setEarnedMarks (int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getLetterGrade () {
        if ((earnedMarks / (double)possibleMarks * 100) >= 90) {
            letterGrade = "A";
        } else if (earnedMarks / (double)possibleMarks * 100 > 79 && earnedMarks / possibleMarks * 100 < 90) {
            letterGrade = "B";
        } else if (earnedMarks / (double)possibleMarks * 100 > 69 && earnedMarks / possibleMarks * 100 < 80) {
            letterGrade = "C";
        } else if (earnedMarks / (double)possibleMarks * 100 > 59 && earnedMarks / possibleMarks * 100 < 70) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    }


//    public static void main(String[] args) {
//        HomeworkAssignment homeworkAssignment = new HomeworkAssignment();

//        if (earnedMarks / possibleMarks * 100 >= 90) {
//            letterGrade = "A";
//        } else if (earnedMarks / possibleMarks * 100 > 79 && earnedMarks / possibleMarks * 100 < 90) {
//            letterGrade = "B";
//        } else if (earnedMarks / possibleMarks * 100 > 69 && earnedMarks / possibleMarks * 100 < 80) {
//            letterGrade = "C";
//        } else if (earnedMarks / possibleMarks * 100 > 59 && earnedMarks / possibleMarks * 100 < 70) {
//            letterGrade = "D";
//        } else {
//            letterGrade = "F";
//        }
//        return "Your letter grade is: " + letterGrade;
//    }
//    }
//}
//    public HomeworkAssignment(int possibleMarks, String submitterName) {
//    }
//    public String HomeworkAssignment(int possibleMarks, int earnedMarks,String letterGrade, String submitterName) {
//
//        this.earnedMarks = earnedMarks;
//        this.possibleMarks = possibleMarks;
//        this.submitterName = submitterName;
//        this.letterGrade = letterGrade;
//        return letterGrade;
//


    //    HomeworkAssignment homeworkGrades = new HomeworkAssignment();

//   homeworkGrades.setEarnedMarks(0);
//    homeworkGrades.getEarnedMarks();
//    homeworkGrades.getPossibleMarks();
//    homeworkGrades.getSubmitterName();
//    homeworkGrades.getLetterGrade();
