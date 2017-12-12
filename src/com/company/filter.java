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

    public int findIndexofKey(ArrayList<Integer> key) {
        for (int i = 0; i < layers.size(); i++)
            if (layers.get(i).getKey().equals(key))
                return i;
        return 0;
    }

    public boolean haskey(ArrayList<Integer> key) {
        for (keyandlist kal : layers)
            if (kal.getKey().equals(key))
                return true;
        return false;
    }

    public ArrayList<Integer> ConvertToKey(String word, String c) {
        ArrayList<Integer> key = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++)
            if (word.substring(i, i + 1).equals(c))
                key.add(1);
            else
                key.add(0);
        return key;
    }

    public ArrayList<Integer> getBiggest() {
        int maxindex = 0;
        int max = layers.get(0).getLayor().size();
        for (int i = 0; i < layers.size(); i++) {
            if (max < layers.get(i).getLayor().size()) {
                max = layers.get(i).getLayor().size();
                maxindex = i;
            }
        }
        WordsFiltered = layers.get(maxindex).getLayor();
        return layers.get(maxindex).getKey();
    }

    public void setGuess(String c) {
        this.guess = c;
    }
}
