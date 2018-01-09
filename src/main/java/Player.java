class Player {

    private Reward totalWinAmount = new Reward(0);
    private int live = 1;
    private BoxesWithAwards boxesWithAwards;
    private RewardLogger log;

    Player(BoxesWithAwards boxes, RewardLogger log) {
        this.boxesWithAwards = boxes;
        this.log = log;
    }

    void increaseLife() {
        ++live;
    }

    void decreaseLife() {
        --live;
    }

    Reward getTotalWinAmount() {
        return totalWinAmount;
    }

    int getLive() {
        return live;
    }

    private void setTotalWinAmount(Reward totalWinAmount) {
        this.totalWinAmount = totalWinAmount;
    }

    void addMoneyReward(Reward reward) {
        Reward amountPerRound = Reward.moneyComposition(reward, getTotalWinAmount());
        setTotalWinAmount(amountPerRound);
        log.addAmountToTotal(reward);
    }

    Reward openBox() {
        return boxesWithAwards.getNextBox().getReward();
    }
}
