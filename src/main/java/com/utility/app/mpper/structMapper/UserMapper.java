package com.utility.app.mpper.structMapper;

import com.utility.app._dtos.UserDTO;
import com.utility.app._entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToDTO(UserDTO userDTO);
}
