package cindyhj.com.flight_booking.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @Size(max = 11)
    private String cpf;

    @Column(nullable = false)
    @Size(min = 4, max = 12)
    private char[] password;

    //@OneToMany
    //private List<FlightTicket> flightTicket;

}
