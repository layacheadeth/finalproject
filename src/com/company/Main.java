package com.company;

import login.secondframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private
    static JFrame frame;
    static  JPanel panel_01;
    static JLabel label;
    static JTextField user;
    static JPasswordField pass;
    private static JButton bok ;


    public static void main(String[] args) {
	// write your code here
        frame = new JFrame("Bee_school");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel_01=new JPanel();
        frame.add(panel_01);
        panel_01.setLayout(null);

        label =new JLabel("user");
        label.setBounds(10,20,80,25);
        panel_01.add(label);

        user=new JTextField();
        user.setBounds(100,20,165,25);
        panel_01.add(user);

        label=new JLabel("password");
        label.setBounds(10,50,80,25);
        panel_01.add(label);

        pass=new JPasswordField();
        pass.setBounds(100,50,165,25);
        panel_01.add(pass);

        bok=new JButton("login");
        bok.setBounds(10,20,30,40);
        panel_01.add(bok);



        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(bok);

        bok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new secondframe();
            }
        });
        frame.setSize(100,100);
        frame.setVisible(true);



        frame.setVisible(true);






    }
}
