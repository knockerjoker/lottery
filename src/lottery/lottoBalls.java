package lottery;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Objects;
import java.util.List;

public class lottoBalls implements Comparable<lottoBalls>{
    private final int startingLottoNumber = 1;
    private final int endingLottoNumber = 45;

    private final int ball;

    public lottoBalls(int ball) {
        validBall(ball);
        this.ball = ball;
    }

    public void validBall(int ball){
        if (ball < startingLottoNumber || ball > endingLottoNumber){
            throw new IllegalArgumentException("숫자는 1에서 45 사이여야 해요");
        }
    }

    @Override
    public int compareTo(lottoBalls o) {
        return this.ball - o.ball;
    }
}
