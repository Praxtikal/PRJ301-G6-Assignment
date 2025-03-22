package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Service;
import model.Users;

public class ServicesDAO extends DBConnect{

    

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM Services";

        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Service service = new Service();
                service.setServiceID(rs.getInt("ServiceID"));
                service.setServiceName(rs.getString("ServiceName"));
                service.setDescription(rs.getString("Description"));
                service.setBasePrice(rs.getDouble("BasePrice"));
                services.add(service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return services;
    }
     public Service getServiceByID(int serviceID) {
        String sql = "SELECT * FROM Services WHERE ServiceID = ?";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, serviceID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Service(rs.getInt("serviceID")
                        ,rs.getNString("serviceName"),
                        rs.getNString("description"),
                        rs.getDouble("basePrice"));
                    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
