package com.springTest.photoApp.api.users.photoAppApiUsers.ui.service;


import com.springTest.photoApp.api.users.photoAppApiUsers.ui.data.UserEntity;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.models.UserDto;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsersServiceImpl implements UsersService{


    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createuser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails,UserEntity.class);
        userEntity.setEncryptedPassword("test");
         usersRepository.save(userEntity);
         UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
        return returnValue;

    }
}
