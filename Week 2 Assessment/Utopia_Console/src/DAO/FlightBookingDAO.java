package DAO;

import POJO.FlightBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingDAO extends BaseDAO<FlightBooking> {

    public FlightBookingDAO(Connection conn) {
        super(conn);
    }

    public void addFlightBooking(FlightBooking flightBooking) throws SQLException {
        save("INSERT INTO flight_bookings (flight_id, booking_id) VALUES (?, ?)",
                new Object[]{flightBooking.getFlight().getFlightId(),
                        flightBooking.getBooking().getBookingId()});
    }

    public void deleteFlightBooking(FlightBooking flightBooking) throws SQLException {
        save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?",
                new Object[]{flightBooking.getFlight().getFlightId(),
                flightBooking.getBooking().getBookingId()});
    }

    public List<FlightBooking> readFlightBookings() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM flight_bookings", null);
    }

    @Override
    protected List<FlightBooking> extractData(ResultSet rs) throws SQLException {
        List<FlightBooking> flightBookings = new ArrayList<>();
        while (rs.next()) {
            FlightBooking flightBooking = new FlightBooking();
            flightBooking.getFlight().setFlightId(rs.getInt("flight_id"));
            flightBooking.getBooking().setBookingId(rs.getInt("booking_id"));
            flightBookings.add(flightBooking);
        }
        return flightBookings;
    }
}