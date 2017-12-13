package com.company;

import java.util.ArrayList;

public class keyandlist {
    ArrayList<Integer> key;
    ArrayList<String> layer = new ArrayList<>();


    public keyandlist(ArrayList<Integer> key, String w) {
        this.key = key;
        layer.add(w);
    }

    /**
     * gets the key
     *
     * @return ArrayList<>Integer</>
     */
    public ArrayList<Integer> getKey() {
        return key;
    }

    /**
     * sets the key
     *
     * @param key
     */
    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }

    /**
     * adds a word to the layer
     *
     * @param w
     */
    public void addword(String w) {
        layer.add(w);
    }

    /**
     * gets the layer
     *
     * @return ArrayList<>String</>
     */
    public ArrayList<String> getLayer() {
        return layer;
    }

}
