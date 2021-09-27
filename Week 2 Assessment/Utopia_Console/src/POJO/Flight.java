package POJO;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {

    private Integer flightId;
    private Route route = new Route();
    private Airplane airplane = new Airplane();
    private LocalDateTime departureTime;
    private Integer reservedSeats;
    private Float seatPrice;
    private List<FlightBooking> flightBookings;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public List<FlightBooking> getFlightBookings() {
        return flightBookings;
    }

    public void setFlightBookings(List<FlightBooking> flightBookings) {
        this.flightBookings = flightBookings;
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightId + ", "
                + "Route ID: " + route.getRouteId() + ", "
                + "Airplane ID: " + airplane.getAirplaneId() + ", "
                + "Departure Time: " + departureTime.toString() + ", "
                + "Reserved Seats: " + reservedSeats + ", "
                + "Seat Price: " + seatPrice;
    }
}
