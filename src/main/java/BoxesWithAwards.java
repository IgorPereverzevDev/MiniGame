import java.util.*;
import java.util.stream.Collectors;

class BoxesWithAwards {

    private static final int MaxRange = 12;

    private List<Box> listsOfBoxes;

    private List<Box> createListOfBoxes() {
        return createListOfRewardsForBoxes().entrySet()
                .stream()
                .map(entry -> addToSeqNumberOfRewards(entry.getKey(), entry.getValue()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    List<Box> getListsOfBoxes() {
        return listsOfBoxes;
    }

    Box getNextBox() {
        if (listsOfBoxes == null || listsOfBoxes.isEmpty()) {
            listsOfBoxes = new ArrayList<>(MaxRange);
            this.createListOfBoxes();
            Collections.shuffle(listsOfBoxes);
        }
        Box box = listsOfBoxes.get(getNextBoxIndex());
        listsOfBoxes.remove(box);
        return box;
    }

    private List<Box> addToSeqNumberOfRewards(Reward reward, Integer numberRewards) {
        for (int i = 0; i < numberRewards; i++) {
            listsOfBoxes.add(new Box(reward));
        }
        return listsOfBoxes;
    }

    private Map<Reward, Integer> createListOfRewardsForBoxes() {
        Map<Reward, Integer> rewards = new HashMap<>();
        rewards.put(new Reward(RewardValues.OneHundredEuro), 1);
        rewards.put(new Reward(RewardValues.TwentyEuro), 2);
        rewards.put(new Reward(RewardValues.FiveEuro), 5);
        rewards.put(new Reward(RewardValues.ExtraLife), 1);
        rewards.put(new Reward(RewardValues.GameOver), 3);
        return rewards;
    }

    private int getNextBoxIndex() {
        int maxRangeBoxes = listsOfBoxes.size();
        return (int) (Math.random() * ((maxRangeBoxes - 1) + 1));
    }
}
