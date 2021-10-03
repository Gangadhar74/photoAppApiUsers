package com.springTest.photoApp.api.users.photoAppApiUsers.ui.service;

import com.springTest.photoApp.api.users.photoAppApiUsers.ui.data.UserEntity;
import com.springTest.photoApp.api.users.photoAppApiUsers.ui.models.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface UsersService {

    UserDto createuser(UserDto userDetails);
}
