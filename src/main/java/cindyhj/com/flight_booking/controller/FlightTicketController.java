package cindyhj.com.flight_booking.controller;

import cindyhj.com.flight_booking.domain.model.FlightTicket;
import cindyhj.com.flight_booking.service.FlightTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class FlightTicketController {

    private final FlightTicketService flightTicketService;


    public FlightTicketController(FlightTicketService flightTicketService) {
        this.flightTicketService = flightTicketService;
    }

    @GetMapping("/passenger/{userId}")
    public ResponseEntity<List<FlightTicket>> findAllByUser(@PathVariable Long userId) {
        List<FlightTicket> tickets = this.flightTicketService.findAllByPassenger(userId);
        return ResponseEntity.ok().body(tickets);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FlightTicket> findById(@PathVariable Long id){
        var ticket = flightTicketService.findById(id);
        return ResponseEntity.ok(ticket);

    }

    @PostMapping
    public ResponseEntity<FlightTicket> create(@RequestBody FlightTicket ticketToIssue){
        flightTicketService.create(ticketToIssue);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(ticketToIssue.getId()).toUri();
        return ResponseEntity.created(location).body(ticketToIssue);
    }
}
