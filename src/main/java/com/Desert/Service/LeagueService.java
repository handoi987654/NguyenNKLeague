package com.Desert.Service;

import com.Desert.Entity.League;

import java.util.List;

public interface LeagueService {

    List<League> getLeagueList();

    League getLeagueByID(long leagueID);
}
