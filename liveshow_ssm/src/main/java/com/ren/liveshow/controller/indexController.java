package com.ren.liveshow.controller;

import com.ren.liveshow.pojo.Player;
import com.ren.liveshow.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:58
 * @description:
 **/
@Controller
@RequestMapping(
        value = {"index","/"}
        )
public class indexController {

    @Resource
    GameService gameService;

    @RequestMapping(
            value = {"/indexPage","/"}
            )
    public String index(HttpSession session,@RequestParam(defaultValue = "index") String page) {
        if (page == null){
            page = "index";
        }
        List<Player> playerList = gameService.getPlayerList();
        session.setAttribute("playerList", playerList);

        double percentage;
        Object percentageObj = session.getAttribute("percentage");
        if (percentageObj == null) {
            percentage = 30.0;
            session.setAttribute("percentage", percentage);
        } else {
            percentage = (Double) percentageObj;
        }
        double percentageDb = percentage / 100;
        int aft = (int) (Math.round(playerList.size() * percentageDb));
        List<Player> qualifyPlayerList = new LinkedList<>();

        int fir = aft-1;
        boolean isMore = false;
        while (playerList.get(aft - 1).getScore().equals(playerList.get(aft).getScore())) {
            isMore = true;
            aft++;
        }
        Player[] players = new Player[aft-fir];
        for (int i = 0; i < aft; i++) {
            if (i >= fir && isMore) {
                Player player = new Player();
                player.setScore(playerList.get(i).getScore());
                player.setRank(playerList.get(fir).getRank());
                player.setPName(playerList.get(i).getPName() + "( 暂定 )");
                players[i-fir] = player;
                qualifyPlayerList.add(players[i-fir]);
            } else {
                qualifyPlayerList.add(playerList.get(i));
            }
        }
        session.setAttribute("qualifyPlayerList",qualifyPlayerList);
        return page;
    }

    @RequestMapping("/setPercent")
    public String setPercent(HttpSession session, Double percentage) {
        if (percentage == null) {
            percentage = (Double) session.getAttribute("percentage");
        }
        session.setAttribute("percentage",percentage);
        return "redirect:indexPage?page=rank2";
    }

    @RequestMapping("/pageInfo")
    public String page(String page){
        return page;
    }
}
