import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testGameRun() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();

        //action
        for (int i = 0; i < 10000000; ++i) {
            new Game(rewardLogger).run();
        }
        System.out.println(rewardLogger.getDictionaryRewards());
    }

}