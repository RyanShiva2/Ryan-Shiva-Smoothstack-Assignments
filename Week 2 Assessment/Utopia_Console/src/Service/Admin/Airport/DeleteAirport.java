package Service.Admin.Airport;

import DAO.AirportDAO;
import POJO.Airport;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAirport {

    public void deleteAirport() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        Scanner scanner = new Scanner(System.in);

        AdminService adminService = new AdminService();
        AirportDAO airportDAO = new AirportDAO(conn);

        Airport airport = new Airport();

        try {
            System.out.println("DELETE AIRPORT");

            airport.setAirportCode(getAirportInput(scanner));

            airportDAO.deleteAirport(airport);
            conn.commit();

            System.out.println("The airport was successfully deleted.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The airport was not deleted.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public String getAirportInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the three letter airport code of the airport to be deleted: ");
        return scanner.nextLine();
    }
}
