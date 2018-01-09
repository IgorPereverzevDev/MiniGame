import java.util.HashMap;
import java.util.Map;


class RewardLogger {

    private Map<Reward, Integer> rewards = new HashMap<>();
    private Integer totalAmount = 0;

    RewardLogger() {
        this.addRewardsToDictionary();
    }

    Map<Reward, Integer> getDictionaryRewards() {
        return rewards;
    }

    void addNumberRewardsToDictionary(Reward reward) {
        for (Map.Entry<Reward, Integer> entry : rewards.entrySet()) {
            if (entry.getKey().getEuroReward() == reward.getEuroReward()) {
                rewards.put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }

    private void addRewardsToDictionary() {
        rewards.put(new Reward(RewardValues.OneHundredEuro), 0);
        rewards.put(new Reward(RewardValues.TwentyEuro), 0);
        rewards.put(new Reward(RewardValues.FiveEuro), 0);
        rewards.put(new Reward(RewardValues.TenEuro), 0);
        rewards.put(new Reward(RewardValues.ExtraLife), 0);
        rewards.put(new Reward(RewardValues.GameOver), 0);
        rewards.put(new Reward(RewardValues.SecondChance), 0);
        rewards.put(new Reward(RewardValues.TotalAmount), totalAmount);
    }

    void addAmountToTotal(Reward reward) {
        totalAmount += reward.getEuroReward();
    }
}
