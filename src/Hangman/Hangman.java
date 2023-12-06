package Hangman;
import java.util.Objects;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        System.out.println("Guess the word: ");
        String word = scanner.nextLine();
        if (Objects.equals(word, "java")) {
            System.out.println("You survived!");
        }
        else {
            System.out.println("You lost!");
        }
    }
}