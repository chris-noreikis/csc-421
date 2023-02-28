package algorithms;

import java.util.ArrayList;

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

        if (lastChar(initial) == lastChar(target)) {
            return solve(initialSlice, targetSlice);
        } else {
            String lastCharSwapped = initialSlice + lastChar(target);
            int substitutionSwaps = solve(lastCharSwapped, target) + 1;

            int insertSwaps = solve(initial + lastChar(target), target) + 1;

            int deleteSwaps = solve(initialSlice, target) + 1;

            return min(substitutionSwaps, insertSwaps, deleteSwaps);
        }
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
