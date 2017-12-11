package com.company;

import java.util.ArrayList;

public class filter {
    ArrayList<keyandlist> layers = new ArrayList<>();
    reader r = new reader(4);

    public filter(String guess) {
        fill(guess);
    }

    public ArrayList<keyandlist> fill(String c) {
        ArrayList<Integer> key;
        ArrayList<String> word = new ArrayList<>();
        for (String w : r.words) {
            word.add(w);
            key = ConvertToKey(w, c);
            if (!haskey(key)) {
                keyandlist KL = new keyandlist(key, word);
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
}
