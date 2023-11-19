package com.mshzidan.society.Controllers;

import com.mshzidan.society.dtos.UserAccountSignUPDto;
import com.mshzidan.society.servicies.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserAccountSignUPDto userAccountSignUPDto){
        accountService.createAccount(userAccountSignUPDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PreAuthorize("#accountId == principal.id")
    @PutMapping("/edit/{accountId}")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserAccountSignUPDto userAccountSignUPDto,@PathVariable Integer accountId){
        accountService.updateAccount(userAccountSignUPDto,accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
