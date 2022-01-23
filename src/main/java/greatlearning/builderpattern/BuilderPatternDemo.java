package greatlearning.builderpattern;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Account savingAccount = new Account.AccountBuilder(2008059568, AccountType.SAVING, "WHITEFIELD", 500000L)
                .setAtmTransactions(atmTransactions())
                .setEmiSchedule(emiSchedules())
                .build();

        System.out.println("Saving account created is - " + savingAccount);


    }

    private static List<String> atmTransactions() {
        ArrayList<String> atmTransactions = new ArrayList<>();
        atmTransactions.add("15-Nov-2020");
        atmTransactions.add("20-Feb-2021");
        return atmTransactions;
    }

    private static List<String> emiSchedules() {
        ArrayList<String> emischedules = new ArrayList<>();
        emischedules.add("10-Mar-2021");
        emischedules.add("20-Jun-2021");
        return emischedules;
    }
}
