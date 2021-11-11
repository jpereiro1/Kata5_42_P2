package view;

import java.util.ArrayList;
import java.util.Iterator;
import model.Histogram;
import model.Mail;


public class MailHistogramBuilder {
    
    public static Histogram<String> build(ArrayList<Mail> mailList){
        Histogram hist = new Histogram();
        
        for(Mail it : mailList){
            hist.increment(it.getDomain());
        }
        
        return hist;
    }
    
    
}
