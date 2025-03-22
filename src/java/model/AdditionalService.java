package model;

public class AdditionalService {
    private String serviceName;
    private String description;
    private double price;
    private String unit;

    public AdditionalService(String serviceName, String description, double price, String unit) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.unit = unit;
    }

    // Getter
    public String getServiceName() { return serviceName; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getUnit() { return unit; }
}
