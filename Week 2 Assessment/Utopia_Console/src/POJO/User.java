package POJO;

import java.util.List;

public class User {

    private Integer userId;
    private UserRole userRole = new UserRole();
    private String givenName;
    private String familyName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private List<BookingAgent> bookingAgents;
    private List<BookingUser> bookingUsers;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookingAgent> getBookingAgents() {
        return bookingAgents;
    }

    public void setBookingAgents(List<BookingAgent> bookingAgents) {
        this.bookingAgents = bookingAgents;
    }

    public List<BookingUser> getBookingUsers() {
        return bookingUsers;
    }

    public void setBookingUsers(List<BookingUser> bookingUsers) {
        this.bookingUsers = bookingUsers;
    }
}
