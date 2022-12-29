package com.ren.liveshow;

import com.ren.liveshow.mapper.PlayerMapper;
import com.ren.liveshow.pojo.Player;
import com.ren.liveshow.service.GameService;
import com.ren.liveshow.util.SortListToArrayUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:01
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-persist.xml")
public class PlayerMapperTest {

    @Resource
    private PlayerMapper playerMapper;

    @Resource
    private GameService gameService;


    @Test
    public void testGetSortList() {
        List<Player> players = playerMapper.playerList();
        List<Player> sortList = SortListToArrayUtil.getSortList(players);
        for (Player player : sortList) {
            System.out.println(player);
        }
    }

    @Test
    public void testGetSortListService() {
        List<Player> players = gameService.getPlayerList();
        List<Player> sortList = SortListToArrayUtil.getSortList(players);
        for (Player player : sortList) {
            System.out.println(player);
        }
    }
}
