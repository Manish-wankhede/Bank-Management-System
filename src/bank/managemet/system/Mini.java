package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    String pin;
    JButton button;

    Mini(String pin){

        this.pin = pin;

        getContentPane().setBackground(new Color(232, 143, 60));
        setSize(400,600);
        setLocation(20,40);
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20,130,700,290);
        l1.setFont(new Font("System",Font.BOLD,13));
        add(l1);

        JLabel l2 = new JLabel("Bank Statement");
        l2.setFont(new Font("System",Font.BOLD,18));
        l2.setBounds(140,20,200,20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20,80,400,20);
        l3.setFont(new Font("System",Font.BOLD,15));
        add(l3);

        JLabel l4 = new JLabel();
        l4.setFont(new Font("System",Font.BOLD,15));
        l4.setBounds(20,500,700,20);
        add(l4);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                l3.setText("Card Number:  "+resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){

                l1.setText(l1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            l4.setText("Your Total Balance is Rs. "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,550,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            setVisible(false);
            new Mail_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
