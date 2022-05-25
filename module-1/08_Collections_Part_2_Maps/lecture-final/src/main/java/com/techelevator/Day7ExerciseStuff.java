package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Day7ExerciseStuff {

    /*
         Given two lists of Integers, interleave them beginning with the first element in the first list followed
         by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
         Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
         list to the new list before returning it.
         interleaveLists( [1, 2, 3, 7, 8], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
         */
    //TODO
    public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {

        List<Integer> integerList = new ArrayList<>();

//		List<Integer> largerIntList;
//		List<Integer> smallerIntList;
//
//
//
//		if (listOne.size() > listTwo.size()) {
//			largerIntList = listOne;
//		} else {
//			largerIntList = listTwo;
//		}

        List<Integer> larger = listOne.size() > listTwo.size() ? listOne : listTwo;
        List<Integer> smaller = listOne.size() < listTwo.size() ? listOne : listTwo;


        for (int index = 0; index < smaller.size(); index++) {
            integerList.add(listOne.get(index));
            integerList.add(listTwo.get(index));
        }

        for (int index = smaller.size(); index < larger.size(); index++) {
            integerList.add(larger.get(index));
        }


        return integerList;
    }

}
