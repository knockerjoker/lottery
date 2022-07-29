package ticket;

import lottery.lottoBalls;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoTickets extends Tickets {
    private final int startingIndex = 0;
    public AutoTickets(List<lottoBalls> lottoNumbers) {
        super(Collections.emptyList());
    }

    @Override
    protected List<lottoBalls> create(List<lottoBalls> lottoNumbers) {
        List<lottoBalls> aLineOfNumbers = lottoBalls.generateLottoNumbers();
        Collections.shuffle(aLineOfNumbers);//나열한 공등을 섞어버림
        return aLineOfNumbers.subList(startingIndex, totalLottoBalls);//섞은 공 중에서 6개만 출력
    }
}
