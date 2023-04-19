package unifligth.vuelos.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_date")
    private String departureDate;

    @Column(name = "departure_airport_code")
    private String departureAirportCode;

    @Column(name = "departure_airport_name")
    private String departureAirportName;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "departure_locale")
    private String departureLocale;

    @Column(name = "arrival_date")
    private String arrivalDate;

    @Column(name = "arrival_airport_code")
    private String arrivalAirportCode;

    @Column(name = "arrival_airport_name")
    private String arrivalAirportName;

    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "arrival_locale")
    private String arrivalLocale;

    @Column(name = "ticket_price")
    private Integer ticketPrice;

    @Column(name = "ticket_currency")
    private String ticketCurrency;

    @Column(name = "flight_number")
    private Integer flightNumber;

    @Column(name = "seat_capacity")
    private Integer seatCapacity;

    // getters and setters
}

