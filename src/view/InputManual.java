package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManual {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final int manualTickets;
    private final List<String> manualNumberString;

    private InputManual(int manualTickets) {
        this.manualTickets = manualTickets;
        this.manualNumberString = getManualNumberStringInputs(manualTickets);
    }

    public static InputManual enterInputManual(){
        return new InputManual(getInput());
    }

    private static int getInput(){
        System.out.println("수동 매수를 입력해주세요: ");
        return SCANNER.nextInt();
    }

    private List<String> getManualNumberStringInputs(final int manualTickets){
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        for (int i = 0; i < manualTickets; i++){
            manualNumberString.add(scanManualNumberString());
        }
        return manualNumberString;
    }

    public int getManualTickets(){
        return manualTickets;
    }

    private static String scanManualNumberString(){
        return SCANNER.nextLine();
    }

    public List<String> getManualNumberString(){
        return manualNumberString;
    }
}
