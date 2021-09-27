package DAO;

import POJO.Passenger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO extends BaseDAO<Passenger> {

    public PassengerDAO(Connection conn) {
        super(conn);
    }

    public void addPassenger(Passenger passenger) throws SQLException {
        save("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                new Object[]{passenger.getBooking().getBookingId(),
                        passenger.getGivenName(),
                        passenger.getFamilyName(),
                        passenger.getDob(),
                        passenger.getGender(),
                        passenger.getAddress()});
    }

    public void updatePassenger(Passenger passenger) throws SQLException {
        save("UPDATE passenger SET booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
                new Object[]{passenger.getBooking().getBookingId(),
                        passenger.getGivenName(),
                        passenger.getFamilyName(),
                        passenger.getDob(),
                        passenger.getGender(),
                        passenger.getAddress(),
                        passenger.getPassengerId()});
    }

    public void deletePassenger(Passenger passenger) throws SQLException {
        save("DELETE FROM passenger WHERE id = ?",
                new Object[]{passenger.getPassengerId()});
    }

    public List<Passenger> readPassengers() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM passenger", null);
    }

    @Override
    protected List<Passenger> extractData(ResultSet rs) throws SQLException {
        List<Passenger> passengers = new ArrayList<>();
        while (rs.next()) {
            Passenger passenger = new Passenger();
            passenger.setPassengerId(rs.getInt("id"));
            passenger.getBooking().setBookingId(rs.getInt("booking_id"));
            passenger.setGivenName(rs.getString("given_name"));
            passenger.setFamilyName(rs.getString("family_name"));
            passenger.setDob(rs.getDate("dob").toLocalDate());
            passenger.setGender(rs.getString("gender"));
            passenger.setAddress(rs.getString("address"));
            passengers.add(passenger);
        }
        return passengers;
    }
}