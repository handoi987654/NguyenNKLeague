package com.Desert.Service;

import com.Desert.Entity.Match;
import com.Desert.Repository.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MatchServiceBean implements MatchService {

    @Autowired
    private MatchRepo matchRepo;

    @Override
    public List<Match> getMatchList() {
        return matchRepo.getMatchList();
    }

    @Override
    public void insertMatch(Match match) {
        matchRepo.insertMatch(match);
    }

    @Override
    public Match getMatchByID(long matchID) {
        return matchRepo.getMatchByID(matchID);
    }

    @Override
    public void updateMatch(Match match) {
        matchRepo.updateMatch(match);
    }

    @Override
    public Match getMatchOfClub(long clubID) {
        return matchRepo.getMatchOfClub(clubID);
    }
}
