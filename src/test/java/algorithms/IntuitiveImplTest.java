package algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntuitiveImplTest {
    IntuitiveImpl uut;
    String initial;
    String target;

    @Before
    public void setUp() throws Exception {
        uut = new IntuitiveImpl();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("initial = " + initial);
        System.out.println("target = " + target);
        System.out.println("invocations = " + uut.numInvocations());
        System.out.println("memory = " + uut.peakMemoryConsumption() / 1000 + "MB" + '\n');
    }

    @Test
    public void testOne() {
        initial = "ab";
        target = "abc";
        assertEquals(1, uut.solve(initial, target));
    }

    @Test
    public void testTwo() {
        initial = "horse";
        target = "ros";
        assertEquals(3, uut.solve(initial, target));
    }

    @Test
    public void testThree() {
        initial = "intentionabcd";
        target = "execution";
        assertEquals(6, uut.solve(initial, target));
    }
}
