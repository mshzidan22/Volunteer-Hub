package com.mshzidan.society.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserInfoDto {

    private Integer id;
    private String name;

    private LocalDate birth;

    private String email;

    private String phone;

    private String address;

    private double credits;
    private List<InitiativeDto> initiatives;

    private List<InitiativeDto> volunteeringJobs;



}
