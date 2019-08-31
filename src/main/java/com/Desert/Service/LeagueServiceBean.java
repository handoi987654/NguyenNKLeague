package com.Desert.Service;

import com.Desert.Entity.League;
import com.Desert.Repository.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LeagueServiceBean implements LeagueService {

    @Autowired
    private LeagueRepo leagueRepo;

    @Override
    public List<League> getLeagueList() {
        return leagueRepo.getLeagueList();
    }

    @Override
    public League getLeagueByID(long leagueID) {
        return leagueRepo.getLeagueByID(leagueID);
    }
}
