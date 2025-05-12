
    //import library............
import javax.swing.*;
import java.awt.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//extends class..............

public class SignupTwo  extends JFrame implements ActionListener {

    //Declare variable.............


    JTextField aadharTextField, panTextField ;
    JComboBox religios , categoryComboBox , income, occupationComboBox, education;
    
    long random;
    
    JRadioButton male , female ,yes ,no;
    JRadioButton married ,Unmarried , Other;
    String formno;



    //Constructor..............
     SignupTwo(String formno) {   
        // Constructor of the class
            this.formno = formno;
        



        //ADDITIONAL form no........

        
        JLabel Additional = new JLabel("Page 2: Additional Details");
        Additional.setFont(new Font("Raleway", Font.BOLD, 24));
        Additional.setBounds(230, 80 , 300 , 30);
        add(Additional);
//RELIGION and text field.........

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(100, 130 , 100 , 30);
        add(religion);

        String[] religions = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
         religios = new JComboBox(religions);
        religios.setBounds(300, 130 , 300 , 30);
        religios.setBackground(Color.WHITE);
        add(religios);
        

//CATEGORY and text field.......

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(100, 180 , 200 , 30);
        add(category);

        String[] valcategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox(valcategory);
        categoryComboBox.setBounds(300, 180 , 300 , 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);



        //INCOME.................

        JLabel in = new JLabel("Income:");
        in.setFont(new Font("Raleway", Font.BOLD, 18));
        in.setBounds(100, 230 , 200 , 30);
        add(in);

        String[] valincome = {">50000", ">150000", ">250000", ">500000", "UP TO 1000000"};
        income = new JComboBox(valincome);
        income.setBounds(300, 230 , 300 , 30);
        income.setBackground(Color.WHITE);
        add(income);


        //EDUCATIONAL...........


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 280 , 200 , 30);
        add(gender);


        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 305 , 200 , 30);
        add(email);


        String[] valEducation = {"None graduation", "Graduation", "Post Graduation", "Doctrate", "Other"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 305 , 300 , 30);
        education.setBackground(Color.WHITE);
        add(education);


        

 
        //Occupation status........

        JLabel oc  = new JLabel("Occupation:");
        oc.setFont(new Font("Raleway", Font.BOLD, 18));
       oc.setBounds(100, 380 , 200 , 30);
        add( oc);


        String[] occupations = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Other"};

        occupationComboBox = new JComboBox<>(occupations);
        occupationComboBox.setBounds(300, 380 , 300 , 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);
        
        


        //PAN NO.............

        JLabel pan  = new JLabel("PAN No.:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(100, 430 , 200 , 30);
        add( pan);

         panTextField = new JTextField();
       panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 430 , 300 , 30);
        add(panTextField);



        //AADHAR..............

        JLabel city  = new JLabel("Aadhar No.:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 480 , 200 , 30);
        add( city);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 480 , 300 , 30);
        add(aadharTextField);


        //senior citizen.........

        JLabel sc  = new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 18));
        sc.setBounds(100, 530 , 200 , 30);
        add( sc);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 530 , 100 , 30);
        yes.setBackground(Color.WHITE);
        add(yes);
         no =new JRadioButton("No");
        no.setBounds(400, 530 , 100 , 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);



        //Existing account...............

        JLabel ac  = new JLabel("Existing Account:");
        ac.setFont(new Font("Raleway", Font.BOLD, 18));
        ac .setBounds(100, 580 , 200 , 30);
        add( ac);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 580 , 100 , 30);
        yes.setBackground(Color.WHITE);
        add(yes);
         no =new JRadioButton("No");
        no.setBounds(400, 580 , 100 , 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup acgroup = new ButtonGroup();
        acgroup.add(yes);
        acgroup.add(no);

        //next button.........

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(520 , 630 , 80 , 30);
        next.addActionListener(this);
        add(next);





        //frame create.............
   
        setLayout(null);
        setTitle("SignPageTwo");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);



        // Constructor
    }
    // Action listener method
    public void actionPerformed(ActionEvent ae){
        // Action performed method
         // This should be passed from the previous form
        String religion = (String) religios.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) this.income.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String education = (String) this.education.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String ac = (yes.isSelected()) ? "Yes" : "No";
        String sc = (yes.isSelected()) ? "Yes" : "No";
    
    
    try{
        if(religion.equals("")){
            JOptionPane.showMessageDialog(null, "religion is required");
        }
        else if(category.equals("")){
            JOptionPane.showMessageDialog(null, "category's name is required");
        }
        else if(income.equals("")){
            JOptionPane.showMessageDialog(null, "income is required");
        } 
        else if (occupation.equals("")){
            JOptionPane.showMessageDialog(null, "occupation is required");
        } 
        else if (education.equals("")){
            JOptionPane.showMessageDialog(null, "education is required");
        } 
        else if (pan.equals("")){
            JOptionPane.showMessageDialog(null, "pan is required");
        } 
        else if (aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "aadhar is required");
        } 
        else if (ac.equals("")){
            JOptionPane.showMessageDialog(null, "ac is required");
        } 
        else {
            // Database connection and insertion logic here
            Connection c = new Connection();
            String query = "insert into SignupTwo values('"+ formno + "','" + religion + "','" + category + "','" + income + "','" + occupation + "','" + education + "','" + pan + "','" + aadhar + "','" + sc + "','" + ac + "')";

            c.s.executeUpdate(query);

        
        }
        setVisible(false);
        new SignupThree(formno);
            


    } catch(Exception e){ 
        System.out.println(e);
    }

    }


    

    public static void main(String[] args) {
        // Main method inside the class
        new SignupTwo("");
    }
}


