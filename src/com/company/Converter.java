package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// lib for clipboard
import java.awt.datatransfer.*;
import java.awt.Toolkit;

/**
 * Created by Samir on 17.3.2017 г..
 */
public class Converter {

    public JTextField targetSizeTextField;
    public JTextField baseSizeTextField;
    public JButton Calculate;
    public JLabel Base;
    public JLabel target;
    public JPanel panel1;



    public Converter() {
        //eventList CalcButton
        Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double target;
                target = Double.parseDouble(targetSizeTextField.getText());
                double base;
                base = Double.parseDouble(baseSizeTextField.getText());
                //rem = target/body
                double result = target/base;

                //copy to clipboard
                String clipString = String.format("%.1f",result);
                StringSelection stringSelection = new StringSelection(clipString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection,null);

                //output
                JOptionPane.showMessageDialog(null,clipString + " REM");
            }
        });
    }

    private void createUIComponents() {
      /* TODO: place custom component creation code here */

}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Px to Rem Converter");
        frame.setContentPane(new Converter().panel1);
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.pack();
        frame.setVisible(true);
    }

}
