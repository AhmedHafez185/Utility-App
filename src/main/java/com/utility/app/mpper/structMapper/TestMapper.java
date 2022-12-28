package com.utility.app.mpper.structMapper;

import com.utility.app._dtos.AdminDTO;
import com.utility.app._entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface TestMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO mapToDTO(Admin admin);
    Admin mapToEntity(AdminDTO adminDTO);
}
