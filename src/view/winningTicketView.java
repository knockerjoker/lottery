package view;

import java.util.Scanner;

public class winningTicketView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final String matchingNumbers;
    private final int bonusNumber;

    public winningTicketView(String matchingNumbers, int bonusNumber) {
        this.matchingNumbers = matchingNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static winningTicketView enterWinningTicket(){
        return new winningTicketView(getMatcingInput(), getBonusInput());
    }

    private static String getMatcingInput() {
        System.out.println("지난주 당첨 번호를 입력해 주세요");
        return SCANNER.nextLine();
    }

    private static int getBonusInput(){
        System.out.println("뽀너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public String getWinningTicket(){
        return matchingNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
