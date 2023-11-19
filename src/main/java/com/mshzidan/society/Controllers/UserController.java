package com.mshzidan.society.Controllers;

import com.mshzidan.society.dtos.UserInfoDto;
import com.mshzidan.society.entites.Account;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.mappers.DtoConverter;
import com.mshzidan.society.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DtoConverter conv;


    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfoDto> getUserById(@PathVariable Integer id){
        return new ResponseEntity<>(conv.toUserInfoDto(userService.getUserById(id)) ,HttpStatus.OK);
    }

    private User getCurrentUser(){
        Account principal = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUser();
    }

}
