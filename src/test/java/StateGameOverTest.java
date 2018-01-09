import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class StateGameOverTest {

    @Test
    public void testChangeStateGameOverWhenRewardIsSecondChanceToStateInGame() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        StateInGame expectedStateInGame = new StateInGame();
        Reward reward = new Reward(RewardValues.SecondChance);
        AdditionalRewards additionalRewards = new AdditionalRewards();
        List<Reward> rewards = new ArrayList<>();
        rewards.add(reward);
        additionalRewards.setAdditionalRewards(rewards);
        game.setAdditionalRewards(additionalRewards);

        //action
        State actualResult = new StateGameOver().changeStateGame(game, reward);

        //assert
        assertEquals(expectedStateInGame.getClass(), actualResult.getClass());
    }


    @Test
    public void testChangeStateGameOverWhenRewardIsMoneyToExitGame() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        Reward reward = new Reward(RewardValues.TenEuro);
        AdditionalRewards additionalRewards = new AdditionalRewards();
        List<Reward> rewards = new ArrayList<>();
        rewards.add(reward);
        additionalRewards.setAdditionalRewards(rewards);
        game.setAdditionalRewards(additionalRewards);

        //action
        State actualResult = new StateGameOver().changeStateGame(game, reward);

        //assert
        assertNull(actualResult);
    }
}
