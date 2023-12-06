package Machine;
import java.util.Scanner;




public class Machine {

    int water = 400;

    int milk = 540;

    int beans = 120;

    int cups = 9;

    int money = 550;







    public static void main(String[] args) {

        Machine main = new Machine();

        main.menu();

    }




    public void menu() {

        Scanner in = new Scanner(System.in);

        boolean isexit = false;

        while (!isexit) {

            System.out.println();

            System.out.println("Write action (buy, fill, take, remaining, exit): ");

            String action = in.next();

            isexit = modifyState(action, in);

        }

        in.close();

    }




    private void Availability() {

        System.out.println("The coffee machine has: ");

        System.out.println(this.water + " of water");

        System.out.println(this.milk + " of milk");

        System.out.println(this.beans + " of coffee beans");

        System.out.println(this.cups + " of disposable cups");

        System.out.println("$" + this.money + " of money");

    }

    private void complete_the_order(int water, int milk, int beans, int money) {

        if (cups > 0 && this.water - water >= 0 && this.milk - milk >= 0 && this.beans - beans >= 0) {

            System.out.println("I have enough resources, making you a coffee!");

            this.cups--;

            this.water -= water;

            this.milk -= milk;

            this.beans -= beans;

            this.money += money;

        } else {

            System.out.println("Sorry, not enough " +

                    (cups <= 0 ? "cups" : this.water - water < 0 ? "water" : this.milk - milk < 0 ? "milk" : "beans")

                    + "!");

        }

    }

    private boolean modifyState(String action, Scanner in) {

        System.out.println();

        switch (action) {

            case "buy":

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

                switch (in.next()) {

                    case "1":

                        complete_the_order(250,0,16,4);

                        break;

                    case "2":

                        complete_the_order(350,75,20,7);

                        break;

                    case "3":

                        complete_the_order(200,100,12,6);

                        break;

                    case "back":

                        return false;

                    default:

                        break;

                }

                break;

            case "fill":

                System.out.println("Write how many ml of water do you want to add: ");

                this.water += in.nextInt();




                System.out.println("Write how many ml of milk do you want to add: ");

                this.milk += in.nextInt();




                System.out.println("Write how many grams of coffee beans do you want to add: ");

                this.beans += in.nextInt();




                System.out.println("Write how many disposable cups of coffee do you want to add: ");

                this.cups += in.nextInt();

                break;

            case "take":

                System.out.println("I gave you " + this.money + "$");

                this.money = 0;

                break;

            case "remaining":

                this.Availability();

                break;

            case "exit":

                return true;

            default:

                break;

        }

        return false;

    }

}