package ticket;

import lottery.lottoBalls;
import ticket.Tickets;

import java.util.List;

public class ManualTickets extends Tickets {

    public ManualTickets(List<lottoBalls> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    protected List<lottoBalls> create(List<lottoBalls> lottoNumbers) {
        return lottoNumbers;//그냥 리턴하면 끝
    }
}
