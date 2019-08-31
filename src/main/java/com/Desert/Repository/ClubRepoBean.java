package com.Desert.Repository;

import com.Desert.Entity.Club;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubRepoBean implements ClubRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Club> getClubList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Club> query =
                session.createQuery("FROM Club", Club.class);
        return query.getResultList();
    }

    @Override
    public void insertClub(Club club) {
        Session session = sessionFactory.getCurrentSession();
        session.save(club);
    }

    @Override
    public Club getClubByID(long clubID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Club.class, clubID);
    }

    @Override
    public List<Club> getRankedClubs() {
        Session session = sessionFactory.getCurrentSession();
        Query<Club> query =
                session.createQuery("FROM Club ORDER BY point DESC", Club.class);
        return query.getResultList();
    }

    @Override
    public void updateClub(Club club) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(club);
    }

    @Override
    public List<Club> getClubsOfLeague() {
        Session session = sessionFactory.getCurrentSession();
        Query<Club> query =
                session.createQuery("FROM Club WHERE leagueID = 1", Club.class);
        return query.getResultList();
    }

    @Override
    public List<Club> getFreeClubs() {
        Session session = sessionFactory.getCurrentSession();
        Query<Club> query =
                session.createQuery("FROM Club WHERE leagueID IS NULL", Club.class);
        return query.getResultList();
    }
}
