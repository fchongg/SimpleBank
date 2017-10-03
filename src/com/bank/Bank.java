package com.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        int new_bal = balance + Integer.parseInt(amount.substring(1,amount.length()));
        if (new_bal <= limit){
            ((ArrayList<String>) accounts.get(name)).set(2, Integer.toString(new_bal));
        }

        System.out.println(accounts.get(name).toString());

    }

    // This function credits the amount from the account only if
    // the credit does not make the balance fall below zero
    public void credit(String name, String amount){
        ArrayList<String> account_info = (ArrayList<String>) accounts.get(name);
        int balance = Integer.parseInt(account_info.get(2));
        int new_bal = balance - Integer.parseInt(amount.substring(1,amount.length()));
        if (new_bal >= 0){
            ((ArrayList<String>) accounts.get(name)).set(2, Integer.toString(new_bal));
        }

        System.out.println(accounts.get(name).toString());
    }

    // This function prints out the summary statement
    public void printSummary(){

    }

    public void doAction(String line){
        String[] parts = line.split(" ");
        String function = parts[0];
        if (function.equals("Add")){
            this.createAccount(parts[1], parts[2], parts[3]);
        }
        else if (function.equals("Charge")){
            this.charges(parts[1], parts[2]);
        }
        else if (function.equals("Credit")){
            this.credit(parts[1], parts[2]);
        }
    }
}
