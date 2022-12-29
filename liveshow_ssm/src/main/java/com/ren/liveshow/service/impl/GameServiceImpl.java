package com.ren.liveshow.service.impl;

import com.ren.liveshow.mapper.PlayerMapper;
import com.ren.liveshow.pojo.Player;
import com.ren.liveshow.service.GameService;
import com.ren.liveshow.util.SortListToArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:18
 * @description:
 **/
@Service
public class GameServiceImpl implements GameService {

    @Resource
    PlayerMapper playerMapper;

    //获取人员排行名单
    @Override
    @Transactional
    public List<Player> getPlayerList() {
        List<Player> playerList = playerMapper.playerList();
        return SortListToArrayUtil.getSortList(playerList);

    }

    //添加人员
    @Override
    @Transactional
    public Integer addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }
}
