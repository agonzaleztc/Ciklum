package com.ciklum.rps.service;

import com.ciklum.rps.bean.RoundResult;
import com.ciklum.rps.bean.Stats;

/**
 * Game service interface.
 */
public interface GameService {

    /**
     * Plays a new round.
     *
     * @return
     */
    RoundResult play();

    /**
     * Gets the global stats.
     *
     * @return
     */
    Stats getGlobalStats();
}
