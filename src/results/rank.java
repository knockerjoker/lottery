package results;

import java.util.Arrays;

public enum rank {
    nothing(0,0),
    fifth(3, 5_000),
    fourth(4, 50_000),
    third(5, 1_500_000),
    second(5, 30_000_000),
    first(6, 200_000_000);

    private final int matchingBalls;
    private final int prizeMoney;

    rank(int matchingBalls, int prizeMoney) {
        this.matchingBalls = matchingBalls;
        this.prizeMoney = prizeMoney;
    }

    public static rank rankAndPrize(int ballsMatch, final boolean bonusMatch){
        if (ballsMatch == second.matchingBalls && bonusMatch){
            return rank.second;
        }
        if (ballsMatch == third.matchingBalls){
            return rank.third;
        }
        return Arrays.stream(rank.values())
                    .filter((rank) -> rank.matchingBalls == ballsMatch)
                    .findFirst()
                    .orElse(rank.nothing);
    }

    public int getMatchingBalls(){
        return matchingBalls;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
