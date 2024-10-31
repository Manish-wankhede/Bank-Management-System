package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){

        super("DEPOSIT");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        lab1.setForeground(Color.WHITE);
        lab1.setFont(new Font("System",Font.BOLD,16));
        lab1.setBounds(460,180,400,35);
        l3.add(lab1);

        textField = new TextField();
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField.setBackground(new Color(61, 61, 52));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,230,300,25);
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
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
        try{
            String amount = textField.getText();
            Date date = new Date();

            if(e.getSource() == b1){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                } else {
                    Conn c = new Conn();
                    String str = ("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    c.statement.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Mail_Class(pin);
                }
            } else if(e.getSource() == b2){
                setVisible(false);
                new Mail_Class(pin);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
