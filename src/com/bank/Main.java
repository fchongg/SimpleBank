package com.bank;

import jdk.nashorn.internal.objects.NativeJSON;

import java.io.BufferedReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        List<String> lines = rf.readFile(args[0]);

        Bank new_bank = new Bank();
        for (int i = 0; i < lines.size(); i++){
            new_bank.doAction(lines.get(i));
        }
        new_bank.printSummary();
    }
}
