package Service.Admin.Airport;

import DAO.AirportDAO;
import POJO.Airport;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AddAirport {

    public void addAirport() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        AirportDAO airportDAO = new AirportDAO(conn);

        Scanner scanner = new Scanner(System.in);

        Airport airport = new Airport();

        try {
            System.out.println("ADD AIRPORT");

            airport.setAirportCode(getIataIdInput(scanner));
            airport.setCityName(getCityInput(scanner));

            airportDAO.addAirport(airport);
            conn.commit();

            System.out.println("The airport was successfully added.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The airport was not added.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public String getIataIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the three letter IATA location identifier: ");
        return scanner.nextLine();
    }

    public String getCityInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the airport city: ");
        return scanner.nextLine();
    }
}