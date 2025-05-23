import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquiry extends JFrame  implements ActionListener{

    JButton back;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);

         back = new JButton("Back");
        back.setBounds(400, 520, 100, 25);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        

         Connection c = new Connection();
            int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                            } 
                       
                    }
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current account balance is Rs " + balance);
        text.setBounds(200, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        setTitle("Baalance Enquiry");
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
