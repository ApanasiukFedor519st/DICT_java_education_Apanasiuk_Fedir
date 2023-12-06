package Hangman;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        ArrayList guessed = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String[] strArray = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN");
        int rnd = new Random().nextInt(strArray.length);
        String w = strArray[rnd];
        String temp_word = w.replaceAll("[a-z]", "-");
        StringBuilder hidden_word = new StringBuilder(temp_word);
        System.out.println(hidden_word);
        int i = 0;
        while (i < 8) {
            System.out.print("\nInput a letter:");
            String input = scanner.next();

            if (!input.matches(".")) {
                System.out.println("You should input a single letter");
                continue;
            }

            if (!input.matches("[a-z]")) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (guessed.contains(input.charAt(0))) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            if (!w.contains(input)) {
                System.out.println("That letter doesnt appear in the word!");
                i++;
                continue;
            }
            guessed.add(input.charAt(0));
            for (int z = 0; z < hidden_word.length(); z++) {
                if (w.charAt(z) == input.charAt(0)){
                    hidden_word.setCharAt(z, input.charAt(0));
                }
            }
            System.out.println(hidden_word);
            long lettersToGuess = hidden_word.toString().chars().filter(ch -> ch == '-').count();
            if (lettersToGuess == 0) break;
        }
        if (i == 8) {
            System.out.println("You lost!");
            return;
        }

        System.out.println("You guessed the word!");
        System.out.println("You survived!");
    }
}