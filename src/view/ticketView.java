package view;

import ticket.Tickets;

import java.util.List;
import java.util.stream.Collectors;

public class ticketView {
    public static void ticketCountView(final int manualTickets, final int autoTickets){
        System.out.println("수동으로 "+ manualTickets + "개, 자동으로 "+ autoTickets +"개 구매했습니다.");
    }
    public static void lottoTicketsView(final List<Tickets> allTickets){
        for (Tickets oneTicket: allTickets){
            final String oneTicketView = oneTicket.getNumbers().stream()
                                                .map(String::valueOf)
                                                .collect(Collectors.joining(","));
            System.out.println(String.format("[%s]", oneTicketView));
        }
    }
}
