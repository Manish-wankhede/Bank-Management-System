package bank.managemet.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    JTextField textN, textF, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;
    Random ran = new Random();
    long f4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(f4);

    Signup(){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel l1 = new JLabel("APPLICATION Number" + first);
        l1.setBounds(160,20,600,40);
        l1.setFont(new Font("Raleway",Font.BOLD, 38));
        add(l1);

        JLabel l2 = new JLabel("Page 1");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(330,60,600,30);
        add(l2);

        JLabel l3 = new JLabel("Personal Details");
        l3.setFont(new Font("Raleway",Font.BOLD,22));
        l3.setBounds(290,90,600,30);
        add(l3);

        JLabel lName = new JLabel("Name :");
        lName.setFont(new Font("Raleway", Font.BOLD, 20));
        lName.setBounds(100,190,100,30);
        add(lName);

        textN = new JTextField();
        textN.setFont(new Font("Raleway",Font.BOLD,14));
        textN.setBounds(300,190,400,30);
        add(textN);

        JLabel fName = new JLabel("Father's Name :");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100,240,200,30);
        add(fName);

        textF = new JTextField();
        textF.setFont(new Font("Raleway",Font.BOLD,14));
        textF.setBounds(300,240,400,30);
        add(textF);

        JLabel DoB = new JLabel("Date Of Birth :");
        DoB.setFont(new Font("Raleway", Font.BOLD, 20));
        DoB.setBounds(100,340,200,30);
        add(DoB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBackground(new Color(254, 214, 127, 233));
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(300,290,90,30);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(254, 214, 127, 233));
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelE = new JLabel("Email Address :");
        labelE.setFont(new Font("Raleway",Font.BOLD,20));
        labelE.setBounds(100,390,200,30);
        add(labelE);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(254, 214, 127, 233));
        m1.setBounds(300,440,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(254, 214, 127, 233));
        m2.setBounds(450,440,100,30);
        add(m2);

        m3 = new JRadioButton("Others");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBackground(new Color(254, 214, 127, 233));
        m3.setBounds(630,440,100,30);
        add(m3);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(m1);
        bg1.add(m2);
        bg1.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelC = new JLabel("City :");
        labelC.setFont(new Font("Raleway",Font.BOLD,20));
        labelC.setBounds(100,540,200,30);
        add(labelC);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pincode :");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,710,80,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(254, 214, 127, 233));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textN.getText();
        String fname = textF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if(r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        } else if(m2.isSelected()){
            marital = "Unmarried";
        } else if(m3.isSelected()){
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if(textN.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else {
                Conn con1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
