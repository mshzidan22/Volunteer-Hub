package com.mshzidan.society.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UserAccountSignUPDto {
    @NotBlank
    @Size(min = 3 , max = 50,message = "Name should be between 3 to 50 char")
    private String name;
    @NotBlank
    @Size(min = 3,max = 20,message = "User name should be between 3 - 20 char")
    private String username;

    @Past(message = "Birth date must be in the past")
    private LocalDate birth;
    @Email(message = "Invalid Email")
    private String email;
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d+$", message = "Invalid phone number format")
    private String phone;

    @Size(min = 2 , max = 50)
    private String address;
    @NotBlank(message = "Password cannot be blank")
    private String password;


}
