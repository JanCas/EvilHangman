package com.company;

import java.util.ArrayList;

public class keyandlist {
    ArrayList<Integer> key;
    ArrayList<String> layor = new ArrayList<>();

    public keyandlist(ArrayList<Integer> key, ArrayList<String> layor) {
        this.key = key;
        this.layor = layor;
    }

    public keyandlist(ArrayList<Integer> key, String w) {
        this.key = key;
        layor.add(w);
    }

    public keyandlist() {
    }

    public ArrayList<Integer> getKey() {
        return key;
    }

    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }

    public void addword(String w) {
        layor.add(w);
    }

    public ArrayList<String> getLayor() {
        return layor;
    }

    public void setLayor(ArrayList<String> layor) {
        this.layor = layor;
    }
}
