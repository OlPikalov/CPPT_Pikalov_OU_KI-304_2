package KI304PikalovLab3;

import java.io.*;
import java.util.*;

/**
 * Class representing a Videoplayer device.
 * Contains functionality for controlling power, mode, volume,
 * screen size, managing video list, and video playback.
 *
 * Saves logs into a text file "MyFile.txt".
 *
 * @author
 * @version 1.1
 */
abstract class Videoplayer {
    Power pow;
    Volume vol;
    Screen screen;
    Mode mode;
    ProgramStatus stat;
    Scanner in = new Scanner(System.in);
    PrintWriter fout;
    protected ArrayList<String> videos = new ArrayList<>();
    protected boolean videoStat = false;
    protected String currentVideo;

    /**
     * Default constructor.
     * Initializes Videoplayer with default values.
     */
    Videoplayer() throws FileNotFoundException{
        fout = new PrintWriter(new FileOutputStream("MyFile.txt"), true);
        pow = new Power(true);
        vol = new Volume(50);
        screen = new Screen(12.0);
        mode = new Mode(true);
        stat = new ProgramStatus(true);
        videos.clear();
    }

    /**
     * Parametrized constructor.
     * Initializes Videoplayer with custom values and a set of default videos.
     *
     * @param power initial power state
     * @param volume initial volume level
     * @param sreenSize initial screen size
     * @param mode initial mode (on/off)
     */
    Videoplayer(boolean power, int volume, double sreenSize, boolean mode)throws FileNotFoundException {
        fout = new PrintWriter(new FileOutputStream("MyFile.txt"), true);
        pow = new Power(power);
        vol = new Volume(volume);
        screen = new Screen(sreenSize);
        this.mode = new Mode(mode);
        stat = new ProgramStatus(true);
        videos = new ArrayList<>(Arrays.asList("The_Matrix.mp4","Inception.mp4",
            "Interstellar.mp4","The_Dark_Knight.mp4","Avatar.mp4","Titanic.mp4",
            "Jurassic_Park.mp4","The_Godfather.mp4","Forrest_Gump.mp4","The_Avengers.mp4"));
    }

    /**
     * Displays and logs device statistics:
     * power state, mode, volume level, screen size and number of videos.
     */
    public void Stats() {
        pow.powerState();
        mode.CurrentMode();
        vol.volumeLevel();
        screen.screenSize();
        System.out.println("Amount of videos: " + videos.size());
        fout.println("Amount of videos: " + videos.size());
    }

    /**
     * Toggles power state of the device (plug/unplug).
     */
    public void Plug_unplug(){
        if(pow.getPower()){
            pow.setPower(false);
            mode.setMode(false);
            System.out.println("Power: off");
            fout.println("Power: off");
        }
        else {
            pow.setPower(true);
            System.out.println("Power: on");
            fout.println("Power: on");
        }
    }

    /**
     * Turns device on/off depending on current state and power availability.
     */
    public void Turn_OnOff(){
        if(pow.getPower()) {
            if(mode.getMode()){
                mode.setMode(false);
                System.out.println("Mode: off");
                fout.println("Mode: off");
            }
            else {
                mode.setMode(true);
                System.out.println("Mode: on");
                fout.println("Mode: on");
            }
        }
        else {
            mode.setMode(false);
            System.out.println("Unable to turn on due to lack of power");
            fout.println("Unable to turn on due to lack of power");
        }
    }

    /**
     * Changes program running status (used to exit main loop).
     */
    public void changePStatus(){
        if(stat.getProgramStatus()) stat.setProgramStatus(false);
        else stat.setProgramStatus(true);
    }

    /**
     * Allows user to change volume level via console input.
     * Logs changes into file.
     */
    public void ChangeVolume(){
        if(mode.getMode()) {
            System.out.println("Current volume: " + vol.getVolume() + '%');
            fout.println("Current volume: " + vol.getVolume() + '%');
            System.out.println("New volume:");
            fout.println("New volume:");
            int volume = in.nextInt();
            in.nextLine(); // clear buffer
            vol.setVolume(volume);
        }
        else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }

    /**
     * Displays available videos and their total count.
     */
    public void AvailableVideos(){
        if(mode.getMode()) {
            for (String string : videos) {
                System.out.println(string);
                fout.println(string);
            }
            System.out.println("Total amount: " + videos.size());
            fout.println("Total amount: " + videos.size());
        }
        else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }

    /**
     * Adds a new video to the list (entered by user).
     */
    public void AddVideo(){
        if(mode.getMode()) {
            System.out.println("Enter new video name (without .mp4):");
            fout.println("Enter new video name (without .mp4):");
            String newvid = in.nextLine();
            videos.add(newvid + ".mp4");
            System.out.println("Video has been added");
            fout.println("Video has been added");
        }
        else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }

