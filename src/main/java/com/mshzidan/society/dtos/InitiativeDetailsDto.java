package com.mshzidan.society.dtos;

import com.mshzidan.society.entites.InitiativeStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InitiativeDetailsDto {
    private Integer id;
    private String name;
    private LocalDateTime dateTime;
    private String description;
    private double creditPoints;
    private InitiativeStatus status;
    private UserDto initiator;

    private List<UserDto> volunteers;
}
