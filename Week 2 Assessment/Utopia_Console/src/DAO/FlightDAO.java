package DAO;

import POJO.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends BaseDAO<Flight> {

    public FlightDAO(Connection conn) {
        super(conn);
    }

    public void addFlight(Flight flight) throws SQLException {
        save("INSERT INTO flight (id, route_id, airplane_id, departure_time, "
                        + "reserved_seats, seat_price) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                new Object[]{flight.getFlightId(),
                        flight.getRoute().getRouteId(),
                        flight.getAirplane().getAirplaneId(),
                        flight.getDepartureTime(),
                        flight.getReservedSeats(),
                        flight.getSeatPrice()});
    }

    public void updateFlight(Flight flight) throws SQLException {
        save("UPDATE flight "
                        + "SET route_id = ?, airplane_id = ?, departure_time = ?, "
                        + "reserved_seats = ?, seat_price = ? "
                        + "WHERE id = ?",
                new Object[]{flight.getRoute().getRouteId(),
                        flight.getAirplane().getAirplaneId(),
                        flight.getDepartureTime(),
                        flight.getReservedSeats(),
                        flight.getSeatPrice(),
                        flight.getFlightId()});
    }

    public void deleteFlight(Flight flight) throws SQLException {
        save("DELETE FROM flight WHERE id = ?",
                new Object[]{flight.getFlightId()});
    }

    public List<Flight> readFlights() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM flight", null);
    }

    @Override
    protected List<Flight> extractData(ResultSet rs) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        while (rs.next()) {
            Flight flight = new Flight();
            flight.setFlightId(rs.getInt("id"));
            flight.getRoute().setRouteId(rs.getInt("route_id"));
            flight.getAirplane().setAirplaneId(rs.getInt("airplane_id"));
            flight.setDepartureTime(rs.getTimestamp("departure_time").toLocalDateTime());
            flight.setReservedSeats(rs.getInt("reserved_seats"));
            flight.setSeatPrice(rs.getFloat("seat_price"));
            flights.add(flight);
        }
        return flights;
    }
}