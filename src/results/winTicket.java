package results;

import lottery.lottoBalls;
import ticket.Tickets;

import java.util.List;
import java.util.stream.Collectors;

public class winTicket {
    private final lottoBalls bonus;
    private final Tickets wonTicket;

    public winTicket(lottoBalls bonus, Tickets wonTicket) {
        validBonus(bonus, wonTicket);
        this.bonus = bonus;
        this.wonTicket = wonTicket;
    }

    public void validBonus(lottoBalls bonus, Tickets wonTicket){
        if (wonTicket.has(bonus)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 번호가 포함되어 있습니당");
        }
    }

    public List<rank> winOrLose(final List<Tickets> boughtTickets){
        return boughtTickets.stream()
                    .map((boughtTicket) -> boughtTicket.getRank(wonTicket, bonus))
                    .collect(Collectors.toList());
    }

}
