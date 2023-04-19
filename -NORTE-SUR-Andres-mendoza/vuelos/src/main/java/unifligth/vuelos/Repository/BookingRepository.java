package unifligth.vuelos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifligth.vuelos.entidades.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
