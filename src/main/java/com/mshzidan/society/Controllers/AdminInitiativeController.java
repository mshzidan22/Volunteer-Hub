package com.mshzidan.society.Controllers;

import com.mshzidan.society.dtos.InitiativeDetailsDto;
import com.mshzidan.society.dtos.InitiativeDto;
import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.mappers.DtoConverter;
import com.mshzidan.society.servicies.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/initiatives")
public class AdminInitiativeController {
    @Autowired
    private InitiativeService initiativeService;

    @Autowired
    private DtoConverter conv;
    @GetMapping("")
    public ResponseEntity<List<InitiativeDto>> getAllInitiatives
            (@RequestParam(defaultValue = "0",name = "page") int page , @RequestParam(defaultValue = "20",name = "size") int size,
             @RequestParam(defaultValue ="asc",name = "dir") String sortDir,@RequestParam(defaultValue = "id",name = "sort-by") String sort){
        return new ResponseEntity<>(conv.toInitiativeDto(initiativeService.getAllInitiatives(page, size, sortDir, sort)), HttpStatus.OK);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<InitiativeDto>> getAllPendingInitiatives
            (@RequestParam(defaultValue = "0",name = "page") int page , @RequestParam(defaultValue = "20",name = "size") int size,
             @RequestParam(defaultValue ="asc",name = "dir") String sortDir,@RequestParam(defaultValue = "id",name = "sort-by") String sort){
        return new ResponseEntity<>(conv.toInitiativeDto(initiativeService.getAllPendingInitiative(page, size, sortDir, sort)), HttpStatus.OK);
    }



    @GetMapping("/search/{name}")
    public ResponseEntity<List<InitiativeDto>> getInitiativesByName(@PathVariable String name,
              @RequestParam(defaultValue = "0",name = "page") int page , @RequestParam(defaultValue = "20",name = "size") int size,
              @RequestParam(defaultValue ="asc",name = "dir") String sortDir,@RequestParam(defaultValue = "id",name = "sort-by") String sort){

        return new ResponseEntity<>(conv.toInitiativeDto(initiativeService.getInitiativeByName(name,page,size,sortDir,sort)),HttpStatus.OK);
    }




    @GetMapping("/{id}")
    public ResponseEntity<InitiativeDetailsDto> getInitiative(@PathVariable Integer id){
        Initiative initiative = initiativeService.getInitiativeById(id);
        return new ResponseEntity<>( conv.toInitiativeDetailsDto(initiative), HttpStatus.OK);

    }


    @PostMapping ("/{id}/approve")
    public ResponseEntity<Initiative> approveInitiative(@PathVariable Integer id){
       return new ResponseEntity<>(initiativeService.approveInitiative(id) , HttpStatus.OK) ;
    }

    @PostMapping ("/{id}/deny")
    public ResponseEntity<Initiative> deny(@PathVariable Integer id){
        return new ResponseEntity<>(initiativeService.denyInitiative(id) , HttpStatus.OK) ;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> removeInitiative(@PathVariable Integer id){
        initiativeService.deleteInitiative(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;

    }
    @DeleteMapping("/{initiativeId}/volunteers/{userId}")
    public ResponseEntity<Void> removeVolunteer(@PathVariable Integer initiativeId , @PathVariable Integer userId){
        initiativeService.removeVolunteer(initiativeId,userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }







}
