package Service.Admin.TicketAndPassenger;

import DAO.PassengerDAO;
import POJO.Passenger;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPassenger {

    public void readPassenger() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        PassengerDAO passengerDAO = new PassengerDAO(conn);

        Scanner scanner = new Scanner(System.in);

        Passenger passenger = new Passenger();

        ArrayList<Passenger> passengers = new ArrayList<>(passengerDAO.readPassengers());

        try {
            System.out.println();
            System.out.println("LIST OF PASSENGERS");
            System.out.println();

            printPassengers(passengers);

            System.out.println("The passengers were successfully read.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The passengers were not read.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public void printPassengers(ArrayList<Passenger> passengers) {
        for (Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
    }
}
