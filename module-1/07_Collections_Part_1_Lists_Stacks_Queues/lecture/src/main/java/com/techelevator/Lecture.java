package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<String>();

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		names.add("Yoav");
		names.add("Jim");
		names.add("Amber");

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			String ourName = names.get(i);
			System.out.println(ourName);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2,"Andrea");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

String [] namesArray = names.toArray(new String[0]);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

Collections.sort(names);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

Collections.reverse(names);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();



	}
}
