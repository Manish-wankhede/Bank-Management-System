package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton b1,b2,b3,b4;

    String pin;

    Login(String pin){

        super("Bank Management System");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,380,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade", Font.BOLD,38));
        label1.setBounds(270,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Raleway", Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150, 250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        b1 = new JButton("SIGN IN");
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(325,300,100,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CLEAR");
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(455,300,100,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("SIGN UP");
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(325,350,230,30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("CLOSE");
        b4.setFont(new Font("Arial",Font.BOLD,10));
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(770,10,70,30);
        b4.addActionListener(this);
        add(b4);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
//        iiimage.setLocation(0,0);
        add(iiimage);

        setLayout(null);
        setSize(850,480);
        setLocation(450,150);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == b1){
                Conn c =new Conn();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();

                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new Mail_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }else if (e.getSource() == b2){
                textField2.setText("");
                passwordField3.setText("");
            }else if (e.getSource() == b3){
                new Signup();
                setVisible(false);
            } else if (e.getSource() == b4) {
                System.exit(0);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login("");
    }
}
