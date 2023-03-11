package algorithms;

import org.junit.Before;
import org.junit.Test;
import tester.timing.TimingHelper;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TimingTest {
    EditDistanceAlgorithm recursiveImpl;
    EditDistanceAlgorithm intuitiveImpl;
    EditDistanceAlgorithm dynamicImpl;
    TimingHelper intuitiveTiming = new TimingHelper();
    TimingHelper recursiveTiming = new TimingHelper();
    TimingHelper dynamicTiming = new TimingHelper();
    @Before
    public void setUp() throws Exception {
        recursiveImpl = new RecursiveImpl();
        intuitiveImpl = new IntuitiveImpl();
        dynamicImpl = new DynamicImpl();
    }

    @Test
    public void testTiming() {
        int index = 1;
        int numTrials = 500;
        while (index <= numTrials) {
            int randomStrLen = new Random().nextInt(10);
            String initial = randomStr(randomStrLen);
            String target = randomStr(randomStrLen);
            System.out.println("initial = " + initial);
            System.out.println("target = " + target);
            System.out.println("trial number = " + index);

            intuitiveTiming.start();
            int initAnswer = intuitiveImpl.solve(initial, target);
            intuitiveTiming.stop();
            recursiveTiming.start();
            int recrAnswer = recursiveImpl.solve(initial, target);
            recursiveTiming.stop();
            dynamicTiming.start();
            int dynAnswer = dynamicImpl.solve(initial, target);
            dynamicTiming.stop();
            assertEquals(initAnswer, recrAnswer);
            assertEquals(initAnswer, dynAnswer);
            index++;
        }
        System.out.println("Intuitive: " + intuitiveTiming.getOverview());
        System.out.println("Recursive: " + recursiveTiming.getOverview());
        System.out.println("Dynamic: " + dynamicTiming.getOverview());
    }

    private String randomStr(int len) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            s.append(randomChar());
        }
        return s.toString();
    }

    private char randomChar() {
        return (char)(new Random().nextInt(26) + 'a');
    }
}
