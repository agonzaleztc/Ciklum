package com.ciklum.rps.controller;

import com.ciklum.rps.bean.RoundResult;
import com.ciklum.rps.bean.Stats;
import com.ciklum.rps.constant.RPSConstants;
import com.ciklum.rps.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView(RPSConstants.INDEX);
    }

    @RequestMapping(value = RPSConstants.PLAY_URL, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RoundResult play() {
        return gameService.play();
    }

    @RequestMapping(value = RPSConstants.STATS_URL, method = RequestMethod.GET)
    public ModelAndView stats(Model model) {
        Stats stats = gameService.getGlobalStats();
        model.addAttribute(RPSConstants.STATS, stats);
        return new ModelAndView(RPSConstants.STATS);
    }

}
