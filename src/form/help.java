package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class help {
    JFrame f1=new JFrame("helps");
    help() throws IOException {

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        f1.setContentPane(new backImage(bf));
        f1.setResizable(false);

        JTextArea te=new JTextArea("1. Click add new to create user \n2. If you already have one, just fill in\n3. If you are not staff in school, you won't be able to log in\n");
        JScrollPane scroll=new JScrollPane(te);
        scroll.setBounds(280,100,500,500);
        te.setEditable(false);
        f1.add(scroll);

        JButton goback=new JButton("goback");
        goback.setBounds(110,600,100,30);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    f1.dispose();
                    hello he=new hello();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        f1.add(goback);


        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setSize(1024,683);
        f1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        f1.setVisible(true);

    }
}
