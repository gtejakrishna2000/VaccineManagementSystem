package com.example.VaccinationManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "dose")
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key

    @Column(unique = true)
    private String doseId; //Unique

    @CreationTimestamp
    private Date vaccinationDate;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private User user;

//    public User getUser() {
//        return user;






//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
