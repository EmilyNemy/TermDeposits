package org.termdeposit;

import org.termdeposit.InterestPeriod;
import org.termdeposit.TermDeposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double principal = 0;
        while(true){
            System.out.print("Enter the principal: ");
            if( scan.hasNextDouble()){
                principal = scan.nextDouble();
                break;
            }else{
                System.out.print("Invalid input. Please enter a valid number.");
                scan.next();
            }
        }

        double interest = 0;
        while (true){
            System.out.print("Enter the interest rate: ");
            if(scan.hasNextDouble()){
                interest = scan.nextDouble();
                break;
            }else {
                System.out.print("Invalid input Please enter a valid number. ");
                scan.next();
            }
        }

        int term = 0;
        while (true){
            System.out.print("Enter the investment term in years: ");
            if(scan.hasNextDouble()){
                term = scan.nextInt();
                break;
            }else {
                System.out.print("Invalid input Please enter a valid number. ");
                scan.next();
            }
        }

        String interestPeriod = "";
        while(true){
            System.out.print("Enter the interest period e.g  ((MONTHLY, QUARTERLY, ANNUALLY, AT MATURITY): ");
            List<String> intPeriod = new ArrayList<>();
            intPeriod.add("MONTHLY");
            intPeriod.add("QUARTERLY");
            intPeriod.add("ANNUALLY");
            intPeriod.add("AT MATURITY");
            intPeriod.add("monthly");
            intPeriod.add("quarterly");
            intPeriod.add("annually");
            intPeriod.add("at maturity");

            if(scan.hasNext()){
              interestPeriod = scan.next();
              if(intPeriod.contains(interestPeriod)){
                  break;
              }else{
                  System.out.print("Invalid input please enter a valid interest period");
              }
            }
        }

        TermDeposit termDeposit = new TermDeposit(principal, interest, term);
        double finalBalance = termDeposit.getCompoundInterest(InterestPeriod.valueOf(interestPeriod.toUpperCase()));

        System.out.println("Value will be " + finalBalance + "at the end of " + term + " years " );
    }
}