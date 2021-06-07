package be.intecbrussel.lotto;

import java.util.Arrays;
import java.util.Random;

public final class Lotto {

    private static Random generate = new Random();
    private static int[] draw = new int[7];
    private static int[] firstSixNumbers = new int[6];
    private static boolean alreadyExists = true;
    private static int temp;


    //generate 7 different numbers (1-45) and store in array draw
    private static void generateLottoResults() {
        for (int i = 0; i < 7; i++) {

            do {
                temp = generate.nextInt(45) + 1;
            } while (alreadyExistsInArray(temp));

            draw[i] = temp;
        }
    }

    // test to see if number already is in the array
    private static boolean alreadyExistsInArray(int testNumber) {

        for (int j : draw) {
            if (testNumber == j) {
                return true;
            }
        }
        return false;
    }

    // take the first six numbers, store in firstSixNumbers and sort them
    private static void firstSix() {
        for (int i = 0; i < 6; i++) {
            firstSixNumbers[i] = draw[i];
        }
        Arrays.sort(firstSixNumbers);
    }

    // print the result of the Lotto draw; reserve number is the 7th in the draw
    public static void printResults() {
        generateLottoResults();
        firstSix();

        for (int j : firstSixNumbers) {
            System.out.print(j + "\t");
        }
        System.out.println("\n________________________");
        System.out.println("Reservegetal: " + draw[6]);
    }
}

