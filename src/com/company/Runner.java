package com.company;

import java.util.Scanner;

public class Runner {
    Scanner keyboard = new Scanner(System.in);
    int length, guesses;
    String guess;

    public Runner() {
    }

    public void Asker() {
        System.out.println("Please enter how long you'd like your word to be");
        this.length = keyboard.nextInt();

        System.out.println("Please enter how many guesses youd like to have");
        this.guesses = keyboard.nextInt();

        System.out.println("Please enter your first guess");
        this.guess = keyboard.nextLine();
        if (guess.length() > 1 || isNumeric(guess)) {
            System.out.println("Please enter a new guess");
            guess = keyboard.nextLine();
        }
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
