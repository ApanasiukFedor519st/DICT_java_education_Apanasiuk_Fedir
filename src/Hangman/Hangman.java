package Hangman;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArray = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN "+ "\nYou guess the word:");
        int rnd = new Random().nextInt(strArray.length);
        String w = strArray[rnd];
        System.out.print(w.charAt(0));
        System.out.print(w.charAt(1));
        for (int i = 2; i < w.length(); i++){
            System.out.print("-");
        }
        System.out.println();
        String word = scanner.nextLine();
        if (Objects.equals(word, w)){
            System.out.println("You survived!");
        }
        else {
            System.out.println("You lost!");
        }
    }


}