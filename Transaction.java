import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Transaction  extends JFrame implements ActionListener{

    String pin;
    JButton deposit, withdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    Transaction(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);
    
        JLabel text = new JLabel("Please Select your transaction");
        text.setBounds(230, 300,  400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160, 415, 160, 30);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton(" Case Withdrawal");
        withdraw.setBounds(350 , 415, 160, 30);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);


        
        fastcash = new JButton(" Fast Cash");
        fastcash .setBounds(160 , 450, 160, 30);
        fastcash .setFont(new Font("System", Font.BOLD, 14));
        fastcash .setBackground(Color.WHITE);
        fastcash .setForeground(Color.BLACK);
        fastcash .addActionListener(this);
        image.add(fastcash );

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(350, 450, 160, 30);
        ministatement.setFont(new Font("System", Font.BOLD, 14));
        ministatement.setBackground(Color.WHITE);
        ministatement.setForeground(Color.BLACK);
        
        image.add(ministatement);

        pinchange = new JButton(" Pin Change");
        pinchange .setBounds(160 , 485, 160, 30);
        pinchange .setFont(new Font("System", Font.BOLD, 14));
        pinchange .setBackground(Color.WHITE);
        pinchange .setForeground(Color.BLACK);
        pinchange .addActionListener(this);
        image.add(pinchange );

        balanceenquiry = new JButton(" Balance Enquiry");
        balanceenquiry.setBounds(350, 485, 160, 30);
        balanceenquiry.setFont(new Font("System", Font.BOLD, 14));
        balanceenquiry.setBackground(Color.WHITE);
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton(" Exit");
        exit.setBounds(350, 520, 160, 30);
        exit.setFont(new Font("System", Font.BOLD, 14));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);


    


        setTitle("Transaction");
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        
        
        setVisible(true);

        

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        // }else if(ae.getSource() == ministatement){
        //     setVisible(false);
        //     new MiniStatement(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
