package com.Desert.Service;

import com.Desert.Entity.Club;
import com.Desert.Repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClubServiceBean implements ClubService {

    @Autowired
    private ClubRepo clubRepo;

    @Override
    public List<Club> getClubList() {
        return clubRepo.getClubList();
    }

    @Override
    public void insertClub(Club club) {
        clubRepo.insertClub(club);
    }

    @Override
    public Club getClubByID(long clubID) {
        return clubRepo.getClubByID(clubID);
    }

    @Override
    public List<Club> getRankedClubs() {
        return clubRepo.getRankedClubs();
    }

    @Override
    public void updateClub(Club club) {
        clubRepo.updateClub(club);
    }

    @Override
    public List<Club> getClubsOfLeague() {
        return clubRepo.getClubsOfLeague();
    }

    @Override
    public List<Club> getFreeClubs() {
        return clubRepo.getFreeClubs();
    }
}
