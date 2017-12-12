package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    Scanner keyboard = new Scanner(System.in);
    int length, guesses;
    String guess;
    filter f;
    ArrayList<String> WordInQuestion = new ArrayList<>();

    public Runner() {
        Asker();
        f = new filter(guess, length);
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

    public void runFilter() {
        ArrayList<Integer> biggestkey = new ArrayList<>();
        for (int i = 0; i < guesses; i++) {
            biggestkey = f.getBiggest();
            FillFinalWord(biggestkey);
            PrintWordInQuestion();
            setGuess();
            f.setGuess(guess);
            f.fill();
        }
    }

    public void setGuess() {
        System.out.println("Type in your next guess");
        guess = keyboard.nextLine();
    }

    public void PrintWordInQuestion(){
        System.out.println("This is your word");
        for(String s : WordInQuestion)
            System.out.print(s);
        System.out.println();
    }

    public void FillFinalWord(ArrayList<Integer> key) {
        for (int i = 0; i < key.size(); i++) {
            if(WordInQuestion.size() <= key.size())
                if (key.get(i) == 0)
                    WordInQuestion.add("-");
                else
                    WordInQuestion.add(guess);
            else
                if (WordInQuestion.get(i) == "-")
                    WordInQuestion.set(i, guess);
        }
    }

}
