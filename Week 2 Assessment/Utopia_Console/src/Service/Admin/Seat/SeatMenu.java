package Service.Admin.Seat;

import Service.Admin.AdminService;
import Service.Admin.Seat.AddSeat;
import Service.Admin.Seat.DeleteSeat;
import Service.Admin.Seat.ReadSeat;
import Service.Admin.Seat.UpdateSeat;
import Service.ServiceUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class SeatMenu {

    public void displaySeatMenu() throws SQLException, ClassNotFoundException {
        AddSeat addSeat = new AddSeat();
        UpdateSeat updateSeat = new UpdateSeat();
        DeleteSeat deleteSeat = new DeleteSeat();
        ReadSeat readSeat = new ReadSeat();
        AdminService adminService = new AdminService();

        final String menuTitle = "ADMIN SEAT MENU";
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("Add an available seat to a flight.", "Update the number of seats and seat price of a flight.", "Delete a seat from a flight.", "Read the seat information of all flights.", "Quit to Previous."));

        System.out.println(menuTitle);
        System.out.println("");

        ServiceUtil serviceUtil = new ServiceUtil();
        switch (serviceUtil.displayMenu(menuOptions)) {
            case 1:
                addSeat.addSeat();
                break;
            case 2:
                updateSeat.updateSeat();
                break;
            case 3:
                deleteSeat.deleteSeat();
                break;
            case 4:
                readSeat.readSeat();
                break;
            case 5:
                adminService.displayAdminMainMenu();
                break;
        }
    }
}
