package Service.Admin.OverrideTripCancellation;

import DAO.BookingDAO;
import POJO.Booking;
import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class OverrideTripCancellationMenu {

    public void displayOverrideTripCancellationMenu() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        Scanner scanner = new Scanner(System.in);

        AdminService adminService = new AdminService();
        BookingDAO bookingDAO = new BookingDAO(conn);

        Booking booking = new Booking();

        try {
            System.out.println("OVERRIDE TRIP CANCELLATION");

            booking.setBookingId(getBookingIdInput(scanner));
            booking.setActive(getIsActiveInput(scanner));

            System.out.println("h");
            for (Booking bookingInDb : bookingDAO.readBookings()) {
                if (bookingInDb.getBookingId().equals(booking.getBookingId())) {
                    booking.setConfirmationCode(bookingInDb.getConfirmationCode());
                    break;
                }
            }

            bookingDAO.updateBooking(booking);
            conn.commit();

            if (booking.getActive() == 0) {
                System.out.println("The booking was successfully cancelled.");
            } else {
                System.out.println("The booking was successfully activated.");
            }

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The booking was not cancelled/activated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Integer getBookingIdInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter the booking ID of the booking to be cancelled or activated: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Integer getIsActiveInput(Scanner scanner) {
        System.out.println();
        System.out.print("Enter 1 to activate the booking and 0 to cancel the booking: ");
        return Integer.parseInt(scanner.nextLine());
    }
}