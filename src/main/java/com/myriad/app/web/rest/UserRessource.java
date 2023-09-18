package com.myriad.app.web.rest;

import com.myriad.app.service.UserService;
import com.myriad.app.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;

/**
 * REST controller for managing {@link com.myriad.app.domain.User}.
 */

@RestController
@RequestMapping("/api/user")
public class UserRessource {

    private final Logger log = LoggerFactory.getLogger(UserRessource.class);
    private final UserService userService;

    public UserRessource(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register a new User
     *
     * @param UserDTO the userDTO to create.
     * @return the  ResponseEntity with status  201 (Created) and with body of the new userDTO,
     * or with status  400 (Bad request) if the user enter invalid data : age & country of birth
     */
    @PostMapping("/sign-in")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) throws Exception {
        log.debug("REST request to register a User : {}", userDTO);

        int age = Period.between(userDTO.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();

        if (!(age > 18 && userDTO.getCountryOfResidence().equals("France"))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserDTO result = userService.save(userDTO);
        return ResponseEntity.created(new URI("/api/user/" + result.getId())).body(result);
    }

    /**
     * Get User Details
     *
     * @param id the id of the userDTO to retrieve.
     * @return the ResponseEntity with status  200 (OK) and with body the userDTO,
     * or with status  404 (Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        log.debug("REST request to get Flux : {}", id);
        Optional<UserDTO> userDTO = userService.findOne(id);
        if (!userDTO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDTO.get());
    }

}
