package com.bank;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Frances on 2017-09-30.
 */
public class Bank {
    HashMap accounts;

    // TODO: write test cases
    public Bank(){
        accounts = new HashMap<String, ArrayList<String>>();
    }

    public void createAccount(String name, String account_num, String limit){
        ArrayList<String> new_account = new ArrayList<String>();
        new_account.add(account_num);
        new_account.add(limit);
        new_account.add("0");
        accounts.put(name, new_account);

        System.out.print(accounts.get(name).toString());
    }

    // This function debits the amount to the specified bank account
    // If the amount being debited will result in a balance greater than the
    // limit, then it will not be debited
    public void charges(String name, String amount){
        ArrayList<String> account_info = (ArrayList<String>) accounts.get(name);
        int limit = Integer.parseInt(account_info.get(1).substring(1));
        int balance = Integer.parseInt(account_info.get(2));
        int new_bal = balance + Integer.parseInt(amount);
        if (new_bal <= limit){
            ((ArrayList<String>) accounts.get(name)).set(2, Integer.toString(new_bal));
        }

        System.out.println(accounts.get(name).toString());

    }

    // This function credits the amount from the account o
    // Credits against Luhn 10 cards will produce an error
    public void credit(String name, String amount){
        ArrayList<String> account_info = (ArrayList<String>) accounts.get(name);
        int balance = Integer.parseInt(account_info.get(2));
        int new_bal = balance - Integer.parseInt(amount);
        accounts.get(name).set(2, Integer.toString(new_bal));

        System.out.println(accounts.get(name).toString());
    }

    // This function prints out the summary statement
    public void printSummary(){
        for (accounts.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(2));
        }
    }
}
