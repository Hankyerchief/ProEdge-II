package frame;

import utils.FrameManager;
import utils.Settings;

import javax.swing.*;
import java.awt.*;

public class Control extends JFrame {

    //Main window frame
    private JFrame control;

    //Potential Table
    private JTable settingTable;

    //Declarable column names
    private String[] columnNames;
    private Object[][] data;

    //Buttons
    JButton PSI;
    JButton rollers;
    JButton clamps;
    JButton speed;
    JButton miter;
    JButton cycle;

    public Control() {
        control = new JFrame("Control Interface");

        updateFrameManager();
        createTable();

    }

    private void addButtons() {
        this.add(PSI);
        this.add(rollers);
        this.add(clamps);
        this.add(speed);
        this.add(miter);
        this.add(cycle);
    }

    private void updateFrameManager() {
        FrameManager.getManager().addToMap("Control", this);
    }

    private void createTable() {
        intializeButtons();
        addButtons();
        intitiateTableValues();

        //Create the table.
        intitiateTable();
    }

    private void intializeButtons () {
        this.PSI = new JButton("PSI");
        this.rollers = new JButton("Rollers");
        this.clamps = new JButton("Clamps");
        this.speed = new JButton("Speed");
        this.miter = new JButton("Miter");
        this.cycle = new JButton("Cycle");
    }

    private void intitiateTable() {
        this.settingTable = new JTable(data, columnNames);
        this.add(settingTable);

        this.setBounds(20, 20, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void intitiateTableValues() {
        columnNames = new String[]{"Setting", "Value"};

        data = new Object[][] {
                {
                    "Cycle", Settings.retrieve().translateSettingBool("Running")
                },

                {
                    "Rollers", Settings.retrieve().translateSettingBool("Rollers")
                },

                {
                    "Miter", Settings.retrieve().getSetting("Miter") + "°"
                },

                {
                    "Clamps", Settings.retrieve().translateSettingBool("Clamps")
                },

                {
                    "PSI", Settings.retrieve().getSetting("PSI")
                },

                {
                    "Speed", Settings.retrieve().getSetting("Speed")
                }
        };
    }
}

