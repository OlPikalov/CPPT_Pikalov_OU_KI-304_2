import java.io.*;
import java.util.*;

/**
 * Lab1PikalovKI304 class implements creation of a symmetric pattern
 * with a given size and character. The result is printed to console
 * and written to a file.
 * 
 * @author 
 * @version 1.0
 */
public class Lab1PikalovKI304 {

    /**
     * Fills a jagged 2D character array with a given symbol according to
     * the specified size and width. The array forms the basis of a symmetric pattern.
     *
     * @param arr       two-dimensional char array to fill
     * @param size      overall size of the pattern
     * @param character character used to fill the pattern
     * @param width     thickness of the border
     */
    public static void fillArr(char arr[][], int size, char character, int width) {
        for (int i = 0; i < size; i++) {
            if (i < width + 1 || i >= size - width - 1) {
                arr[i] = new char[size / 2]; 
            } else {
                arr[i] = new char[width + 1];
            }

            for (int b = 0; b < arr[i].length; b++) {
                arr[i][b] = character;
            }
        }
    }

    /**
     * Main entry point of the program. Reads user input (character and size),
     * generates the symmetric pattern using {@link #fillArr(char[][], int, char, int)},
     * prints it to the console, and writes it to "MyFile.txt".
     *
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if the output file cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть символ: ");
        String str = in.next();
        if (str.length() != 1) {
            System.out.println("Непідходящий символ");
            System.exit(1);
        }
        char character = str.charAt(0);

        System.out.print("Введіть розмір: ");
        int size = in.nextInt();
        if (size < 3) {
            System.out.println("Замалий розмір");
            System.exit(1);
        }
        in.close();

        char[][] arr = new char[size][];
        int width = (size < 6) ? 1 : size / 6;

        fillArr(arr, size, character, width);

        PrintWriter fout = new PrintWriter(new File("MyFile.txt"));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                fout.print(arr[i][j]);
            }
            if (i > width && i < size - width - 1) {
                for (int k = width - 1; k < size - width - 3; k++) {
                    System.out.print(' ');
                    fout.print(' ');
                }
            }

            for (int j = arr[i].length - 1; j >= 0; j--) {
                System.out.print(arr[i][j]);
                fout.print(arr[i][j]);
            }
            System.out.println();
            fout.println();
        }
        fout.close();
    }
}
