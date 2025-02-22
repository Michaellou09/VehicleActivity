package vehicle;

import java.time.LocalDate;

public class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(Vehicle vehicle, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        vehicle.setAvailable(false);
    }

    public double calculateTotalCost() {
        long days = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        return days * vehicle.getRentalPricePerDay();
    }

    public void returnVehicle() {
        vehicle.setAvailable(true); 
    }
}