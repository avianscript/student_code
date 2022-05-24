package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.List;


public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();

		names.add("Yoav");
		names.add("Jim");
		names.add("Amber");



		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			String curName = names.get(i);
			System.out.println(curName);
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Jim");
//		for (int i = 0; i < names.size(); i++) {
//			String curName = names.get(i);
//			System.out.println(curName);
//		}
		dumpStringList(names);


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		names.add(2, "Andrea");
		dumpStringList(names);


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(1);

		// can remove by specifying an object to remove (if there
		// are multiples ot will remove the first one
//		names.remove("Jim");

		names.remove(1);

		dumpStringList(names);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		boolean jimExists = names.contains("Jim");
		System.out.println("jimExists: " + jimExists);
		boolean andreaExists = names.contains("Andrea");
		System.out.println("andreaExists: " + andreaExists);


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		int indexOfJim = names.indexOf("Jim");
		System.out.println("indexOfJim: " + indexOfJim);
		int indexOfAndrea = names.indexOf("Andrea");
		System.out.println("indexOfAndrea: " + indexOfAndrea);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String [] namesArray = names.toArray(new String[0]);

		System.out.println(namesArray.length);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);

		dumpStringList(names);




		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);

		dumpStringList(names);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for ( String curName : names ) {
			System.out.println(curName);
		}


		for ( String curName : namesArray) {
			System.out.println("array: " + curName);
		}

	}

	public  static void dumpStringList(List<String> strings) {
		for (int i = 0; i < strings.size(); i++) {
			String curString = strings.get(i);
			System.out.println(curString);
		}
	}
}
