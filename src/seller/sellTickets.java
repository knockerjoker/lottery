package seller;

import lottery.lottoBalls;
import ticket.AutoTickets;
import ticket.ManualTickets;
import ticket.Tickets;
import changer.typeChanger;

import java.util.List;
import java.util.ArrayList;

public class sellTickets {
    public static List<Tickets> soldTotalTickets(final moneyCheck totalTicketNumber, final List<String> getManualNumberString){
        int AutoTicketCount = getAutoTicketCount(totalTicketNumber, getManualNumberString.size());
        List<Tickets> totalTickets = new ArrayList<>();
        totalTickets.addAll(soldAutoTickets(AutoTicketCount));
        totalTickets.addAll(soldManualTickets(getManualNumberString));
        return totalTickets;
    }

    private static List<Tickets> soldManualTickets(final List<String> getManualNumberString) {
        final List<Tickets> manualTickets = new ArrayList<>();
        for (String oneLine : getManualNumberString){
            final List<lottoBalls> oneTicket = typeChanger.ballsToIntList(oneLine);
            manualTickets.add(new ManualTickets(oneTicket));
        }
        return manualTickets;
    }

    private static List<Tickets> soldAutoTickets(final int AutoTicketCount) {
        final List<Tickets> autoTickets = new ArrayList<>();
        for (int i = 0; i < AutoTicketCount; i++){
            final Tickets oneTicket = new AutoTickets();
            autoTickets.add(oneTicket);
        }
        return autoTickets;
    }

    public static int getAutoTicketCount(final moneyCheck totalTicketNumber, final int ManualTicketCount){
        if (totalTicketNumber.possibleManualTickets(ManualTicketCount)) {
            throw new IllegalArgumentException("수동 매수가 전체 매수보다 큽니다.");
        }
        return totalTicketNumber.totalTicketNumber() - ManualTicketCount;
    }
}
