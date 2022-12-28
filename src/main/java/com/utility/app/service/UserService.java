package com.utility.app.service;

import com.utility.app._dtos.AdminDTO;
import com.utility.app._dtos.UserDTO;
import com.utility.app._entity.Product;
import com.utility.app._entity.User;
import com.utility.app.mpper.structMapper.UserMapper;
import com.utility.app.threads.SecurityContext;
import com.utility.app.threads.TheUserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserMapper userMapper;

    public UserDTO save(UserDTO userDTO) throws Exception {
        if (userDTO.getUserId() == 1) {
            throw new Exception("Testing exception user id = = 1");
        }
        User user = modelMapper.map(userDTO, User.class);

        User user2 = userMapper.mapToDTO(userDTO);
//        System.out.println("you are in the save user service , username : " + username);
        return userDTO;
    }
}
