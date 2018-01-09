import java.util.ArrayList;
import java.util.List;

class AdditionalRewards {

    private List<Reward> additionalRewards;

    private void createAdditionalListOfRewards() {
        additionalRewards.add(new Reward(RewardValues.FiveEuro));
        additionalRewards.add(new Reward(RewardValues.TenEuro));
        additionalRewards.add(new Reward(RewardValues.TwentyEuro));
        additionalRewards.add(new Reward(RewardValues.SecondChance));
    }

    Reward getWinningReward() {
        if (additionalRewards == null) {
            additionalRewards = new ArrayList<>();
            this.createAdditionalListOfRewards();
        }
        Reward reward = additionalRewards.get(generateReward());
        additionalRewards.remove(reward);
        return reward;
    }

    List<Reward> getAdditionalRewards() {
        return additionalRewards;
    }

    void setAdditionalRewards(List<Reward> additionalRewards) {
        this.additionalRewards = additionalRewards;
    }

    private int generateReward() {
        int maxRangeRewards = additionalRewards.size();
        return (int) (Math.random() * ((maxRangeRewards - 1) + 1));
    }
}
