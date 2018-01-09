import org.junit.Test;


public class GameTest {
    @Test
    public void testGameRun() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        int step = 10;

        //action
        for (long i = 0; i < step; ++i) {
            System.out.println("Game:" + i);
            new Game(rewardLogger).run();
        }

        //Euro Rewards
        rewardLogger.getDictionaryRewards().entrySet().stream().filter(entry -> entry.getKey().isMoneyValue())
                .forEach((key) -> System.out.println(key.getKey().toStringEuroReward() + ":" +
                        " " + "Number received for " + step + " games = " + key.getValue()));
        //Other Rewards
        rewardLogger.getDictionaryRewards().entrySet().stream().filter(entry -> entry.getKey().isOtherValue())
                .forEach((key) -> System.out.println(key.getKey().toStringOtherReward() + ":" +
                        " " + "Number received for " + step + " games = " + key.getValue()));

        //TotalAmount
        System.out.println("Total Amount = " + rewardLogger.getTotalAmount());

        //Average
        System.out.println("Average Amount = " + rewardLogger.getTotalAmount()/step);

    }

}