package tester.timing;

import java.util.ArrayList;
import java.util.List;

public class TimingHelper
{
	private List<Long> durations = new ArrayList<>();
	private long start;
	private Double average;
	
	public void start()
	{
		start = System.currentTimeMillis();
	}

	public void stop()
	{
		long duration = System.currentTimeMillis() - start;
		durations.add(duration);
	}

	public List<Long> getDurations()
	{
		return durations;
	}

	public double getAverageRuntime()
	{
		if (average == null)
		{
			double total = 0;
			for (Long duration : durations)
			{
				total += duration;			
			}
			average = total/durations.size();
		}
		return average;
	}
	
	public String getOverview()
	{
		StringBuilder out = new StringBuilder();
		out.append("Over ");
		out.append(durations.size());
		out.append(" runs the average was ");
		out.append(getAverageRuntime());
		return out.toString();
	}
}