package unifligth.vuelos.controladores;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unifligth.vuelos.Dto.FlightDto;
import unifligth.vuelos.entidades.Flight;
import unifligth.vuelos.Services.FlightService;
import unifligth.vuelos.Dto.FlightMapper;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @Autowired
    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flightMapper.toFlightDto(flight), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<FlightDto> flightDtos = flights.stream().map(flightMapper::toFlightDto).collect(Collectors.toList());
        return new ResponseEntity<>(flightDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        Flight flight = flightMapper.toFlight(flightDto);
        Flight createdFlight = flightService.saveFlight(flight);
        FlightDto createdFlightDto = flightMapper.toFlightDto(createdFlight);
        return new ResponseEntity<>(createdFlightDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        Flight flightToUpdate = flightService.getFlightById(id);
        if (flightToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Flight flight = flightMapper.toFlight(flightDto);
        flight.setId(id);
        Flight updatedFlight = flightService.saveFlight(flight);
        FlightDto updatedFlightDto = flightMapper.toFlightDto(updatedFlight);
        return new ResponseEntity<>(updatedFlightDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flightService.deleteFlightById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
