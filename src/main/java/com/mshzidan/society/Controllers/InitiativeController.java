package com.mshzidan.society.Controllers;

import com.mshzidan.society.dtos.InitiativeCreateDto;
import com.mshzidan.society.dtos.InitiativeDetailsDto;
import com.mshzidan.society.dtos.InitiativeDto;
import com.mshzidan.society.entites.Account;
import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.mappers.DtoConverter;
import com.mshzidan.society.servicies.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/initiatives")
public class InitiativeController {
    @Autowired
    private InitiativeService initiativeService;
    @Autowired
    private DtoConverter conv;


    @GetMapping("")
    public ResponseEntity<List<InitiativeDto>> getAllActiveInitiatives
            (@RequestParam(defaultValue = "0",name = "page") int page , @RequestParam(defaultValue = "20",name = "size") int size,
             @RequestParam(defaultValue ="asc",name = "dir") String sortDir,@RequestParam(defaultValue = "id",name = "sort-by") String sort){
        List<Initiative> initiativeList = initiativeService.getAllActiveInitiative(page, size, sortDir, sort);
        return new ResponseEntity<>(conv.toInitiativeDto(initiativeList), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<InitiativeDto> createInitiative(@RequestBody @Valid InitiativeCreateDto initiativeCreateDto){
       Initiative initiative =initiativeService.addInitiative(initiativeCreateDto,getCurrentUser());
       return new ResponseEntity(conv.toInitiativeDto(initiative),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InitiativeDetailsDto> getInitiative(@PathVariable Integer id){
        Initiative initiative = initiativeService.getInitiativeById(id);
        return new ResponseEntity<>( conv.toInitiativeDetailsDto(initiative), HttpStatus.OK);

    }



    @PostMapping("/{id}/register")
    public ResponseEntity<InitiativeDto> volunteerInInitiative(@PathVariable Integer id){
        Initiative initiative = initiativeService.addVolunteer(id, getCurrentUser());
        return new ResponseEntity<>(conv.toInitiativeDto(initiative) , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editInitiative(@PathVariable Integer id ,@RequestBody @Valid InitiativeCreateDto initiativeCreateDto){

        Initiative initiative =initiativeService.editInitiative(id,initiativeCreateDto,getCurrentUser());
        return new ResponseEntity<>("Your initiative has successfully update, wait until the admin approve the updates.",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInitiative(@PathVariable Integer id){

        initiativeService.deleteInitiative(id,getCurrentUser());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



//    @GetMapping("/")
//    public List<InitiativeDto> getAll(){
//        return conv.toInitiativeDto(initiativeService.getAll());
//    }



    private User getCurrentUser(){
        Account principal = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUser();
    }
}
