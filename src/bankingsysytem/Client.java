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
public class Client {
    
    String name;
    String address;
    String phone;
    BankAccount myAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public BankAccount getMyAccount() {
        return myAccount;
    }

    public void setMyAccount(BankAccount myAccount) {
        this.myAccount = myAccount;
    }
    
    
    public void View (){
        System.out.println("name : "+name);
        System.out.println("address : "+address);
        System.out.println("phone : "+phone);
        myAccount.View();
    }
    
    
}
