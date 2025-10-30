package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {
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
}
