package com.Desert.Controller;

import com.Desert.Entity.Club;
import com.Desert.Entity.Player;
import com.Desert.Model.PlayerModel;
import com.Desert.Service.ClubService;
import com.Desert.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private ClubService clubService;

    @GetMapping("/list")
    public ModelAndView playerList() {
        List<Player> playerList = playerService.getPlayerList();
        return new ModelAndView("player-list")
                .addObject("playerList", playerList);
    }

    @GetMapping("/new")
    public ModelAndView newPlayer() {
        List<Club> clubList = clubService.getClubList();
        return new ModelAndView("player-form")
                .addObject("clubList", clubList)
                .addObject("playerModel", new PlayerModel());
    }

    @PostMapping("/add")
    public String addPlayer(@Valid @ModelAttribute PlayerModel playerModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "player-form";
        }

        Club club = clubService.getClubByID(playerModel.getClubID());
        Player player = new Player();
        player.setName(playerModel.getName());
        player.setClub(club);
        playerService.insertPlayer(player);

        return "redirect:/player/list";
    }
}
