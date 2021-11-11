package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.MailListReaderBD;

public class Kata5_42 {
    
    Histogram<String> histogram;
    ArrayList<Mail> mailList;
    
    public static void main(String[] args) throws FileNotFoundException {
        
        new Kata5_42().execute();
        
    }
    
    private void execute() throws FileNotFoundException{
        input();
        process();
        output();
    }

    private void input() throws FileNotFoundException {
        mailList = MailListReaderBD.read();
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    
    
}
