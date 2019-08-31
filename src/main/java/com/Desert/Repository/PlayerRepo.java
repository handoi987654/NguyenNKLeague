package com.Desert.Repository;

import com.Desert.Entity.Player;

import java.util.List;

public interface PlayerRepo {

    List<Player> getPlayerList();

    void insertPlayer(Player player);
}
