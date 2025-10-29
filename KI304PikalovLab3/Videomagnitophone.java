package KI304PikalovLab3;

import java.io.*;
import java.util.*;

/**
 * Клас {@code Videomagnitophone} розширює функціональність {@code Videoplayer}
 * та реалізує інтерфейс {@code Record}, додаючи можливість запису відео.
 * 
 * <p>Реалізує такі можливості:
 * <ul>
 *   <li>Початок запису відео</li>
 *   <li>Зупинка запису</li>
 *   <li>Збереження нового записаного відео</li>
 * </ul>
 * 
 * Результати роботи методів виводяться у консоль і записуються у файл.
 * 
 * @author 
 * @version 1.0
 */
public class Videomagnitophone extends Videoplayer implements Record {

    /** Прапорець стану запису (true, якщо запис активний) */
    private boolean recBool = false;

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує параметри відеомагнітофона стандартними значеннями.
     * 
     * @throws FileNotFoundException якщо файл для запису не знайдено
     */
    Videomagnitophone() throws FileNotFoundException {      
         fout = new PrintWriter(new FileOutputStream("MyFile.txt"), true);
        pow = new Power(true);
        vol = new Volume(50);
        screen = new Screen(12.0);
        mode = new Mode(true);
        stat = new ProgramStatus(true);
        videos.clear();
    }

    /**
     * Конструктор з параметрами.
     * 
     * @param power стан живлення пристрою (вкл/викл)
     * @param volume рівень гучності
     * @param sreenSize розмір екрана (у дюймах)
     * @param mode режим роботи (true — увімкнено)
     * @throws FileNotFoundException якщо не вдається створити файл для запису
     */
    Videomagnitophone(boolean power, int volume, double sreenSize, boolean mode) throws FileNotFoundException {
        fout = new PrintWriter(new FileOutputStream("MyFile.txt"), true);
        pow = new Power(power);
        vol = new Volume(volume);
        screen = new Screen(sreenSize);
        this.mode = new Mode(mode);
        stat = new ProgramStatus(true);
        videos = new ArrayList<>(Arrays.asList(
            "The_Matrix.mp4", "Inception.mp4", "Interstellar.mp4",
            "The_Dark_Knight.mp4", "Avatar.mp4", "Titanic.mp4",
            "Jurassic_Park.mp4", "The_Godfather.mp4", "Forrest_Gump.mp4", "The_Avengers.mp4"
        ));
    }

    /**
     * Починає запис відео, якщо запис ще не активний.
     * Виводить повідомлення у консоль та записує у файл.
     */
    @Override
    public void StartRecording() {
        System.out.println(recBool ? "Recording already in progress" : "Recording started...");
        if (!recBool) recBool = true;
    }

    /**
     * Зупиняє запис відео, якщо він активний.
     * Виводить повідомлення у консоль та записує у файл.
     */
    @Override
    public void StopRecording() {
        System.out.println(recBool ? "Recording stopped" : "Recording is off already");
        if (recBool) recBool = false;
    }

    /**
     * Зберігає записане відео у список файлів, якщо пристрій увімкнений
     * і запис активний.
     * 
     * Якщо пристрій вимкнено або запис не ведеться — виводить відповідне повідомлення.
     */
    public void SaveRecVid() {
        if (mode.getMode() && recBool) {
            recBool = true;
            System.out.println("Enter new video name (without .mp4):");
            fout.println("Enter new video name (without .mp4):");
            String newvid = in.nextLine();
            videos.add(newvid + ".mp4");
            System.out.println("Recorded video has been added");
            fout.println("Recorded video has been added");
        } else if (!mode.getMode()) {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        } else if (!recBool) {
            System.out.println("The video isn't being recorded right now");
            fout.println("The video isn't being recorded right now");
        }
    }
}

/**
 * Інтерфейс {@code Record} описує базові операції запису.
 */
interface Record {
    /**
     * Почати запис відео.
     */
    void StartRecording();

    /**
     * Зупинити запис відео.
     */
    void StopRecording();
}
