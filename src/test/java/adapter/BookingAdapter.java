package adapter;

import constants.Endpoints;
import model.Booking;

public class BookingAdapter extends BaseAdapter {

    private static final String BOOKING_ID_PATH = "bookingid";

    public BookingAdapter() {
        super(Endpoints.BOOKING_URN);
    }

    public String getBookingsId() {
        return get()
                .log().body()
                .extract()
                .body().jsonPath().get().toString();
    }

    public int createBooking(Booking booking) {
        return post(booking)
                .log().body()
                .extract()
                .path(BOOKING_ID_PATH);
    }
}
