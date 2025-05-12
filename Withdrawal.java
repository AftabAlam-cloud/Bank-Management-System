import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawal  extends JFrame implements ActionListener{
    JButton withdraw, cancel;
    JTextField amount;
    String pin;
    Withdrawal(String pin){
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Enter the amount you want to withdraw");
        text.setBounds(170, 300, 400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", java.awt.Font.BOLD, 16));  
        image.add(text);

         amount = new JTextField();
        amount.setBounds(170, 350, 320,30);
        image.add(amount);

         withdraw = new JButton("Withdraw");
         withdraw.setBounds(360, 490, 130, 30);
         withdraw.setFont(new Font("System", Font.BOLD, 16));
         withdraw.addActionListener(this);
         withdraw.setForeground(Color.BLACK);
        image.add(withdraw);


         cancel = new JButton("Cancel");
        cancel.setBounds(170, 490, 130, 30);
        cancel.setFont(new Font("System", Font.BOLD, 16));
        cancel.addActionListener(this);
        cancel.setForeground(Color.BLACK);
        image.add(cancel);
        


        setLayout(null);
        setTitle("Withdraw Money");
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){

            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                try{
                    Connection c = new Connection();
                    String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdraw', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdraw Successfully");

                    setVisible(false);
                    new Transaction( pin).setVisible(true);

                }catch(Exception e){
                    System.out.println(e);
                JOptionPane.showMessageDialog(null, "Please enter a valid amount");
                }
            }

        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Transaction(pin).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
