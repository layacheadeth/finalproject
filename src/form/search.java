package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

public class search {
    JFrame search =new JFrame("Student's registration");
    JLabel lc;
    JButton goback,se;
    JTextField searches;

    JButton submit;
    JTextField name,mobile,course;
  String name2;
  String mobile2;

  public String getName2(){
      return name2;
  }
  public  void setName2(String name2){
      this.name2=this.name.getText();
  }
  public String getMobile2(){
      return mobile2;
  }
  public void setMobile2(String mobile2){
      this.mobile2=this.mobile.getText();
  }

    search() throws IOException {
        search.setLayout(null);
        search.setResizable(false);

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        search.setContentPane(new backImage(bf));





        lc = new JLabel("name");
        lc.setBounds(280, 150, 100, 30);
        search.add(lc);

        name = new JTextField(20);
        name.setBounds(370, 150, 210, 50);
        search.add(name);

        lc = new JLabel("gender");
        lc.setBounds(590, 150, 100, 30);
        search.add(lc);


        String gen[]={"Male","Female"};
        JComboBox sex = new JComboBox(gen);
        sex.setBounds(630, 150, 80, 40);
        search.add(sex);


        lc = new JLabel("mobile");
        lc.setBounds(280, 200, 100, 30);
        search.add(lc);

        mobile = new JTextField(20);
        mobile.setBounds(370, 200, 350, 50);
        search.add(mobile);

        lc=new JLabel("course");
        lc.setBounds(280,250,100,30);
        search.add(lc);

        course=new JTextField(20);
        course.setBounds(370,250,350,50);
        search.add(course);






        JButton submit=new JButton("submit");
        submit.setBounds(370,300,100,30);
        search.add(submit);



        submit.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent actionEvent) {
                                         String name2 = name.getText();
                                         String sex1=sex.getSelectedItem().toString();
                                         String mobile2 = mobile.getText();
                                         String course2=course.getText();







                                         Connection conn,con1;
                                         PreparedStatement pst,pst1;
                                         if (name2 == null || mobile2 == null|| sex1==null) {
                                             JOptionPane.showMessageDialog(null, "All the field is mandatory and needed to be filled ");
                                         } else {
                                             try {
                                                 Class.forName("org.sqlite.JDBC");
                                                 conn = DriverManager.getConnection("jdbc:sqlite:University.db");
                                                 con1=DriverManager.getConnection("jdbc:sqlite:gpa.db");

                                                 pst = conn.prepareStatement("SELECT * FROM courses where name=? and mobile=?");
                                                pst1=con1.prepareStatement("SELECT * FROM grade where name=?");
                                                 pst.setString(1, name2);
                                                 pst.setString(2, mobile2);
                                                 pst1.setString(1,name2);

                                                 ResultSet rs = pst.executeQuery();
                                                 ResultSet rs1=pst1.executeQuery();

                                                 if (rs.next()) {
                                                     if(!rs1.next()) {

                                                         search.dispose();
                                                         course_form ce = new course_form(name2, sex1, mobile2,course2);

                                                     }
                                                     else{
                                                         JOptionPane.showMessageDialog(null,"data already existed");
                                                     }


                                                 } else {
                                                     JOptionPane.showMessageDialog(null, "Fault information");
                                                 }
                                             } catch (Exception es) {
                                                 System.out.println(es.getMessage());
                                             }
                                         }

                                     }
                                 });


//        Connection conn;
//        PreparedStatement pst=null;
//        ResultSet rs;
//
//        JPanel p=new JPanel();
//        p.setBounds(110,280,500,500);
//        search.add(p);
//
//        JLabel la4=new JLabel("course");
//        la4.setBounds(280,300,100,30);
//        p.add(la4);
//
//        JComboBox co=new JComboBox();
//        co.setBounds(370,300,150,40);
//        p.add(co);
//        try{
//            Class.forName("org.sqlite.JDBC");
//            conn= DriverManager.getConnection("jdbc:sqlite:University.db");
//            pst=conn.prepareStatement("SELECT * FROM courses WHERE name= ");
//            rs=pst.executeQuery();
//            co.removeAllItems();
//
//            while(rs.next()){
//                co.addItem(rs.getString(5));
//            }
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        finally {
//            try{
//                pst.close();
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//
//
//        JLabel la=new JLabel("assignment");
//        la.setBounds(280,350,100,30);
//        p.add(la);
//
//        JTextField assign=new JTextField(5);
//        assign.setBounds(370,350,150,40);
//        p.add(assign);
//
//        JLabel la1=new JLabel("project");
//        la1.setBounds(280,400,100,30);
//        p.add(la1);
//
//        JTextField pro=new JTextField(5);
//        pro.setBounds(370,400,150,40);
//        p.add(pro);
//
//        JLabel la2=new JLabel("midexam");
//        la2.setBounds(280,450,100,30);
//        p.add(la2);
//
//        JTextField mid=new JTextField(5);
//        mid.setBounds(370,450,150,40);
//        p.add(mid);
//        JLabel la3=new JLabel("finalexam");
//        la3.setBounds(280,500,100,30);
//        p.add(la3);
//
//        JTextField fin=new JTextField(5);
//        fin.setBounds(370,500,150,40);
//        search.add(fin);
//
//        JButton record=new JButton("submit");
//        submit.setBounds(370,600,100,30);
//        search.add(record);
//        record.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                String co1=co.getSelectedItem().toString();
//                int assign1=Integer.parseInt(assign.getText());
//                int pro1=Integer.parseInt(pro.getText());
//                int mid1=Integer.parseInt(mid.getText());
//                int fin1=Integer.parseInt(fin.getText());
//
//                Connection con1;
//                PreparedStatement pst1=null;
//                String grade=null;
//
//                double avg;
//                avg=(assign1+pro1+mid1+fin1)/4.0;
//
//                if(avg<100&&avg>90){
//                    grade="A";
//                }
//                else if(avg<90&&avg>80){
//                    grade="B";
//                }
//                else if(avg<80&&avg>70){
//                    grade="C";
//                }
//                else if(avg<70&&avg>60){
//                    grade="D";
//                }
//                else if(avg<60&&avg>50){
//                    grade="E";
//                }
//                else if(avg<50){
//                    grade="F";
//                }
//                else{
//                    grade="Error wrong input";
//                }
//
//                try{
//                    Class.forName("org.sqlite.JDBC");
//                    con1=DriverManager.getConnection("jdbc:sqlite:gpa.db");
//                    pst1=con1.prepareStatement("INSERT INTO grade(course,assignment,project,midexam,finalexam,grades) VALUES(?,?,?,?,?,?)");
//                    pst1.setString(1,co1);
//                    pst1.setInt(2,assign1);
//                    pst1.setInt(3,pro1);
//                    pst1.setInt(4,mid1);
//                    pst1.setInt(5,fin1);
//                    pst1.setString(6,grade);
//
//                    pst1.executeUpdate();
//                    JOptionPane.showMessageDialog(null,"Record added");
//                    co.setSelectedIndex(-1);
//                    assign.setText("");
//                    pro.setText("");
//                    mid.setText("");
//                    fin.setText("");
//                }
//                catch (Exception e){
//                    System.out.println(e.getMessage());
//                }
//                finally {
//                    try {
//                        pst1.close();
//                    }
//                    catch(Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                }
//
//            }
//        });
//
//
//
//
//


        goback=new JButton("goback");
        goback.setBounds(270,300,100,30);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    search.dispose();
                    hello1 he=new hello1();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        search.add(goback);




        search.setVisible(true);
        search.setSize(1024,683);
        search.setLocationRelativeTo(null);
        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }
}


