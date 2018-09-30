package utils;

import controller.KeypadController;
import frame.SettingControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends DefaultCellEditor {

    private final JButton button;

    private String label;

    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {

            switch (label) {
                case "Cycle":
                    SettingControl.getModel().setValueAt(run("Running"), 0 ,1);
                    break;
                case"Rollers":
                    SettingControl.getModel().setValueAt(run("Rollers"), 1, 1);
                    break;
                case "Clamps":
                    SettingControl.getModel().setValueAt(run("Clamps"), 2, 1);
                    break;
                case "Miter":
                    pushValueUpdate("Miter", 3);
                    break;
                case "PSI":
                    pushValueUpdate("PSI", 4);
                    break;
                case "Speed":
                    pushValueUpdate("Speed", 5);
                    break;
            }
        }
        isPushed = false;
        return label;
    }

    private void pushValueUpdate(String setting, int row) {
        int s = Integer.parseInt(String.valueOf(SettingControl.getModel().getValueAt(row, 1)));

        Settings.retrieve().changeSettingWithValue(setting, s);
    }

    private String run(String s) {
        Settings.retrieve().reverseSetting(s);

        return Settings.retrieve().translateSettingBool(s);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}
