package com.myriad.app.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myriad.app.domain.enumeration.Gender;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.myriad.app.domain.User} entity.
 */
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String countryOfResidence;

    private Gender gender;

    private String phoneNumber;

}
