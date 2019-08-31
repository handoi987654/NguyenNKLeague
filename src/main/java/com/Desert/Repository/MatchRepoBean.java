package com.Desert.Repository;

import com.Desert.Entity.Match;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchRepoBean implements MatchRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Match> getMatchList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Match> query =
                session.createQuery("FROM Match", Match.class);
        return query.getResultList();
    }

    @Override
    public void insertMatch(Match match) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(match);
    }

    @Override
    public Match getMatchByID(long matchID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Match.class, matchID);
    }

    @Override
    public void updateMatch(Match match) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(match);
    }

    @Override
    public Match getMatchOfClub(long clubID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Match> query =
                session.createQuery("FROM Match " +
                        "WHERE firstClubID = :clubID " +
                        "OR secondClubID = :clubID", Match.class);
        return query.getSingleResult();
    }
}
