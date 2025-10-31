package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public final class LottoFactory {
    public static Lotto random() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return make(nums);
    }

    private static Lotto make(List<Integer> input) {
        List<Integer> sorted = input.stream()
                .sorted()
                .toList();
        return new Lotto(List.copyOf(sorted));
    }
}
