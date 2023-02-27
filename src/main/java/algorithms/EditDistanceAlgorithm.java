package algorithms;

public interface EditDistanceAlgorithm {
    public int numInvocations();
    public int peakMemoryConsumption();

    public int solve(String initial, String target);
}
