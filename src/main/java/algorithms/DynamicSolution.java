package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DynamicSolution {
    private ArrayList<Player> bestTeam;
    private List<Player> _team;
    private int[] _ages;
    private int[] _scores;

    public int bestTeamScoreHelper(int i, int j) {
        if (j == _team.size()) {
            return 0;
        } else if (_team.get(i).isConflicting(_team.get(j))) {
            return bestTeamScoreHelper(i, j + 1);
        } else {
            return Math.max(
                    _team.get(j).score + bestTeamScoreHelper(j, j + 1),
                    bestTeamScoreHelper(i, j + 1)
            );
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        _ages = ages;
        _scores = scores;
        initPlayers(scores, ages);
        _team.add(0, new Player(0, -1));
        return bestTeamScoreHelper(0, 1);
    }

    private void initPlayers(int[] scores, int[] ages) {
        _team = IntStream
                .range(0, scores.length)
                .mapToObj(i -> new Player(scores[i], ages[i]))
                .collect(Collectors.toList());
        Collections.sort(_team);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}