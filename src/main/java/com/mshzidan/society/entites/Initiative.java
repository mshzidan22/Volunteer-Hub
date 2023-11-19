package com.mshzidan.society.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NamedEntityGraph(name = "Initiative.volunteers",
        attributeNodes = @NamedAttributeNode("volunteers")
)
public class Initiative {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "initiative_id_seq")
    @SequenceGenerator(name = "initiative_id_seq", initialValue = 20)
    private Integer id;
    @NotBlank
    @Size(min = 5 , max = 25,message = "Name should be more than 5 and less than 25 char")
    private String name;

    private LocalDateTime dateTime;
    private String description;
    private double creditPoints;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InitiativeStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User initiator;

    @ManyToMany
    private List<User> volunteers;
}
