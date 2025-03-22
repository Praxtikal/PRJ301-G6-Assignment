package dal;

import model.HouseMovingPrice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseMovingPriceDAO extends DBConnect{
    public List<HouseMovingPrice> getAllPrices() {
        List<HouseMovingPrice> prices = new ArrayList<>();
        String sql = "SELECT VehicleType, DistanceRange, Floor, Workers, PackingService, BasePrice, AdditionalCost FROM HouseMovingPricing WHERE Status = 'Active'";

        try {
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                prices.add(new HouseMovingPrice(
                    rs.getNString("VehicleType"),
                    rs.getNString("DistanceRange"),
                    rs.getNString("Floor"),
                    rs.getInt("Workers"),
                    rs.getBoolean("PackingService"),
                    rs.getDouble("BasePrice"),
                    rs.getDouble("AdditionalCost")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prices;
    }
}
