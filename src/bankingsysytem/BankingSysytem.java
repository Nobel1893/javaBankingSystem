/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsysytem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BankingSysytem {

    /**
     * @param args the command line arguments
     */
    public static void ViewAllAccounts() {
        for (int i = 0; i < allClients.size(); i++) {
            allClients.get(i).View();//access
            //allClients[i]
            System.out.println("**********************************");
        }

    }

    static int Search(int accountId) {
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getAccount_id() == accountId) {
                return i;
            }
        }
        return -1;
    }

    static void ViewAccount(int id) {
        int index = Search(id);
        if (index == -1) {
            System.err.println("account not found");
            return;
        }

        allClients.get(index).View();

    }

    private static void removeAccount(int id) {
        System.err.println(id);
        int index = Search(id);
        System.err.println(index);
        if (index == -1) {
            System.err.println("account not found");
            return;
        }
        System.out.println("account removed");
        allAccounts.remove(index);
        allClients.remove(index);

    }

    private static void addAccount() {

        input.nextLine();
        System.out.println("please enter name ");
        String name = input.nextLine();
        System.out.println("please enter phone ");
        String phone = input.nextLine();
        System.out.println("please enter address ");
        String address = input.nextLine();

        Client newClient = new Client(name, address, phone);

        int choice;
        System.out.println("enter 1 for basic account\n"
                + "enter 2 for savings bank account");
        choice = input.nextInt();
        if (choice != 1 && choice != 2) {
            System.err.println("wrong choice");
            return;
        }

        BankAccount bankAccount = null;
        System.out.println("enter account balance\n");
        double balance = input.nextDouble();

        if (choice == 1) {
            bankAccount = new BankAccount(allClients.size(), balance);
        } else if (choice == 2) {
            bankAccount = new SavingsBankAccount(allClients.size(), balance);
        }
        bankAccount.setOwner(newClient);
        newClient.setMyAccount(bankAccount);

        allClients.add(newClient);
        allAccounts.add(bankAccount);
    }

    private static void Withdraw(int id) {
        int index = Search(id);
        if (index == -1) {
            System.err.println("account not found");
            return;
        }
        System.out.println("enter amount");
        double amount = input.nextDouble();

        if (allAccounts.get(index).Withdraw(amount)) {
            System.out.println("successfull withdraw");
        }

    }

    private static void Deposit(int id) {
        int index = Search(id);
        if (index == -1) {
            System.err.println("account not found");
            return;
        }
        System.out.println("enter amount");
        double amount = input.nextDouble();

        if (allAccounts.get(index).Deposit(amount)) {
            System.out.println("successfull Deposit");
        }

    }

    static ArrayList<BankAccount> allAccounts;
    static ArrayList<Client> allClients;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        allAccounts = new ArrayList<>();
        allClients = new ArrayList<>();
        AddTestData();
        while (true) {
            System.out.println("1- view All Accounts \n"
                    + "2- search for Account\n"
                    + "3- Add Account\n"
                    + "4- remove Account\n"
                    + "5- deposit\n"
                    + "6- Withdraw\n"
                    + "7- exit");
            int choice = input.nextInt();
            if (choice == 1) {
                ViewAllAccounts();
            } else if (choice == 2) {
                System.out.println("please enter account id");
                int id = input.nextInt();
                ViewAccount(id);
            } else if (choice == 3) {
                addAccount();
            } else if (choice == 4) {
                System.out.println("please enter account id");
                int id = input.nextInt();
                removeAccount(id);
            } else if (choice == 6) {
                System.out.println("please enter account id");
                int id = input.nextInt();
                Withdraw(id);

            } else if (choice == 5) {
                System.out.println("please enter account id");
                int id = input.nextInt();
                Deposit(id);
            } else if (choice == 7) {
                break;
            }
        }
    }

    public static void AddTestData() {

        for (int i = 0; i < 20; i++) {
            BankAccount b = new BankAccount(i, 5000);
            Client c = new Client("name " + i, "address " + i, "phone " + i);

            b.setOwner(c);
            c.setMyAccount(b);

            allAccounts.add(b);
            allClients.add(c);
        }

    }

}
