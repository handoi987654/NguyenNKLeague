package com.Desert.Controller;

import com.Desert.Entity.Club;
import com.Desert.Entity.League;
import com.Desert.Service.ClubService;
import com.Desert.Service.LeagueService;
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
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private LeagueService leagueService;

    @GetMapping("/list")
    public ModelAndView listClub() {
        List<Club> clubList = clubService.getClubList();
        return new ModelAndView("club-list", "clubList", clubList);
    }

    @GetMapping("/new")
    public ModelAndView newClub() {
        return new ModelAndView("club-form", "club", new Club());
    }

    @PostMapping("/add")
    public String addClub(@Valid @ModelAttribute Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "club-form";
        }

        League league = leagueService.getLeagueByID(1);
        club.setLeague(league);
        clubService.insertClub(club);
        return "redirect:/club/list";
    }

    @GetMapping("/rank")
    public ModelAndView getRank() {
        List<Club> rankedClubList = clubService.getRankedClubs();
        return new ModelAndView("rank")
                .addObject("clubList", rankedClubList);
    }
}
