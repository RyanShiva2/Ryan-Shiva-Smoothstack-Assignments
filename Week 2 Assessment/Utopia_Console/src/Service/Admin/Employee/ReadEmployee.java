package Service.Admin.Employee;

import DAO.UserDAO;
import POJO.User;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadEmployee {
    public void readEmployee() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();
        UserDAO userDAO = new UserDAO(conn);

        ArrayList<User> employees = new ArrayList<>();
        for (User userInDB : userDAO.readUsers()) {
            if (userInDB.getUserRole().getUserRoleId() == 2) {
                employees.add(userInDB);
            }
        }

        try {
            System.out.println("LIST OF EMPLOYEES");

            printEmployees(employees);

            System.out.println("The employees were successfully read.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The employees were not read.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public void printEmployees(ArrayList<User> employees) {
        for (User employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
