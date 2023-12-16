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
        char parametric;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your parametric (m/n): ");
        parametric = in.next().charAt(0);
        System.out.print("Enter the loan interest:");
        loan_interest=in.nextDouble();
        loan_interest=loan_interest/(12*100);
        if (parametric == 'a'){
            System.out.print("Enter your principal: ");
            principal = in.nextDouble();
            System.out.print("Enter number of periods: ");
            number_period=in.nextDouble();
            monthly_payments=principal*(loan_interest*pow(1+loan_interest,number_period))/(pow(1+loan_interest,number_period)-1);
            monthly_payments=ceil(monthly_payments);
            System.out.print("Your monthly payment = " +monthly_payments);
        }
        else if (parametric == 'p') {
            System.out.print("Enter the annuity payment: ");
            monthly_payments = in.nextDouble();
            System.out.print("Enter number of periods: ");
            number_period = in.nextDouble();
            principal = monthly_payments * (loan_interest * pow(1 + loan_interest, number_period)) / (pow(1 + loan_interest, number_period) - 1);
            principal = ceil(principal);
            System.out.print("Your loan principal = " + principal);
        }
        else if (parametric=='n'){
            System.out.print("Enter the monthy payment: ");
            monthly_payments = in.nextDouble();
            System.out.print("Enter principal : ");
            principal=in.nextDouble();
            number_period=log(monthly_payments/(monthly_payments-loan_interest*principal))/log(1+loan_interest);
            number_period=ceil(number_period);
            years=number_period/12;
            years=floor(years);
            System.out.print("If will take"+ years+ "years");
            if (number_period-years*12>0){
                number_period=number_period-years*12;
                System.out.print("and" +number_period+ "months to repay this loan");
            }
        }else {
            System.out.println("ERROR");
        }
    }
}