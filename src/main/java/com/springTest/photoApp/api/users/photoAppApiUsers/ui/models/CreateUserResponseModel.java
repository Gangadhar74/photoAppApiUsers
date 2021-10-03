package com.springTest.photoApp.api.users.photoAppApiUsers.ui.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class CreateUserResponseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
