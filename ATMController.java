package com.test.mojo.testproject;

public class ATMController {
    public static void main(String[] args) {
        ATM atm = new ATM();

        System.out.println("Deposit 1: 10s: 8, 5s: 20");
        System.out.println("------------------------");
        atm.deposit(8,10);
        atm.deposit(20,5);
        atm.printAmount();
        System.out.println("Deposit 2: 20s: 3, 5s: 18, 1s: 4");
        System.out.println("------------------------");
        atm.deposit(3,20);
        atm.deposit(18,5);
        atm.deposit(4,1);
        atm.printAmount();


        System.out.println("Withdraw 1: 75");
        System.out.println("------------------------");
        atm.withdraw(75);
        atm.printAmount();
        System.out.println("Withdraw 2: 122");
        System.out.println("------------------------");
        atm.withdraw(122);
        atm.printAmount();
        System.out.println("Withdraw 3: 253");
        System.out.println("------------------------");
        atm.withdraw(253);
        atm.printAmount();
        System.out.println("Withdraw 4: 0");
        System.out.println("------------------------");
        atm.withdraw(0);
        atm.printAmount();
        System.out.println("Withdraw 5: -25");
        System.out.println("------------------------");
        atm.withdraw(-25);
        atm.printAmount();

    }
}
