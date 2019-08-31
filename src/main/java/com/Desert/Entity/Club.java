package com.Desert.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Club")
@Getter
@Setter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "name")
    @NotNull(message = "Club name can't be null!")
    private String name;
    @Column(name = "point")
    private int point;
    @ManyToOne
    @JoinColumn(name = "leagueID")
    private League league;
    @OneToMany(mappedBy = "club")
    private List<Player> playerList;

    void addWinningPoint() {
        this.point += 3;
    }

    void addDrawPoint() {
        this.point += 1;
    }
}
