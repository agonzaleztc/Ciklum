package com.ciklum.rps;

import com.ciklum.rps.bean.RoundResult;
import com.ciklum.rps.bean.Stats;
import com.ciklum.rps.enums.RoundStatus;
import com.ciklum.rps.enums.Shape;
import com.ciklum.rps.service.GameService;
import com.ciklum.rps.service.impl.GameServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RpsApplicationTests {

    @TestConfiguration
    static class RPSContextConfiguration {
        @Bean
        public GameService gameService() {
            return new GameServiceImpl();
        }
    }

    @Autowired
    private GameService gameService;

    @Test
    public void testA_statsInitializedTest() {
        Stats globalStats = gameService.getGlobalStats();
        Assert.assertEquals(0, globalStats.getTotalPlayedRounds());
        Assert.assertEquals(0, globalStats.getTotalPlayer1Wins());
        Assert.assertEquals(0, globalStats.getTotalPlayer2Wins());
        Assert.assertEquals(0, globalStats.getTotalDraws());
    }

    @Test
    public void testB_statsNotNullTest() {
        Stats globalStats = gameService.getGlobalStats();
        Assert.assertNotNull(globalStats);
    }

    @Test
    public void testC_playNotNullTest() {
        RoundResult result = gameService.play();
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPlayer1());
        Assert.assertNotNull(result.getPlayer2());
        Assert.assertNotNull(result.getRoundStatus());
    }

    @Test
    public void testD_playCorrectSumTest() {
        for (int i = 0; i < 10; i++) {
            gameService.play();
        }
        Stats globalStats = gameService.getGlobalStats();
        Assert.assertEquals(globalStats.getTotalPlayedRounds(), globalStats.getTotalPlayer1Wins() + globalStats.getTotalPlayer2Wins() + globalStats.getTotalDraws());
    }

    @Test
    public void testE_playPlayer1WinsResultTest() {
        GameServiceImpl gameServiceImpl = new GameServiceImpl();
        Assert.assertEquals(RoundStatus.PLAYER1_WINS, gameServiceImpl.checkGame(Shape.ROCK, Shape.SCISSORS));
        Assert.assertEquals(RoundStatus.PLAYER1_WINS, gameServiceImpl.checkGame(Shape.PAPER, Shape.ROCK));
        Assert.assertEquals(RoundStatus.PLAYER1_WINS, gameServiceImpl.checkGame(Shape.SCISSORS, Shape.PAPER));
    }

    @Test
    public void testF_playPlayer2WinsResultTest() {
        GameServiceImpl gameServiceImpl = new GameServiceImpl();
        Assert.assertEquals(RoundStatus.PLAYER2_WINS, gameServiceImpl.checkGame(Shape.ROCK, Shape.PAPER));
        Assert.assertEquals(RoundStatus.PLAYER2_WINS, gameServiceImpl.checkGame(Shape.PAPER, Shape.SCISSORS));
        Assert.assertEquals(RoundStatus.PLAYER2_WINS, gameServiceImpl.checkGame(Shape.SCISSORS, Shape.ROCK));
    }

    @Test
    public void testG_playDrawsResultTest() {
        GameServiceImpl gameServiceImpl = new GameServiceImpl();
        Assert.assertEquals(RoundStatus.DRAW, gameServiceImpl.checkGame(Shape.ROCK, Shape.ROCK));
        Assert.assertEquals(RoundStatus.DRAW, gameServiceImpl.checkGame(Shape.PAPER, Shape.PAPER));
        Assert.assertEquals(RoundStatus.DRAW, gameServiceImpl.checkGame(Shape.SCISSORS, Shape.SCISSORS));
    }

}
