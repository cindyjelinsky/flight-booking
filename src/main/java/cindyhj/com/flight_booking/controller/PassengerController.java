package cindyhj.com.flight_booking.controller;

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
    public ResponseEntity<Passenger> findById(@PathVariable Long id){
       var passenger = passengerService.findById(id);
       return ResponseEntity.ok(passenger);

    }

    @PostMapping
    public ResponseEntity<Passenger> create(@RequestBody Passenger passengerToCreate){
        passengerService.create(passengerToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(passengerToCreate.getId()).toUri();
        return ResponseEntity.created(location).body(passengerToCreate);
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
