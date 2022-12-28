package com.utility.app.mpper.modelMapper;

import com.utility.app._dtos.AdminDTO;
import com.utility.app._entity.Admin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapperUtils {
    @Autowired
    ModelMapper modelMapper;

    public AdminDTO mapToDTO(Admin admin){
        AdminDTO adminDTO = modelMapper.map(admin, AdminDTO.class);
        return adminDTO;
    }
    public Admin mapToEntity(AdminDTO adminDTO){
        Admin admin = modelMapper.map(adminDTO,Admin.class);
        return admin;
    }
}
