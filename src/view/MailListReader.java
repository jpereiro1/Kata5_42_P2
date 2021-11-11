package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mail;

public class MailListReader {
    
    
    
    public static ArrayList<Mail> read(String fileName) throws FileNotFoundException{
        
        ArrayList<Mail> mailList = new ArrayList<Mail>();
        
        
        String line;
        try {
            File archivo = new File (fileName);
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            while((line=br.readLine())!=null)
                if(line.contains("@")){
                    Mail mail = new Mail(line);
                    mailList.add(mail);
                }
       
        } catch (IOException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mailList;
    }
}
