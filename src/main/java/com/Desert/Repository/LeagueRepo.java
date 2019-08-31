package com.Desert.Repository;

import com.Desert.Entity.League;

import java.util.List;

public interface LeagueRepo {

    List<League> getLeagueList();

    League getLeagueByID(long leagueID);
}
