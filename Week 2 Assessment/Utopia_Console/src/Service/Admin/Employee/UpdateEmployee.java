package Service.Admin.Employee;

import DAO.UserDAO;
import POJO.User;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {
    public void updateEmployee() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        try {
            System.out.println("UPDATE EMPLOYEE");

            user.setUserId(getUserIdInput(scanner));
            user.getUserRole().setUserRoleId(2);
            user.setGivenName(getGivenNameInput(scanner));
            user.setFamilyName(getFamilyNameInput(scanner));
            user.setUsername(getUsernameInput(scanner));
            user.setEmail(getEmailInput(scanner));
            user.setPassword(getPasswordInput(scanner));
            user.setPhone(getPhoneInput(scanner));

            userDAO.updateUser(user);
            conn.commit();

            System.out.println("The employee was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The employee was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getUserIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the user ID of the employee to be updated: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getGivenNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee given name: ");
        return scanner.nextLine();
    }

    public String getFamilyNameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee family name: ");
        return scanner.nextLine();
    }
    public String getUsernameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee username: ");
        return scanner.nextLine();
    }
    public String getEmailInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee email: ");
        return scanner.nextLine();
    }
    public String getPasswordInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee password: ");
        return scanner.nextLine();
    }
    public String getPhoneInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the employee phone number: ");
        return scanner.nextLine();
    }
}
