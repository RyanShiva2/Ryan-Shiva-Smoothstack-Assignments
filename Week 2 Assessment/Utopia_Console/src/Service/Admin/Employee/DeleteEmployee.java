package Service.Admin.Employee;

import DAO.UserDAO;
import POJO.User;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
    public void deleteEmployee() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        try {
            System.out.println("DELETE EMPLOYEE");

            user.setUserId(getUserIdInput(scanner));

            userDAO.deleteUser(user);
            conn.commit();

            System.out.println("The employee was successfully deleted.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The employee was not deleted.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getUserIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the user ID of the employee to be deleted: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

