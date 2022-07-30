package view;

import java.math.RoundingMode;
import java.util.List;
import java.math.BigDecimal;

public class totalResultView {
    public static void totalResult(final List<String> winResults){
        System.out.println("당첨 통계");
        System.out.println("--------");
        for(String winResult : winResults){
            System.out.println(winResult);
        }
    }
    public static void earningRateView(final BigDecimal earningRate){
        if (earningRate.setScale(0, RoundingMode.FLOOR).intValue() == 0){
            System.out.println("총 수익률은 " + earningRate +"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        else{
            System.out.println("총 수익률은 " + earningRate + "입니다.");
        }
    }
}
