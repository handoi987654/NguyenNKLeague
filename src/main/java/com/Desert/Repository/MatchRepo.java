package com.Desert.Repository;

import com.Desert.Entity.Match;

import java.util.List;

public interface MatchRepo {

    List<Match> getMatchList();

    void insertMatch(Match match);

    Match getMatchByID(long matchID);

    void updateMatch(Match match);

    Match getMatchOfClub(long clubID);
}
