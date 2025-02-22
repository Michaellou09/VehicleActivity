package vehicle;

public class Vehicle {
    private String vehicleId;
    private String model;
    private double rentalPricePerDay;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double rentalPricePerDay) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = true; 
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}