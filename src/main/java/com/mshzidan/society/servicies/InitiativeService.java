package com.mshzidan.society.servicies;

import com.mshzidan.society.dtos.InitiativeCreateDto;
import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.entites.InitiativeStatus;
import com.mshzidan.society.entites.User;
import com.mshzidan.society.exceptions.*;
import com.mshzidan.society.repository.InitiativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InitiativeService {
    private final InitiativeRepo initiativeRepo;

    @Autowired
    public InitiativeService(InitiativeRepo initiativeRepo) {
        this.initiativeRepo = initiativeRepo;
    }

    public Initiative addInitiative(InitiativeCreateDto initiativeCreateDto, User user) {
        validateUserActiveInitiatives(user);
        Initiative initiative = createInitiative(initiativeCreateDto, user);
        return initiativeRepo.save(initiative);
    }

    public Initiative addVolunteer(Integer initiativeId, User user) {
        Initiative initiative = getInitiativeById(initiativeId);
        validateVolunteerRegistration(initiative, user);
        user.setCredits(user.getCredits() + initiative.getCreditPoints());
        initiative.getVolunteers().add(user);
        return initiativeRepo.save(initiative);
    }

    //for admin
    public void deleteInitiative(Integer id) {
        Initiative initiative = getInitiativeById(id);
        refundCredits(initiative);
        initiativeRepo.delete(initiative);
    }
    //for user
    public void deleteInitiative(Integer id, User user){
        Initiative initiative = getInitiativeById(id);
        validateInitiativeBelongsToUser(user,initiative);
        refundCredits(initiative);
        initiativeRepo.delete(initiative);

    }

    public List<Initiative> getAllActiveInitiative(int page, int size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Initiative> initiatives = initiativeRepo.findByStatus(InitiativeStatus.Active, pageReq);
        return initiatives.getContent();
    }

    public List<Initiative> getAllPendingInitiative(int page, int size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Initiative> initiatives = initiativeRepo.findByStatus(InitiativeStatus.Pending, pageReq);
        return initiatives.getContent();
    }

    public void withdraw(User user, Initiative initiative) {
        validateWithdrawal(initiative);
        initiative.getVolunteers().remove(user);
        user.setCredits(user.getCredits() - initiative.getCreditPoints());
        initiativeRepo.save(initiative);
    }

    public void removeVolunteer(Integer initiativeId, Integer volunteerId) {
        Initiative initiative = getInitiativeById(initiativeId);
        User user = initiative.getVolunteers().stream()
                .filter(volunteer -> volunteer.getId().equals(volunteerId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        withdraw(user, initiative);
        initiative.getVolunteers().remove(user);
        initiativeRepo.save(initiative);
    }

    public List<Initiative> getAllInitiatives(int page, int size, String sortDir, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        return initiativeRepo.findAll(pageRequest).getContent();
    }

    public List<Initiative> getInitiativeByName(String name, int page, int size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Initiative> initiatives = initiativeRepo.findByNameLike(name, pageReq);
        return initiatives.getContent();
    }



    public List<Initiative> getAll() {
        return initiativeRepo.findAll();
    }

    public Initiative approveInitiative(Integer id) {
        Initiative initiative = getInitiativeById(id);
        initiative.setStatus(InitiativeStatus.Active);
        return initiativeRepo.save(initiative);
    }

    public Initiative denyInitiative(Integer id) {
        Initiative initiative = getInitiativeById(id);
        initiative.setStatus(InitiativeStatus.Denied);
        return initiativeRepo.save(initiative);
    }

    public Initiative getInitiativeById(Integer id) {
        return initiativeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Initiative not found"));
    }

    @Scheduled(fixedRate = 60000 * 5) // runs every 5 min
    public void updateExpiredInitiatives() {
        initiativeRepo.findByDateTimeBeforeAndStatus(LocalDateTime.now(), InitiativeStatus.Active)
                .forEach(this::expireInitiative);
    }

    private void validateUserActiveInitiatives(User user) {
        long activeInitiatives = user.getInitiatives()
                .stream().filter(initiative -> initiative.getStatus().equals(InitiativeStatus.Active))
                .count();

        if (activeInitiatives >= 2)
            throw new MaximumInitiativeException("You cannot have more than 2 active initiatives");
    }

    private void validateVolunteerRegistration(Initiative initiative, User user) {
        if (initiative.getDateTime().isBefore(LocalDateTime.now())) {
            expireInitiative(initiative);
            throw new InitiativeExpiredException("The initiative is expired");
        }

        if (!initiative.getStatus().equals(InitiativeStatus.Active)) {
            throw new IntiativeNotApprovedException("You cannot register for a non-approved initiative");
        }

        if (initiative.getInitiator().equals(user)) {
            throw new VolunteerInOwnInitiativeException("You cannot volunteer in an initiative you have created");
        }
    }

    private void refundCredits(Initiative initiative) {
        initiative.getVolunteers().forEach(vol -> vol.setCredits(vol.getCredits() - initiative.getCreditPoints()));
        initiativeRepo.save(initiative);
    }

    private void validateWithdrawal(Initiative initiative) {
        if (initiative.getStatus().equals(InitiativeStatus.Expired))
            throw new InitiativeExpiredException("The initiative is expired");
    }

    private void expireInitiative(Initiative initiative) {
        initiative.setStatus(InitiativeStatus.Expired);
        initiativeRepo.save(initiative);
    }

    private Initiative createInitiative(InitiativeCreateDto initiativeCreateDto, User user) {
        Initiative initiative = new Initiative();
        initiative.setName(initiativeCreateDto.getName());
        initiative.setCreditPoints(initiativeCreateDto.getCreditPoints());
        initiative.setDescription(initiativeCreateDto.getDescription());
        initiative.setDateTime(initiativeCreateDto.getDateTime());
        initiative.setStatus(InitiativeStatus.Pending);
        initiative.setInitiator(user);
        return initiative;
    }

    public Initiative editInitiative(Integer id ,InitiativeCreateDto initiativeCreateDto,User user){
        Initiative initiative = getInitiativeById(id);
        if(!initiative.getInitiator().getId().equals(user.getId()))
            throw new ChangeNotOwningInitiative("Only initiator can edit this initiative");
        initiative.setName(initiativeCreateDto.getName());
        initiative.setDescription(initiativeCreateDto.getDescription());
        initiative.setCreditPoints(initiativeCreateDto.getCreditPoints());
        initiative.setStatus(InitiativeStatus.Pending);
        return initiativeRepo.save(initiative);
    }

    public void validateInitiativeBelongsToUser(User user, Initiative initiative){
        if(!initiative.getInitiator().getId().equals(user.getId()))
            throw  new ChangeNotOwningInitiative("Only initiator can delete");
    }
}
