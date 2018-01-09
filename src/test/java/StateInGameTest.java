import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StateInGameTest {

    @Test
    public void testChangeStateInGameMoneyRewardPlayer() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        Reward expectedPlayerTotalAmount = new Reward(RewardValues.FiveEuro);
        Box box = new Box(expectedPlayerTotalAmount);

        //action
        new StateInGame().changeStateGame(game, box.getReward());
        Reward actualTotalAmount = game.getPlayer().getTotalWinAmount();

        //assert
        assertEquals(expectedPlayerTotalAmount.getEuroReward(), actualTotalAmount.getEuroReward());

    }

    @Test
    public void testChangeStateInGameWhenRewardIsMoneyStayInGame() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        StateInGame expectedStateInGame = new StateInGame();
        Reward reward = new Reward(RewardValues.FiveEuro);
        Box box = new Box(reward);

        //action
        State actualResult = expectedStateInGame.changeStateGame(game, box.getReward());

        //assert
        assertEquals(expectedStateInGame.getClass(), actualResult.getClass());
    }


    @Test
    public void testChangeStateInGameWhenRewardIsExtraLifeIncreased() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        int expectedLife = 2;
        Reward reward = new Reward(RewardValues.ExtraLife);
        Box box = new Box(reward);

        //action
        new StateInGame().changeStateGame(game, box.getReward());
        int actualLife = game.getPlayer().getLive();

        //assert
        assertEquals(expectedLife, actualLife);
    }


    @Test
    public void testChangeStateInGameWhenRewardIsExtraLifeStayInGame() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        StateInGame expectedStateInGame = new StateInGame();
        Reward reward = new Reward(RewardValues.ExtraLife);
        Box box = new Box(reward);

        //action
        State actualResult = expectedStateInGame.changeStateGame(game, box.getReward());

        //assert
        assertEquals(expectedStateInGame.getClass(), actualResult.getClass());
    }


    @Test
    public void testChangeStateInGameWhenRewardIsIsExtraLifeDecreased() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        int expectedLife = 0;
        Reward reward = new Reward(RewardValues.GameOver);
        Box box = new Box(reward);

        //action
        new StateInGame().changeStateGame(game, box.getReward());
        int actualLife = game.getPlayer().getLive();

        //assert
        assertEquals(expectedLife, actualLife);
    }


    @Test
    public void testChangeStateInGameWhenRewardIsGameOverStayInGame() throws Exception {
        //adjust
        RewardLogger rewardLogger = new RewardLogger();
        Game game = new Game(rewardLogger);
        Player player = game.getPlayer();
        player.increaseLife();
        StateInGame expectedStateInGame = new StateInGame();
        Reward reward = new Reward(RewardValues.GameOver);
        Box box = new Box(reward);

        //action
        State actualResult = expectedStateInGame.changeStateGame(game, box.getReward());

        //assert
        assertEquals(expectedStateInGame, actualResult);
    }

}
