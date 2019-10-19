package com.company;

public class SavingsAccount {
    static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(){
	    this.savingsBalance = 0.0;
    }

    public SavingsAccount(double savingsBalance){
        this.savingsBalance =  savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void calculateMonthlyInterest(){
        double interest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += interest;
    }

    public static void modifyInterestRate( double newVal){
        annualInterestRate = (newVal / 100);
    }


}