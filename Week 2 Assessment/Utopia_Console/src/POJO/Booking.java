package POJO;

import java.util.List;

public class Booking {

    private Integer bookingId;
    private Boolean isActive;
    private String confirmationCode;
    private List<FlightBooking> flightBookings;
    private List<Passenger> passengers;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public List<FlightBooking> getFlightBookings() {
        return flightBookings;
    }

    public void setFlightBookings(List<FlightBooking> flightBookings) {
        this.flightBookings = flightBookings;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
