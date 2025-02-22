package vehicle;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        rentalService.addVehicle(new Vehicle("001", "Honda Civic", 400.0));
        rentalService.addVehicle(new Vehicle("002", "Isuzu D-max", 600.0));
        rentalService.addVehicle(new Vehicle("003", "Ford Ranger", 800.0));

        String customerId = JOptionPane.showInputDialog("Enter Customer ID:");
        String customerName = JOptionPane.showInputDialog("Enter Customer Name:");
        String contactNumber = JOptionPane.showInputDialog("Enter Contact Number:");

        Customer customer = new Customer(customerId, customerName, contactNumber);

        String vehicleId = JOptionPane.showInputDialog("Enter Vehicle ID to Rent:");

        LocalDate startDate = null;
        LocalDate endDate = null;

        while (startDate == null) {
            String startDateStr = JOptionPane.showInputDialog("Enter Start Date (YYYY-MM-DD):");
            try {
                startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        while (endDate == null) {
            String endDateStr = JOptionPane.showInputDialog("Enter End Date (YYYY-MM-DD):");
            try {
                endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        Rental rental = rentalService.rentVehicle(customer, vehicleId, startDate, endDate);

        if (rental != null) {
            JOptionPane.showMessageDialog(null, "Vehicle rented successfully!\nTotal cost: $" + rental.calculateTotalCost());
        } else {
            JOptionPane.showMessageDialog(null, "Vehicle not available for rent.");
        }

        if (rental != null) {
            rentalService.returnVehicle(rental);
            JOptionPane.showMessageDialog(null, "Vehicle returned successfully.");
        }
    }
}