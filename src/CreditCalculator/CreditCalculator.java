package CreditCalculator;
import java.util.Scanner;
import static java.lang.Math.*;

public class CreditCalculator {
    public static void main (String[] args){
        double principal;
        double months;
        double monthly_payments;
        char parametric;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your principal: ");
        principal = in.nextInt();
        System.out.print("Enter your parametric (m/n): ");
        parametric = in.next().charAt(0);
        if (parametric == 'm') {
            System.out.print("Enter the monthly payment:");
            monthly_payments = in.nextInt();
            months = principal / monthly_payments;
            months = ceil(months);
            System.out.println("Your must paying for" + months + "months");
        }else if (parametric == 'p') {
            System.out.print("Enter months");
            months = in.nextInt();
            monthly_payments = principal / months;
            monthly_payments = ceil(monthly_payments);

            System.out.print("Your monthy paymens = " + monthly_payments);
            if (principal - (monthly_payments * months) < 0) {
                monthly_payments = principal - (monthly_payments * (months - 1));
                System.out.println(" and last payment =" + monthly_payments);
            }
        }else {
            System.out.println("ERROR");
        }
    }
}