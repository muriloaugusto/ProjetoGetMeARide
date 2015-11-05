package dao;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectBD {
    public static Connection getConnnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado!");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastroGetMeARide","root","");
            
         } catch (ClassNotFoundException ex) {
          throw new SQLException(ex.getMessage());
          
        }
    }
}
