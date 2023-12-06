package Hangman;
import java.util.Random;


public class Hangman {
    public static void main(String[] args) {
        String[] strArray = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN "+ "\nYou guess the word:");
        getRandomWord(strArray);
    }

    static String getRandomWord(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);

        if (index == 0) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
        return null;

    }
}