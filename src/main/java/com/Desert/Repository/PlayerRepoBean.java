package com.Desert.Repository;

import com.Desert.Entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepoBean implements PlayerRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Player> getPlayerList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Player> query =
                session.createQuery("FROM Player", Player.class);
        return query.getResultList();
    }

    @Override
    public void insertPlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(player);
    }
}
