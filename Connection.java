import java.sql.*;
public class Connection {
    java.sql.Connection c;
    Statement s ;
    Connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root" ,"786092" );
             
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
