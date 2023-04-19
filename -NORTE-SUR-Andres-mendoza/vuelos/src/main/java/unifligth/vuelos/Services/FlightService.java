package unifligth.vuelos.Services;

import java.util.List;

import unifligth.vuelos.entidades.Flight;

public interface FlightService {
    Flight getFlightById(Long id);
    List<Flight> getAllFlights();
    Flight saveFlight(Flight flight);
    void deleteFlightById(Long id);
}