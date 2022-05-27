package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScratchPad {


    public void run() {

        String value = null;

//        if (value != null) {
//            if (value.equals("Yoav")) {
//                System.out.println("Yay!");
//            }
//        }

        if (value != null && value.equals("Yoav")) {
            System.out.println("Yay");
        } else {

            System.out.println("Done!");
        }

        Set<Integer> myNums = new HashSet<>();

        myNums.add(10);
        myNums.add(243);
        myNums.add(3);

        myNums.add(10);

        myNums.remove(243)
;
        for (Integer num : myNums) {
            System.out.println(num);
        }
    }

    public String animalGroupName(String animalName) {


        Map<String, String> animalGrouops = new HashMap<>();

        animalGrouops.put("RHINO", "Crash");
        animalGrouops.put("GIRAFFE", "Tower");
        animalGrouops.put("ELEPHANT", "Herd");
        animalGrouops.put("LION", "Pride");
        animalGrouops.put("CROW", "Murder");
        animalGrouops.put("PIGEON", "Kit");
        animalGrouops.put("FLAMINGO", "Pat");
        animalGrouops.put("DEER", "Herd");
        animalGrouops.put("DOG", "Pack");
        animalGrouops.put("CROCODILE", "Float");


        if (animalName != null) {
            String normalizedAnimalName = animalName.toUpperCase();
            if (animalGrouops.containsKey(normalizedAnimalName)) {
                return animalGrouops.get(normalizedAnimalName);
            }
        }

		/*
		animalGrouops.put("Rhino", "Crash");
		animalGrouops.put("Giraffe", "Tower");
		animalGrouops.put("Elephant", "Herd");
		animalGrouops.put("Lion", "Pride");
		animalGrouops.put("Crow", "Murder");
		animalGrouops.put("Pigeon", "Kit");
		animalGrouops.put("Flamingo", "Pat");
		animalGrouops.put("Deer", "Herd");
		animalGrouops.put("Dog", "Pack");
		animalGrouops.put("Crocodile", "Float");

		if (animalName != null) {

			for (Map.Entry<String, String> entry : animalGrouops.entrySet()) {

				String key = entry.getKey().toUpperCase();
				String normalizedAnimalName = animalName.toUpperCase();

				// don't to convert because we have equalsIgnoreCase
				// but this is how the concept of normalizing data works...
				// compare apples to apples
				if (key.equals(normalizedAnimalName)) {
					return entry.getValue();
				}

			}
		}
		*/


        return "unknown";
    }

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
//			if (wordCounts.containsKey(word)) {
            if (wordCounts.get(word) != null) {
                Integer curCount = wordCounts.get(word);
                wordCounts.put(word, curCount + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        return wordCounts;
    }





    public static void main(String[] args) {
        ScratchPad pad = new ScratchPad();
        pad.run();
    }
}
