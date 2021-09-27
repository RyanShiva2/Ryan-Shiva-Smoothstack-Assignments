package Service.Admin.Traveler;

import DAO.PassengerDAO;
import POJO.Passenger;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class UpdatePassenger {

    public void updatePassenger() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        PassengerDAO passengerDAO = new PassengerDAO(conn);

        Scanner scanner = new Scanner(System.in);

        Passenger passenger = new Passenger();

        try {
            System.out.println("UPDATE PASSENGER");

            passenger.setPassengerId(getPassengerIdInput(scanner));
            passenger.getBooking().setBookingId(getBookingIdInput(scanner));
            passenger.setGivenName(getGivenNameInput(scanner));
            passenger.setFamilyName(getFamilyNameInput(scanner));
            passenger.setDob(getDobInput(scanner));
            passenger.setGender(getGenderInput(scanner));
            passenger.setAddress(getAddressInput(scanner));

            passengerDAO.updatePassenger(passenger);
            conn.commit();

            System.out.println("The passenger was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The passenger was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getPassengerIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the passenger ID for the passenger to be updated: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Integer getBookingIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the booking ID for the passenger: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getGivenNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the given name of the passenger: ");
        return scanner.nextLine();
    }

    public String getFamilyNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the family name of the passenger: ");
        return scanner.nextLine();
    }

    public LocalDate getDobInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the passenger date of birth (format 'YYYY-MM-DD'): ");
        return LocalDate.parse(scanner.nextLine());
    }

    public String getGenderInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the passenger gender: ");
        return scanner.nextLine();
    }

    public String getAddressInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the passenger address: ");
        return scanner.nextLine();
    }
}
