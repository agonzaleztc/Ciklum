package com.ciklum.rps.bean;

import com.ciklum.rps.enums.RoundStatus;
import com.ciklum.rps.enums.Shape;

/**
 * Result of a round.
 */
public class RoundResult {

    private Shape player1;

    private Shape player2;

    private RoundStatus roundStatus;

    public Shape getPlayer1() {
        return player1;
    }

    public void setPlayer1(Shape player1) {
        this.player1 = player1;
    }

    public Shape getPlayer2() {
        return player2;
    }

    public void setPlayer2(Shape player2) {
        this.player2 = player2;
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(RoundStatus roundStatus) {
        this.roundStatus = roundStatus;
    }
}
