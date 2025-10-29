package KI304PikalovLab5;

import java.io.*;
import java.util.*;

/**
 * Головний клас лабораторної роботи №5.
 * <p>
 * Програма зчитує значення аргументу {@code x} з клавіатури, обчислює вираз
 * <pre>
 *     y = (x - 4) / sin(3x - 1)
 * </pre>
 * за допомогою класу {@link Equasion}, записує результат у текстовий та бінарний файли,
 * а потім зчитує та виводить їх вміст у консоль.
 * </p>
 * <p>
 * Використовує обробку винятків для некоректного вводу та проблем із файлами.
 * </p>
 * 
 * @author
 *     Pikalov Oleksandr, KI-304
 * @version 1.0
 */
public class Lab5PikalovKI304 {

    /**
     * Головний метод програми.
     * <p>
     * Послідовність дій:
     * <ol>
     *     <li>Зчитування базового імені файлу з клавіатури.</li>
     *     <li>Зчитування значення {@code x} з клавіатури.</li>
     *     <li>Обчислення виразу {@code y = (x - 4) / sin(3x - 1)} через {@link Equasion}.</li>
     *     <li>Запис результату у текстовий та бінарний файли.</li>
     *     <li>Зчитування та вивід результатів із файлів у консоль.</li>
     *     <li>Обробка можливих винятків: {@link InputMismatchException}, {@link IOException}.</li>
     * </ol>
     *
     * @param args аргументи командного рядка (не використовуються)
     * @throws FileNotFoundException якщо не вдалося створити файл для запису
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Equasion equ = new Equasion();

        System.out.println("Enter file name:");
        String baseName = in.nextLine();
        String fname = baseName + ".txt";    // текстовий файл
        String fnameBin = baseName + ".bin"; // бінарний файл

        try {
            try {
                System.out.println("Enter x:");
                equ.SetX(in.nextDouble());
                double result = equ.Equa();
                System.out.println("Result: " + result);

                // --- запис у текстовий файл ---
                try (PrintWriter fout = new PrintWriter(new FileOutputStream(fname))) {
                    fout.println(result);
                }

                // --- запис у бінарний файл ---
                try (DataOutputStream f = new DataOutputStream(new FileOutputStream(fnameBin))) {
                    f.writeDouble(result);
                }

                System.out.println("Result saved to file: " + fname + " and " + fnameBin);

            } catch (InputMismatchException ee) {
                System.out.print("Invalid input! Please enter a valid number.");
            }

            // --- зчитування та вивід результатів ---
            equ.readResBin(fnameBin);
            equ.readResTxt(fname);

            in.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File error: file not found.");
        } catch (IOException ex) {
            System.out.println("File error: I/O exception occurred.");
        }
    }
}
