package POJO;

import java.time.LocalDate;

public class Passenger {

    private Integer passengerId;
    private Booking booking = new Booking();
    private String givenName;
    private String familyName;
    private LocalDate dob;
    private String gender;
    private String address;

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + ", "
                + "Passenger ID: " + booking.getBookingId() + ", "
                + "Given Name: " + givenName + ", "
                + "Family Name: " + familyName + ", "
                + "Date of Birth: " + dob + ", "
                + "Gender: " + gender + ", "
                + "Address: " + address;
    }
}
