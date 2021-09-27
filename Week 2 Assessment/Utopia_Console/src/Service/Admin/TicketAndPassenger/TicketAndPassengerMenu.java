package Service.Admin.TicketAndPassenger;

import Service.Admin.AdminService;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TicketAndPassengerMenu {
    
    public void displayTicketAndPassengerMenu() throws SQLException, ClassNotFoundException {
        AddPassenger addPassenger = new AddPassenger();
        UpdatePassenger updatePassenger = new UpdatePassenger();
        DeletePassenger deletePassenger = new DeletePassenger();
        ReadPassenger readPassenger = new ReadPassenger();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN PASSENGER MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add a passenger.", "Update a passenger.", "Delete a passenger.", "Get all passenger information.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addPassenger.addPassenger();
                break;
            case 2:
                updatePassenger.updatePassenger();
                break;
            case 3:
                deletePassenger.deletePassenger();
                break;
            case 4:
                readPassenger.readPassenger();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
