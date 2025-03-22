/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.FollowContract;
import java.sql.*;

/**
 *
 * @author 84376
 */
public class FollowContractDAO extends DBConnect {

    public List<FollowContract> getPendingContracts() {
        List<FollowContract> fc = new ArrayList<>();
        String sql = "SELECT \n"
                + "    c.ContractID, \n"
                + "    c.UserID, \n"
                + "    u.FullName , \n"
                + "    u.PhoneNumber, \n"
                + "    c.RequestID, \n"
                + "    c.StartLocation, \n"
                + "    c.EndLocation, \n"
                + "    c.StartDate, \n"
                + "    c.EndDate\n"
                + " \n"
                + "    \n"
                + "FROM Contracts c\n"
                + "JOIN Users u ON c.UserID = u.UserID";
        try (PreparedStatement ps = c.prepareStatement(sql); 
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FollowContract contract = new FollowContract(
                        rs.getInt("ContractID"),
                        rs.getInt("UserID"),
                        rs.getString("FullName"),
                        rs.getString("PhoneNumber"),
                         rs.getInt("RequestID"),
                        rs.getString("StartLocation"),
                        rs.getString("EndLocation"),
                         
                        rs.getDate("StartDate"),
                        rs.getDate("EndDate")
                       
                        
                        
                );
                fc.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fc;
    }
}
