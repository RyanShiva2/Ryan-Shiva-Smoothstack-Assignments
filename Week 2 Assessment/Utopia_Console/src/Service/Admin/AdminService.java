package Service.Admin;

import Service.Admin.Airport.AirportMenu;
import Service.Admin.Flight.FlightMenu;
import Service.Admin.OverrideTripCancellation.OverrideTripCancellationMenu;
import Service.Admin.Seat.SeatMenu;
import Service.Admin.Traveler.TravelerMenu;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminService {

    public AdminService() throws SQLException, ClassNotFoundException {
    }

    public void displayAdminMainMenu() throws SQLException, ClassNotFoundException {
        ServiceUtil serviceUtil = new ServiceUtil();
        FlightMenu flightMenu = new FlightMenu();
        AirportMenu airportMenu = new AirportMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        OverrideTripCancellationMenu overrideTripCancellationMenu = new OverrideTripCancellationMenu();
        SeatMenu seatMenu = new SeatMenu();
        TicketAndPassengerMenu ticketAndPassengerMenu = new TicketAndPassengerMenu();
        TravelerMenu travelerMenu = new TravelerMenu();

        final String menuTitle = "ADMIN MAIN MENU";
        final ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Flights", "Seats", "Tickets and Passengers", "Airports", "Travelers", "Employees", "Override a Trip Cancellation", "Quit Program"));

        System.out.println();
        System.out.println(menuTitle);
        System.out.println();

        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                flightMenu.displayFlightMenu();
                break;
            case 2:
                seatMenu.displaySeatMenu();
                break;
            case 3:
                ticketAndPassengerMenu.displayTicketAndPassengerMenu();
                break;
            case 4:
                airportMenu.displayAirportMenu();
                break;
            case 5:
                travelerMenu.displayTravelerMenu();
                break;
            case 6:
                employeeMenu.displayEmployeeMenu();
                break;
            case 7:
                overrideTripCancellationMenu.displayOverrideTripCancellationMenu();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
}
