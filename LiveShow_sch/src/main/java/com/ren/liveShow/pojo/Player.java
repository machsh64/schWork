package com.ren.liveShow.pojo;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {

    private Integer pId;

    private String pName;

    private Integer score;

    private Integer rank;

    public Player() {
    }

    public Player(String pName, Integer score) {
        this.pName = pName;
        this.score = score;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        if (this.score > o.score){
            return -1;
        }else if (this.score < o.score){
            return 1;
        }else {
            return -this.pName.compareTo(o.pName);
        }
    }
}