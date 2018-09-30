package utils;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class FrameManager {

    private static FrameManager manager;
    private static HashMap<String, JFrame> frames = null;

   public static FrameManager getManager() {

       if (manager == null) {
           manager = new FrameManager();

           //if the class hasn't been initiated until now, we initiate the HashMap
           frames = new HashMap<>();
       }

       return manager;
   }

   public void addToMap(String label, JFrame frame) {

       frames.put(label, frame);
   }

   public void closeFrame(String label) {
       if(frames.containsKey(label)) {
           JFrame frame = frames.get(label);

           //Close the window
           frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
       }
   }
}

