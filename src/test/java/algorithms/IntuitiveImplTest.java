package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntuitiveImplTest {
    @Test
    public void testOne() {
        IntuitiveImpl uut = new IntuitiveImpl();
        assertEquals(1, uut.solve("ab", "abc"));
    }

    @Test
    public void testTwo() {
        IntuitiveImpl uut = new IntuitiveImpl();
        assertEquals(3, uut.solve("horse", "ros"));
    }

    @Test
    public void testThree() {
        IntuitiveImpl uut = new IntuitiveImpl();
        assertEquals(5, uut.solve("intention", "execution"));
    }
}
