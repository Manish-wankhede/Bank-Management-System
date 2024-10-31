package bank.managemet.system;

import java.sql.*;

public class Conn {
    Connection connect;

    Statement statement;
    public Conn(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Manish@1432");
            statement = connect.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
