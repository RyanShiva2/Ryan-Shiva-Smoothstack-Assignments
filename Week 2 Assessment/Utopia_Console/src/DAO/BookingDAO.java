package DAO;

import POJO.Booking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends BaseDAO<Booking> {

    public BookingDAO(Connection conn) {
        super(conn);
    }

    public void addBooking(Booking booking) throws SQLException {
        save("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
                new Object[]{booking.getActive(),
                        booking.getConfirmationCode()});
    }

    public void updateBooking(Booking booking) throws SQLException {
        save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?",
                new Object[]{booking.getActive(),
                        booking.getConfirmationCode(),
                        booking.getBookingId()});
    }

    public void deleteBooking(Booking booking) throws SQLException {
        save("DELETE FROM booking WHERE id = ?",
                new Object[]{booking.getBookingId()});
    }

    public List<Booking> readBookings() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM booking", null);
    }

    @Override
    protected List<Booking> extractData(ResultSet rs) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (rs.next()) {
            Booking booking = new Booking();
            booking.setBookingId(rs.getInt("id"));
            booking.setActive(rs.getInt("is_active"));
            booking.setConfirmationCode(rs.getString("confirmation_code"));
            bookings.add(booking);
        }
        return bookings;
    }
}