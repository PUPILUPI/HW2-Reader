package ru.belov.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "subregion")
    private String subregion;
    @Column(name = "region")
    private String region;
    @Column(name = "region_id")
    private long regionId;
}
