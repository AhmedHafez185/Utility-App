package com.utility.app.mpper.structMapper;

import com.utility.app._dtos.AdminDTO;
import com.utility.app._entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
//   @Mappings({
//       @Mapping(source="x",target = "y")
//    })
    AdminDTO mapToDTO(Admin admin);
    Admin mapToEntity(AdminDTO adminDTO);
}
