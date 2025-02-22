package vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Vehicle> vehicles;
    private List<Rental> rentals;

    public RentalService() {
        vehicles = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Rental rentVehicle(Customer customer, String vehicleId, LocalDate startDate, LocalDate endDate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailable()) {
                Rental rental = new Rental(vehicle, customer, startDate, endDate);
                rentals.add(rental);
                return rental;
            }
        }
        return null;
    }

    public void returnVehicle(Rental rental) {
        rental.returnVehicle();
        rentals.remove(rental);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }
}