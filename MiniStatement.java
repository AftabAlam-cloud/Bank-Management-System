import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    MiniStatement(String pin){
        
        setLayout(null);


        JLabel text = new JLabel("");
        text.setBounds(20, 150, 400, 30);
        add(text);


        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 400, 30);
        bank.setFont(new Font("System", Font.BOLD, 20));
       
        add(bank);


        JLabel mini = new JLabel("Mini Statement");
        mini.setBounds(150, 60, 400, 30);
        add(mini);

        JLabel balance = new JLabel("");
        balance.setBounds(20, 200, 400, 30);
        add(balance);


        JLabel card = new JLabel("");
        card.setBounds(20, 100, 400, 30);
        add(card);

        try{
            Connection c = new Connection();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+1234+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber"));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            Connection c = new Connection();
            int bal= 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");

                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
            balance.setFont(new Font("System", Font.BOLD, 14));


        }catch(Exception e){
            System.out.println(e);;
        }
    

        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}