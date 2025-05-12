import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

class Login extends JFrame  implements ActionListener{

    JButton login, Clear, SignUp;
    JTextField cardTextField;
    JPasswordField PinTextField;
    Login(){
        setTitle("Automated teller Machine (Login Page)");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        l1.setBounds(70 , 20, 100, 100);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setFont(new Font("Raleway", Font.BOLD, 18));
        CardNo.setBounds(120,150 , 150, 30);
        add(CardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30 );
        add(cardTextField);

        JLabel Pin = new JLabel("Pin:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 18));
        Pin.setBounds(120, 190, 150, 30);
        add(Pin);

        PinTextField = new JPasswordField();
        PinTextField.setBounds(300, 190, 100, 30 );
        add(PinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 250, 80, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
       
        add(login);



        Clear = new JButton("CLEAR");
        Clear.setBounds(400, 250, 80, 30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
       
        add(Clear);

        SignUp = new JButton("SIGN UP");
        SignUp.setBounds(300, 300,180 , 30);
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
       
        add(SignUp);





        setLayout(null);
        

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            cardTextField.setText("");
            PinTextField.setText("");

        }else if ( ae.getSource() == login){
            String cardno = cardTextField.getText();
            String pin = PinTextField.getText();
            Connection c = new Connection();
            String query = "select *from login where cardNumber = '"+cardno+"' and pin = '"+pin+"'";
            try{

                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if ( ae.getSource() == SignUp){

            setVisible(false);
            new SignUpOne().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login();
    }

}
