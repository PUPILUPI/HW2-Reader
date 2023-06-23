package ru.belov.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "companies_name")
    private String companiesName;
    @Column(name = "full_name")
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;



}
