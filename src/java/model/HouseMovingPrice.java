package model;

public class HouseMovingPrice {
    private String vehicleType;
    private String distanceRange;
    private String floor;
    private int workers;
    private boolean packingService;
    private double basePrice;
    private double additionalCost;

    public HouseMovingPrice(String vehicleType, String distanceRange, String floor, int workers, boolean packingService, double basePrice, double additionalCost) {
        this.vehicleType = vehicleType;
        this.distanceRange = distanceRange;
        this.floor = floor;
        this.workers = workers;
        this.packingService = packingService;
        this.basePrice = basePrice;
        this.additionalCost = additionalCost;
    }

    // Getter
    public String getVehicleType() { return vehicleType; }
    public String getDistanceRange() { return distanceRange; }
    public String getFloor() { return floor; }
    public int getWorkers() { return workers; }
    public boolean isPackingService() { return packingService; }
    public double getBasePrice() { return basePrice; }
    public double getAdditionalCost() { return additionalCost; }
}
