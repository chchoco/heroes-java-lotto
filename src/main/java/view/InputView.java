package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력하세요");
        return scanner.nextInt();
    }

    public static int inputSlipCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int slipCount = scanner.nextInt();
        return slipCount;
    }

    public static List<String> inputSlipNumbers(int slipCount) {
        List<String> slipLottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < slipCount; i++) {
            String slipNumbers = scanner.next();
            slipLottos.add(slipNumbers);
        }
        return slipLottos;
    }

    public static String inputLastJackpot() {
        System.out.println("지난주 당첨 번호를 입력해 주세요");
        return scanner.next();
    }

    public static int inputBonusBall() {
        System.out.println("보너스볼을 입력해 주세요");
        return scanner.nextInt();
    }
}
