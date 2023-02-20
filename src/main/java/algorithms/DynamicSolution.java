package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicSolution {
    private ArrayList<Player> bestTeam;
    private Player[] _team;
    private int[] _ages;
    private int[] _scores;

    public void bestTeamScoreHelper(int nextIdx) {

    }
    public int bestTeamScore(int[] scores, int[] ages) {
        _ages = ages;
        _scores = scores;
        initPlayers(scores, ages);
        return 0;
    }

    private void initPlayers(int[] scores, int[] ages) {
        _team = new Player[scores.length];
        for (int i = 0; i < scores.length; i++) {
            _team[i] = new Player(scores[i], ages[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}