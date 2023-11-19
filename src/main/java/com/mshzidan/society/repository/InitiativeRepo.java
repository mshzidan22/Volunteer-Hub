package com.mshzidan.society.repository;

import com.mshzidan.society.entites.Initiative;
import com.mshzidan.society.entites.InitiativeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface InitiativeRepo extends JpaRepository<Initiative,Integer> {
    @EntityGraph(value = "Initiative.volunteers")
    Optional<Initiative> findById(Integer id);
     Page<Initiative> findByStatus(InitiativeStatus status, PageRequest pageRequest);

     List<Initiative> findByDateTimeBeforeAndStatus(LocalDateTime localDateTime, InitiativeStatus status);

     Page<Initiative>  findByNameLike(String name,PageRequest pageRequest);
}
