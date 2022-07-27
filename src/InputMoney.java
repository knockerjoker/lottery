import java.util.Scanner;
import  java.math.BigDecimal;

public class InputMoney {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final BigDecimal money;

    public InputMoney(BigDecimal money) {
        this.money = money;
    }

    public static InputMoney enterMoney(){
        return new InputMoney(getInput());
    }

    public static BigDecimal getInput(){
        System.out.println("구입 금액을 입력해주세요: ");
        return SCANNER.nextBigDecimal();
    }

    public BigDecimal getMoney(){
        return money;
    }
}
