package results;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class lottoResult {
    private static final int startingPrizeMoney = 0;
    private final List<rank> allRanks;

    public lottoResult(List<rank> allRanks) {
        this.allRanks = allRanks;
    }

    public List<String> collectResults(){
        return Arrays.stream(rank.values())
                    .filter((oneTicket) -> oneTicket.getPrizeMoney() > startingPrizeMoney)
                    .map((oneTicket) -> {
                            return getResult(oneTicket, rankCounts(allRanks, oneTicket));
                    })
                    .collect(Collectors.toList());
    }

    private static int rankCounts(final List<rank> allRanks, rank oneTicket) {
        return (int) allRanks.stream()
                    .filter(ticketResult -> ticketResult == oneTicket)
                    .count();
    }

    private static String getResult(final rank oneTicket, final int rankCount){
        if (oneTicket == rank.second){
            return oneTicket.getMatchingBalls() + "개 일치, 보너스 볼 일치(" + oneTicket.getPrizeMoney() + ")- " + rankCount + "개";
        }
        else {
            return oneTicket.getMatchingBalls() + "개 일치 (" + oneTicket.getPrizeMoney() + ")- " + rankCount + "개";
        }
    }

    public BigDecimal getEarningRate(final BigDecimal paid){
        final long totalMoneyWin = allRanks.stream()
                                            .mapToLong(rank::getPrizeMoney)
                                            .sum();
        return BigDecimal.valueOf(totalMoneyWin).divide(paid, 3, BigDecimal.ROUND_UP);
    }
}
