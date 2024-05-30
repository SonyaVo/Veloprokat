package com.example.veloprokat;

import java.util.ArrayList;

public class List {


    public static ArrayList<String> list = new ArrayList<>();

    public static void add(String str){
        list.add(str);
    }

    public static String get(int i){
        return list.get(i);
    }


}
