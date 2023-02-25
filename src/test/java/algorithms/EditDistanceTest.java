package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
    @Test
    public void testOne() {
        EditDistance uut = new EditDistance();
        assertEquals(1, uut.editDistanceIntuitive("ab", "abc"));
        assertEquals(1, uut.editDistanceDynamicProgramming("ab", "abc"));
    }

    @Test
    public void testTwo() {
        EditDistance uut = new EditDistance();
        assertEquals(3, uut.editDistanceIntuitive("horse", "ros"));
        assertEquals(3, uut.editDistanceDynamicProgramming("horse", "ros"));
    }

    @Test
    public void testThree() {
        EditDistance uut = new EditDistance();
        assertEquals(5, uut.editDistanceIntuitive("intention", "execution"));
        assertEquals(5, uut.editDistanceDynamicProgramming("intention", "execution"));
    }
}
