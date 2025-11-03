package lotto.view;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final int LOTTO_PRICE = 1_000;
    private static final int PURCHASE_AMOUNT_LIMIT = 10_000_000;

    public static List<Integer> winningNumInputParser(String input) {
        inputHasText(input);
        winningNumHasComma(input);
        return winningNumParseToInteger(input);
    }

    public static int purchaseAmountInputParser(String input) {
        inputHasText(input);
        int purchaseAmount = purchaseAmountParseInt(input);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public static int bonusNumInputParser(String input) {
        inputHasText(input);
        return bonusNumParseInt(input);
    }

    private static void inputHasText(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
        }
    }

    private static List<Integer> winningNumParseToInteger(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 문자가 아닌 숫자로 구성되어야 합니다.");
        }
    }

    private static void winningNumHasComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
        }
    }

    private static int purchaseAmountParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자여야 합니다.");
        }
    }

    private static int bonusNumParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 0보다 커야합니다.");
        }
        if (purchaseAmount >= PURCHASE_AMOUNT_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000만원 미만만 가능합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }

}
