import org.junit.Test;


public class GameTest {
    @Test
    public void testGameRun() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();

        //action
        for (long i = 0; i < 10000000; ++i) {
            System.out.println("New game:" + i);
            new Game(rewardLogger).run();
        }
        System.out.println(rewardLogger.getDictionaryRewards());
    }

}