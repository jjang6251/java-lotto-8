package lotto.parser;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottosRankResult;
import lotto.domain.Rank;

public class OutputParser {
    public static String addComma(List<Integer> lotto) {
        return "[" + String.join(",", lotto.toString()) + "]";
    }
}
