package adapter;

import constants.Endpoints;
import model.Booking;
import model.BookingPartialData;
import org.apache.http.HttpStatus;

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

    public String getEmptyById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return get(HttpStatus.SC_NOT_FOUND)
                .extract()
                .body()
                .asPrettyString();
    }

    public Booking updateBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return put(new Booking())
                .extract()
                .body()
                .as(Booking.class);
    }

    public Booking partialUpdateBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        return patch(new BookingPartialData())
                .extract()
                .body()
                .as(Booking.class);
    }

    public void deleteBookingById(int id) {
        setEndpoint(String.format(Endpoints.BOOKING_ID_URN_PATTERN, id));
        delete();
    }
}
