package com.Desert.Service;

import com.Desert.Entity.Player;
import com.Desert.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerServiceBean implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public List<Player> getPlayerList() {
        return playerRepo.getPlayerList();
    }

    @Override
    public void insertPlayer(Player player) {
        playerRepo.insertPlayer(player);
    }
}
