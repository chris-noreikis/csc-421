package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
    @Test
    public void testOne() {
        EditDistance uut = new EditDistance();
        assertEquals(1, uut.editDistanceIntuitive("ab", "abc"));
    }
}
