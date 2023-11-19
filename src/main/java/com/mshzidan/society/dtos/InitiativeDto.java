package com.mshzidan.society.dtos;

import com.mshzidan.society.entites.InitiativeStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InitiativeDto {
    private Integer id;
    private String name;
    private LocalDateTime dateTime;
    private String description;
    private double creditPoints;
    private InitiativeStatus initiativeStatus;
    private Integer volunteersCount;
    private UserDto initiatorDTO;


}
