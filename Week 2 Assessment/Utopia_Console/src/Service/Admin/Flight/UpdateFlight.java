package Service.Admin.Flight;

import DAO.FlightDAO;
import POJO.Flight;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateFlight {
    public void updateFlight() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();
        Scanner scanner = new Scanner(System.in);

        AdminService adminService = new AdminService();
        FlightDAO flightDAO = new FlightDAO(conn);

        Flight flight = new Flight();

        try {
            System.out.println("UPDATE FLIGHT");

            flight.setFlightId(getFlightIdInput(scanner));
            flight.getRoute().setRouteId(getRouteIdInput(scanner));
            flight.getAirplane().setAirplaneId(getAirplaneIdInput(scanner));
            flight.setDepartureTime(getDepartureTimeInput(scanner));
            flight.setReservedSeats(getReservedSeatInput(scanner));
            flight.setSeatPrice(getSeatPriceInput(scanner));

            flightDAO.updateFlight(flight);
            conn.commit();
            System.out.println("The flight was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The flight was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getFlightIdInput(Scanner scanner) {
        System.out.print("Enter the Flight ID of the flight to be updated: ");
        return scanner.nextInt();
    }

    public Integer getRouteIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the updated Route ID: ");
        return scanner.nextInt();
    }

    public Integer getAirplaneIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the updated Airplane ID: ");
        return scanner.nextInt();
    }

    public LocalDateTime getDepartureTimeInput(Scanner scanner) {
        while (true) {
            try {
                return LocalDateTime.parse(scanner.nextLine());
            } catch (Exception ignored) {
            }
            System.out.println();
            System.out.print("Enter the updated Departure Date and Time (format 'YYYY-MM-DDTHH:MM'): ");
        }
    }

    public Integer getReservedSeatInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the updated number of reserved seats: ");
        return scanner.nextInt();
    }

    public Float getSeatPriceInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the updated seat price: ");
        return scanner.nextFloat();
    }
}
