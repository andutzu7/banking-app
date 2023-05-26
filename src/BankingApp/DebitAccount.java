package BankingApp;

public class DebitAccount extends Account {

    public DebitAccount(int balance,double commissionRate) throws Exception {
        super(balance,commissionRate);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            //System.out.println(String.format("Successfully withdrew %d .",amount));
            return true;
        }
        else{
            //System.out.println("Insufficient funds.");
            return false;
        }

    }

}
