package ticket;

import lottery.lottoBalls;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Tickets {
    protected final int totalLottoBalls = 6;
    private final List<lottoBalls> lottoNumbers;

    public Tickets(List<lottoBalls> lottoNumbers) {
        List<lottoBalls> tmp = create(lottoNumbers);
        valid(tmp);
        Collections.sort(tmp);
        this.lottoNumbers = tmp;
    }

    private void valid(List<lottoBalls> tmp) {
        if (!rightSize(lottoNumbers) || !noDuplicants(lottoNumbers)){
            throw new IllegalArgumentException("티켓 출력상 오류: 길이가 옳지 않거나 중복이 있음");
        }
    }

    private boolean rightSize(List<lottoBalls> lottoNumbers) {
        return lottoNumbers.size() == totalLottoBalls;
    }

    private boolean noDuplicants(List<lottoBalls> lottoNumbers){
        Set<lottoBalls> tmp = new HashSet<>(lottoNumbers);
        return tmp.size() == lottoNumbers.size();
    }

    protected abstract List<lottoBalls> create(List<lottoBalls> lottoNumbers);
}
