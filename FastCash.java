import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FastCash  extends JFrame implements ActionListener{

    String pin;
    JButton hundred, fiveH, OneTh, TwoTh, FiveTh, TenTh, back;
    FastCash(String pin){
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

        hundred = new JButton("Rs 100");
        hundred.setBounds(160, 415, 160, 30);
        hundred.setFont(new Font("System", Font.BOLD, 14));
        hundred.setBackground(Color.WHITE);
        hundred.setForeground(Color.BLACK);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveH = new JButton("Rs 500");
        fiveH.setBounds(350 , 415, 160, 30);
        fiveH.setFont(new Font("System", Font.BOLD, 14));
        fiveH.setBackground(Color.WHITE);
        fiveH.setForeground(Color.BLACK);
        fiveH.addActionListener(this);
        image.add(fiveH);


        
        OneTh = new JButton(" Rs 1000");
        OneTh .setBounds(160 , 450, 160, 30);
        OneTh .setFont(new Font("System", Font.BOLD, 14));
        OneTh .setBackground(Color.WHITE);
        OneTh .setForeground(Color.BLACK);
        OneTh .addActionListener(this);
        image.add(OneTh );

        TwoTh = new JButton("Rs 2000");
        TwoTh.setBounds(350, 450, 160, 30);
        TwoTh.setFont(new Font("System", Font.BOLD, 14));
        TwoTh.setBackground(Color.WHITE);
        TwoTh.setForeground(Color.BLACK);
        TwoTh.addActionListener(this);
        image.add(TwoTh);

        FiveTh = new JButton("Rs 5000");
        FiveTh .setBounds(160 , 485, 160, 30);
        FiveTh .setFont(new Font("System", Font.BOLD, 14));
        FiveTh .setBackground(Color.WHITE);
        FiveTh .setForeground(Color.BLACK);
        FiveTh .addActionListener(this);
        image.add(FiveTh );

        TenTh = new JButton("Rs 10000");
        TenTh.setBounds(350, 485, 160, 30);
        TenTh.setFont(new Font("System", Font.BOLD, 14));
        TenTh.setBackground(Color.WHITE);
        TenTh.setForeground(Color.BLACK);
        TenTh.addActionListener(this);
        image.add(TenTh);

        back = new JButton("Back");
        back.setBounds(350, 520, 160, 30);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);


    


        setTitle("Fast Cash");
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        
        
        setVisible(true);

        

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);

        }else {
            String amount  = ((JButton) ae.getSource()).getText().substring(3);
            Connection c = new Connection();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back){
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                }
                Date date = new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdraw Successfully");

                setVisible(false);
                new Transaction(pin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            
        }
        
    }
}
    public static void main(String[] args) {
        new FastCash("");
    }

}