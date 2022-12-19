package com.ren.liveShow.service.impl;

import com.ren.liveShow.mapper.PlayerMapper;
import com.ren.liveShow.pojo.Player;
import com.ren.liveShow.service.GameService;
import com.ren.myssm.util.SortListToArrayUtil;

import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:18
 * @description:
 **/
public class GameServiceImpl implements GameService {

    PlayerMapper playerMapper;

    //获取人员排行名单
    @Override
    public List<Player> getPlayerList() {
        List<Player> playerList = playerMapper.playerList();
        return SortListToArrayUtil.getSortList(playerList);

    }

    //添加人员
    @Override
    public Integer addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }
}
