package Service.Admin.Airport;

import DAO.AirportDAO;
import POJO.Airport;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadAirport {

    public void readAirport() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        AirportDAO airportDAO = new AirportDAO(conn);
        ArrayList<Airport> airports = new ArrayList<>(airportDAO.readAirports());

        try {
            System.out.println();
            System.out.println("LIST OF AIRPORTS");
            System.out.println();

            printAirports(airports);

            System.out.println("The airports were successfully read.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The airports were not read.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public void printAirports(ArrayList<Airport> airports) {
        for (Airport airport : airports) {
            System.out.println(airport.toString());
        }
    }
}
