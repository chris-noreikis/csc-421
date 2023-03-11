package algorithms;

public class DynamicImpl extends EditDistanceAlgorithm {
    public int solve(String initial, String target) {
        int[][] solutions = new int[initial.length() + 1][target.length() + 1];
        for (int i = 0; i < solutions.length; i++) {
            solutions[i][0] = i;
        }

        for (int j = 0; j < solutions[0].length; j++) {
            solutions[0][j] = j;
        }

        for (int i = 1; i < solutions.length; i++) {
            for (int j = 1; j < solutions[0].length; j++) {
                this.recordTelemetry();
                char lastCharInitial = initial.charAt(i - 1);
                char lastCharTarget = target.charAt(j - 1);

                if (lastCharInitial == lastCharTarget) {
                    solutions[i][j] = solutions[i - 1][j - 1];
                } else {
                    solutions[i][j] = 1 + min(
                            solutions[i][j - 1],
                            solutions[i - 1][j],
                            solutions[i - 1][j - 1]
                    );
                }
            }
        }

        return solutions[initial.length()][target.length()];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
