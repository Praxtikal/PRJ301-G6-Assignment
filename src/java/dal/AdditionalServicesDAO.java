package dal;

import model.AdditionalService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdditionalServicesDAO extends DBConnect{
    public List<AdditionalService> getAllServices() {
        List<AdditionalService> services = new ArrayList<>();
        String sql = "SELECT ServiceName, Description, Price, Unit FROM AdditionalServices WHERE Status = 'Active'";

        try {
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                services.add(new AdditionalService(
                    rs.getNString("ServiceName"),
                    rs.getNString("Description"),
                    rs.getDouble("Price"),
                    rs.getString("Unit")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;
    }
}
