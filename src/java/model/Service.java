package model;

public class Service {
    private int serviceID;
    private String serviceName;
    private String description;
    private double basePrice;

    public Service(int serviceID, String serviceName, String description, double basePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.description = description;
        this.basePrice = basePrice;
    }

    public Service() {
    }

    // Getters and Setters

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
