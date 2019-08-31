package com.Desert.Service;

import com.Desert.Entity.Club;

import java.util.List;

public interface ClubService {

    List<Club> getClubList();

    void insertClub(Club club);

    Club getClubByID(long clubID);

    List<Club> getRankedClubs();

    void updateClub(Club club);

    List<Club> getClubsOfLeague();

    List<Club> getFreeClubs();
}
