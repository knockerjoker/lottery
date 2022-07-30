package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getManualNumbers {
    private static Scanner SCANNER = new Scanner(System.in);
    private final int manualTicketCount;
    private List<String> manualNumberString;

    private getManualNumbers(int manualTicketCount) {
        this.manualTicketCount = manualTicketCount;
        this.manualNumberString = getManualNumberString(manualTicketCount);
    }

    public static getManualNumbers enterManualTicketCount(){
        return new getManualNumbers(getManualTicketCountInput());
    }

    private static int getManualTicketCountInput(){
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return SCANNER.nextInt();
    }

    private List<String> getManualNumberString(int manualTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        final List<String> manualNumberString = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++){
            final String oneTicket = getManualInputs();
            manualNumberString.add(oneTicket);
        }
        return manualNumberString;
    }

    public String getManualInputs() {
        return SCANNER.nextLine();
    }

    public List<String> getManualNumberString(){
        return manualNumberString;
    }

    public int getManualTicketCount(){
        return manualTicketCount;
    }
}
