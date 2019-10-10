package com.ciklum.rps.bean;

public class Stats {

    private long totalPlayedRounds;

    private long totalPlayer1Wins;

    private long totalPlayer2Wins;

    private long totalDraws;

    public long getTotalPlayedRounds() {
        return totalPlayedRounds;
    }

    public void setTotalPlayedRounds(long totalPlayedRounds) {
        this.totalPlayedRounds = totalPlayedRounds;
    }

    public long getTotalPlayer1Wins() {
        return totalPlayer1Wins;
    }

    public void setTotalPlayer1Wins(long totalPlayer1Wins) {
        this.totalPlayer1Wins = totalPlayer1Wins;
    }

    public long getTotalPlayer2Wins() {
        return totalPlayer2Wins;
    }

    public void setTotalPlayer2Wins(long totalPlayer2Wins) {
        this.totalPlayer2Wins = totalPlayer2Wins;
    }

    public long getTotalDraws() {
        return totalDraws;
    }

    public void setTotalDraws(long totalDraws) {
        this.totalDraws = totalDraws;
    }

    public void addTotalPlayedRounds() {
        totalPlayedRounds++;
    }

    public void addTotalPlayer1Wins() {
        totalPlayer1Wins++;
    }

    public void addTotalPlayer2Wins() {
        totalPlayer2Wins++;
    }

    public void addTotalDraws() {
        totalDraws++;
    }
}
