package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    Scanner keyboard = new Scanner(System.in);
    int length, guesses;
    String guess;
    filter f;
    ArrayList<String> WordInQuestion = new ArrayList<>();
    ArrayList<String> recordedguesses = new ArrayList<String>();

    public Runner() {
        Asker();
        f = new filter(guess, length);
        run();
    }

    /**
     * does the initial asking of how long the word
     * how many guesses
     * and the first guess
     */
    public void Asker() {
        System.out.println("Please enter how long you'd like your word to be");
        this.length = keyboard.nextInt();

        System.out.println("Please enter how many guesses youd like to have");
        this.guesses = keyboard.nextInt();

        System.out.println("Please enter your first guess (just one letter)");
        this.guess = keyboard.next();
        //
        //if (guess.length() > 1 || isNumeric(guess)) {
        //System.out.println("Please enter a new guess");
        //guess = keyboard.nextLine();
        //}
        //
    }

    /**
     * runs the game, iterates x amount of times
     * calls the needed methods to trick the user and make him miserble
     * also stops the game if the user has guessed it right
     */
    public void run() {
        ArrayList<Integer> biggestkey = new ArrayList<>();
        String playagain = "Y";
        while (playagain.equalsIgnoreCase("y")) {
            for (int i = 0; i < guesses; i++) {
                System.out.println();
                biggestkey = f.getBiggest();
                FillFinalWord(biggestkey);
                if (!WordInQuestion.contains("-")) {
                    System.out.println("You won congratulations");
                    PrintWordInQuestion();
                    return;
                }
                f.layers.clear();
                PrintWordInQuestion();
                System.out.println("You have " + (guesses - (i + 1)) + " guesses remaining");
                setGuess();
                f.setGuess(guess);
                f.fill2();
            }
            System.out.println("You ran out of guesses, shame on you");
            System.out.println();
            System.out.println("Do you want to play again (Y/N)");
            playagain = keyboard.next();
            if(playagain.equalsIgnoreCase("y")) {
                Asker();
                f = new filter(guess, length);
                recordedguesses.clear();
            }
        }
    }

    /**
     * shows already used up guesses
     * asks you for a guess
     * prompts you to take a new one if you are making a repeat
     */
    public void setGuess() {
        recordedguesses.add(guess);
        System.out.print("Already taken guesses: ");
        for (String s : recordedguesses)
            System.out.print(s + " ");
        System.out.println();

        System.out.println("Type in your next guess");
        guess = keyboard.next();
        while (recordedguesses.contains(guess)) {
            System.out.println("Please eneter a new guess this is already taken");
            guess = keyboard.next();
        }
    }

    /**
     * prints the word but in ------- format
     * with only the letters you already guessed showing
     */
    public void PrintWordInQuestion() {
        System.out.println("This is your word, with the correct guesses");
        for (String s : WordInQuestion)
            System.out.print(s);
        System.out.println();
    }

    /**
     * turns the key (100010 whatever) into a word (b---b-) something like that
     * and then at the next key, keeps the already discovered ones there and just adds if there are any new ones
     *
     * @param key
     */
    public void FillFinalWord(ArrayList<Integer> key) {
        for (int i = 0; i < key.size(); i++) {
            if (WordInQuestion.size() < key.size())
                if (key.get(i) == 0)
                    WordInQuestion.add("-");
                else
                    WordInQuestion.add(guess);
            else if (key.get(i) == 1)
                WordInQuestion.set(i, guess);
        }
    }

}
