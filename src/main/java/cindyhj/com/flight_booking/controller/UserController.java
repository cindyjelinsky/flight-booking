package cindyhj.com.flight_booking.controller;

import cindyhj.com.flight_booking.domain.model.User;
import cindyhj.com.flight_booking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
       var user = userService.findByiId(id);
       return ResponseEntity.ok(user);

    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userToCreate.getId()).toUri();
        return ResponseEntity.created(location).body(userToCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
       userService.update(id,user);
       return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}