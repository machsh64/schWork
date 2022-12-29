package com.ren.liveshow.controller;

import com.ren.liveshow.pojo.Player;
import com.ren.liveshow.service.GameService;
import com.ren.liveshow.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 18:48
 * @description:
 **/
@Controller
@RequestMapping("add")
public class addPlayerController {

    @Resource
    GameService gameService;

    @RequestMapping(
            value = {"/addPlayer"},
            method = {RequestMethod.POST},
            params = {"playerName","score"}
    )
    public String addPlayer(String playerName,Integer score){
        if (!StringUtil.isEmpty(playerName)) {
            Player player = new Player(playerName, score);
            gameService.addPlayer(player);
        }
        return "forward:/index/indexPage?page=rank1";
    }
}
