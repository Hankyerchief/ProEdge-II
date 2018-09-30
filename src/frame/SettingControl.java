package frame;

import utils.ButtonEditor;
import utils.ButtonRenderer;
import utils.FrameManager;
import utils.Settings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SettingControl extends JFrame {

    private static DefaultTableModel dm;

    private JPanel panel;

    //Constructor
    public SettingControl() {
        super("FastEdge - Settings");

        load();

    }

    public static DefaultTableModel getModel() {
        return dm;
    }

    private void load() {
        setup();
        updateFrameManager();
    }

    private void updateFrameManager() {
        FrameManager.getManager().addToMap("SettingControl", this);
    }

    private void setup() {
        setPanel();

        //Method to setup table.
        setupTable();

        //Set window properties
        frameWindow();
    }

    //Sets window properties
    private void frameWindow() {

        this.setBounds(20, 20, 400, 160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    //Sets up the table
    private void setupTable() {

        //The default table model.
        dm = new DefaultTableModel();

        //Set the vector data
        dm.setDataVector(new Object[][] {

                //Set the table up
                { "Cycle", Settings.retrieve().translateSettingBool("Running") },
                { "Rollers", Settings.retrieve().translateSettingBool("Rollers") },
                { "Clamps", Settings.retrieve().translateSettingBool("Clamps")},
                { "Miter°" , Settings.retrieve().getSetting("Miter")},
                {"PSI", Settings.retrieve().getSetting("PSI")},
                {"Speed", Settings.retrieve().getSetting("Speed")}

                //Table headers
        }, new Object[] { "Setting", "Value" });

        //Create table with values
        JTable table = new JTable(dm);
        table.getColumn("Setting").setCellRenderer(new ButtonRenderer());
        table.getColumn("Setting").setCellEditor(
                new ButtonEditor(new JCheckBox()));
        JScrollPane scroll = new JScrollPane(table);
       // getContentPane().add(scroll);
        addComponenToPanel(scroll);
        getContentPane().add(panel);

        //Set properties
        setSize(400, 100);
        setVisible(true);
    }

    private void setPanel() {
        panel = new JPanel();
    }

    private void addComponenToPanel(Component c) {
        panel.add(c);
    }


}

