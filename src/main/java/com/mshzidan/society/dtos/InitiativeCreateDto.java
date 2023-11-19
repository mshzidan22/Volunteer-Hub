package com.mshzidan.society.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class InitiativeCreateDto {
    @NotBlank
    @Size(min = 5 , max = 25,message = "Name should be more than 5 and less than 25 char")
    private String name;

    private String description;

    @Min(value = 1,message = "Credits less than 1 not allowed" )
    @Max(value = 1000,message = "Credits more than 1000 not allowed")
    private double creditPoints;

    @Future(message = "Date must be in the future")
    private LocalDateTime dateTime;


}
