package Service.Admin.Airport;

import Service.Admin.AdminService;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AirportMenu {

    public void displayAirportMenu() throws SQLException, ClassNotFoundException {
        AddAirport addAirport = new AddAirport();
        UpdateAirport updateAirport = new UpdateAirport();
        DeleteAirport deleteAirport = new DeleteAirport();
        ReadAirport readAirport = new ReadAirport();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN AIRPORT MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add an airport.", "Update an airport.", "Delete an airport.", "Get all airport information.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addAirport.addAirport();
                break;
            case 2:
                updateAirport.updateAirport();
                break;
            case 3:
                deleteAirport.deleteAirport();
                break;
            case 4:
                readAirport.readAirport();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
