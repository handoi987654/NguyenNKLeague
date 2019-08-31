package com.Desert.Service;

import com.Desert.Entity.Match;

import java.util.List;

public interface MatchService {

    List<Match> getMatchList();

    void insertMatch(Match match);

    Match getMatchByID(long matchID);

    void updateMatch(Match match);

    Match getMatchOfClub(long clubID);
}
