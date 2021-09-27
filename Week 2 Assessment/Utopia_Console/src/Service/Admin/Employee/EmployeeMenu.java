package Service.Admin.Employee;

import Service.Admin.AdminService;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeMenu {
    public void displayEmployeeMenu() throws SQLException, ClassNotFoundException {
        AddEmployee addEmployee = new AddEmployee();
        UpdateEmployee updateEmployee = new UpdateEmployee();
        DeleteEmployee deleteEmployee = new DeleteEmployee();
        ReadEmployee readEmployee = new ReadEmployee();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN EMPLOYEE MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add an employee.", "Update an employee.", "Delete an employee.", "Get all employee information.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addEmployee.addEmployee();
                break;
            case 2:
                updateEmployee.updateEmployee();
                break;
            case 3:
                deleteEmployee.deleteEmployee();
                break;
            case 4:
                readEmployee.readEmployee();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
