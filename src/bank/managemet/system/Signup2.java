package bank.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox cBox, cBox2, cBox3, cBox4, cBox5;
    JTextField textPan, textAdhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    String formno;
    Signup2(String formno){

        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno = formno;
        JLabel l0 = new JLabel("Form No ");
        l0.setFont(new Font("Raleway",Font.BOLD,14));
        l0.setBounds(700,10,100,30);
        add(l0);

        JLabel l01 = new JLabel(formno);
        l01.setFont(new Font("Raleway",Font.BOLD,14));
        l01.setBounds(760,10,100,30);
        add(l01);

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additioanl Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,100,30);
        add(l3);

        String religion[] = {"Hindu","Muslim","sikh","Cristian","Other"};
        cBox = new JComboBox(religion);
        cBox.setBackground(new Color(254, 214, 127, 233));
        cBox.setFont(new Font("Raleway",Font.BOLD,14));
        cBox.setBounds(350,120,320,30);
        add(cBox);

        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String category[] = {"General","OBC","SC","ST","Other"};
        cBox2 = new JComboBox(category);
        cBox2.setBackground(new Color(254, 214, 127, 233));
        cBox2.setFont(new Font("Raleway",Font.BOLD,14));
        cBox2.setBounds(350,170,320,30);
        add(cBox2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,220,100,30);
        add(l5);

        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","up to 10,00,000","Above 10,00,000"};
        cBox3 = new JComboBox(income);
        cBox3.setBackground(new Color(254, 214, 127, 233));
        cBox3.setFont(new Font("Raleway",Font.BOLD,14));
        cBox3.setBounds(350,220,320,30);
        add(cBox3);

        JLabel l6 = new JLabel("Educational :");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,270,200,30);
        add(l6);

        String educational[] = {"Post-Graduation","Under-Graduation","Doctorate","No-Graduation","Other"};
        cBox4 = new JComboBox(educational);
        cBox4.setBackground(new Color(254, 214, 127, 233));
        cBox4.setFont(new Font("Raleway",Font.BOLD,14));
        cBox4.setBounds(350,270,320,30);
        add(cBox4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,320,200,30);
        add(l7);

        String occupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        cBox5 = new JComboBox(occupation);
        cBox5.setBackground(new Color(254, 214, 127, 233));
        cBox5.setFont(new Font("Raleway",Font.BOLD,14));
        cBox5.setBounds(350,320,320,30);
        add(cBox5);

        JLabel l8 = new JLabel("PAN Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,16));
        l8.setBounds(100,370,200,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        textPan.setBounds(350,370,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Adhar Number :");
        l9.setFont(new Font("Raleway",Font.BOLD,16));
        l9.setBounds(100,420,320,30);
        add(l9);

        textAdhar = new JTextField();
        textAdhar.setFont(new Font("Raleway",Font.BOLD,18));
        textAdhar.setBounds(350,420,320,30);
        add(textAdhar);

        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(new Font("Raleway",Font.BOLD,16));
        l10.setBounds(100,470,320,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(254, 214, 127, 233));
        r1.setBounds(350,470,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(254, 214, 127, 233));
        r2.setBounds(460,470,100,30);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);


        JLabel l11 = new JLabel("Existing Account :");
        l11.setFont(new Font("Raleway",Font.BOLD,16));
        l11.setBounds(100,520,320,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,16));
        e1.setBackground(new Color(254, 214, 127, 233));
        e1.setBounds(350,520,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,16));
        e2.setBackground(new Color(254, 214, 127, 233));
        e2.setBounds(460,520,100,30);
        add(e2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(e1);
        bg1.add(e2);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(254, 214, 127, 233));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) cBox.getSelectedItem();
        String cate = (String) cBox2.getSelectedItem();
        String inc = (String) cBox3.getSelectedItem();
        String edu = (String) cBox4.getSelectedItem();
        String occu = (String) cBox5.getSelectedItem();

        String pan = textPan.getText();
        String adhar = textAdhar.getText();

        String s_Citizen = null;
        if((r1.isSelected())){
            s_Citizen = "Yes";
        } else if (r2.isSelected()) {
            s_Citizen = "No";
        }
        String eAcc = null;
        if(e1.isSelected()){
            eAcc = "yes";
        } else if(e2.isSelected()){
            eAcc = "No";
        }


        try {
            if(textPan.getText().equals("") || textAdhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else {
                Conn conn = new Conn();
                String q = "insert into signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occu+"','"+pan+"','"+adhar+"','"+s_Citizen+"','"+eAcc+"')";
                conn.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
