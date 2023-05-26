package BankingApp;

public class Customer {
    private String name;
    private DebitAccount debitAccount;
    private CreditAccount creditAccount;

    public Customer(String name, DebitAccount debitAccount) {
        this.name = name;
        this.debitAccount = debitAccount;
    }

    public Customer(String name, DebitAccount debitAccount, CreditAccount creditAccount) {
        this.name = name;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DebitAccount getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(DebitAccount debitAccount) {
        this.debitAccount = debitAccount;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }
}