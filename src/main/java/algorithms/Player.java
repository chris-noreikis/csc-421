package algorithms;

public class Player implements Comparable<Player> {
    public int score;
    public int age;

    public Player(int score, int age) {
        this.score = score;
        this.age = age;
    }

    public boolean isConflicting(Player o) {
        return o.age > this.age && this.score > o.score;
    }

    @Override
    public int compareTo(Player o) {
        if (this.age != o.age) {
            return this.age - o.age;
        }

        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", age=" + age +
                '}';
    }
}
