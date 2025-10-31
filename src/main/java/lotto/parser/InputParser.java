package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_AMOUNT_LIMIT = 10000000;

    public List<Integer> winningNumInputParser(String input) {
        try {
            if (!input.contains(",")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
            }
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 문자가 아닌 숫자로 구성되어야 합니다.");
        }
    }

    public int purchaseAmountInputParser(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
            }
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 0보다 커야합니다.");
            }
            if (purchaseAmount >= PURCHASE_AMOUNT_LIMIT) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 1000만원 미만만 가능합니다.");
            }
            if (purchaseAmount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여 합니다.");
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자여야 합니다.");
        }
    }
}
