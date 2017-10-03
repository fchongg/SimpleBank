package com.bank;

import jdk.nashorn.internal.objects.NativeJSON;

import java.io.BufferedReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReadFile rf = new ReadFile();
        List<String> lines = rf.readFile(args[0]);

        System.out.println(lines);
        Bank new_bank = new Bank();
        for (int i = 0; i < lines.size(); i++){
            new_bank.doAction(lines.get(i));
        }
//        new_bank.createAccount("Ben", "218397189", "$1000");
//        new_bank.charges("Ben", "$20");
//        new_bank.charges("Ben", "$800");
//        new_bank.charges("Ben", "$200");
//        new_bank.credit("Ben", "$50");
//        new_bank.credit("Ben", "$1000");
    }
}
