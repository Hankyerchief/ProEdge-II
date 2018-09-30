package main;

import frame.SettingControl;
import utils.Settings;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hook {

    public static void main(String[] args) {

        //Initiate Settings
        Settings.retrieve().load(null);

        SettingControl frame = new SettingControl();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

