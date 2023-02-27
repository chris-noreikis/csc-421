package algorithms;

public class IntuitiveImpl extends EditDistanceAlgorithm {


    private String removeLastChar(String s) {
        return s.substring(0, s.length() - 1);
    }

    private char lastChar(String s) {
        return s.charAt(s.length() - 1);
    }

    public int solve(String initial, String target) {
        this.recordTelemetry();

        if ("".equals(initial)) {
            return target.length();
        }

        if ("".equals(target)) {
            return initial.length();
        }

        String initialSlice = removeLastChar(initial);
        String targetSlice = removeLastChar(target);
        char lastCharInitial = lastChar(initial);
        char lastCharTarget = lastChar(target);

        if (lastCharInitial == lastCharTarget) {
            return solve(initialSlice, targetSlice);
        } else {
            String lastCharSwapped = initialSlice + lastCharTarget;
            int substitutionSwaps = solve(lastCharSwapped, target) + 1;

            int insertSwaps = solve(initial + lastCharTarget, target) + 1;

            int deleteSwaps = solve(initialSlice, target) + 1;

            return Math.min(Math.min(substitutionSwaps, insertSwaps), deleteSwaps);
        }
    }
}
