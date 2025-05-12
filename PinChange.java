import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PinChange extends JFrame  implements ActionListener{

    JButton change, back;
    JTextField PIN, repintext;
    String pin;
    
    PinChange(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);

        add(image);
    
        JLabel text = new JLabel("Change your pin");
        text.setBounds(250, 350,  400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("Enter New Pin:");
        pintext.setBounds(180, 415,  150, 35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        PIN = new JTextField();
        PIN.setBounds(320, 415, 150, 30);
        PIN.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(PIN);



        JLabel repin = new JLabel("Confirm Pin:");
        repin.setBounds(180, 455,  150, 35);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System", Font.BOLD, 16));
        image.add(repin);

         repintext = new JTextField();
        repintext.setBounds(320, 455, 150, 30);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repintext);


        change = new JButton("Change");
        change.setBounds(370, 520, 100, 25);
        change.setFont(new Font("System", Font.BOLD, 16));
        change.setForeground(Color.BLACK);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(240, 520, 100, 25);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);



        setTitle("Fast Cash");
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == change){
            try{
                String npin = PIN.getText();
                String rpin = repintext.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Pin does not match");
                    return;
                }else if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter a valid pin");
                    return;
                }else if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter a valid pin");
                    return;
                }else if(npin.equals(rpin)){
                    Connection c = new Connection();
                    String query1 = "update bank set pin = '"+npin+"' where pin = '"+pin+"'";
                    String query2 = "update login set pin = '"+npin+"' where pin = '"+pin+"'";
                    String query3 = "update SignupThree set pin = '"+npin+"' where pin = '"+pin+"'";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Pin changed successfully");

                    setVisible(false);
                    new Transaction(npin).setVisible(true);


                    // Pin change logic can be added here
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }


    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);;
    }
}
