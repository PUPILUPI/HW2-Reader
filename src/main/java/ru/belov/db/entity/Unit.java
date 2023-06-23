package ru.belov.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "units")
public class Unit {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "unit_name")
    private String unitName;
    @ManyToOne
    @JoinColumn(name = "site", referencedColumnName = "id")
    private Site site;
    @Column(name = "status")
    private String status;
    @Column(name = "type")
    private String type;
    @Column(name = "model")
    private String model;
    @Column(name = "class")
    private String reactorClass;
    @Column(name = "ru_design")
    private boolean ruDesign;
    @Column(name = "operator")
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
    private Date constructionStart;
    @Column(name = "commercial_operation")
    private Date commercialOperation;
    @Column(name = "date_shutdown")
    private Date dateShutdown;
    @Column(name = "enrichment")
    private double enrichment;
    @Column(name = "load_factor")
    private int loadFactor;
    @Column(name = "burnup")
    private double burnUp;
    @Column(name = "first_load")
    private double firstLoad;
    @Column(name = "yearly_P")
    private double yearlyP;
}
