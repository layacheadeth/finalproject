package login;

// MyLogin.java
import javax.swing.*;
import java.awt.event.*;
public class login {
    private JFrame f = new JFrame("Login");
    private JButton bok = new JButton("Login");

    public login() {





        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.getContentPane().add(bok);

        bok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new secondframe();
            }
        });
        f.setSize(100,100);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}

// SecondFrame.java
