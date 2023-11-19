package com.mshzidan.society.mappers;

import com.mshzidan.society.dtos.InitiativeDetailsDto;
import com.mshzidan.society.dtos.InitiativeDto;
import com.mshzidan.society.dtos.UserDto;
import com.mshzidan.society.dtos.UserInfoDto;
import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.entites.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toUserDto(List<User> users){
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public InitiativeDto toInitiativeDto(Initiative initiative) {
        InitiativeDto initiativeDto = modelMapper.map(initiative, InitiativeDto.class);
        initiativeDto.setInitiatorDTO(toUserDto(initiative.getInitiator()));
        if(initiative.getVolunteers() != null) initiativeDto.setVolunteersCount(0);
        initiativeDto.setVolunteersCount(initiative.getVolunteers().size());
        return initiativeDto;
    }

    public List<InitiativeDto> toInitiativeDto(List<Initiative> initiativesList) {
        return initiativesList.stream().map(this::toInitiativeDto).collect(Collectors.toList());
    }

    public InitiativeDetailsDto toInitiativeDetailsDto(Initiative initiative) {
        InitiativeDetailsDto initiativeDetailsDto = modelMapper.map(initiative, InitiativeDetailsDto.class);
        initiativeDetailsDto.setInitiator(toUserDto(initiative.getInitiator()));
        initiativeDetailsDto.setVolunteers(toUserDto(initiative.getVolunteers()));
        return initiativeDetailsDto;
    }

    public UserInfoDto toUserInfoDto(User user) {

        UserInfoDto userInfoDto = modelMapper.map(user, UserInfoDto.class);
        userInfoDto.setInitiatives(toInitiativeDto(user.getInitiatives()));
        userInfoDto.setVolunteeringJobs(toInitiativeDto(user.getVolunteeringJobs()));
        return userInfoDto;
    }

    public List<UserInfoDto> toUserInfoDto(List<User> usersList) {
        return usersList.stream().map(this::toUserInfoDto).collect(Collectors.toList());
    }
}