package com.mshzidan.society.servicies;

import com.mshzidan.society.dtos.UserAccountSignUPDto;
import com.mshzidan.society.entites.Account;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.exceptions.UserNotFoundException;
import com.mshzidan.society.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Account getAccountByUsername(String username){
      return   accountRepo.getByUsername(username).orElseThrow(() -> new UserNotFoundException("User is not found"));
    }

    public Account createAccount(UserAccountSignUPDto dto){
        User user = new User();
        Account account  = new Account();
        user.setName(dto.getName());
        user.setBirth(dto.getBirth());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setPhone(dto.getPhone());
        account.setUsername(dto.getUsername());
        account.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        account.setRole("USER");
        account.setUser(user);
        return accountRepo.save(account);
    }

    public Account updateAccount(UserAccountSignUPDto dto , Integer accountId){
        Account account = accountRepo.findById(accountId).orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        account.getUser().setName(dto.getName());
        account.getUser().setEmail(dto.getEmail());
                account.getUser().setPhone(dto.getPhone());
                account.getUser().setBirth(dto.getBirth());
                account.getUser().setAddress(dto.getAddress());
          return   accountRepo.save(account);


    }
}
