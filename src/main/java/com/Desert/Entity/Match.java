package com.Desert.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "\"Match\"")
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "result")
    private String result;

    @ManyToOne
    @JoinColumn(name = "leagueID")
    private League league;
    @OneToOne
    @JoinColumn(name = "firstClubID")
    private Club firstClub;
    @OneToOne
    @JoinColumn(name = "secondClubID")
    private Club secondClub;

    public void updateResult(int firstGrade, int secondGrade) {
        if (firstGrade > secondGrade) {
            this.firstClub.addWinningPoint();
        } else if (firstGrade < secondGrade) {
            this.secondClub.addWinningPoint();
        } else {
            this.firstClub.addDrawPoint();
            this.secondClub.addDrawPoint();
        }

        this.result = String.format("%d - %d", firstGrade, secondGrade);
    }
}
