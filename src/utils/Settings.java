package utils;

import java.util.HashMap;

public class Settings {

    private int miter;
    private int psi;
    private int speed;
    private boolean rollers;
    private boolean clamps;
    private boolean running;

    private HashMap<String, Object> settingMap;

    //Instance of the class to access
    private static Settings settings;

    //Creates a singleton instance
    public static Settings retrieve () {
        if (settings == null) {
            settings = new Settings();
        }

        //Returns instance
        return settings;
    }

    //Load all settings or reload a certian setting.
    public boolean load (String setting) {

        //Checks if the input is null, if so it loads all settings to default
        if (setting == null) {
            setSettingsDefault();
        }

        //Attempt to reload a particular setting
        if(setting != null) {

            //If it loads the setting, we update the UI with the new value.
            if (settingMap.containsKey(setting)) {
                //update the ui, to be built later
            }

            else {

                //Eventually printed out in a console window.
                System.out.println("Setting Not Valid.");
                return false;
            }
        }

        return true;

    }

    //Method to set all settings to default.
    private void setSettingsDefault() {
        this.miter = 90;
        this.psi = 45;
        this.speed = 0;

        this.clamps = false;
        this.rollers = false;
        this.running = false;

        //Build the map
        buildSettingMap();
    }

    private void buildSettingMap() {
        if (settingMap == null) {
            settingMap = new HashMap<>();

            //Build the map
            build();
        }

        else {

            //this is in the case that the map is filled.
            settingMap.clear();
        }
    }

    //update a setting with a new value.
    public void changeSettingWithValue(String set, Object object) {
        settingMap.put(set, object);
    }

    public Object getSetting(String set) {

        if(settingMap.containsKey(set)) {

            return settingMap.get(set);
        }

        //uh oh no bueno
        return null;
    }

    private void build() {
        settingMap.put("Miter", this.miter);
        settingMap.put("PSI", this.psi);
        settingMap.put("Speed", this.speed);
        settingMap.put("Rollers", this.rollers);
        settingMap.put("Clamps", this.clamps);
        settingMap.put("Running", this.running);
    }

    public String translateSettingBool(String set) {

        Boolean bool = (boolean) settingMap.get(set);

        if(String.valueOf(bool).equalsIgnoreCase("false")) {

            return "Off";
        }

        return "On";
    }
}
