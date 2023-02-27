package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceDynamicTest {
    @Test
    public void testOne() {
        EditDistanceDynamic uut = new EditDistanceDynamic();
        assertEquals(1, uut.editDistanceDynamicProgramming("ab", "abc"));
        assertEquals(1, uut.editDistanceDynamicProgramming("ab", "abc"));
    }

    @Test
    public void testTwo() {
        EditDistanceDynamic uut = new EditDistanceDynamic();
        assertEquals(3, uut.editDistanceDynamicProgramming("horse", "ros"));
        assertEquals(3, uut.editDistanceDynamicProgramming("horse", "ros"));
    }

    @Test
    public void testThree() {
        EditDistanceDynamic uut = new EditDistanceDynamic();
        assertEquals(5, uut.editDistanceDynamicProgramming("intention", "execution"));
        assertEquals(5, uut.editDistanceDynamicProgramming("intention", "execution"));
    }
}
