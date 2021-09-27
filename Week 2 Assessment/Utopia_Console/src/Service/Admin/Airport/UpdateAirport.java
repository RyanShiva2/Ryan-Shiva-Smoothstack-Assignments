package Service.Admin.Airport;

import DAO.AirportDAO;
import POJO.Airport;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAirport {
    public void updateAirport() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        AirportDAO airportDAO = new AirportDAO(conn);

        Scanner scanner = new Scanner(System.in);

        Airport airport = new Airport();

        try {
            System.out.println("UPDATE AIRPORT");

            airport.setAirportCode(getIataIdInput(scanner));
            airport.setCityName(getCityInput(scanner));

            airportDAO.updateAirport(airport);
            conn.commit();

            System.out.println("The airport was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The airport was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public String getIataIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the three letter IATA location identifier of the airport to be updated: ");
        return scanner.nextLine();
    }

    public String getCityInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the updated airport city: ");
        return scanner.nextLine();
    }
}
