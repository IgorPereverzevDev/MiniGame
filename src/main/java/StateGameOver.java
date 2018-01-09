class StateGameOver implements State {

    public State changeStateGame(Game game, Reward reward) {
        AdditionalRewards additionalRewards = game.getAdditionalRewards();
        Reward additionalReward = additionalRewards.getWinningReward();
        if (additionalReward.isOtherValue()) {
            return new StateInGame();
        } else {
            game.getPlayer().addMoneyReward(additionalReward);
        }
        return null;
    }
}