package Service.Admin.Seat;

import Service.Admin.AdminService;
import Service.Admin.Flight.UpdateFlight;
import Service.Admin.TicketAndPassenger.TicketAndPassengerMenu;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class SeatMenu {

    public void displaySeatMenu() throws SQLException, ClassNotFoundException {
        AdminService adminService = new AdminService();
        TicketAndPassengerMenu ticketAndPassengerMenu = new TicketAndPassengerMenu();
        UpdateFlight updateFlight = new UpdateFlight();

        final String menuTitle = "ADMIN SEAT MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Go to the Update Flight Menu to update the number of reserved seats in a flight.",
                "Got to the Ticket And Passenger Menu to Add, Update, Delete, or Get Information for Passengers.",
                "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                updateFlight.updateFlight();
                break;
            case 2:
                ticketAndPassengerMenu.displayTicketAndPassengerMenu();
                break;
            case 3:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
