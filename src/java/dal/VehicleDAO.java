/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 84376
 */
public class VehicleDAO extends DBConnect {
 public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles where status ='Available'";
        try (PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        rs.getInt("VehicleID"),
                        rs.getString("LicensePlate"),
                        rs.getInt("Capacity"),
                        rs.getString("Status")
                );
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
