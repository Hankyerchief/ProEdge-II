package main;

import frame.Control;
import utils.Settings;

public class Hook {

    public static void main(String[] args) {

        //Initiate Settings
        Settings.retrieve().load(null);

        Control control = new Control();
    }
}