    /**
     * Removes a video by index or name (entered by user).
     */
    public void RemoveVideo() {
        if(mode.getMode()) {
            for(int i = 0; i < videos.size(); i++){
                System.out.println((i + 1) + ": " + videos.get(i));
                fout.println((i + 1) + ": " + videos.get(i));
            }
            System.out.println("Enter the integer or name of the video(without .mp4) to remove:");
            fout.println("Enter the integer or name of the video(without .mp4) to remove:");
            String input = in.nextLine();
            try {
                int delvid = Integer.parseInt(input);
                if(delvid >= 1 && delvid <= videos.size()) {
                    System.out.println("Video removed: " + videos.get(delvid - 1));
                    fout.println("Video removed: " + videos.get(delvid - 1));
                    videos.remove(delvid - 1);
                } else {
                    System.out.println("Invalid number.");
                    fout.println("Invalid number.");
                }
            } catch(NumberFormatException p) {
                if(videos.remove(input + ".mp4")) {
                    System.out.println("Video has been removed: " + input);
                    fout.println("Video has been removed: " + input);
                } else {
                    System.out.println("Video hasn't been found: " + input);
                    fout.println("Video hasn't been found: " + input);
                }
            }
        } else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }

    /**
     * Starts playing a video chosen by index or name.
     */
    public void PlayVideo() {
        if (mode.getMode()) {
            videoStat = true;
            System.out.println("Choose a video to play (integer or name without .mp4)");
            fout.println("Choose a video to play (integer or name without .mp4)");
            for (int i = 0; i < videos.size(); i++) {
                System.out.println((i + 1) + ": " + videos.get(i));
                fout.println((i + 1) + ": " + videos.get(i));
            }
            String input = in.nextLine().trim();
            try {
                int vidIndex = Integer.parseInt(input);
                if (vidIndex >= 1 && vidIndex <= videos.size()) {
                    currentVideo = videos.get(vidIndex - 1);
                    System.out.println("Video playing: " + currentVideo);
                    fout.println("Video playing: " + currentVideo);
                } else {
                    videoStat = false;
                    System.out.println("Invalid number.");
                    fout.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                String videoName = input + ".mp4";
                if (videos.contains(videoName)) {
                    currentVideo = videoName;
                    System.out.println("Video playing: " + videoName);
                    fout.println("Video playing: " + videoName);
                } else {
                    videoStat = false;
                    System.out.println("Video hasn't been found: " + videoName);
                    fout.println("Video hasn't been found: " + videoName);
                }
            }
        } else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }

    /**
     * Displays the currently playing video.
     */
    public void checkCurVid(){
        System.out.println("Video playing: " + currentVideo);
        fout.println("Video playing: " + currentVideo);
    }

    /**
     * Stops video playback and returns to main menu.
     */
    public void GoToMainMenu(){ videoStat = false; }

    boolean getProgramStatus(){ return stat.getProgramStatus(); }

    boolean getVideoStat(){ return videoStat; }

    /**
     * Allows user to change screen diagonal size.
     */
    public void ChangeDiagonal(){
        if(mode.getMode()) {
            System.out.println("Enter new diagonal: ");
            fout.println("Enter new diagonal: ");
            int newD = in.nextInt();
            in.nextLine(); // clear buffer
            if(newD > 0) screen.setDiagonal(newD);
            else {
                System.out.println("Invalid number");
                fout.println("Invalid number");
            }
        }
        else {
            System.out.println("You need to turn device on before using any features");
            fout.println("You need to turn device on before using any features");
        }
    }
}

class Volume {
    private int volume;
    Volume(int volume) { this.volume = volume; }
    public void volumeLevel() { System.out.println("Volume: " + volume + '%'); }
    public void setVolume(int volume) {
        if(volume >= 0 && volume <= 100) this.volume = volume;
        else {System.out.println("Invalid number");}
    }
    public int getVolume(){ return volume; }
}

class Power {
    private boolean power;
    Power(boolean power) { this.power = power; }
    public void powerState(){
        if (power) {System.out.println("Power: on");}
        else {System.out.println("Power: off");}
    }
    public void setPower(boolean power) { this.power = power; }
    public boolean getPower(){ return power; }
}

class Screen {
    private double size;
    Screen(double size) { this.size = size; }
    public void screenSize()  { System.out.println("Screen size: " + size + "d"); }
    public void setDiagonal(double size){ this.size = size; }
}

class Mode {
    private boolean mode;
    Mode(boolean mode) { this.mode = mode; }
    public void CurrentMode()  {
        if (mode) {System.out.println("Mode: on");}
        else {System.out.println("Mode: off");}
    }
    public void setMode(boolean mode) { this.mode = mode; }
    public boolean getMode(){ return mode; }
}

class ProgramStatus{
    private boolean status;
    ProgramStatus(boolean status) { this.status = status; }
    public boolean getProgramStatus(){ return status; }
    public void setProgramStatus(boolean status){ this.status = status; }
}
