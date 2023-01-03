package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderBD {
    
    public static List<Mail> read() {
        List<Mail> mailList = new ArrayList<>();
        String sql = "SELECT * FROM EMAIL";
        
        try (Connection conn = connect("kata5.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                mailList.add(new Mail(rs.getString("mail")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailList;
    }
    
    private static Connection connect(String dataBase) {
        String url = "jdbc:sqlite:" + dataBase;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
}
