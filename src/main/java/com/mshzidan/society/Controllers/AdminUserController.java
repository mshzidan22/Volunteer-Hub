package com.mshzidan.society.Controllers;

import com.mshzidan.society.dtos.UserInfoDto;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.mappers.DtoConverter;
import com.mshzidan.society.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {
     private final UserService userService;
     private final DtoConverter conv;

    @Autowired
    public AdminUserController( UserService userService, DtoConverter conv) {
        this.userService = userService;
        this.conv = conv;
    }

    @GetMapping("")
    public ResponseEntity<List<UserInfoDto>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(conv.toUserInfoDto(users), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoDto> getUser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(conv.toUserInfoDto(user),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
