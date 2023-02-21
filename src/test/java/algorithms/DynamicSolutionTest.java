package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Example 1:
//
//Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
//Output: 34
//Explanation: You can choose all the players.
//Example 2:
//
//Input: scores = [4,5,6,5], ages = [2,1,2,1]
//Output: 16
//Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
//Example 3:
//
//Input: scores = [1,2,3,5], ages = [8,9,10,1]
//Output: 6
//Explanation: It is best to choose the first 3 players.

public class DynamicSolutionTest {
    @Test
    public void testCaseOne() {
        DynamicSolution uut = new DynamicSolution();
        int[] scores = new int[]{1, 3, 5, 10, 15};
        int[] ages = new int[]{1, 2, 3, 4, 5};
        assertEquals(34, uut.bestTeamScore(scores, ages));
    }

    @Test
    public void testCaseTwo() {
        DynamicSolution uut = new DynamicSolution();
        int[] scores = new int[]{4, 5, 6, 5};
        int[] ages = new int[]{2, 1, 2, 1};
        assertEquals(16, uut.bestTeamScore(scores, ages));
    }
}