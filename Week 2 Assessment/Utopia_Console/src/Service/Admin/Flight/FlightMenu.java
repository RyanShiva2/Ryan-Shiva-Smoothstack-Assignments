package Service.Admin.Flight;

import Service.Admin.AdminService;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class FlightMenu {

    public void displayFlightMenu() throws SQLException, ClassNotFoundException {
        AddFlight addFlight = new AddFlight();
        UpdateFlight updateFlight = new UpdateFlight();
        DeleteFlight deleteFlight = new DeleteFlight();
        ReadFlight readFlight = new ReadFlight();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN FLIGHT MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add a flight.", "Update a flight.", "Delete a flight.", "Get all flight information.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addFlight.addFlight();
                break;
            case 2:
                updateFlight.updateFlight();
                break;
            case 3:
                deleteFlight.deleteFlight();
                break;
            case 4:
                readFlight.readFlight();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
