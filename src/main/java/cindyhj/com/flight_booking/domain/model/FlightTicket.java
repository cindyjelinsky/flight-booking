package cindyhj.com.flight_booking.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="tb_ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private Date issuedDate;
    private Date flightDate;


    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;



}
