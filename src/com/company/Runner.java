package com.company;

import java.util.Scanner;

public class Runner {
    Scanner keyboard = new Scanner(System.in);
    int length, guesses;
    String guess;
    filter f;

    public Runner() {
        Asker();
        new filter(guess, length);
        runFilter();

    }

    public void Asker() {
        System.out.println("Please enter how long you'd like your word to be");
        this.length = keyboard.nextInt();

        System.out.println("Please enter how many guesses youd like to have");
        this.guesses = keyboard.nextInt();

        System.out.println("Please enter your first guess");
        this.guess = keyboard.next();
        //
        //if (guess.length() > 1 || isNumeric(guess)) {
        //System.out.println("Please enter a new guess");
        //guess = keyboard.nextLine();
        //}
        //
    }

    public void runFilter(){
        for (int i = 0; i < guesses; i++){
            System.out.println("Got in");
            f.getBiggest();
            setGuess();
            f.setGuess(guess);
            f.fill();
        }
    }

    public void setGuess(){
        System.out.println("Type in your next guess");
        guess = keyboard.nextLine();
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
