package dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;
import dal.DBConnect;
import java.util.ArrayList;
import java.util.List;
public class UsersDAO extends DBConnect {
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

    // ✅ Lấy danh sách tất cả khách hàng (RoleID = 1)
    public List<Users> getAllCustomers() {
        List<Users> customers = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE RoleID = 1"; // RoleID = 1 là khách hàng
        try (PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new Users(
                    rs.getInt("userID"),
                    rs.getString("fullName"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    rs.getString("ddress"),
                    rs.getString("password"),
                    rs.getInt("roleID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // ✅ Lấy danh sách tất cả quản lý (RoleID = 3)
    public List<Users> getAllManagers() {
        List<Users> managers = new ArrayList<>();
        String sql = "SELECT * FROM Users "; // RoleID = 3 là quản lý
        try (PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                managers.add(new Users(
                    rs.getInt("userID"),
                    rs.getString("fullName"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    rs.getString("address"),
                    rs.getString("password"),
                    rs.getInt("roleID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }
    public Users validateUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try {
             PreparedStatement stmt = c.prepareStatement(sql); 
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Users(
                    rs.getInt("userID"),
                    rs.getNString("FullName"),
                    rs.getNString("Username"),
                    rs.getNString("Email"),
                    rs.getNString("PhoneNumber"),
                    rs.getNString("Address"),
                    rs.getNString("Password"),
                    rs.getInt("RoleID")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(Users user) {
        String sql = "INSERT INTO Users (FullName, Username, Email, PhoneNumber, Address, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
             PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setNString(1, user.getFullName());
            stmt.setNString(2, user.getUserName());
            stmt.setNString(3, user.getEmail());
            stmt.setNString(4, user.getPhoneNumber());
            stmt.setNString(5, user.getAddress());
            stmt.setNString(6, user.getPassword());
            stmt.setInt(7, user.getRoleID());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
public boolean addUserByAdmin(Users user) {
    String sql = "INSERT INTO Users (FullName, Username, Email, PhoneNumber, Address, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
         PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, user.getFullName());
        stmt.setString(2, user.getUserName());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPhoneNumber());
        stmt.setString(5, user.getAddress());
        stmt.setString(6, user.getPassword());
        stmt.setInt(7, user.getRoleID()); // Nhân viên hoặc Quản lý
        return stmt.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
 public Users getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Users WHERE Username = ?";
        try (PreparedStatement stmt =c.prepareStatement(query)){
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Users(
                        rs.getInt("UserID"),
                        rs.getString("FullName"),
                        rs.getString("Username"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address"),
                        rs.getString("Password"),
                        rs.getInt("RoleID")
                    );
                }
            }
        }
        return null;
    }
 
   
}
