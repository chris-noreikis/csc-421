package algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tester.timing.TimingHelper;

import static org.junit.Assert.assertEquals;

public class TimingTest {
	EditDistanceAlgorithm recursiveImpl;
	EditDistanceAlgorithm intuitiveImpl;
	EditDistanceAlgorithm dynamicImpl;
	TimingHelper intuitiveTiming = new TimingHelper();
	TimingHelper recursiveTiming = new TimingHelper();
	TimingHelper dynamicTiming = new TimingHelper();
	String initial;
	String target;
	
	@Before
	public void setUp() throws Exception {
		recursiveImpl = new RecursiveImpl();
		intuitiveImpl = new IntuitiveImpl();
		dynamicImpl = new DynamicImpl();
	}

	@Test
	public void testTiming() {
		int index = 1;
		while (index <= 20000) {
			initial = "a";
			target = "ab";
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
			initial += "a";
			target += "a";
		}
		System.out.println("Intuitive: " + intuitiveTiming.getOverview());
		System.out.println("Recursive: " + recursiveTiming.getOverview());
		System.out.println("Dynamic: " + dynamicTiming.getOverview());
	}
}
