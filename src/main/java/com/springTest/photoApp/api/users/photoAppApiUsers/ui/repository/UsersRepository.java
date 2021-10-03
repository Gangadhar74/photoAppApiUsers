package com.springTest.photoApp.api.users.photoAppApiUsers.ui.repository;

import com.springTest.photoApp.api.users.photoAppApiUsers.ui.data.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {



}
