import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;

        JLabel l1  = new JLabel("Page3: Account Details");
        l1.setFont(new Font("Rayleway", Font.BOLD , 22));
        l1.setBounds(230,80,300,30);
        add(l1);

        JLabel type  = new JLabel("Account Type");
        type.setFont(new Font("Rayleway", Font.BOLD , 18));
        type.setBounds(100,130,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway" , Font.BOLD , 16));
        r1.setBounds(100 , 170 , 300 , 30);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway" , Font.BOLD , 16));
        r2.setBounds(400 , 170 , 300 , 30);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway" , Font.BOLD , 16));
        r3.setBounds(100 , 230 , 300 , 30);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway" , Font.BOLD , 16));
        r4.setBounds(400 , 230 , 300 , 30);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);


        JLabel card  = new JLabel("Card Number");
        card.setFont(new Font("Rayleway", Font.BOLD , 16));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number  = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD , 16));
        number.setBounds(300,300,300,30);
        add(number);


        JLabel pin  = new JLabel("Pin Number");
        pin.setFont(new Font("Rayleway", Font.BOLD , 16));
        pin.setBounds(100,350,200,30);
        add(pin);

        JLabel pnumber  = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD , 16));
        pnumber.setBounds(300,350,100,30);
        add(pnumber);

        JLabel service = new JLabel("Services Required: ");
        service.setFont(new Font("Raleway", Font.BOLD , 16));
        service.setBounds(100,400,200,30);
        add(service);


        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD , 14));
        c1.setBackground(Color.white);
        c1.setBounds(100,450,150,30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD , 14));
        c2.setBackground(Color.white);
        c2.setBounds(300,450,150,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD , 14));
        c3.setBackground(Color.white);
        c3.setBounds(500,450,150,30);
        add(c3);

        c4 = new JCheckBox("Email / SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD , 14));
        c4.setBackground(Color.white);
        c4.setBounds(100,500,170,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD , 14));
        c5.setBackground(Color.white);
        c5.setBounds(300,500,150,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD , 14));
        c6.setBackground(Color.white);
        c6.setBounds(500,500,150,30);
        add(c6);


        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD , 12));
        c7.setBackground(Color.white);
        c7.setBounds(100,570,600,30);
        add(c7);



        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD , 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(300,650,100,30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD , 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(450,650,100,30);
        submit.addActionListener(this);
        add(submit);

        

        


 
        setLayout(null);
        setTitle("SignPageThree");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposte Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            }

            Random rand = new Random();
            String cardNumber = "" + Math.abs(rand.nextLong() % 90000000L + 5040937700000000L);

            String pin = "" + Math.abs(rand.nextLong() % 9000L + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility += "ATM Card";

            }else if(c2.isSelected()){
                facility += "Internet Banking";
            }else if(c3.isSelected()){              
                facility += "Mobile Banking";
            }else if(c4.isSelected()){
                facility += "Email/SMS Alerts";
            }else if(c5.isSelected()){
                facility += "Cheque Book";
            }else if(c6.isSelected()){
                facility += "E-Statement";
            }

            try{
                if(accountType == null){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                
                } else {
                    Connection c = new Connection();
                    String query1 = "insert into SignupThree values('" + formno + "' , '" + accountType + "' , '" + cardNumber + "' , '" + pin + "' , '" + facility + "')";
                    c.s.executeUpdate(query1);

                    String query2 = "insert into login values('" + formno + "' , '" + cardNumber + "' , '" + pin + "')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pin);
                }
                setVisible(false);
                new Deposit(pin).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        } // Closing brace for actionPerformed method
        
    
        public static void main(String[] args) {
            new SignupThree("");
        }
    } // Closing brace for SignupThree class


