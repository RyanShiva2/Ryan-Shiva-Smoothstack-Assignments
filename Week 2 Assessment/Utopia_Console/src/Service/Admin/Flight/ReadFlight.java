package Service.Admin.Flight;

import DAO.FlightDAO;
import POJO.Flight;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadFlight {
    public void readFlight() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        FlightDAO flightDAO = new FlightDAO(conn);
        ArrayList<Flight> flights = new ArrayList<>(flightDAO.readFlights());

        try {
            System.out.println();
            System.out.println("LIST OF FLIGHTS");
            System.out.println();

            printFlights(flights);

            System.out.println("The flights were successfully read.");
        } catch (Exception e) {
            System.out.println("The flights were not read.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public void printFlights(ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }
}
