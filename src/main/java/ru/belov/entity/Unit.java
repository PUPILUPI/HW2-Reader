package ru.belov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "units")
public class Unit {

    @Id
    @Column(name = "id")
    private long id;
    private String code;
    private String unitName;
    private long site;
    private String status;
    private String type;
    private String model;
    @Column(name = "ru_design")
    private boolean ruDesign;
    private int operator;
    @Column(name = "nsss_supplier")
    private int nsssSupplier;
    @Column(name = "thermal_capacity")
    private int thermalCapacity;
    @Column(name = "gross_capacity")
    private int grossCapacity;
    @Column(name = "net_capacity")
    private int netCapacity;
    @Column(name = "construction_start")
    private LocalDate constructionStart;
    @Column(name = "commercial_operation")
    private LocalDate commercialOperation;
    @Column(name = "date_shutdown")
    private LocalDate date_shutdown;
    private double enrichment;
    @Column(name = "load_factor")
    private int loadFactor;
    @Column(name = "burnup")
    private double burnUp;
    @Column(name = "first_load")
    private double firstLoad;
}
