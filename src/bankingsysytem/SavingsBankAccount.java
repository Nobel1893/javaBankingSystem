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
public class SavingsBankAccount extends BankAccount {
    
    double minimumBalance ;

    public SavingsBankAccount( int account_id, double balance) {
        super(account_id, balance);
        this.minimumBalance = 1000;
    }

    public SavingsBankAccount() {
        balance=1000;
        minimumBalance=1000;
        account_id=0;
    }

    @Override
    public boolean Withdraw(double amount) {
        if (balance-amount<minimumBalance){
            System.err.println("invalid amount");
            return false;
        }
        balance-=amount;
        return true;
    }

    @Override
    public boolean Deposit(double amount) {
        
        if(amount<100){
            System.err.println("invalid amount");
            return false;
        }
        balance+=amount;
        return true;
    }

    @Override
    public void View() {
//        System.out.println("id : "+account_id);
//        System.out.println("balance : "+balance);
        super.View();
        System.out.println("min Balance : "+minimumBalance);
    }
    
    
    
    
   
    
    
    
}
