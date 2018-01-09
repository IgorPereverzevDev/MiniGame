
class Reward {

    private int euroReward;
    private String otherReward;

    Reward(int euroReward) {
        this.euroReward = euroReward;
    }

    Reward(String otherReward) {
        this.otherReward = otherReward;
    }

    private int getRewardInEUR() {
        return euroReward;
    }

    String getRewardOther() {
        return otherReward;
    }

    int getEuroReward() {
        return euroReward;
    }

    boolean isMoneyValue() {
        return otherReward == null;
    }
    boolean isOtherValue(){return otherReward != null; }

    static Reward moneyComposition(Reward reward1, Reward reward2) {
        if (reward1.isMoneyValue() && reward2.isMoneyValue()) {
            return new Reward(reward1.getRewardInEUR() + reward2.getRewardInEUR());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
