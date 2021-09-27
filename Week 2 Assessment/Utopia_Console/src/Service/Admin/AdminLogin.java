package Service.Admin;

import DAO.UserDAO;
import POJO.User;
import Service.ConnectionUtil;
import Service.WelcomeMenu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin {
    public void adminLogin() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);
        WelcomeMenu welcomeMenu = new WelcomeMenu();

        Scanner scanner = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>(userDAO.readUsers());

        User user = new User();

        try {
            System.out.println("ADMIN LOGIN");
            System.out.println();

            user.setUsername(getUsernameInput(scanner));
            user.setPassword(getPasswordInput(scanner));

            Boolean validAdmin = false;
            for (User userInDb : users) {
                if (userInDb.getUserRole().getUserRoleId() == 3) {
                    if (user.getUsername().equals(userInDb.getUsername())
                    && user.getPassword().equals(userInDb.getPassword())) {
                        validAdmin = true;
                        break;
                    }
                }
            }

            if (validAdmin) {
                System.out.println("The admin login was successful.");
                adminService.displayAdminMainMenu();
            } else {
                System.out.println("The admin login was not successful.");
                welcomeMenu.displayWelcomeMenu();
            }
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The admin login was not successful.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            welcomeMenu.displayWelcomeMenu();
        }
    }

    public String getUsernameInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String getPasswordInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }
}