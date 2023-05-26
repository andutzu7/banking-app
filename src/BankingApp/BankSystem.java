package BankingApp;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<Customer, Double> customers;

    public BankSystem(Map<Customer, Double> customers) {
        this.customers = customers;
    }

    public Map<Customer, Double> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Customer, Double> customers) {
        this.customers = customers;
    }

    public BankSystem() {
        customers = new HashMap<>();
    }

    public void performTransaction(Customer c, String transactionName, double amount) {

        if (customers.get(c) == null) {
            System.out.println("The specified client doesn't exist.");
        } else {

            switch (transactionName) {
                case "Withdraw":

                    boolean performed_transaction = false;
                    double commission_tax = amount * c.getDebitAccount().getCommissionRate();
                    // We first try to extract the money from the debit account
                    if (c.getDebitAccount().withdraw(amount + commission_tax)) {
                        performed_transaction = true;
                        System.out.println(String.format("Successfully withdrew %s .", amount));
                        System.out.println(String.format("Commission tax: %s .", commission_tax));
                    } else {
                        // check if the user has a credit account
                        if (c.getCreditAccount() != null) {
                            // Otherwise we try the credit account
                            commission_tax = amount * c.getCreditAccount().getCommissionRate();
                            // if we successfully withdrew money from the debit account
                            if (c.getCreditAccount().withdraw(amount + commission_tax)) {

                                performed_transaction = true;
                                System.out.println(String.format("Successfully withdrew %s .", amount));
                                System.out.println(String.format("Commission tax: %s .", commission_tax));

                            }
                        }
                        if (!performed_transaction) {
                            double failure_commission = 0.005;
                            double accountBalance = c.getDebitAccount().getBalance();
                            commission_tax = failure_commission * accountBalance;
                            c.getDebitAccount().setBalance(accountBalance - commission_tax);
                            System.out.println("Insufficient funds.");
                            System.out.println(String.format("%s has been deducted from your account.", commission_tax));
                        }
                    }
                    //updating the commission
                    customers.put(c, customers.get(c) + commission_tax);

                    break;
                case "CreditAccountDeposit":
                    if (c.getCreditAccount() != null) {
                        c.getCreditAccount().deposit(amount);

                        System.out.println(String.format("Deposited %s into the credit account.", amount));
                    }

                    break;
                case "DebitAccountDeposit":
                    //First we treat the case where the balance in the credit account is negative
                    c.getDebitAccount().deposit(amount);
                    System.out.println(String.format("Deposited %s into the debit account.", amount));
                    break;
            }
        }
    }

    public double computeTotalCommission() {
        return this.customers.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
