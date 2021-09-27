package Service;

import Service.Admin.AdminLogin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class WelcomeMenu {
    public void displayWelcomeMenu() throws SQLException, ClassNotFoundException {
        ServiceUtil serviceUtil = new ServiceUtil();
        AdminLogin adminLogin = new AdminLogin();

        final String menuTitle = "UTOPIA AIRLINE CONSOLE APPLICATION WELCOME MENU";
        final ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Employee/Agent", "Administrator", "Traveler", "Quit Program"));

        System.out.println();
        System.out.println(menuTitle);
        System.out.println();
        System.out.println("Which category of a user are you?");
        System.out.println();

        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                System.out.println("Employee/Agent Login does not exist.");
                System.exit(0);
                break;
            case 2:
                adminLogin.adminLogin();
                break;
            case 3:
                System.out.println("Traveler Login does not exist.");
                System.exit(0);
            case 4:
                System.exit(0);
                break;
        }
    }
}
