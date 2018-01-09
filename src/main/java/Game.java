
class Game {

    private Player player;
    private AdditionalRewards additionalRewards = new AdditionalRewards();
    private RewardLogger log;

    Game(RewardLogger log) {
        this.player = new Player(new BoxesWithAwards(), log);
        this.log = log;
    }


    AdditionalRewards getAdditionalRewards() {
        return additionalRewards;
    }

    void setAdditionalRewards(AdditionalRewards additionalRewards) {
        this.additionalRewards = additionalRewards;
    }

    Player getPlayer() {
        return player;
    }

    private boolean isGameOver(State state, Reward reward) {
        return state == null || reward == null;
    }

    void run() {
        State state = new StateInGame();
        Reward reward = player.openBox();

        while (!isGameOver(state, reward)) {
            state = state.changeStateGame(this, reward);
            reward = player.openBox();
            log.addNumberRewardsToDictionary(reward);
        }
        log.addAmountToTotal(player.getTotalWinAmount());
    }
}