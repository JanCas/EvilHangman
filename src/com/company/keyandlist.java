package com.company;

import java.util.ArrayList;

public class keyandlist {
    String key;
    ArrayList<String> layor = new ArrayList<>();

    public keyandlist(String key, ArrayList<String> layor) {
        this.key = key;
        this.layor = layor;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getLayor() {
        return layor;
    }

    public void setLayor(ArrayList<String> layor) {
        this.layor = layor;
    }
}
