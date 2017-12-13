package com.company;

import java.util.ArrayList;

public class filter {

    public ArrayList<keyandlist> layers = new ArrayList<>();
    public int length;
    public ArrayList<String> WordsFiltered = new ArrayList<>();
    public reader r;
    public String guess;

    public filter(String guess, int length) {
        this.length = length;
        this.guess = guess;
        r = new reader(length);
        fill();
    }

    /**
     * fills up the arraylist<>keyandlist</> with a key and the corresponding list
     * this is the initial method and only gets run once
     * @return Arraylist<>keyandlist</>
     */
    public ArrayList<keyandlist> fill() {
        ArrayList<Integer> key;
        for (String w : r.words) {
            key = ConvertToKey(w, guess);
            if (!haskey(key)) {
                keyandlist KL = new keyandlist(key, w);
                layers.add(KL);
            } else {
                layers.get(findIndexofKey(key)).addword(w);
            }
        }
        return layers;
    }

    /**
     * same as fill, just uses the refined word list
     * used all the time except first
     * @return ArrayList<>keyandlist</>
     */
    public ArrayList<keyandlist> fill2() {
        ArrayList<Integer> key;
        for (String w : WordsFiltered) {
            key = ConvertToKey(w, guess);
            if (!haskey(key)) {
                keyandlist KL = new keyandlist(key, w);
                layers.add(KL);
            } else {
                layers.get(findIndexofKey(key)).addword(w);
            }
        }
        return layers;
    }

    /**
     * Finds the index of the key in the ArrayList
     * @param key
     * @return int index
     */
    public int findIndexofKey(ArrayList<Integer> key) {
        for (int i = 0; i < layers.size(); i++)
            if (layers.get(i).getKey().equals(key))
                return i;
        return 0;
    }

    /**
     * sees if the ArrayList has the key specified
     * @param key
     * @return boolean
     */
    public boolean haskey(ArrayList<Integer> key) {
        for (keyandlist kal : layers)
            if (kal.getKey().equals(key))
                return true;
        return false;
    }

    /**
     * converts the word to a key
     * for example if the guess from the user is e
     * and the word is ebola, then the key would be 1 0 0 0 0
     * a 1 for when your guess applies and a 0 for when not
     * @param word
     * @param c guess
     * @return ArrayList<>Integer</>
     */
    public ArrayList<Integer> ConvertToKey(String word, String c) {
        ArrayList<Integer> key = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++)
            if (word.substring(i, i + 1).equals(c))
                key.add(1);
            else
                key.add(0);
        return key;
    }

    /**
     * gets the biggest list from the ArrayList<>keyandlist</>
     * and returns the key associated with it
     * @return ArrayList<>Integer</>
     */
    public ArrayList<Integer> getBiggest() {
        int maxindex = 0;
        int max = layers.get(0).getLayer().size();
        for (int i = 0; i < layers.size(); i++) {
            if (max < layers.get(i).getLayer().size()) {
                max = layers.get(i).getLayer().size();
                maxindex = i;
            }
        }
        WordsFiltered = layers.get(maxindex).getLayer();
        return layers.get(maxindex).getKey();
    }

    /**
     * sets the guess to c
     * @param c
     */
    public void setGuess(String c) {
        this.guess = c;
    }
}
