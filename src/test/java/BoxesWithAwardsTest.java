import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoxesWithAwardsTest {
    @Test
    public void testListBoxesWithRewardHasTwelveRewards() throws Exception {
        //adjust
        BoxesWithAwards boxesWithAwards = new BoxesWithAwards();
        int expectedListSize = 12;
        List<Box> actualList = new ArrayList<>();

        //action
        for (int i = 0; i < 12; ++i) {
            actualList.add(boxesWithAwards.getNextBox());
        }
        //assert
        assertEquals(expectedListSize, actualList.size());
    }


    @Test
    public void testListBoxesWithRewardDecreaseSize() throws Exception {
        //adjust
        BoxesWithAwards boxesWithAwards = new BoxesWithAwards();
        int expectedListSize = 11;

        //action
        boxesWithAwards.getNextBox();
        int actualListSize = boxesWithAwards.getListsOfBoxes().size();

        //assert
        assertEquals(expectedListSize, actualListSize);
    }

}
