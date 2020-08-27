package de.gerweckweb.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA,
 * User: corat
 * Date: 25.08.2020
 * Time: 13:02
 *
 * Einfache Gui zur Erweiterung des TestKlasse mit GuiFunktionalität
 */
public class SimpleGui extends JFrame implements ActionListener{
    JTextField text;
    JLabel label;
    JButton button;

    SimpleGui(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JTextField(10);
        label = new JLabel("");
        button = new JButton("DO!");
        setLayout(new FlowLayout());
        add(text);
        add(label);
        add(button);
        button.addActionListener((ActionListener) this);
        button.setActionCommand("DO");
    }

    public void actionPerformed(ActionEvent e) {
        //Keyboard.guiReadInt(text,2,3);
        Keyboard.guiReadDouble(text,3.0, 15.0);
        label.setText(text.getText());
    }
}
