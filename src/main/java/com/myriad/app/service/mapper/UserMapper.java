package com.myriad.app.service.mapper;

import com.myriad.app.domain.User;
import com.myriad.app.service.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link com.myriad.app.domain.User} and its DTO {@link com.myriad.app.service.dto.UserDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {

    default User fromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
