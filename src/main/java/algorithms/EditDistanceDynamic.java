package algorithms;

import java.util.Arrays;

public class EditDistanceDynamic {
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
