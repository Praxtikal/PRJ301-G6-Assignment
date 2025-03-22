package dal;

import java.sql.*;

public class ContractDetailDAO extends DBConnect {

    // Phương thức gán nhân viên và xe vào hợp đồng chi tiết
    public boolean addContractDetail(int contractID, int employeeID, int vehicleID) {
    String sqlInsert = "INSERT INTO Contract_Details (ContractID, EmployeeID, VehicleID) VALUES (?, ?, ?)";

    try (PreparedStatement stmtInsert = c.prepareStatement(sqlInsert)){

        // Thêm nhân viên và phương tiện vào hợp đồng
        stmtInsert.setInt(1, contractID);
        stmtInsert.setInt(2, employeeID);
        stmtInsert.setInt(3, vehicleID);
        
        // Thực thi câu lệnh thêm hợp đồng chi tiết
        int rowsAffectedInsert = stmtInsert.executeUpdate();

        // Cập nhật trạng thái phương tiện thành 'In Use'
       

        // Kiểm tra nếu cả hai câu lệnh đều thành công
        return rowsAffectedInsert > 0 ;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
}

    // Lấy tất cả hợp đồng (giả sử có phương thức này)
    
    