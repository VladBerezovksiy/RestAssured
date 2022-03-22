package adapter;

import constants.Endpoints;
import model.Booking;

public class BookingIdAdapter extends BaseAdapter {

    public BookingIdAdapter() {
        super(Endpoints.BOOKING_ID_URN_PATTERN);
    }

    public Booking getBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return get()
                .log().body()
                .extract()
                .body()
                .as(Booking.class);
    }

    public Booking updateBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return put(new Booking())
                //.cookie(token)
                .log().body()
                .extract()
                .body()
                .as(Booking.class);
    }

    public Booking partialUpdateBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return patch(Booking.builder().firstname("Lol").lastname("Rm").build())
                //.cookie(token)
                .log().body()
                .extract()
                .body()
                .as(Booking.class);
    }

    public void deleteBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        delete();
                //.cookie(token);
    }
}
