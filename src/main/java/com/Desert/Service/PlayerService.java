package com.Desert.Service;

import com.Desert.Entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayerList();

    void insertPlayer(Player player);
}
