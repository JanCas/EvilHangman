package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class reader {
    ArrayList<String> words = new ArrayList<>();
    static int length = 15;

    public reader(int length) {
        try {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\janlc\\OneDrive\\Documents\\GitHub\\EvilHangman\\src\\com\\company\\dictionary.txt"));
            while(fileScanner.hasNextLine()){
                words.add(fileScanner.nextLine());
            }
            for(int i = 0; i < words.size(); i++){
                if(words.get(i).length() != length){
                    words.remove(i);
                    i--;
                }
            }
            System.out.println(words);
        } catch (IOException FileNotFound) {
            System.out.print("File could not be found");
        }

    }
}
