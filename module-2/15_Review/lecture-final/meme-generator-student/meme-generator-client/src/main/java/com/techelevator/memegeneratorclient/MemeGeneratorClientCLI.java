package com.techelevator.memegeneratorclient;

import com.techelevator.memegeneratorclient.api.MemeGeneratorApiService;
import com.techelevator.memegeneratorclient.model.Meme;

import java.util.Scanner;

public class MemeGeneratorClientCLI {

    private static final int MAX_MEMES = 10;

    private final MemeGeneratorApiService apiService;
    private Scanner scanner;
    private Meme[] memes;

    private int memeCount = MAX_MEMES;

    public MemeGeneratorClientCLI() {
        this.apiService = new MemeGeneratorApiService();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        memes = apiService.getMemes();
        if (memes.length < MAX_MEMES) {
            memeCount = memes.length;
        }

        boolean done = false;

        while (!done) {
            listMemes();
            System.out.println("X) Exit");
            String selectedMemeId = null;;
            String userChoice = getStringInput("Enter choice: ", scanner);
            if (userChoice.equalsIgnoreCase("X")) {
                done = true;
            } else {
                try {
                    Integer memeNum = Integer.parseInt(userChoice);
                    System.out.println();
                    if (memeNum <= memeCount) {
                        System.out.println(memes[memeNum - 1].getMemeName());
                        selectedMemeId = memes[memeNum - 1].getMemeId();
                    } else {
                        System.out.println("Please choose a number from 1 to " + memeCount);
                    }

                } catch (NumberFormatException ex) {
                    System.out.println("Invalid option... please try again");
                }
            }

            String caption = getStringInput("Enter caption: ", scanner);
            String result = apiService.createMeme(selectedMemeId, caption);
            System.out.println("URL: " + result);
            getStringInput("Press enter to contnue...", scanner);
        }

    }

    public String getStringInput(String message, Scanner scanner) {
        System.out.println();
        System.out.print(message);
        return scanner.nextLine();
    }

    public void listMemes() {

        for (int i = 0; i < memeCount; i++) {
            System.out.println(String.format("%d) %s", i + 1, memes[i].getMemeName()));
        }

    }

}
