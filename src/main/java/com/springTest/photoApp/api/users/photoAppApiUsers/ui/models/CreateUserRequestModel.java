package com.springTest.photoApp.api.users.photoAppApiUsers.ui.models;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter@Setter
@ToString
public class CreateUserRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min=2, message = "First name should not be less than two characters")
    private String firstName;

    @NotNull(message = "last Name cannot be null")
    @Size(min=2, message = "Last name should not be less than two characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;


}
