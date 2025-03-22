/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 84376
 */
public class DBConnect {
    protected Connection c;
    public DBConnect(){
        try {
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01:1433;databaseName=Quanlichuyennha;encrypt=true;trustServerCertificate=true";
            String username ="sa";
            String pass ="123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c= DriverManager.getConnection(url,username , pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            if(c!=null && !c.isClosed()){
                c.close();
                System.out.println("Connection closed successfully");
            }
        } catch (Exception e) {
            System.out.println("Error closing connection " + e.getMessage());
        }
        
    }
    public static void main(String[] args) {
        DBConnect d = new DBConnect();
    }
}
