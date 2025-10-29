package KI304PikalovLab5;

import java.io.*;
import java.util.*;

/**
 * Клас {@code Equasion} реалізує обчислення математичного виразу:
 * <pre>
 *     y = (x - 4) / sin(3x - 1)
 * </pre>
 * <p>
 * Дозволяє:
 * <ul>
 *     <li>встановлювати значення аргументу {@code x},</li>
 *     <li>обчислювати результат {@code y},</li>
 *     <li>зчитувати збережене значення з бінарного або текстового файлу.</li>
 * </ul>
 * </p>
 *
 * @author 
 *     Pikalov Oleksandr, KI-304
 * @version 1.1
 */
public class Equasion {
    /** Аргумент функції x */
    protected double x;
    
    /** Результат обчислення y */
    protected double y;

    /**
     * Встановлює значення аргументу {@code x}.
     *
     * @param x значення аргументу
     */
    public void SetX(double x) {
        this.x = x;
    }

    /**
     * Обчислює вираз
     * <pre>
     *     y = (x - 4) / sin(3x - 1)
     * </pre>
     * і повертає результат.
     *
     * @return обчислене значення y
     */
    public double Equa() {
        y = (x - 4) / Math.sin((3 * x) - 1);
        return y;
    }

    /**
     * Зчитує значення {@code double} з бінарного файлу та виводить його у консоль.
     *
     * @param fName ім'я бінарного файлу
     * @throws FileNotFoundException якщо файл не знайдено
     * @throws IOException якщо виникає помилка вводу/виводу
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        try (DataInputStream f = new DataInputStream(new FileInputStream(fName))) {
            double val = f.readDouble();
            System.out.println("Binary read: " + val);
        }
    }

    /**
     * Зчитує значення {@code double} з текстового файлу та виводить його у консоль.
     * <p>
     * Для коректного зчитування у файлі має бути лише число.
     * </p>
     *
     * @param fName ім'я текстового файлу
     */
    public void readResTxt(String fName) {
        try {
            Locale.setDefault(Locale.US); // щоб крапка була роздільником десяткових
            try (Scanner s = new Scanner(new File(fName))) {
                if (s.hasNextDouble()) {
                    double val = s.nextDouble();
                    System.out.println("Text read: " + val);
                } else {
                    System.out.println("Text file format error: not a number.");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File error txt read: " + ex.getMessage());
        }
    }
}
