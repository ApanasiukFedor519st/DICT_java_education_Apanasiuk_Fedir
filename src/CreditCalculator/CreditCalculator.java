package CreditCalculator;
import java.util.Scanner;

import static java.lang.Math.*;

public class CreditCalculator {
    public static void main (String[] args){
        double principal;
        double number_period;
        double monthly_payments;
        double loan_interest;
        double years;
        double D_m;
        double Overpayment = 0;
        char parametric;
        Scanner in = new Scanner(System.in);
        String type = System.getProperty("type");
        String loan_interest_console = System.getProperty("interest");
        String principal_console = System.getProperty("principal");
        String periods_console = System.getProperty("periods");
        String monthly_payments_console = System.getProperty("payment");
        if (type == null) {
            System.out.println("Incorrect parameters.");
        }else if (loan_interest_console == null) {
            System.out.println("Incorrect parameters.\n");
        }else if (type.equals("annuity")) {
            loan_interest = Double.parseDouble(loan_interest_console);
            loan_interest = loan_interest / (12 * 100);
            if (principal_console != null && periods_console != null) {
                principal = Double.parseDouble(principal_console);
                number_period = Double.parseDouble(periods_console);

                monthly_payments = principal * (loan_interest * pow(1 + loan_interest, number_period)) / (pow(1 + loan_interest, number_period) - 1);
                monthly_payments = ceil(monthly_payments);
                System.out.println("Your monthly payment = " + monthly_payments);
            }else if (monthly_payments_console != null && periods_console != null) {
                monthly_payments = Double.parseDouble(monthly_payments_console);
                number_period = Double.parseDouble(periods_console);

                principal = monthly_payments / ((loan_interest * pow(1 + loan_interest, number_period)) / (pow(1 + loan_interest, number_period) - 1));
                principal = ceil(principal);
                System.out.println("Your loan principal = " + principal);
            }else if (monthly_payments_console != null && principal_console != null) {
                monthly_payments = Double.parseDouble(monthly_payments_console);
                principal = Double.parseDouble(principal_console);
                number_period = log(monthly_payments / (monthly_payments - loan_interest * principal)) / log(1 + loan_interest);
                number_period = ceil(number_period);
                years = number_period / 12;
                years = floor(years);
                System.out.print("It will take " + years + " years");
                if (number_period - years * 12 > 0) {
                    number_period = number_period - years * 12;
                    System.out.print(" and " + number_period + " months to repay this loan!");
                }
            }else {
                System.out.println("Incorrect parameters.");
            }
        }else if (type.equals("diff")) {
            loan_interest = Double.parseDouble(loan_interest_console);
            loan_interest = loan_interest / (12 * 100);
            if (principal_console == null || periods_console == null){
                System.out.println("Incorrect parameters.");
            }
            else {
                principal = Double.parseDouble(principal_console);
                number_period = Double.parseDouble(periods_console);
                for (int m = 1; m <= number_period; m++) {
                    D_m = principal / number_period + loan_interest * (principal - (principal * (m - 1)) / number_period);
                    D_m = ceil(D_m);
                    Overpayment = Overpayment + (D_m-(principal/number_period));
                    System.out.println("You must pay for " + number_period + " months. Payment is " + D_m);
                }
                System.out.println("Overpayment = " + Overpayment);
            }

        } else {
            System.out.println("Incorrect parameters.");
        }
    }
}