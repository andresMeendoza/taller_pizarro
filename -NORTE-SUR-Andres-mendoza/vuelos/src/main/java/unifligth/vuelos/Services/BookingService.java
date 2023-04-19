package unifligth.vuelos.Services;
import java.util.List;

import unifligth.vuelos.entidades.Booking;
public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Booking booking);
    void deleteBookingById(Long id);
}
