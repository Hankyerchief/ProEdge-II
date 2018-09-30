package controller;

import javax.swing.*;

public class KeypadController extends JFrame {

    public KeypadController() {
        super("FastEdge - Keypad");

        init();
    }

    private JButton one, two, three, four, five, six, seven, eight, nine, zero, enter;
    private JButton[] buttons;

    private void init() {
        createButtons();
        initButtonArray();
        addButtonsToContentPane();
        initFrame();
    }

    private void createButtons() {
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        enter = new JButton("Enter");
    }

    private void addButtonsToContentPane() {

        for(int i =0; i < buttons.length; i++) {
            getContentPane().add(buttons[i]);
        }
    }

    private void initButtonArray() {
        buttons = new JButton[10];

        buttons[0] = one;
        buttons[1] = two;
        buttons[2] = three;
        buttons[3] = four;
        buttons[4] = five;
        buttons[5] = six;
        buttons[6] = seven;
        buttons[7] = eight;
        buttons[8] = nine;
        buttons[9] = zero;
        buttons[10] = enter;
    }

    private void initFrame() {
        setSize(300, 300);
        setVisible(true);
    }



}
