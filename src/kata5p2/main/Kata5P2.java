package kata5p2.main;

import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

public class Kata5P2 {

    private static List<Mail> mailList;
    private static Histogram<String> histogram;

    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        input();
        process();
        output();
    }

    private static void input() {
        mailList = MailListReader.read("email.txt");
    }

    private static void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAMA", histogram);
        histogramDisplay.execute();
    }
}