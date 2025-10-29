package KI304PikalovLab2;

import java.io.*;
import java.util.*;

/**
 * Main class for Lab2PikalovKI304 project.
 * This program simulates the behavior of a video player device.
 * The user can choose different options such as turning the device on/off,
 * changing volume, adding or removing videos, and playing videos.
 * 
 * The results of user actions are logged into a file ("MyFile.txt").
 * 
 * @author 
 * @version 1.0
 */
public class Lab2PikalovKI304 {
    /**
     * Main entry point of the program.
     *
     * @param args command-line arguments (not used in this program)
     * @throws FileNotFoundException if the output file cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter fout = new PrintWriter(new FileOutputStream("MyFile.txt"), true);
        Scanner in = new Scanner(System.in);

        System.out.println("Local storage or USB");
        int flag = in.nextInt();

        Videoplayer player = null;
        if(flag == 1) 
            player = new Videoplayer(); 
        else if(flag == 2) 
            player = new Videoplayer(false, 50, 12, false); 
        else {
            System.out.println("Wrong number");
            System.exit(0); 
        }

        while (player.getProgramStatus() == true){
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }

            System.out.println("Chose option 1: Plug In/Off 2: Turn On/Off 3:Change Volume 4:Available videos " +
                   "5:Add video 6:Delete video 7:Play video 8:Change diagonal 9:About device 10:End program");

            int choice = in.nextInt();

            switch (choice) {
               case 1:
                   fout.println("Plug In/Off");
                   player.Plug_unplug();
                   break;
               case 2:
                   fout.println("Turn On/Off");
                   player.Turn_OnOff();
                   break;
               case 3:
                   fout.println("Change Volume");
                   player.ChangeVolume();
                   break;
               case 4:
                   fout.println("Available videos");
                   player.AvailableVideos();
                   break;
                case 5:
                   fout.println("Add video");
                   player.AddVideo();
                   break;
                case 6:
                   fout.println("Delete video");
                   player.RemoveVideo();
                   break;
                case 7:
                   fout.println("Play video");
                   player.PlayVideo();
                   while (player.getVideoStat()){
                        System.out.println("1:Check current video 2:Chose another video 3:Go to main menu ");
                        int choicePl = in.nextInt();
                        switch (choicePl) {
                        case 1:
                            fout.println("Check current video");
                            player.checkCurVid();
                            break;
                        case 2:
                            fout.println("Chose another video");
                            player.PlayVideo();
                            break;
                        case 3:
                            fout.println("Go to main menu");
                            player.GoToMainMenu();
                            break;
                        default:
                            break;
                       }
                    }
                    break;
                case 8:
                   fout.println("Change diagonal");
                   player.ChangeDiagonal();
                   break;
                case 9:
                   fout.println("About device");
                   player.Stats();
                   break; 
                case 10:
                   fout.println("End program");
                   System.exit(0); 
               default:
                   break;
            }

            System.out.println("Continue or end program: ");
            int choice2 = in.nextInt();
            switch (choice2) {
               case 1:
                   break;
               case 2:
                   player.changePStatus();
                   break;
               default:
                   break;
            }
        }
        fout.println();
        fout.close();  
        in.close();
    }
}
