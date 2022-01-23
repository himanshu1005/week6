package week6.problem2;

import java.util.List;
import java.util.Objects;

/*
properties of the bank Account
BankAccountNo
AccountType
branch
balance

Additional Field for future

AtmTransactions
emiSchedule
 */
public class Account {

    private int bankAccountNo;
    private AccountType accountType;
    private String branch;
    private long balance;
    private final List<String> atmTransactions;
    private final List<String> emiSchedule;

    public Account(AccountBuilder accountBuilder) {
        this.bankAccountNo = accountBuilder.bankAccountNo;
        this.accountType = accountBuilder.accountType;
        this.branch = accountBuilder.branch;
        this.balance = accountBuilder.balance;

        this.atmTransactions = accountBuilder.atmTransactions;
        this.emiSchedule = accountBuilder.emiSchedule;
    }

    public int getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(int bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return bankAccountNo == account.bankAccountNo && balance == account.balance && accountType == account.accountType && Objects.equals(branch, account.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNo, accountType, branch, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankAccountNo=" + bankAccountNo +
                ", accountType=" + accountType +
                ", branch='" + branch + '\'' +
                ", balance=" + balance +
                ", atmTransactions=" + atmTransactions +
                ", emiSchedule=" + emiSchedule +
                '}';
    }

    /**
     * Define the builder for this Account class
     *
     * @return
     */

    public static class AccountBuilder {
        //Mandatory
        private final int bankAccountNo;
        private final AccountType accountType;
        private final String branch;
        private final long balance;
        //additional field
        private List<String> atmTransactions;
        private List<String> emiSchedule;

        //constructor of builder
        public AccountBuilder(int bankAccountNo, AccountType accountType, String branch, long balance) {
            this.bankAccountNo = bankAccountNo;
            this.accountType = accountType;
            this.branch = branch;
            this.balance = balance;
        }

        /**
         * Main focous for Builder design pattern
         *
         * @param atmTransactions
         * @return
         */
        public AccountBuilder setAtmTransactions(List<String> atmTransactions) {
            this.atmTransactions = atmTransactions;
            return this;
        }

        /**
         * Main focous for Builder design pattern
         *
         * @param emiSchedule
         * @return
         */
        public AccountBuilder setEmiSchedule(List<String> emiSchedule) {
            this.emiSchedule = emiSchedule;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
