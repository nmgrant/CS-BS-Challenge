package GameClasses;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Sounds implements Serializable {

   private Clip clip;

   public Sounds(String fileName) {

      try {
         AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource(fileName));
         clip = AudioSystem.getClip();
         clip.open(sound);

      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
         throw new RuntimeException("Sound: Unsupported Audio File: " + e);

      } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException("Sound: Input/Output Error: " + e);

      } catch (LineUnavailableException e) {
         e.printStackTrace();
         throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);

      }
      
   }

   public void loop() {
      clip.loop(Clip.LOOP_CONTINUOUSLY);
   }

   public void play() {
      clip.start();
   }

   public void stop() {
      clip.stop();
      clip.flush();
      clip.setFramePosition(0);
   }
   
   public void pause() {
      clip.stop();
   }

}
