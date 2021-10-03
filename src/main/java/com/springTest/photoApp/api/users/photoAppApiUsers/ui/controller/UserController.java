package com.springTest.photoApp.api.users.photoAppApiUsers.ui.controllers;

import com.netflix.discovery.converters.Auto;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.models.CreateUserRequestModel;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.models.CreateUserResponseModel;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.models.UserDto;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.service.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping(path="/status/check")
    public String status(){
        return "working on port"+ env.getProperty("local.server.host");
    }

    @PostMapping()
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser=usersService.createuser(userDto);
        CreateUserResponseModel responseModel = modelMapper.map(createdUser, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel) ;
    }
}
