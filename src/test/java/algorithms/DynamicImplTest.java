package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicImplTest {
    @Test
    public void testOne() {
        DynamicImpl uut = new DynamicImpl();
        assertEquals(1, uut.solve("ab", "abc"));
        assertEquals(1, uut.solve("ab", "abc"));
    }

    @Test
    public void testTwo() {
        DynamicImpl uut = new DynamicImpl();
        assertEquals(3, uut.solve("horse", "ros"));
        assertEquals(3, uut.solve("horse", "ros"));
    }

    @Test
    public void testThree() {
        DynamicImpl uut = new DynamicImpl();
        assertEquals(5, uut.solve("intention", "execution"));
        assertEquals(5, uut.solve("intention", "execution"));
    }
}
