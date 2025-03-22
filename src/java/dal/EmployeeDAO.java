/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84376
 */
public class EmployeeDAO extends DBConnect {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.EmployeeID, e.Position, u.FullName, u.Email, u.PhoneNumber, u.Address  from  employees e  \n"
                + "                     JOIN users u ON e.UserID = u.UserID  \n"
                + "                     WHERE u.RoleID = 2";
        try (PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("EmployeeID"),
                        rs.getString("Position"),
                        rs.getString("FullName"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
    