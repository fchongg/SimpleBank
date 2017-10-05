package com.bank;

import java.util.*;
import com.bank.Luhn;

/**
 * Created by Frances on 2017-09-30.
 */
public class Bank {
    HashMap accounts;

    // TODO: write test cases
    public Bank(){
        accounts = new HashMap<String, ArrayList<String>>();
    }

    public HashMap getAccounts(){
        return accounts;
    }
    // This function creates an account and inputs it
    // into the bank history
    public void createAccount(String name, String account_num, String limit){
        if(name.equals("")){
            return;
        }
        ArrayList<String> new_account = new ArrayList<String>();
        boolean luhn_approved = Luhn.Check(account_num);
        new_account.add(account_num);
        new_account.add(limit);
        if(!luhn_approved){
          // this sets the balance to error
          new_account.add("error");
        }
        else {
          new_account.add("0");
        }
        accounts.put(name, new_account);
    }

    // This function debits the amount to the specified bank account
    // If the amount being debited will result in a balance greater than the
    // limit, then it will not be debited
    // If it's a Luhn cc, then nothing will be done to the balance (error will persist)
    public void charges(String name, String amount){
        ArrayList<String> account_info = (ArrayList<String>) accounts.get(name);
        if (account_info.get(2).equals("error")){
          return;
        }
        int limit = Integer.parseInt(account_info.get(1).substring(1));
        int balance = Integer.parseInt(account_info.get(2));
        int new_bal = balance + Integer.parseInt(amount.substring(1,amount.length()));
        if (new_bal <= limit){
            ((ArrayList<String>) accounts.get(name)).set(2, Integer.toString(new_bal));
        }
    }

    // This function credits the amount from the account o
    // If it's a Luhn cc, then nothing will be done to the balance (error will persist)
    public void credit(String name, String amount){
        ArrayList<String> account_info = (ArrayList<String>) accounts.get(name);
        if (account_info.get(2).equals("error")){
          return;
        }
        int balance = Integer.parseInt(account_info.get(2));
        int new_bal = balance - Integer.parseInt(amount.substring(1,amount.length()));
        ((ArrayList<String>) accounts.get(name)).set(2, Integer.toString(new_bal));
    }

    // This function prints out the summary statement
    public void printSummary(){

        SortedSet<String> keys = new TreeSet<String>(accounts.keySet());
        for (String key : keys) {
            ArrayList<String> value = (ArrayList<String>) accounts.get(key);

            String balance = value.get(2);
            if(!balance.equals("error")){
                balance = "$" + balance;
            }
            System.out.println(key + ": " + balance);
        }
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
