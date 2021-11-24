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
        
        String sql = "SELECT * FROM EMAIL";
        
        try (Connection conn = MailListReaderBD.connect(fileName);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Mail mail = new Mail(rs.getString("Mail"));
                mailList.add(mail);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return mailList;
    }
    
    private static Connection connect(String fileName) {
        String url = fileName;
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
