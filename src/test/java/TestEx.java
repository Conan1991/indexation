import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class TestEx {

    @Test
    @DisplayName("SequenceOfNumbers should matched")
    void testGetSequenceOfNumbers() {
        String s1 = "1,2,4-5";
        String s2 = "3,6,7";
        String s3 = "8,1";

        List<List<Integer>> sequenceOfNumbers = Main.getSequenceOfNumbers(List.of(s1, s2, s3));

        //All passed / true

        //1. Test equal.
        assertThat(sequenceOfNumbers.get(0), is(List.of(1, 2, 4, 5)));

        //2. Check List has this value
        assertThat(sequenceOfNumbers.get(0), hasItems(4, 5));

        //3. Check List Size
        assertThat(sequenceOfNumbers.get(0), hasSize(4));

        //5. check empty list
        assertThat(sequenceOfNumbers.get(2), not(IsEmptyCollection.empty()));

        //6. Test numeric comparisons
        assertThat(sequenceOfNumbers.get(1), everyItem(greaterThanOrEqualTo(3)));

        assertThat(sequenceOfNumbers.get(1), everyItem(lessThan(10)));
    }


    @Test
    @DisplayName("All pairs should matched")
    void testGetPairsOfNumbers() {
        String s1 = "1,2,4-5";
        String s2 = "3,6,7";
        String s3 = "8,1";

        List<List<Integer>> sequenceOfNumbers = Main.getPairsOfNumbers(List.of(s1, s2, s3));

        //All passed / true

        //1. Test equal.
        assertThat(sequenceOfNumbers.get(0), is(List.of(1, 3, 8)));

        //2. Check List has this value
        assertThat(sequenceOfNumbers.get(9), hasItems(2, 1));

        //3. Check List Size
        assertThat(sequenceOfNumbers.get(15), hasSize(3));
        assertThat(sequenceOfNumbers, hasSize(24));

        //5. check empty list
        assertThat(sequenceOfNumbers.get(17), not(IsEmptyCollection.empty()));

        //6. Test numeric comparisons
        assertThat(sequenceOfNumbers.get(14), everyItem(greaterThanOrEqualTo(4)));

        assertThat(sequenceOfNumbers.get(18), everyItem(lessThan(10)));
    }
}
