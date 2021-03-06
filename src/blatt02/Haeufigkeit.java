package blatt02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Haeufigkeit {
    private static final String FILE_NAME = "german.txt";       // most frequent letter : e
    private static final String FILE_NAME2 = "english.txt";     // most frequent letter : e
    private static final String FILE_NAME3 = "hindi.txt";       // most frequent letter : ा = aa ki matra


    public static void main(String[] args) {
        int rows = 256;
        int col = 2;
        int[][] array = new int[rows][col];

        File file = new File(FILE_NAME3);
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int rowCounter = 0;
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            for (char symbol : line.toCharArray()) {
                if (!symbolInArray(array, symbol)) {
                    array[rowCounter][0] = symbol;
                    array[rowCounter][1]++;
                    rowCounter++;
                } else {
                    int rowNumber = findSymbol(array, symbol);
                    array[rowNumber][1]++;
                }
            }
        }

        sortArray(array);
        printArray(array);

    }

    private static boolean symbolInArray(int[][] array, char symbol) {
        for (int i = 0; i < 256; i++) {
            if (array[i][0] == symbol) {
                return true;
            }
        }
        return false;
    }

    private static int findSymbol(int[][] array, char symbol) {
        int rowNumber = -1;     // -1 means not in the Array
        for (int i = 0; i < 256; i++) {
            if (array[i][0] == symbol) {
                return i;
            }
        }
        return rowNumber;
    }

    private static void sortArray(int[][] array) {   //in descending order of frequency
        int[] temp;
        boolean sorted = true;
        int j = 0;
        while (sorted) {
            sorted = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i][1] < array[i + 1][1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = true;
                }
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < 256; i++) {
            if ((array[i][0] != 0 && array[i][1] != 0)) {
                System.out.println((char) array[i][0] + " : " + array[i][1]);
            }
        }
    }


}
