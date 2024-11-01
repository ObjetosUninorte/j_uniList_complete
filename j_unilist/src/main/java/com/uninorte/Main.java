package com.uninorte;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProfeList<String> example = new ProfeList<>();
        System.out.println(example.size());
        example.add("Augusto");
        example.add("Augusto2");
        System.out.println(example.size());
        System.out.println(example.get(0));
        System.out.println(example.get(1));
    }
}