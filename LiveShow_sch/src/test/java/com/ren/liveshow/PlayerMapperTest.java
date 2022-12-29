package com.ren.liveshow;

import com.ren.liveshow.mapper.PlayerMapper;
import com.ren.liveshow.pojo.Player;
import com.ren.myssm.util.SortListToArrayUtil;

import com.ren.myssm.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:01
 * @description:
 **/
public class PlayerMapperTest {
    SqlSession sqlSession;
    PlayerMapper mapper;

    @Before
    public void before(){
        sqlSession = SqlSessionUtil.getSqlSession();
        mapper = sqlSession.getMapper(PlayerMapper.class);
        System.out.println("begain");
    }

    @Test
    public void testGetSortList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        List<Player> players = mapper.playerList();
        List<Player> sortList = SortListToArrayUtil.getSortList(players);
        for (Player player : sortList) {
            System.out.println(player);
        }
    }

    @Test
    public void testAddPlayer() {
        Integer integer = mapper.addPlayer(new Player("迪亚波罗", 25));
        System.out.println("num : "+integer);
        sqlSession.commit();
        System.out.println("commit");
    }
}
