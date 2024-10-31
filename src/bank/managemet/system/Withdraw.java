package bank.managemet.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1,b2;

    Withdraw(String pin){

        super("CASH WITHDRAW");
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab1 = new JLabel("MAXIMUM WITHDRAW IS RS.10,000");
        lab1.setForeground(Color.WHITE);
        lab1.setFont(new Font("System",Font.BOLD,16));
        lab1.setBounds(460,180,700,35);
        l3.add(lab1);

        JLabel lab2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        lab2.setForeground(Color.WHITE);
        lab2.setFont(new Font("System",Font.BOLD,16));
        lab2.setBounds(460,220,400,35);
        l3.add(lab2);

        textField = new TextField();
        textField.setFont(new Font("Raleway",Font.BOLD,20));
        textField.setBackground(new Color(61, 61, 52));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBackground(new Color(61, 61, 52));
        b1.setBounds(700,362,125,35);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(61, 61, 52));
        b2.setBounds(700,406,125,35);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdraw','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Dabited Succesfully");
                    setVisible(false);
                    new Mail_Class(pin);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == b2){
            setVisible(false);
            new Mail_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
