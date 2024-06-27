package cindyhj.com.flight_booking.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    @NotEmpty
    private String name;

    @Column(unique = true,nullable = false)
    @Size(max = 11)
    @NotEmpty
    private String cpf;

    @Column(nullable = false)
    @Size(min = 4, max = 12)
    @NotEmpty
    private char[] password;

    @OneToMany(mappedBy = "passenger")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<FlightTicket> flightTicket = new ArrayList<>();

}
