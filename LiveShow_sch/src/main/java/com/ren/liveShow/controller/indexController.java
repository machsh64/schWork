package com.ren.liveShow.controller;

import com.ren.liveShow.pojo.Player;
import com.ren.liveShow.service.GameService;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:58
 * @description:
 **/
public class indexController {

    GameService gameService;

    public String index(HttpSession session,String page) {
        if (page == null){
            page = "index";
        }
        List<Player> playerList = gameService.getPlayerList();
        session.setAttribute("playerList", playerList);

        double percentage;
        Object percentageObj = session.getAttribute("percentage");
        if (percentageObj == null){
            percentage = 30.0;
            session.setAttribute("percentage",percentage);
        }else {
            percentage = (Double) percentageObj;
        }
        double percentageDb = percentage / 100;
        int aft = (int)(Math.round(playerList.size() * percentageDb));
        List<Player> qualifyPlayerList = new LinkedList<>();
        for(int i = 0; i < aft; i++){
            qualifyPlayerList.add(playerList.get(i));
        }
        session.setAttribute("qualifyPlayerList",qualifyPlayerList);
        return page;
    }

    public String setPercent(HttpSession session, Double percentage) {
        if (percentage == null) {
            percentage = (Double) session.getAttribute("percentage");
        }
        session.setAttribute("percentage",percentage);
        return "redirect:index.do?operate=index&page=rank2";
    }
}
