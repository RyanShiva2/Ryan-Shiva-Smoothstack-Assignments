package Service.Admin.Traveler;

import DAO.UserDAO;
import POJO.User;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadTraveler {

    public void readTraveler() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);

        ArrayList<User> travelers = new ArrayList<>();
        for (User userInDB : userDAO.readUsers()) {
            if (userInDB.getUserRole().getUserRoleId() == 1) {
                travelers.add(userInDB);
            }
        }

        try {
            System.out.println("LIST OF TRAVELERS");

            printTravelers(travelers);

            System.out.println("The travelers were successfully read.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The travelers were not read.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public void printTravelers(ArrayList<User> travelers) {
        for (User traveler : travelers) {
            System.out.println(traveler.toString());
        }
    }
}