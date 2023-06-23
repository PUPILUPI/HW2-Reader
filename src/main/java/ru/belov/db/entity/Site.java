package ru.belov.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "npp_name")
    private String nppName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place", referencedColumnName = "id")
    private Country place;
    @Column(name = "owner_id")
    private Long ownerId;
    @ManyToOne
    @JoinColumn(name = "operator", referencedColumnName = "id")
    private Company operator;
    @Column(name = "builder")
    private Long builder;

}
