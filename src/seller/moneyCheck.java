package seller;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class moneyCheck {
    private static final  BigDecimal oneTicket = BigDecimal.valueOf(1000);
    private final BigDecimal paidmoney;

    public moneyCheck(BigDecimal paidMoney) {
        validMoney(paidMoney);
        this.paidmoney = paidMoney;
    }
    private void validMoney(BigDecimal pMoney){
        if (pMoney.remainder(oneTicket).intValue() != 0 || pMoney.intValue() < oneTicket.intValue()){
            throw new IllegalArgumentException("지불 금액을 알맞게 입력해주세요");
        }
    }

    public int totalTicketNumber(){
        return this.paidmoney.divide(oneTicket, RoundingMode.FLOOR).intValue();
    }

    public boolean possibleManualTickets(final int ManualTicketNumbers){
        return totalTicketNumber() >= ManualTicketNumbers;
    }
}
