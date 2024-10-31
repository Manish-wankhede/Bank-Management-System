package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class cPin extends JFrame implements ActionListener {

    JButton b1,b2;

    JPasswordField p1,p2;

    String pin;

    cPin(String pin){

        super("PIN CHANGING");

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1500,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel lab1 = new JLabel("Change your PIN");
        lab1.setForeground(Color.WHITE);
        lab1.setFont(new Font("System",Font.BOLD,22));
        lab1.setBounds(550,180,400,35);
        l3.add(lab1);

        JLabel lab2 = new JLabel("New Pin: ");
        lab2.setForeground(Color.WHITE);
        lab2.setFont(new Font("System",Font.BOLD,16));
        lab2.setBounds(430,265,400,35);
        l3.add(lab2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        p1.setBackground(new Color(61, 61, 52));
        p1.setForeground(Color.WHITE);
        p1.setBounds(520,270,300,30);
        l3.add(p1);

        JLabel lab3 = new JLabel("Re-Enter New Pin: ");
        lab3.setForeground(Color.WHITE);
        lab3.setFont(new Font("System",Font.BOLD,16));
        lab3.setBounds(430,315,400,35);
        l3.add(lab3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        p2.setBackground(new Color(61, 61, 52));
        p2.setForeground(Color.WHITE);
        p2.setBounds(580,320,250,30);
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBackground(new Color(61, 61, 52));
        b1.setBounds(450,410,125,35);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(61, 61, 52));
        b2.setBounds(700,410,125,35);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not Match");
                return;
            }
            if(e.getSource() == b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter new PIN");
                    return;
                }

                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Mail_Class(pin);

            } else if (e.getSource() == b2) {
                new Mail_Class(pin);
                setVisible(false);
            }
        } catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new cPin("");
    }
}
