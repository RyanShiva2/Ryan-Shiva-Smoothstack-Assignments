package Service.Admin.Traveler;

import DAO.UserDAO;
import POJO.User;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTraveler {

    public void updateTraveler() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        try {
            System.out.println("UPDATE TRAVELER");

            user.setUserId(getUserIdInput(scanner));
            user.getUserRole().setUserRoleId(1);
            user.setGivenName(getGivenNameInput(scanner));
            user.setFamilyName(getFamilyNameInput(scanner));
            user.setUsername(getUsernameInput(scanner));
            user.setEmail(getEmailInput(scanner));
            user.setPassword(getPasswordInput(scanner));
            user.setPhone(getPhoneInput(scanner));

            userDAO.updateUser(user);
            conn.commit();

            System.out.println("The traveler was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The traveler was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getUserIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the user ID of the traveler to be updated: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getGivenNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler given name: ");
        return scanner.nextLine();
    }

    public String getFamilyNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler family name: ");
        return scanner.nextLine();
    }
    public String getUsernameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler username: ");
        return scanner.nextLine();
    }
    public String getEmailInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler email: ");
        return scanner.nextLine();
    }
    public String getPasswordInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler password: ");
        return scanner.nextLine();
    }
    public String getPhoneInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the traveler phone number: ");
        return scanner.nextLine();
    }
}
