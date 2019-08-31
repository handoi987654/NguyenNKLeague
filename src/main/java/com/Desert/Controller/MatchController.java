package com.Desert.Controller;

import com.Desert.Entity.Club;
import com.Desert.Entity.League;
import com.Desert.Entity.Match;
import com.Desert.Model.MatchModel;
import com.Desert.Model.ResultModel;
import com.Desert.Service.ClubService;
import com.Desert.Service.LeagueService;
import com.Desert.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private ClubService clubService;

    @GetMapping("/list")
    public ModelAndView listMatch() {
        List<Match> matchList = matchService.getMatchList();
        return new ModelAndView("match-list")
                .addObject("matchList", matchList)
                .addObject("resultModel", new ResultModel());
    }

    @GetMapping("/new")
    public ModelAndView newMatch() {
        List<Club> clubList = clubService.getClubsOfLeague();
        MatchModel matchModel = new MatchModel();

        return new ModelAndView("match-form")
                .addObject("matchModel", matchModel)
                .addObject("clubList", clubList);
    }

    @PostMapping("/add")
    public String addMatch(@Valid @ModelAttribute MatchModel matchModel, BindingResult bindingResult, ModelMap modelMap){
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("clubList", clubService.getClubsOfLeague());
            return "match-form";
        }

        League league = leagueService.getLeagueByID(1);
        Club firstClub = clubService.getClubByID(matchModel.getFirstClubID());
        Club secondClub = clubService.getClubByID(matchModel.getSecondClubID());

        Match match = new Match();
        match.setLeague(league);
        match.setFirstClub(firstClub);
        match.setSecondClub(secondClub);
        match.setDate(matchModel.getDate());
        matchService.insertMatch(match);

        return "redirect:/match/list";
    }

    @PostMapping("/update-result")
    public String updateResult(@Valid @ModelAttribute ResultModel resultModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "match-list";
        }

        Match match = matchService.getMatchByID(resultModel.getMatchID());
        match.updateResult(resultModel.getFirstGrade(), resultModel.getSecondGrade());

        clubService.updateClub(match.getFirstClub());
        clubService.updateClub(match.getSecondClub());
        matchService.updateMatch(match);
        return "redirect:/match/list";
    }
}
