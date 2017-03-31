package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// lib for clipboard
import java.awt.datatransfer.*;
import java.awt.Toolkit;
//regex libs
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //regex
    public static final String REGEX ="^[0-9, ]+$" ;

    public Converter() {
        //eventList CalcButton
        Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target1 = targetSizeTextField.getText();
                String base1 = baseSizeTextField.getText();
                double target;
                double base;

                //regex logic
                Pattern p = Pattern.compile(REGEX);
                Matcher targetInput = p.matcher(target1);
                Matcher baseInput = p.matcher(base1);
                //rem = target/body
                if (targetInput.matches() && baseInput.matches()){
                    //cast strings to double
                    base = Double.parseDouble(base1);
                    target = Double.parseDouble(target1);
                    //formula res=tar/base
                    double result = target / base;
                    //copy to clipboard
                    String clipString = String.format("%.1f",result);
                    StringSelection stringSelection = new StringSelection(clipString);
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection,null);
                    //output
                    JOptionPane.showMessageDialog(null,clipString + " REM");
                }
                else {
                   JOptionPane.showMessageDialog(null, " invalid inputs");
                }
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
