/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
/**
 *
 * @author 84376
 */
public class ProgressDAO extends DBConnect {
    public boolean updateProgress(int contractID, String status, String notes) {
        String sql = "INSERT INTO Progress (ContractID, UpdateDate, Status, Notes) VALUES (?, NOW(), ?, ?)";

        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, contractID);
            ps.setString(2, status);
            ps.setString(3, notes);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean updateContractStatus(int contractID, String status) {
        String sql = "UPDATE Contracts SET Status = ? WHERE ContractID = ?";

        try (Connection conn = c){ 
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status); // Cập nhật trạng thái
            ps.setInt(2, contractID); // Theo contractID

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;  // Trả về true nếu có bản ghi được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
