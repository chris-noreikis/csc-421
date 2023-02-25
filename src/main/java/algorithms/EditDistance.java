package algorithms;

import java.util.Arrays;

public class EditDistance {
    private String _target;
    private String _initial;

    private String elideLast(String s) {
        return s.substring(0, s.length() - 1);
    }

    private char lastChar(String s) {
        return s.charAt(s.length() - 1);
    }

    int editDistanceIntuitive(String initial, String target) {
        System.out.printf("--- Edit Distance %s %s ---%n", initial, target);
        if ("".equals(initial)) {
            return target.length();
        }

        if ("".equals(target)) {
            return initial.length();
        }

        String initialSlice = elideLast(initial);
        String targetSlice = elideLast(target);
        char lastCharInitial = lastChar(initial);
        char lastCharTarget = lastChar(target);

        if (lastCharInitial == lastCharTarget) {
            System.out.printf("[Last Char Same %s %s]%n", initial, target);
            return editDistanceIntuitive(initialSlice, targetSlice);
        } else {
            String initialSwapped = initialSlice + lastCharTarget;
            System.out.printf("[Swap %s %s] %s -> %s%n", initial, target, initial, initialSwapped);
            int substitutionSwaps = editDistanceIntuitive(initialSwapped, target) + 1;

            System.out.printf("[Insert %s %s] %s -> %s%n", initial, target, initial, initial + lastCharTarget);
            int insertSwaps = editDistanceIntuitive(initial + lastCharTarget, target) + 1;

            System.out.printf("[Delete %s %s] %s -> %s%n", initial, target, initialSlice, target);
            int deleteSwaps = editDistanceIntuitive(initialSlice, target) + 1;

            return Math.min(Math.min(substitutionSwaps, insertSwaps), deleteSwaps);
        }
    }



    public int editDistanceDynamicProgramming(String initial, String target) {
        int[][] solutions = new int[initial.length() + 1][target.length() + 1];
        for (int i = 0; i < solutions.length; i++) {
            solutions[i][0] = i;
        }

        for (int i = 0; i < solutions[0].length; i++) {
            solutions[0][i] = i;
        }

        for (int i = 1; i < solutions.length; i++) {
            for (int j = 1; j < solutions[0].length; j++) {
                char lastCharInitial = initial.charAt(i - 1);
                char lastCharTarget = target.charAt(j - 1);
                int min = Math.min(
                        Math.min(solutions[i][j - 1] + 1, solutions[i - 1][j] + 1),
                        solutions[i - 1][j - 1] + (lastCharInitial == lastCharTarget ? 0 : 1));
                solutions[i][j] = min;
            }
        }

        for (int i = 0; i < solutions.length; i++) {
            System.out.println(Arrays.toString(solutions[i]));
        }

        return solutions[initial.length()][target.length()];
    }


}
