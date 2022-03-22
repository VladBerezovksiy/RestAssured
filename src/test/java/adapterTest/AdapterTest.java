package adapterTest;

import model.Booking;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdapterTest extends BaseTest {

    @Test
    public void getTokenTest() {
        assertThat(http.auth.getToken(), allOf(notNullValue(), hasLength(15)));
    }

    @Test
    public void getBookingsTest() {
        assertThat(http.booking.getBookingsId(), notNullValue());
    }

    @Test
    public void getBookingIdTest() {
        assertThat(http.bookingId.getBookingById(6), notNullValue());
    }

    @Test
    public void createBookingTest() {
        int bookingID = http.booking.createBooking(new Booking());
        assertThat(bookingID, greaterThan(10));
        Booking actualBooking = http.bookingId.getBookingById(bookingID);
        assertThat(actualBooking, equalTo(new Booking()));
    }

    @Test
    public void updateBookingIdTest() {
        Booking expectedBooking = http.bookingId.updateBookingById(6);
        Booking actualBooking = http.bookingId.getBookingById(6);
        assertThat(expectedBooking, equalTo(actualBooking));
    }

    @Test
    public void partialUpdateBookingIdTest() {
        Booking expectedBooking = http.bookingId.partialUpdateBookingById(7);
        Booking actualBooking = http.bookingId.getBookingById(7);
        assertThat(expectedBooking, equalTo(actualBooking));
    }

    @Test
    public void deleteBookingTest() {
        http.bookingId.deleteBookingById(5);
    }
}
