package Service.Admin.Flight;

import DAO.FlightDAO;
import POJO.Flight;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteFlight {
    public void deleteFlight() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        Scanner scanner = new Scanner(System.in);

        AdminService adminService = new AdminService();
        FlightDAO flightDAO = new FlightDAO(conn);

        Flight flight = new Flight();

        try {
            System.out.println("DELETE FLIGHT");
            flight = getFlightInput(flight, scanner);

            flightDAO.deleteFlight(flight);
            conn.commit();

            System.out.println("The flight was successfully deleted.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The flight was not deleted.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Flight getFlightInput(Flight flight, Scanner scanner) {
        System.out.print("Enter the flight ID of the flight to be deleted: ");
        flight.setFlightId(scanner.nextInt());
        return flight;
    }
}
