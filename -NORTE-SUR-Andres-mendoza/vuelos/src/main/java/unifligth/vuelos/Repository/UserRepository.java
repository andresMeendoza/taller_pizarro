package unifligth.vuelos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifligth.vuelos.entidades.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}