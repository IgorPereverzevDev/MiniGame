class StateInGame implements State {

    public State changeStateGame(Game game, Reward reward) {
        Player player = game.getPlayer();
        if (reward.isMoneyValue()) {
            player.addMoneyReward(reward);
        } else if (reward.getRewardOther().equals(RewardValues.ExtraLife)) {
            player.increaseLife();
        } else {
            player.decreaseLife();
            if (player.getLive() == 0) {
                return new StateGameOver();
            }
        }
        return this;
    }
}


