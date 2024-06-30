package cindyhj.com.flight_booking.controller;

import cindyhj.com.flight_booking.domain.dto.PassengerDTO;
import cindyhj.com.flight_booking.domain.dto.PassengerResponse;
import cindyhj.com.flight_booking.domain.model.Passenger;
import cindyhj.com.flight_booking.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/passenger")
public class PassengerController {


    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @GetMapping("/passenger/{id}")
    public ResponseEntity<PassengerResponse> findById(@PathVariable Long id){
      Passenger passenger = passengerService.findById(id);
      return ResponseEntity.ok(passengerService.toDTO(passenger));

    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PassengerDTO passengerDTO){
        Passenger passenger  = passengerService.fromDTO(passengerDTO);
        passengerService.create(passenger);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(passengerDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passenger> update(@RequestBody Passenger passenger, @PathVariable Long id){
        passenger.setId(id);
        this.passengerService.update(passenger);
        return ResponseEntity.ok(passenger);

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passengerService.delete(id);

    }
}
