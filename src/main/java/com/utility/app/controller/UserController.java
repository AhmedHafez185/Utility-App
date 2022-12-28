package com.utility.app.controller;

import com.utility.app._dtos.UserDTO;
import com.utility.app._entity.User;
import com.utility.app.jobs.payload.EmailRequest;
import com.utility.app.jobs.payload.EmailResponse;
import com.utility.app.jobs.service.EmailScheduleService;
import com.utility.app.service.UserService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) throws Exception {
        userService.save(userDTO);
        return new ResponseEntity(userDTO, HttpStatus.ACCEPTED);
    }
}
