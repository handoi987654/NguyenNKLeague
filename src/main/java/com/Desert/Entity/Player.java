package com.Desert.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Player")
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "clubID")
    private Club club;
}
