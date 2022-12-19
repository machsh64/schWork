package com.ren.liveShow.service;

import com.ren.liveShow.pojo.Player;

import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:18
 * @description:
 **/
public interface GameService {

    /**
    * @Description: 获取进行排列后的所有人员列表
    * @Param:
    * @Author: Ren
    * @return: List<Player>
    * @Date: 2022/12/19 17:32
    */
    List<Player> getPlayerList();

    /**
    * @Description: 通过实体类添加人员
    * @Param: player
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/19 20:43
    */
    Integer addPlayer(Player player);
}
