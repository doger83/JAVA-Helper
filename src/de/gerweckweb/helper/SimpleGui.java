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
    JTextField jtfTextEntry;
    JLabel jlControlOutput;
    JButton jbtnDoButton;

    SimpleGui(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtfTextEntry = new JTextField(10);
        jlControlOutput = new JLabel("");
        jbtnDoButton = new JButton("DO!");
        setLayout(new FlowLayout());
        add(jtfTextEntry);
        add(jlControlOutput);
        add(jbtnDoButton);
        setSize(100,100);
        setVisible(true);
        jbtnDoButton.addActionListener((ActionListener) this);
        jbtnDoButton.setActionCommand("DO");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Keyboard.guiReadInt(text,2,3);
        Keyboard.readDoubleFromGui(jtfTextEntry,1,11);
        jlControlOutput.setText(String.valueOf(Keyboard.readDoubleFromGui(jtfTextEntry)));
    }
}
