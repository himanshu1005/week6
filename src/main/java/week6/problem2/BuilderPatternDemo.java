package week6.problem2;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Account savingAccount = new Account.AccountBuilder(17867350, AccountType.SAVING, "ALIGANJ", 100000L)
                .setAtmTransactions(atmTransactions())
                .setEmiSchedule(emiSchedules())
                .build();

        System.out.println("Saving account created is - " + savingAccount);


    }

    private static List<String> atmTransactions() {
        ArrayList<String> atmTransactions = new ArrayList<>();
        atmTransactions.add("1-OCt-2021");
        atmTransactions.add("2-Jan-2022");
        return atmTransactions;
    }

    private static List<String> emiSchedules() {
        ArrayList<String> emischedules = new ArrayList<>();
        emischedules.add("5-Feb-2022");
        emischedules.add("5-Mar-2022");
        return emischedules;
    }
}
