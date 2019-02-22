package assignment4;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void TestSolution() {
        Solution solution = new Solution();
        assertTrue(Arrays.equals(solution.SolutionArray[0], new int[] {8, 1, 6, 3, 5, 7, 4, 9, 2}));
    }
}
