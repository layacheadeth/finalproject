package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Student_grade {

    public JFrame s_input= new JFrame("Student's grade input");
    JLabel la;
    JButton goback,submit;
    JTextField name,mobile,course;
    Student_grade() throws IOException {
        s_input.setLayout(null);

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        s_input.setContentPane(new backImage(bf));

    }
}
