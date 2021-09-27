package Service.Admin.TicketAndPassenger;

import DAO.PassengerDAO;
import POJO.Passenger;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePassenger {

    public void deletePassenger() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        PassengerDAO passengerDAO = new PassengerDAO(conn);

        Scanner scanner = new Scanner(System.in);

        Passenger passenger = new Passenger();

        try {
            System.out.println("DELETE PASSENGER");

            passenger.setPassengerId(getPassengerIdInput(scanner));

            passengerDAO.deletePassenger(passenger);
            conn.commit();

            System.out.println("The passenger was successfully deleted.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The passenger was not deleted.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getPassengerIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the passenger ID for the passenger to be deleted: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
