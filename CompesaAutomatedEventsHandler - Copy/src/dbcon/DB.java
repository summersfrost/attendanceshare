/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Frost
 */
public class DB {
public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localHost:3306/mathsciattendance";
        String username = "root";  // Replace with your MySQL username
        String password = "";  // Replace with your MySQL password
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected Successfully");
    } catch (Exception e) {
        System.out.println(e);
    }
    return con;
}
}
/*
public class DB {
    public static Connection getConnection() {
           String dbServerIP="Not FOund";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Get the local machine's IPv4 address
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress[] allMyIps = InetAddress.getAllByName(localHost.getCanonicalHostName());
            
            for(InetAddress ip : allMyIps){
            if(ip.isSiteLocalAddress()&& !ip.isLoopbackAddress()&&ip.getHostAddress().indexOf(":")==-1){
                System.out.println("ipv4: " + ip.getHostAddress());
              
               dbServerIP=ip.getHostAddress();
            }}
            
         
            
          System.out.println(dbServerIP);
            String port = "3306";
            String databaseName = "mathsciattendance2";
            String username = "Frost"; // Replace with your MySQL username
            String password = "Frost"; // Replace with your MySQL password

            String url = "jdbc:mysql://" + dbServerIP + ":" + port + "/" + databaseName;
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
*/