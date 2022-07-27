import java.util.Scanner;

public class InputManual {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final int manualTickets;

    public InputManual(int manualTickets) {
        this.manualTickets = manualTickets;
    }

    private static InputManual enterManualTickets(){
        return new InputManual(getInput());
    }

    public static int getInput(){
        System.out.println("수동 매수를 입력해주세요: ");
        return SCANNER.nextInt();
    }

    public int getManualTickets(){
        return manualTickets;
    }
}
