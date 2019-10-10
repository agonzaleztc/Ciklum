package com.ciklum.rps.service.impl;

import com.ciklum.rps.bean.RoundResult;
import com.ciklum.rps.bean.Stats;
import com.ciklum.rps.enums.RoundStatus;
import com.ciklum.rps.enums.Shape;
import com.ciklum.rps.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    // Global stats
    private static Stats globalStats = new Stats();

    @Override
    public RoundResult play() {
        RoundResult roundResult = new RoundResult();
        roundResult.setPlayer1(generateRandomGame());
        roundResult.setPlayer2(Shape.ROCK);
        roundResult.setRoundStatus(checkGame(roundResult.getPlayer1(), roundResult.getPlayer2()));
        updateStats(roundResult.getRoundStatus());
        return roundResult;
    }

    /**
     * Generates a random shape.
     *
     * @return
     */
    private Shape generateRandomGame() {
        final List<Shape> VALUES = Collections.unmodifiableList(Arrays.asList(Shape.values()));
        Random random = new Random();
        return VALUES.get(random.nextInt(VALUES.size()));
    }

    /**
     * Checks who has won.
     *
     * @param player1
     * @param player2
     * @return
     */
    public RoundStatus checkGame(Shape player1, Shape player2) {
        switch (player1) {
            case ROCK:
                switch (player2) {
                    case ROCK:
                        return RoundStatus.DRAW;
                    case PAPER:
                        return RoundStatus.PLAYER2_WINS;
                    case SCISSORS:
                        return RoundStatus.PLAYER1_WINS;
                }
            case PAPER:
                switch (player2) {
                    case ROCK:
                        return RoundStatus.PLAYER1_WINS;
                    case PAPER:
                        return RoundStatus.DRAW;
                    case SCISSORS:
                        return RoundStatus.PLAYER2_WINS;
                }
            case SCISSORS:
                switch (player2) {
                    case ROCK:
                        return RoundStatus.PLAYER2_WINS;
                    case PAPER:
                        return RoundStatus.PLAYER1_WINS;
                    case SCISSORS:
                        return RoundStatus.DRAW;
                }
        }
        return null;
    }

    /**
     * Updates the stats.
     *
     * @param roundResult
     */
    private synchronized void updateStats(RoundStatus roundResult) {
        if (roundResult != null) {
            globalStats.addTotalPlayedRounds();
            switch (roundResult) {
                case DRAW:
                    globalStats.addTotalDraws();
                    break;
                case PLAYER1_WINS:
                    globalStats.addTotalPlayer1Wins();
                    break;
                case PLAYER2_WINS:
                    globalStats.addTotalPlayer2Wins();
                    break;
            }
        }
    }

    @Override
    public Stats getGlobalStats() {
        return globalStats;
    }

}
