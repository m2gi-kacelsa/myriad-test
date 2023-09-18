package com.myriad.app.service;

import com.myriad.app.service.dto.UserDTO;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.myriad.app.domain.User}.
 */
public interface UserService {

    /**
     * Save a user.
     *
     * @param userDTO the entity to save.
     * @return the persisted entity.
     */
    UserDTO save(UserDTO userDTO);

    /**
     * Get the "id" user.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserDTO> findOne(Long id);
}
