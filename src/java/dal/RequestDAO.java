package dal;
import java.sql.*;
import java.util.*;
import model.Request;

public class RequestDAO  extends DBConnect{
   

    // Method to save a new request in the database
    public boolean createRequest(int userId, int serviceId) {
        String query = "INSERT INTO Requests (UserID, ServiceID, RequestDate, Status) VALUES (?, ?, GETDATE(), 'Pending')";
        try (PreparedStatement statement = c.prepareStatement(query)){
            statement.setInt(1, userId);
            statement.setInt(2, serviceId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public Request getRequestByID(int requestID) {
        String sql = "SELECT * FROM Requests WHERE RequestID = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, requestID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Request(
                    rs.getInt("RequestID"),
                    rs.getInt("UserID"),
                    rs.getInt("ServiceID"),
                    rs.getTimestamp("RequestDate"),
                    rs.getString("Status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // ❌ Nếu không tìm thấy Request, trả về `null`
    }
      public List<Request> getPendingRequests() {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM Requests WHERE Status = 'Pending'";
        
        try (PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Request(
                    rs.getInt("RequestID"),
                    rs.getInt("UserID"),
                    rs.getInt("ServiceID"),
                    rs.getTimestamp("RequestDate"),
                    rs.getString("Status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /** ✅ Lấy UserID từ RequestID */
    public int getUserIDByRequestID(int requestID) {
        String sql = "SELECT UserID FROM Requests WHERE RequestID = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, requestID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("UserID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // ❌ Nếu lỗi
    }
    public void updateRequestStatus(int requestID, String status) {
    String query = "UPDATE Requests SET status = ? WHERE requestID = ?";
    
    try {
         PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, status);
        ps.setInt(2, requestID);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
    

    // Method to fetch all requests (if needed for listing or management)

