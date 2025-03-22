package dal;

import model.Contract;
import model.Users;
import model.Request;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO extends DBConnect {
    
    public int createContract(int userID, int requestID, String startLocation, String endLocation, Date startDate, Date endDate, double totalCost, double depositAmount) {
        String sql = "INSERT INTO Contracts (UserID, RequestID, StartLocation, EndLocation, StartDate, EndDate, Status, DepositAmount, TotalCost) "
                   + "OUTPUT INSERTED.ContractID VALUES (?, ?, ?, ?, ?, ?, 'Pending', ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            stmt.setInt(2, requestID);
            stmt.setString(3, startLocation);
            stmt.setString(4, endLocation);
            stmt.setDate(5, startDate);
            stmt.setDate(6, endDate);
            stmt.setDouble(7, depositAmount);
            stmt.setDouble(8, totalCost);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // ✅ Trả về ContractID mới tạo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // ❌ Nếu có lỗi, trả về -1
    }

    /** ✅ Lấy danh sách tất cả hợp đồng **/
    public List<Contract> getAllContracts() {
        List<Contract> list = new ArrayList<>();
        String sql = "SELECT * FROM Contracts where status ='pending' ORDER BY ContractID DESC";
        
        try (PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Contract(
                    rs.getInt("contractID"),
                    rs.getInt("userID"),
                    rs.getInt("requestID"),
                    rs.getString("startLocation"),
                    rs.getString("endLocation"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate"),
                    rs.getDouble("totalCost"),
                    rs.getString("status"),
                    rs.getDouble("depositAmount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /** ✅ Lấy danh sách hợp đồng của một User **/
    public List<Contract> getContractsByUser(int userID) {
        List<Contract> list = new ArrayList<>();
        String sql = "SELECT * FROM Contracts WHERE UserID = ? ORDER BY ContractID DESC";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Contract(
                    rs.getInt("ContractID"),
                    rs.getInt("UserID"),
                    rs.getInt("RequestID"),
                    rs.getString("StartLocation"),
                    rs.getString("EndLocation"),
                    rs.getDate("StartDate"),
                    rs.getDate("EndDate"),
                    rs.getDouble("TotalCost"),
                    rs.getString("Status"),
                    rs.getDouble("DepositAmount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     public boolean updateContract(int contractID, String startLocation, String endLocation, 
                                  java.sql.Date startDate, java.sql.Date endDate, 
                                  double totalCost, double depositAmount) {
        String query = "UPDATE Contracts SET startLocation = ?, endLocation = ?, startDate = ?, " +
                       "endDate = ?, totalCost = ?, depositAmount = ? WHERE contractID = ?";
        try {
             PreparedStatement ps = c.prepareStatement(query);
            
            // Thiết lập các tham số
            ps.setString(1, startLocation);
            ps.setString(2, endLocation);
            ps.setDate(3, startDate);
            ps.setDate(4, endDate);
            ps.setDouble(5, totalCost);
            ps.setDouble(6, depositAmount);
            ps.setInt(7, contractID);  // ID hợp đồng cần cập nhật

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Nếu có lỗi trong quá trình cập nhật
        }
    }
     public boolean updateContractStatusToConfirmed(int contractID) {
    String sql = "UPDATE Contracts SET Status = 'Confirmed' WHERE ContractID = ?";
    try (PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, contractID);
        
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // Trả về true nếu cập nhật trạng thái thành công
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
      
}
}
