package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;

    String pin;

    FastCash(String pin){

        super("FAST CASH TRANSACTION");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab = new JLabel("Please Select Withdrawal Amount");
        lab.setFont(new Font("System",Font.BOLD,20));
        lab.setBounds(470,180,700,35);
        lab.setForeground(Color.WHITE);
        l3.add(lab);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Rareway",Font.BOLD,15));
        b1.setBackground(new Color(47, 47, 44));
        b1.setBounds(410,270,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Rareway",Font.BOLD,15));
        b2.setBackground(new Color(47, 47, 44));
        b2.setBounds(700,270,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Rareway",Font.BOLD,15));
        b3.setBackground(new Color(47, 47, 44));
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Rareway",Font.BOLD,15));
        b4.setBackground(new Color(47, 47, 44));
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Rareway",Font.BOLD,15));
        b5.setBackground(new Color(47, 47, 44));
        b5.setBounds(410,362,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Rareway",Font.BOLD,15));
        b6.setBackground(new Color(47, 47, 44));
        b6.setBounds(700,362,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(47, 47, 44));
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7){
            setVisible(false);
            new Mail_Class(pin);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            Date date = new Date();

            try {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                String num = "17";

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdraw','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited successfully");

            } catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Mail_Class(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
