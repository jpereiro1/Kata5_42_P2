package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mail;

public class MailListReaderBD {
    
    public static ArrayList<Mail> read(String fileName) throws FileNotFoundException{
        
        ArrayList<Mail> mailList = new ArrayList<Mail>();
        
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                System.out.println(rs.getInt("Id")+ "\t" +
                                   rs.getString("Name")+ "\t" +
                                   rs.getString("Apellidos")+ "\t" +
                                   rs.getString("Departamento"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private Connection connect() {
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println("No se ha podido conectar con la base de datos"
                    + e.getMessage());
        }
        return conn;
    }
}
