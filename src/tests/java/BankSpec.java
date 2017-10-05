package tests.java;

import com.bank.Bank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankSpec {

    @Test
    public void createValidAccount(){
        String name = "Ben";
        String account_num = "4539502788334768";
        String limit = "$1000";

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("0");
        expected.put(name, expected_list);

        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void createLuhnAccount(){
        String name = "Ben";
        String account_num = "1239874986187326";
        String limit = "$0";

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("error");
        expected.put(name, expected_list);

        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void createAccountWithEmptyString(){
        String name = "";
        String account_num = "1239874986187326";
        String limit = "$0";

        HashMap expected = new HashMap<>();

        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void addMoneyToAccountUnderLimit(){
        String name = "Ben";
        String account_num = "4539502788334768";
        String limit = "$300";
        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);
        new_bank.charges(name, "$200");

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("200");
        expected.put("Ben", expected_list);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void addMoneyToAccountOverLimit(){
        String name = "Ben";
        String account_num = "4539502788334768";
        String limit = "$300";
        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);
        new_bank.charges(name, "$500");

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("0");
        expected.put("Ben", expected_list);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void addMoneyToLuhnAccount(){
        String name = "Ben";
        String account_num = "12893798172641";
        String limit = "$300";
        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);
        new_bank.charges(name, "$500");

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("error");
        expected.put("Ben", expected_list);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void creditMoneyToAccount(){
        String name = "Ben";
        String account_num = "4539502788334768";
        String limit = "$300";
        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);
        new_bank.credit(name, "$500");

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("-500");
        expected.put("Ben", expected_list);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void creditMoneyToLuhnAccount(){
        String name = "Ben";
        String account_num = "12893798172641";
        String limit = "$300";
        Bank new_bank = new Bank();
        new_bank.createAccount(name, account_num, limit);
        new_bank.credit(name, "$500");

        HashMap expected = new HashMap<>();
        ArrayList<String> expected_list = new ArrayList<>();
        expected_list.add(account_num);
        expected_list.add(limit);
        expected_list.add("error");
        expected.put("Ben", expected_list);

        HashMap actual = new_bank.getAccounts();
        assertEquals(expected,actual);
    }



}
