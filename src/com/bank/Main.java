package com.bank;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        Bank new_bank = new Bank();
        new_bank.createAccount("Ben", "218397189", "$1000");
        new_bank.charges("Ben", "20");
        new_bank.charges("Ben", "800");
        new_bank.charges("Ben", "200");
        new_bank.credit("Ben", "50");
        new_bank.credit("Ben", "1000");
    }
}
