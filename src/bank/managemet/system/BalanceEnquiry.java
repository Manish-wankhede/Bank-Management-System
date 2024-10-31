package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;

    JLabel lab2;

    JButton b1;

    BalanceEnquiry(String pin){

        super("BALANCE ENQUIRY");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab1 = new JLabel("Your Current Balance is Rs.");
        lab1.setForeground(Color.WHITE);
        lab1.setFont(new Font("System",Font.BOLD,16));
        lab1.setBounds(430,180,700,35);
        l3.add(lab1);

        lab2 = new JLabel();
        lab2.setForeground(Color.WHITE);
        lab2.setFont(new Font("System",Font.BOLD,16));
        lab2.setBounds(430,220,400,35);
        l3.add(lab2);

        b1 = new JButton("BACK");
        b1.setBackground(new Color(61, 61, 52));
        b1.setBounds(700,406,125,35);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");

            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        lab2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Mail_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
