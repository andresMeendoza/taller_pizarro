package unifligth.vuelos.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unifligth.vuelos.entidades.Booking;
import unifligth.vuelos.Repository.BookingRepository;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        // lógica para crear una reserva
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        // lógica para obtener una reserva por ID
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        // lógica para obtener todas las reservas
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        // lógica para actualizar una reserva
        Booking existingBooking = bookingRepository.findById(booking.getId()).orElse(null);
        if (existingBooking == null) {
            return null;
        }
        existingBooking.setStatus(booking.getStatus());
        existingBooking.setOutboundFlight(booking.getOutboundFlight());
        existingBooking.setPaymentToken(booking.getPaymentToken());
        existingBooking.setCheckedIn(booking.getCheckedIn());
        existingBooking.setCustomer(booking.getCustomer());
        existingBooking.setCreatedAt(booking.getCreatedAt());
        existingBooking.setBookingReference(booking.getBookingReference());
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBookingById(Long id) {
        // lógica para eliminar una reserva por ID
        bookingRepository.deleteById(id);
    }
}
