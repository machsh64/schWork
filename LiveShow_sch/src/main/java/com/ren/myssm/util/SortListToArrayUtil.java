package com.ren.myssm.util;

import com.ren.liveshow.pojo.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 17:08
 * @description:
 **/
public class SortListToArrayUtil {

    public static List<Player> getSortList(List<Player> playerList) {
        Player[] players = new Player[playerList.size()];
        int i = 0;
        for (Player player : playerList) {
            players[i++] = player;
        }
        Arrays.sort(players);
        for(int j = 0; j < players.length; j++){
           players[j].setRank(j+1);
        }
        return new LinkedList<>(Arrays.asList(players));
    }
}
