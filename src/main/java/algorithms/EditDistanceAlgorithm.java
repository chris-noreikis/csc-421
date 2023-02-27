package algorithms;

public abstract class EditDistanceAlgorithm {
    private final long _memoryStart;
    private long _memoryInProgress;
    private final Runtime _runtime;
    private int _invocations;

    public EditDistanceAlgorithm() {
        this._runtime = Runtime.getRuntime();
        this._memoryStart = _runtime.totalMemory() - _runtime.freeMemory();
        this._memoryInProgress = 0;
        this._invocations = 0;
    }

    public abstract int solve(String initial, String target);

    protected void recordTelemetry() {
        this._invocations++;
        this._memoryInProgress = Math.max(
                _runtime.totalMemory() - _runtime.freeMemory(),
                this._memoryInProgress
        );
    }

    public int numInvocations() {
        return this._invocations;
    }

    public long peakMemoryConsumption() {
        return this._memoryInProgress - this._memoryStart;
    }
}
