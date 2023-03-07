package algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tester.timing.TimingHelper;

import static org.junit.Assert.assertEquals;

public class RecursiveImplTest {
	EditDistanceAlgorithm uut;
	EditDistanceAlgorithm intuitiveImpl;
	TimingHelper intuitiveTiming = new TimingHelper();
	TimingHelper recursiveTiming = new TimingHelper();
	TimingHelper dynamicTiming = new TimingHelper();
	String initial;
	String target;

	@Before
	public void setUp() throws Exception {
		uut = new RecursiveImpl();
		intuitiveImpl = new IntuitiveImpl();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("initial = " + initial);
		System.out.println("target = " + target);
		System.out.println("invocations = " + uut.numInvocations());
		System.out.println("memory = " + uut.peakMemoryConsumption() + '\n');
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
		initial = "intention";
		target = "execution";
		assertEquals(5, uut.solve(initial, target));
	}

}
