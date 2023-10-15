package com.assignment.game;


import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; 
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;
            rounds++;

            System.out.println("Round " + rounds);
            System.out.println("I've selected a random number between 1 and 100. Try to guess it.");

            while (numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                    score += maxAttempts - numberOfTries + 1;
                    break;
                }
            }

            System.out.println("Round " + rounds + " over.");
            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game over. Your final score: " + score);
        scanner.close();
    }
}
