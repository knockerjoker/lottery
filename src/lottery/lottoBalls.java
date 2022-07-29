package lottery;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Objects;
import java.util.List;

public class lottoBalls implements Comparable<lottoBalls>{
    private static final int startingLottoNumber = 1;
    private static final int endingLottoNumber = 45;

    private final int ball;

    public lottoBalls(int ball) {
        validBall(ball);
        this.ball = ball;
    }

    public lottoBalls(String ball){
        this(Integer.parseInt(ball));
    }

    public void validBall(int ball){
        if (ball < startingLottoNumber || ball > endingLottoNumber){
            throw new IllegalArgumentException("숫자는 1에서 45 사이여야 해요");
        }
    }

    public static List<lottoBalls> generateLottoNumbers(){//공을 1~45까지 쭉 나열
        return IntStream.rangeClosed(startingLottoNumber, endingLottoNumber)
                    .mapToObj(lottoBalls::new)
                    .collect(Collectors.toList());
    }

    @Override
    public int compareTo(lottoBalls o) {

        return this.ball - o.ball;
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        lottoBalls that = (lottoBalls) o;
        return ball == that.ball;
    }
    public int hashCode(){
        return Objects.hash(ball);
    }

    public String toString(){
        return Integer.toString(ball);
    }
}
