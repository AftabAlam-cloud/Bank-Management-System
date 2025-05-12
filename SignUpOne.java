//import library............
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//extends class..............

public class SignUpOne  extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser dateChooser;
    JRadioButton male , female;
    JRadioButton married ,Unmarried , Other;
    JLabel formno;
    



    //Constructor..............
     SignUpOne() {   
        // Constructor of the class
        Random ran = new Random();  //random number generate........

        Long random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        //Application form no........

        formno = new JLabel("APPLICATION FORM NO."+ " "+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20 , 600 , 40);
        add(formno);
        

        JLabel Personal = new JLabel("Page 1: Personal Details");
        Personal.setFont(new Font("Raleway", Font.BOLD, 24));
        Personal.setBounds(230, 80 , 300 , 30);
        add(Personal);
//name and text field.........

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 130 , 100 , 30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 130 , 300 , 30);
        add(nameTextField);

//father name and text field.......

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 180 , 200 , 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 180 , 300 , 30);
        add(fnameTextField);

        //date of birth.................

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 230 , 200 , 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300 , 230, 300 , 30);
        add(dateChooser);


        //gender chooser...........


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 280 , 200 , 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300 , 280 , 100 , 30);
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(400 , 280 , 200 , 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        //email..........

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 330 , 200 , 30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 330 , 300 , 30);
        add(emailTextField);


 
        //marital status........

        JLabel marital  = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(100, 380 , 200 , 30);
        add( marital);

        married = new JRadioButton("Married");
        married.setBounds(300 , 380 , 100 , 30);
        married.setBackground(Color.WHITE);
        add( married);

        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(400 , 380 , 150 , 30);
        Unmarried.setBackground(Color.WHITE);
        add(Unmarried);

         Other = new JRadioButton("Other");
       Other.setBounds(540 , 380 , 250 , 30);
        Other.setBackground(Color.WHITE);
        add(Other);
        

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(Unmarried);
        maritalGroup.add(Other);


        //address............

        JLabel address  = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 430 , 200 , 30);
        add( address);

         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 430 , 300 , 30);
        add(addressTextField);



        //city..............

        JLabel city  = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 480 , 200 , 30);
        add( city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 480 , 300 , 30);
        add(cityTextField);


        //status.........

        JLabel state  = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 530 , 200 , 30);
        add( state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 530 , 300 , 30);
        add(stateTextField);


        //pin...............

        JLabel pin  = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin .setBounds(100, 580 , 200 , 30);
        add( pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 580 , 300 , 30);
        add(pinTextField);


        //next button.........

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(520 , 630 , 80 , 30);
        next.addActionListener(this);
        add(next);





        //frame create.............
   
        setLayout(null);
        setTitle("SignPageOne");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);



        // Constructor
    }
    // Action listener method
    public void actionPerformed(ActionEvent ae){
    String formno = "" + random;
    String name = nameTextField.getText();
    String fname = fnameTextField.getText();
    String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(male.isSelected()){
        gender = "Male";

    } else if(female.isSelected()){
        gender = "Female";
    } 
    String email = emailTextField.getText();
    String marital = null;
    if(married.isSelected()){
        marital = "Married";

    }else if(Unmarried.isSelected()){
        marital = "Unmarried";

    }else if(Other.isSelected()){
        marital = "Other";
    }
    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();

    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        }
        else if(fname.equals("")){
            JOptionPane.showMessageDialog(null, "Father's name is required");
        }
        else if(dob.equals("")){
            JOptionPane.showMessageDialog(null, "Date of birth is required");
        } 
        else if (email.equals("")){
            JOptionPane.showMessageDialog(null, "Email is required");
        } 
        else if (address.equals("")){
            JOptionPane.showMessageDialog(null, "Address is required");
        } 
        else if (city.equals("")){
            JOptionPane.showMessageDialog(null, "City is required");
        } 
        else if (state.equals("")){
            JOptionPane.showMessageDialog(null, "State is required");
        } 
        else if (pin.equals("")){
            JOptionPane.showMessageDialog(null, "Pin code is required");
        } 
        else {
            // Database connection and insertion logic here
            Connection c = new Connection();
            String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+ dob+"', '"+ gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";

            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
            


    } catch(Exception e){ 
        System.out.println(e);
    }

    }
    

    public static void main(String[] args) {
        // Main method inside the class
        new SignUpOne();
    }
}
