package com.ren.liveshow.mapper;

import com.ren.liveshow.pojo.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlayerMapper {

    /**
    * @Description: 获取根据分数从大到小排列的选手列表
    * @Param:
    * @Author: Ren
    * @return: List<Player>
    * @Date: 2022/12/19 17:03
    */
    List<Player> playerList();

    /**
    * @Description: 添加选手
    * @Param: player
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/19 20:07
    */
    Integer addPlayer(Player player);

}