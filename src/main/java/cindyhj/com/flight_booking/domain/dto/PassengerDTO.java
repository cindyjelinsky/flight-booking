package cindyhj.com.flight_booking.domain.dto;

import cindyhj.com.flight_booking.domain.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassengerDTO {

    private Long id;
    private String name;
    private String cpf;


    public PassengerDTO(Passenger passenger) {
           this.id = passenger.getId();
            this.name = passenger.getName();
            this.cpf = passenger.getCpf();
    }




  }
