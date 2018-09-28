package utils;

import javax.swing.*;
import java.util.HashMap;

public class FrameManager {

    private static FrameManager manager;
    static HashMap<String, JFrame> frames = null;

   public static FrameManager getManager() {

       if (manager == null) {
           manager = new FrameManager();

           //if the class hasn't been initiated until now, we initiate the HashMap
           frames = new HashMap<>();
       }

       return manager;
   }

   public void addToMap(String framename, JFrame frame) {

       frames.put(framename, frame);
   }
}

