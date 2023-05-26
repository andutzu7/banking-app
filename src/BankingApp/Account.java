package BankingApp;

public abstract class Account {

    protected double balance;
    protected double commissionRate;

    public Account(int balance,double commissionRate) throws Exception {
        if (balance >= 0) {
            this.balance = balance;
            this.commissionRate=commissionRate;
        } else {
            throw new Exception("The balance value must be positive.");
        }

    }
    public abstract boolean withdraw(double amount);

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void balanceCheck(){
        System.out.println(String.format("Currently the account contains %s .", balance));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
