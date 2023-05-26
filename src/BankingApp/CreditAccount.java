package BankingApp;

public class CreditAccount extends Account {

    private int creditLimit;

    public CreditAccount(int balance, int creditLimit, double commissionRate) throws Exception {
        super(balance,commissionRate);
        this.creditLimit = creditLimit;
    }

    public boolean withdraw(double amount) {
        if (balance + creditLimit >= amount) {
            balance -= amount;
            //System.out.println(String.format("Successfully withdrew %d .",amount));
            return true;
        }
        else{
            //System.out.println("Insufficient funds.");
            return false;
        }
    }
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}
