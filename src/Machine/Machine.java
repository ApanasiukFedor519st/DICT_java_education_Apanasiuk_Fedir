package Machine;
import java.util.Scanner;

public class Machine {
    public static void main(String[] args){
        System.out.println("Write how many cups of coffee you will need:");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int water = 200;
        int milk = 50;
        int coffe = 15;
        System.out.println("For "+ input + " cups of coffee you will need:\n" +
                +water*input+" ml of water\n" +
                +milk*input+" ml of milk\n" +
                +coffe*input+" g of coffee beans");
    }
}