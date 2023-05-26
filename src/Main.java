import BankingApp.BankSystem;
import BankingApp.CreditAccount;
import BankingApp.Customer;
import BankingApp.DebitAccount;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        DebitAccount customer1DebitAccount = new DebitAccount(500,0.02);
        CreditAccount customer1CreditAccount = new CreditAccount(500,500,0.1);
        Customer customer1 = new Customer("Customer 1", customer1DebitAccount,  customer1CreditAccount);

        DebitAccount customer2DebitAccount = new DebitAccount(1000,0.05);
        CreditAccount customer2CreditAccount = new CreditAccount(1000,4000,0.1);
        Customer customer2 = new Customer("Customer 2",  customer2DebitAccount, customer2CreditAccount);

        DebitAccount customer3DebitAccount = new DebitAccount(200,0.05);
        Customer customer3 = new Customer("Customer 3",  customer2DebitAccount, customer2CreditAccount);

        HashMap<Customer,Double> customers = new HashMap<>();

        customers.put(customer1,0.0);
        customers.put(customer2,0.0);
        customers.put(customer3,0.0);

        BankSystem bankingSystem = new BankSystem(customers);

        bankingSystem.performTransaction(customer1,"Withdraw",100);
        bankingSystem.performTransaction(customer1,"Withdraw",200);
        bankingSystem.performTransaction(customer1,"Withdraw",500);

        bankingSystem.performTransaction(customer1,"DebitAccountDeposit",100);

        bankingSystem.performTransaction(customer2,"Withdraw",4500);
        bankingSystem.performTransaction(customer2,"Withdraw",5000);


        bankingSystem.performTransaction(customer3,"Withdraw",5000);
        double totalCommission=bankingSystem.computeTotalCommission();

        Map<Customer, Double> commissionTable= bankingSystem.getCustomers();

        System.out.println(String.format("Total commission collected after the transactions: %s", totalCommission));
        System.out.println("Detailed statistics:");

        for(Customer key:commissionTable.keySet()){
            System.out.println(String.format("%s - commission amount - %s",key.getName(),commissionTable.get(key)));
        }

        Customer customer4 = new Customer("Customer 4",  customer2DebitAccount, customer2CreditAccount);
        bankingSystem.performTransaction(customer4,"Withdraw",5000);


    }
}