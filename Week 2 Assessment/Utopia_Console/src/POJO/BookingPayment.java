package POJO;

public class BookingPayment {

    private Booking booking = new Booking();
    private String stripeId;
    private Boolean refunded;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }
}
