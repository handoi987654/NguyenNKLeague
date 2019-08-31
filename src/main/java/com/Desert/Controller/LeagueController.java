package com.Desert.Controller;

import com.Desert.Entity.Club;
import com.Desert.Entity.League;
import com.Desert.Service.ClubService;
import com.Desert.Service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private LeagueService leagueService;

    @GetMapping("/list-club")
    public ModelAndView getClubsOfLeague() {
        List<Club> clubList = clubService.getClubsOfLeague();
        return new ModelAndView("league-clubs")
                .addObject("clubList", clubList);
    }

    @GetMapping("/new-club")
    public ModelAndView newClub() {
        List<Club> clubList = clubService.getFreeClubs();
        return new ModelAndView("league-add-club")
                .addObject("clubList", clubList);
    }

    @PostMapping("/add-club")
    public String addClubToLeague(@RequestParam long clubID) {
        Club club = clubService.getClubByID(clubID);
        League league = leagueService.getLeagueByID(1);

        club.setLeague(league);
        clubService.updateClub(club);

        return "redirect:/league/list-club";
    }
}
