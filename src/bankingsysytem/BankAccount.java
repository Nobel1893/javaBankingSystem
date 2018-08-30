/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsysytem;

/**
 *
 * @author Admin
 */
public class BankAccount {
    
     protected int account_id;
     protected double balance;
     protected Client owner;

    public BankAccount(int account_id, double balance) {
        this.account_id = account_id;
        this.balance = balance;
    }

    public BankAccount() {
        balance=0;
        account_id=0;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    public boolean Withdraw(double amount){
        if (balance<amount){
            System.err.println("invalid amount");
            return false;
        }
        balance-=amount;
        return true;
    }
    
    public boolean Deposit(double amount){
        if (amount<0){
            System.err.println("invalid amount");
            return false;
        }
        balance+=amount;
        return true;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    
    
    public void View (){
     //   owner.View();
        System.out.println("id : "+account_id);
        System.out.println("balance : "+balance);
    }
    
}
