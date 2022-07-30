import lottery.lottoBalls;
import results.lottoResult;
import results.winTicket;
import seller.moneyCheck;
import ticket.ManualTickets;
import ticket.Tickets;
import view.*;
import changer.typeChanger;

import java.util.List;

public class main {
    public static void main(String[] args){
        InputMoney inputPay = InputMoney.enterMoney();
        moneyCheck totalMoney = new moneyCheck(inputPay.getMoney());
        //1.금액을 입력받아서 맞는 금액인지 확인하는 객채로

        getManualNumbers manualTicketInput = getManualNumbers.enterManualTicketCount();
        //2.수동 매수를 입력 받고, getManualNumbers의 manualNumber로 넣음

        List<Tickets> boughtTickets = seller.sellTickets.soldTotalTickets(totalMoney, manualTicketInput.getManualNumberString());
        //3. 수동티켓들에 대한 입력을 받고 나머지 자동티켓들도 만듬

        ticketView.ticketCountView(manualTicketInput.getManualTicketCount(), seller.sellTickets.getAutoTicketCount(totalMoney, manualTicketInput.getManualTicketCount()));
        //4. 수동티켓과 자동티켓 매수 출력

        ticketView.lottoTicketsView(boughtTickets);
        //5. 산 모든 티켓들의 결과값 출력

        winningTicketView wTicketInput = winningTicketView.enterWinningTicket();
        winTicket winningTicket = new winTicket(new lottoBalls(wTicketInput.getBonusNumber()), new ManualTickets(changer.typeChanger.ballsToIntList(wTicketInput.getWinningTicket())));
        //6. 당첨티켓 입력

        lottoResult allResults = new lottoResult(winningTicket.winOrLose(boughtTickets));
        //7. 당첨티켓에 따른 결과 저장

        totalResultView.totalResult(allResults.collectResults());
        totalResultView.earningRateView(allResults.getEarningRate(inputPay.getMoney()));
        //8. 당첨 결과와 수익률 출력
        }
}
