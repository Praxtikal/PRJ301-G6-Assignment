/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Users;
import model.viewRequest;
import java.sql.Timestamp;
/**
 *
 * @author 84376
 */
public class viewRequestDAO extends DBConnect {
  public Users getUserByID(int userID) {
      
        String sql = "SELECT * FROM Users WHERE UserID = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Users(
                    rs.getInt("userID"),
                    rs.getString("fullName"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    rs.getString("address"),
                    rs.getString("password"),
                    rs.getInt("roleID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  
     public List<viewRequest> readRequest() {
        List<viewRequest> res = new ArrayList();
        String query = "select r.requestID,u.FullName,u.PhoneNumber,u.Address,r.RequestDate,r.Status,s.Description,s.BasePrice from Users u join Requests r on u.UserID = r.UserID join Services s on r.ServiceID = s.ServiceID  where r.Status ='pending'";
        try {
            PreparedStatement stm = c.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                res.add(new viewRequest(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6),rs.getString(7),rs.getDouble(8)));
            }
        } catch (Exception e) {
        }
        return res;
    }
    public boolean deleteRequest(int requestId) {
        String query = "DELETE FROM requests WHERE RequestID = ?";
        try (PreparedStatement statement = c.prepareStatement(query)) {
            statement.setInt(1, requestId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
