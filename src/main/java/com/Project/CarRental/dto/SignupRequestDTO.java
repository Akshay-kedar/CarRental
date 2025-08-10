package com.Project.CarRental.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
