import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AdditionalRewardsTest {


    @Test
    public void testGetWinningRewardEuro() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        Reward reward = new Reward(RewardValues.TenEuro);
        AdditionalRewards additionalRewards = new AdditionalRewards();
        List<Reward> rewards = new ArrayList<>();
        rewards.add(reward);
        additionalRewards.setAdditionalRewards(rewards);

        //action
        game.setAdditionalRewards(additionalRewards);

        Reward actualReward = additionalRewards.getWinningReward();

        //assert
        assertTrue(actualReward.isMoneyValue());
    }

    @Test
    public void testGetWinningRewardOther() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        Reward reward = new Reward(RewardValues.SecondChance);
        AdditionalRewards additionalRewards = new AdditionalRewards();
        List<Reward> rewards = new ArrayList<>();
        rewards.add(reward);
        additionalRewards.setAdditionalRewards(rewards);

        //action
        game.setAdditionalRewards(additionalRewards);

        Reward actualReward = additionalRewards.getWinningReward();

        //assert
        assertTrue(actualReward.isOtherValue());
    }


    @Test
    public void testListRewardsDecreaseSize() throws Exception {
        //adjust
        AdditionalRewards additionalRewards = new AdditionalRewards();
        int expectedListSize = 3;

        //action
        additionalRewards.getWinningReward();
        int actualListSize = additionalRewards.getAdditionalRewards().size();

        //assert
        assertEquals(expectedListSize, actualListSize);
    }
}
