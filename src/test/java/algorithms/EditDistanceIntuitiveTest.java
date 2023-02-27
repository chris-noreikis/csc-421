package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceIntuitiveTest {
    @Test
    public void testOne() {
        EditDistanceIntuitive uut = new EditDistanceIntuitive();
        assertEquals(1, uut.editDistanceIntuitive("ab", "abc"));
    }

    @Test
    public void testTwo() {
        EditDistanceIntuitive uut = new EditDistanceIntuitive();
        assertEquals(3, uut.editDistanceIntuitive("horse", "ros"));
    }

    @Test
    public void testThree() {
        EditDistanceIntuitive uut = new EditDistanceIntuitive();
        assertEquals(5, uut.editDistanceIntuitive("intention", "execution"));
    }
}
