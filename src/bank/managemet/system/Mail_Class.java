package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mail_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;

    String pin;

    Mail_Class(String pin){
        super("ATM Machine");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab = new JLabel("Please Select Your Transaction");
        lab.setFont(new Font("Raleway",Font.BOLD,28));
        lab.setBounds(430,180,700,35);
        lab.setForeground(Color.WHITE);
        l3.add(lab);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(47, 47, 44));
        b1.setBounds(410,270,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAW");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(47, 47, 44));
        b2.setBounds(700,270,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(47, 47, 44));
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(47, 47, 44));
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(47, 47, 44));
        b5.setBounds(410,365,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(47, 47, 44));
        b6.setBounds(700,365,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("LOGOUT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(47, 47, 44));
        b7.setBounds(410,410,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        b8 = new JButton("EXIT");
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(47, 47, 44));
        b8.setBounds(700,410,150,35);
        b8.addActionListener(this);
        l3.add(b8);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == b1){
            new Deposit(pin);
            setVisible(false);
            } else if (e.getSource() == b2){
                new Withdraw(pin);
                setVisible(false);
            } else if (e.getSource() == b3) {
                new FastCash(pin);
                setVisible(false);
            } else if (e.getSource() == b4) {
                new Mini(pin);
                setVisible(false);
            } else if (e.getSource() == b5) {
                new cPin(pin);
                setVisible(false);
            } else if (e.getSource() == b6) {
                new BalanceEnquiry(pin);
                setVisible(false);
            } else if (e.getSource() == b7) {
                new Login(pin);
                setVisible(false);
            }else if (e.getSource() == b8) {
                System.exit(0);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Mail_Class("");
    }
}
