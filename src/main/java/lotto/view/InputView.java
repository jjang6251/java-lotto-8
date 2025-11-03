package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public int inputLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return InputParser.purchaseAmountInputParser(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNums() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해주세요.");
                String input = Console.readLine();
                return InputParser.winningNumInputParser(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNum() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return InputParser.bonusNumInputParser(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
