package Service.Admin.Traveler;

import Service.Admin.AdminService;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TravelerMenu {
    public void displayTravelerMenu() throws SQLException, ClassNotFoundException {
        AddTraveler addTraveler = new AddTraveler();
        UpdateTraveler updateTraveler = new UpdateTraveler();
        DeleteTraveler deleteTraveler = new DeleteTraveler();
        ReadTraveler readTraveler = new ReadTraveler();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN TRAVELER MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add a traveler.", "Update a traveler.", "Delete a traveler.", "Get all traveler information.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addTraveler.addTraveler();
                break;
            case 2:
                updateTraveler.updateTraveler();
                break;
            case 3:
                deleteTraveler.deleteTraveler();
                break;
            case 4:
                readTraveler.readTraveler();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
