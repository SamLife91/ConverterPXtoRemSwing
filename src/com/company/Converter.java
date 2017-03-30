package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
                //format double
                DecimalFormat df = new DecimalFormat("#.#");
                //output
                JOptionPane.showMessageDialog(null,df.format(result) + " REM");
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
