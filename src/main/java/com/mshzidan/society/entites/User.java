package com.mshzidan.society.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id

    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen" , initialValue = 20)
    private Integer id;
    @NotBlank
    @Size(min = 3 , max = 50,message = "Name should be between 3 to 50 char")
    private String name;
    @Past(message = "Birth date must be in the past")
    private LocalDate birth;
    @Email(message = "Invalid Email")
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d+$", message = "Invalid phone number format")
    @Column(unique = true)
    private String phone;
    @Size(min = 2 , max = 50)
    private String address;

    private double credits;
    @OneToOne(mappedBy = "user" ,orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private Account account;

    @OneToMany(mappedBy = "initiator",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Initiative>  initiatives;

    @ManyToMany(mappedBy = "volunteers")
    private List<Initiative> volunteeringJobs;
}
