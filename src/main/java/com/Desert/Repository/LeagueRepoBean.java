package com.Desert.Repository;

import com.Desert.Entity.League;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeagueRepoBean implements LeagueRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<League> getLeagueList() {
        Session session = sessionFactory.getCurrentSession();
        Query<League> query =
                session.createQuery("FROM League", League.class);
        return query.getResultList();
    }

    @Override
    public League getLeagueByID(long leagueID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(League.class, leagueID);
    }
}
