import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the alarm time (HH:MM:SS): ");
        String alarmTime = scanner.nextLine();
        scanner.close();

        System.out.println("Alarm set for " + alarmTime);

        boolean isRunning = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (isRunning) {
            String currentTime = LocalTime.now().format(formatter);
            System.out.println(currentTime);

            if (currentTime.equals(alarmTime)) {
                System.out.println("Wake UP!");
                playSound("music.wav");  // Ensure your sound file is .wav and in the project directory
                isRunning = false;
            }

            try {
                Thread.sleep(1000); // wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + soundFileName);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            while (clip.isRunning()) {
                Thread.sleep(1000);
            }

            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
