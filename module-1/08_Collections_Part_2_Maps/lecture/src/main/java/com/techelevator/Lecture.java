package com.techelevator;


public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();



		/*
		// Create a Map to look up state name by code
		Map<String, String> states = new HashMap<>();
		*/

		/*

		// put data in the map
		states.put("PA", "Pennsylvania");
		states.put("OH", "Ohio");
		states.put("DE", "Delaware");
		*/

		/*
		System.out.println("###### GET BY KEY ######");
		System.out.println();

		// get the state names for PA and DE
		String paName = states.get("PA");
		System.out.println("PA: " + paName);

		String deName = states.get("DE");
		System.out.println("DE: " + deName);

		 */

		/*

		// if you ask for a key that isn't there. the value will be null
		String nyName = states.get("NY");
		System.out.println("NY: " + nyName);

		 */

		/*
		System.out.println();
		System.out.println("###### UPDATE KEY VALUE ######");
		System.out.println();

		// update PA (keys must be unique so putting
		// existing key will update value)

		states.put("PA", "Penn");
		paName = states.get("PA");
		System.out.println("PA: " + paName);

		 */

		/*
		System.out.println();
		System.out.println("###### CHECK IF KEY EXISTS ######");
		System.out.println();

		boolean paExists = states.containsKey("PA");
		System.out.println("paExists: " + paExists);

		boolean nyExists = states.containsKey("NY");
		System.out.println("nyExists: " + nyExists);

		 */

		/*
		System.out.println();
		System.out.println("###### GET NUMBER OF ELEMENTS IN MAP ######");
		System.out.println();

		int stateCount = states.size();
		System.out.println("stateCount: " + stateCount);

		 */

		/*
		System.out.println();
		System.out.println("###### GET KEYS IN MAP ######");
		System.out.println();

		// Ask for key Set (Sets coming up next...)
		Set<String> keys = states.keySet();

		for (String key : keys) {
			System.out.println(key);
		}

		 */

		/*
		System.out.println();
		System.out.println("###### GET ENTRIES IN MAP ######");
		System.out.println();

		Set<Map.Entry<String, String>> entries = states.entrySet();

		for (Map.Entry<String, String> entry : entries) {
			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println("key: " + key + " value: " + value);
		}

		 */

		/*
		System.out.println();
		System.out.println("###### REMOVE ENTRY ######");
		System.out.println();

		// returns the value removed... you can capture or ignore
		String removed = states.remove("OH");
		System.out.println("removed: " + removed);

		stateCount = states.size();
		System.out.println("stateCount: " + stateCount);

		// after removing, getting key will return null
		String ohName = states.get("OH");
		System.out.println("ohName: " + ohName);

		 */

		/*

		System.out.println();
		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		Set<Integer> nums = new HashSet<>();
		nums.add(5);
		nums.add(100);
		nums.add(30);
		nums.add(77);

		 */



		/*
		System.out.println();
		System.out.println("###### ITERATE THROUGH VALUES ######");
		System.out.println();

		for (Integer num : nums) {
			System.out.println(num);
		}

		 */

		/*
		System.out.println();
		System.out.println("###### DUPLICATES NOT ALLOWED ######");
		System.out.println();

		nums.add(100);

		for (Integer num : nums) {
			System.out.println(num);
		}

		 */

		/*
		System.out.println();
		System.out.println("###### CHECK IF SET CONTAINS VALUE ######");
		System.out.println();

		boolean has100 = nums.contains(100);
		System.out.println("has100: " + has100);

		boolean has75 = nums.contains(75);
		System.out.println("has75: " + has75);

		 */

		/*
		System.out.println();
		System.out.println("###### REMOVE ITEM FROM SET ######");
		System.out.println();

		nums.remove(77);

		for (Integer num : nums) {
			System.out.println(num);
		}

		 */

		/*
		System.out.println();
		System.out.println("###### GET NUMBER OF ELEMENTS ######");
		System.out.println();

		int numCount = nums.size();
		System.out.println("numCount: " + numCount);


		 */

	}

}
