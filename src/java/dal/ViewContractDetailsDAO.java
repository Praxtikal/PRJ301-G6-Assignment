/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import model.Users;
import model.ViewContractDetails;

/**
 *
 * @author 84376
 */
public class ViewContractDetailsDAO extends DBConnect {
  public List<ViewContractDetails> getContractsByUserId(int userId) {
        List<ViewContractDetails> contracts = new ArrayList<>();
        String sql = "SELECT cd.ContractDetailID, c.ContractID, u.FullName, u.Email, u.PhoneNumber, u.Address, " +
                     "c.RequestID, c.StartLocation, c.EndLocation, c.StartDate, c.EndDate, c.TotalCost, " +
                     "c.Status AS ContractStatus, c.DepositAmount, e.Position AS EmployeePosition, " +
                     "v.LicensePlate, v.Capacity " +
                     "FROM Contract_Details cd " +
                     "JOIN Contracts c ON cd.ContractID = c.ContractID " +
                     "JOIN Users u ON c.UserID = u.UserID " +
                     "JOIN Employees e ON cd.EmployeeID = e.EmployeeID " +
                     "JOIN Vehicles v ON cd.VehicleID = v.VehicleID " +
                     "WHERE u.UserID = ?";

        try (Connection conn = c){
             PreparedStatement ps = c.prepareStatement(sql) ;

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ViewContractDetails contract = new ViewContractDetails();
                contract.setContractDetailID(rs.getInt("ContractDetailID"));
                contract.setContractID(rs.getInt("ContractID"));
                contract.setFullName(rs.getString("FullName"));
                contract.setEmail(rs.getString("Email"));
                contract.setPhoneNumber(rs.getString("PhoneNumber"));
                contract.setAddress(rs.getString("Address"));
                contract.setRequestID(rs.getInt("RequestID"));
                contract.setStartLocation(rs.getString("StartLocation"));
                contract.setEndLocation(rs.getString("EndLocation"));
                contract.setStartDate(rs.getDate("StartDate"));
                contract.setEndDate(rs.getDate("EndDate"));
                contract.setTotalCost(rs.getDouble("TotalCost"));
                contract.setContractStatus(rs.getString("ContractStatus"));
                contract.setDepositAmount(rs.getDouble("DepositAmount"));
                contract.setEmployeePosition(rs.getString("EmployeePosition"));
                contract.setLicensePlate(rs.getString("LicensePlate"));
                contract.setCapacity(rs.getInt("Capacity"));

                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
   
       
   
}

