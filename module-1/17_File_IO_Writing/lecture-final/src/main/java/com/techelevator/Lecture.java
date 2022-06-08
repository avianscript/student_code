package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

//		String demo = "item1|item2|item3";
//		String [] split1 = demo.split("|");
//		String [] split2 = demo.split("\\|");
//
//		System.out.println();

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		inspectingTheFileSystem(userInput);

		/*
		 * The File class also allows us to manipulate file system objects
		 * */

		/* ************************
		 * CREATING A DIRECTORY
		 * ************************/

//		String newDir = creatingADirectory(userInput);
//		System.out.println(newDir);

		/* ************************
		 * CREATING A FILE
		 * ************************/

//		String newDir = "yoavs-dir/other-dir2";
//		String newFile = creatingAFile(userInput, newDir);
//		System.out.println(newFile);

		/* ************************
		 * WRITING TO A FILE
		 * ************************/

		String filePath = "yoavs-dir/other-dir/yet-another-file.txt";
//		writingToAFile(userInput, filePath);

		/* ************************
		 * APPENDING TO A FILE
//		 * ************************/
		appendingToAFile(userInput, filePath);


	}

	public static void inspectingTheFileSystem(Scanner userInput) {
		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		File f = new File(path);
		System.out.println();
		if (f.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			System.out.println("name: " + f.getName());
			System.out.println("absolutePath: " + f.getAbsolutePath());
			if (f.isDirectory()) {
				System.out.println("type: directory");
			} else if (f.isFile()) {
				System.out.println("type: file");
			}
			System.out.println("size : " + f.length());
		} else {
			System.out.println(f.getAbsolutePath() + " does not exist.");
		}
	}

	public static String creatingADirectory(Scanner userInput) {
		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		String path = userInput.nextLine();
		File newDirectory = new File(path);

		if (newDirectory.exists()) {
			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists.");
			System.exit(1);
		} else {
			if (newDirectory.mkdir()) {
				System.out.println("New directory created at " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("Could not create directory.");
				System.exit(1);
			}
		}

		return path;
	}

	public static String creatingAFile(Scanner userInput)  {
		System.out.println();
		System.out.println("Now let's put a file in the directory.");
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();

		File newFile = new File(fileName);

		try {
			newFile.createNewFile();
			System.out.println();
			System.out.println("name: " + newFile.getName());
			System.out.println("absolutePath: " + newFile.getAbsolutePath());
			System.out.println("size : " + newFile.length());
		} catch (IOException ex) {
			System.out.println("Error creating " + newFile.getAbsolutePath() + ": " + ex.getMessage());
		}

		return fileName;
	}

	public static void writingToAFile(Scanner userInput, String filePath)  throws FileNotFoundException  {
		File newFile = new File(filePath);
		System.out.println();
		System.out.println("Now let's write something in the new file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();

		try (PrintWriter writer = new PrintWriter(newFile)) {
			writer.println(message);
		} // When we exit the try block, this causes the file to be closed and an automatic flush of the buffer to trigger

		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("absolutePath: " + newFile.getAbsolutePath());
		System.out.println("size : " + newFile.length());
	}

	public static void appendingToAFile(Scanner userInput, String filePath) {
		File newFile = new File(filePath);
		System.out.println();
		System.out.println("Now let's appending something an existing file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();

		System.out.print("Do you want to overwrite? (Y/N): ");
		String overwriteChoice = userInput.nextLine();

		boolean append = overwriteChoice.equalsIgnoreCase("Y") ? false : true;

		//boolean append = newFile.exists() ? true : false;
		try (PrintWriter writer =
					 new PrintWriter(new FileOutputStream(newFile, append))) {
			writer.println(message);
		} catch(IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}


	}




}
